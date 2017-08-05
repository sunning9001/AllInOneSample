import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import sample.mybatis.domain.City;
import sample.mybatis.mapper.CityMapper;

public class TApplication {
	public static void main(String[] args) throws Exception {

		ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");

		DataSourceTransactionManager txManager = (DataSourceTransactionManager) context.getBean("txManager");

		CityMapper cityMapper = (CityMapper) context.getBean("cityMapper");

		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);

		City city2 = cityMapper.getCity("2");
		System.out.println(city2);

		TransactionStatus status = txManager.getTransaction(def);
		try {
			City city = new City();
			city.setCountry("China");
			city.setName("China");
			city.setState("2333");
			cityMapper.insertCity(city);
			if (Math.random() > 0.5) {
				throw new Exception("23333");
			}
			txManager.commit(status);
		} catch (Exception ex) {
			txManager.rollback(status);
			throw ex;
		}
		finally {
			
			City city = cityMapper.getCity("2");
			System.out.println(city);
		}


	}
}
