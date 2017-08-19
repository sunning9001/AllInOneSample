package custom;

import java.util.Map;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.util.MultiValueMap;

public class SomeBeanConfigurationSelector implements ImportSelector {
	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		
		return null;
	}
}

@Configuration
class SomeBeanConfigurationType1 {

	@Bean
	public String aBean() {
		return "Type1";
	}

}

@Configuration
class SomeBeanConfigurationDefault {

	@Bean
	public String aBean() {
		return "Default";
	}

}