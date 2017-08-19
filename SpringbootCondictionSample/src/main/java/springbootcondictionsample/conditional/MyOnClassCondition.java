package springbootcondictionsample.conditional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.boot.autoconfigure.AutoConfigurationImportFilter;
import org.springframework.boot.autoconfigure.AutoConfigurationMetadata;
import org.springframework.boot.autoconfigure.condition.ConditionEvaluationReport;
import org.springframework.boot.autoconfigure.condition.ConditionMessage;
import org.springframework.boot.autoconfigure.condition.ConditionMessage.Style;
import org.springframework.boot.autoconfigure.condition.ConditionOutcome;
import org.springframework.boot.autoconfigure.condition.SpringBootCondition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.util.ClassUtils;
import org.springframework.util.MultiValueMap;

public class MyOnClassCondition extends SpringBootCondition implements AutoConfigurationImportFilter, BeanFactoryAware, BeanClassLoaderAware {



	private BeanFactory beanFactory;

	private ClassLoader beanClassLoader;

	@Override
	public boolean[] match(String[] autoConfigurationClasses,
			AutoConfigurationMetadata autoConfigurationMetadata) {
		ConditionEvaluationReport report = getConditionEvaluationReport();
		ConditionOutcome[] outcomes = getOutcomes(autoConfigurationClasses,
				autoConfigurationMetadata);
		boolean[] match = new boolean[outcomes.length];
		for (int i = 0; i < outcomes.length; i++) {
			match[i] = (outcomes[i] == null || outcomes[i].isMatch());
			if (!match[i] && outcomes[i] != null) {
				logOutcome(autoConfigurationClasses[i], outcomes[i]);
				if (report != null) {
					report.recordConditionEvaluation(autoConfigurationClasses[i], this,
							outcomes[i]);
				}
			}
		}
		return match;
	}

	private ConditionEvaluationReport getConditionEvaluationReport() {
		if (this.beanFactory != null
				&& this.beanFactory instanceof ConfigurableBeanFactory) {
			return ConditionEvaluationReport
					.get((ConfigurableListableBeanFactory) this.beanFactory);
		}
		return null;
	}

	private ConditionOutcome[] getOutcomes(String[] autoConfigurationClasses,
			AutoConfigurationMetadata autoConfigurationMetadata) {
		// Split the work and perform half in a background thread. Using a single
		// additional thread seems to offer the best performance. More threads make
		// things worse
		int split = autoConfigurationClasses.length / 2;
		GetOutcomesThread thread = new GetOutcomesThread(autoConfigurationClasses, 0,
				split, autoConfigurationMetadata);
		thread.start();
		ConditionOutcome[] secondHalf = getOutcomes(autoConfigurationClasses, split,
				autoConfigurationClasses.length, autoConfigurationMetadata);
		try {
			thread.join();
		}
		catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
		ConditionOutcome[] firstHalf = thread.getResult();
		ConditionOutcome[] outcomes = new ConditionOutcome[autoConfigurationClasses.length];
		System.arraycopy(firstHalf, 0, outcomes, 0, firstHalf.length);
		System.arraycopy(secondHalf, 0, outcomes, split, secondHalf.length);
		return outcomes;
	}

	private ConditionOutcome[] getOutcomes(final String[] autoConfigurationClasses,
			int start, int end, AutoConfigurationMetadata autoConfigurationMetadata) {
		ConditionOutcome[] outcomes = new ConditionOutcome[end - start];
		for (int i = start; i < end; i++) {
			String autoConfigurationClass = autoConfigurationClasses[i];
			Set<String> candidates = autoConfigurationMetadata
					.getSet(autoConfigurationClass, "MyConditionalOnClass");
			if (candidates != null) {
				outcomes[i - start] = getOutcome(candidates);
			}
		}
		return outcomes;
	}

	private ConditionOutcome getOutcome(Set<String> candidates) {
		try {
			List<String> missing = getMatches(candidates, MatchType.MISSING,
					this.beanClassLoader);
			if (!missing.isEmpty()) {
				return ConditionOutcome
						.noMatch(ConditionMessage.forCondition(MyConditionalOnClass.class)
								.didNotFind("required class", "required classes")
								.items(Style.QUOTE, missing));
			}
		}
		catch (Exception ex) {
			// We'll get another chance later
		}
		return null;
	}

	@Override
	public ConditionOutcome getMatchOutcome(ConditionContext context,
			AnnotatedTypeMetadata metadata) {
		ClassLoader classLoader = context.getClassLoader();
		ConditionMessage matchMessage = ConditionMessage.empty();
		List<String> onClasses = getCandidates(metadata, MyConditionalOnClass.class);
		if (onClasses != null) {
			List<String> missing = getMatches(onClasses, MatchType.MISSING, classLoader);
			if (!missing.isEmpty()) {
				return ConditionOutcome
						.noMatch(ConditionMessage.forCondition(MyConditionalOnClass.class)
								.didNotFind("required class", "required classes")
								.items(Style.QUOTE, missing));
			}
			matchMessage = matchMessage.andCondition(MyConditionalOnClass.class)
					.found("required class", "required classes").items(Style.QUOTE,
							getMatches(onClasses, MatchType.PRESENT, classLoader));
		}
		List<String> onMissingClasses = getCandidates(metadata,
				MyConditionalOnMissingClass.class);
		if (onMissingClasses != null) {
			List<String> present = getMatches(onMissingClasses, MatchType.PRESENT,
					classLoader);
			if (!present.isEmpty()) {
				return ConditionOutcome.noMatch(
						ConditionMessage.forCondition(MyConditionalOnMissingClass.class)
								.found("unwanted class", "unwanted classes")
								.items(Style.QUOTE, present));
			}
			matchMessage = matchMessage.andCondition(MyConditionalOnMissingClass.class)
					.didNotFind("unwanted class", "unwanted classes").items(Style.QUOTE,
							getMatches(onMissingClasses, MatchType.MISSING, classLoader));
		}
		return ConditionOutcome.match(matchMessage);
	}

	private List<String> getCandidates(AnnotatedTypeMetadata metadata,
			Class<?> annotationType) {
		MultiValueMap<String, Object> attributes = metadata
				.getAllAnnotationAttributes(annotationType.getName(), true);
		List<String> candidates = new ArrayList<String>();
		if (attributes == null) {
			return Collections.emptyList();
		}
		addAll(candidates, attributes.get("value"));
		addAll(candidates, attributes.get("name"));
		return candidates;
	}

	private void addAll(List<String> list, List<Object> itemsToAdd) {
		if (itemsToAdd != null) {
			for (Object item : itemsToAdd) {
				Collections.addAll(list, (String[]) item);
			}
		}
	}

	private List<String> getMatches(Collection<String> candidates, MatchType matchType,
			ClassLoader classLoader) {
		List<String> matches = new ArrayList<String>(candidates.size());
		for (String candidate : candidates) {
			if (matchType.matches(candidate, classLoader)) {
				matches.add(candidate);
			}
		}
		return matches;
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		this.beanFactory = beanFactory;
	}

	@Override
	public void setBeanClassLoader(ClassLoader classLoader) {
		this.beanClassLoader = classLoader;
	}

	private enum MatchType {

		PRESENT {

			@Override
			public boolean matches(String className, ClassLoader classLoader) {
				return isPresent(className, classLoader);
			}

		},

		MISSING {

			@Override
			public boolean matches(String className, ClassLoader classLoader) {
				return !isPresent(className, classLoader);
			}

		};

		private static boolean isPresent(String className, ClassLoader classLoader) {
			if (classLoader == null) {
				classLoader = ClassUtils.getDefaultClassLoader();
			}
			try {
				forName(className, classLoader);
				return true;
			}
			catch (Throwable ex) {
				return false;
			}
		}

		private static Class<?> forName(String className, ClassLoader classLoader)
				throws ClassNotFoundException {
			if (classLoader != null) {
				return classLoader.loadClass(className);
			}
			return Class.forName(className);
		}

		public abstract boolean matches(String className, ClassLoader classLoader);

	}

	private class GetOutcomesThread extends Thread {

		private final String[] autoConfigurationClasses;

		private final int start;

		private final int end;

		private final AutoConfigurationMetadata autoConfigurationMetadata;

		private ConditionOutcome[] outcomes;

		GetOutcomesThread(String[] autoConfigurationClasses, int start, int end,
				AutoConfigurationMetadata autoConfigurationMetadata) {
			this.autoConfigurationClasses = autoConfigurationClasses;
			this.start = start;
			this.end = end;
			this.autoConfigurationMetadata = autoConfigurationMetadata;
		}

		@Override
		public void run() {
			this.outcomes = getOutcomes(this.autoConfigurationClasses, this.start,
					this.end, this.autoConfigurationMetadata);
		}

		public ConditionOutcome[] getResult() {
			return this.outcomes;
		}

	}

}
