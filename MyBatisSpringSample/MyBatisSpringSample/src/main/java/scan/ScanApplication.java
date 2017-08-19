package scan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ScanApplication {

	public static void main(String[] args) {
		
		ApplicationContext context =new AnnotationConfigApplicationContext("scan");
		CityMapper mapper = context.getBean(CityMapper.class);
		System.out.println(mapper.getCity("1"));
		
	}
}
