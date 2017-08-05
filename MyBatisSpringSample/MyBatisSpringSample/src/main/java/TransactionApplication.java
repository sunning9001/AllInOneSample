
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import sample.mybatis.domain.City;
import sample.mybatis.mapper.CityMapper;

public class TransactionApplication {
	public static void main(String[] args) throws Exception {

		ApplicationContext context = new ClassPathXmlApplicationContext("transactionApplication.xml");

		CityMapper cityMapper = context.getBean(CityMapper.class);
		DataSourceTransactionManager transactionManager = context.getBean(DataSourceTransactionManager.class);

		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		def.setPropagationBehavior(TransactionDefinition.PROPAGATION_NESTED);

		TransactionStatus status = transactionManager.getTransaction(def);
		try {
			City newCity1 = new City();
			newCity1.setName("1");
			newCity1.setCountry("1");
			newCity1.setState("1");
			cityMapper.insert(newCity1);
			
			transactionManager.commit(status);
			Object savePoint = status.createSavepoint();
			
			City newCity2 = new City();
			newCity2.setName("2");
			newCity2.setCountry("2");
			newCity2.setState("2");
			cityMapper.insert(newCity2);
			System.out.println(cityMapper.getCity("2"));
			status.rollbackToSavepoint(savePoint);
			
			System.out.println(cityMapper.getCity("2"));

		} catch (Exception ex) {
			transactionManager.rollback(status);
			throw ex;
		}


		

	}
}
