package importSelectorSample;

import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class ImportBeanDefinitionRegistrarSample implements ImportBeanDefinitionRegistrar {

	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		System.out.println("*****"+importingClassMetadata.getClassName());
		Set<String> set = importingClassMetadata.getAnnotationTypes();
		
		for (String s : set) {
			System.out.println(s);
		}
		
	
		Map<String, Object> attritues = importingClassMetadata.getAnnotationAttributes(ImportSample.class.getName());
	
		for(Map.Entry<String, Object> entry: attritues.entrySet()){
			
			System.out.println(entry.getKey());
		}
		
		

	}

}
