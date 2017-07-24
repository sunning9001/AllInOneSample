import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import sample.mybatis.dao.CityDao;
import sample.mybatis.mapper.CityMapper;

@ComponentScan
public class Application {

	public static void main(String[] args) {
		
		

		ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
		
		CityMapper mapper = (CityMapper)context.getBean("cityMapper");
		
		
		
		System.out.println(mapper.getCity("1"));
		
		 CityDao cityDao = (CityDao)context.getBean("cityDao");
		 
		 System.out.println(cityDao.selectCityById(1));
	}
}
