package importSelectorSample;

import java.util.Map;
import java.util.Set;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class ImportSelectorSample implements ImportSelector {

	@Override
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
/*		System.out.println("*****"+importingClassMetadata.getClassName());
		Set<String> set = importingClassMetadata.getAnnotationTypes();
		
		for (String s : set) {
			System.out.println(s);
		}
		
	
		Map<String, Object> attritues = importingClassMetadata.getAnnotationAttributes(ImportSample.class.getName());
	
		for(Map.Entry<String, Object> entry: attritues.entrySet()){
			
			System.out.println(entry.getKey());
		}*/
		
		return new String[]{ImportHelloWorld.class.getName()};
	}

}
