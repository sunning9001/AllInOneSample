package importSelectorSample;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@ImportSample
@RegisterSample
public class ImportSampleMain {
	public static void main(String[] args) {

		  ApplicationContext ctx = new AnnotationConfigApplicationContext("importSelectorSample");
	}
}
