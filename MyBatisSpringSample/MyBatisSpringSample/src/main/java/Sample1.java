import javax.sql.DataSource;

import org.apache.ibatis.transaction.managed.ManagedTransactionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.mybatis.spring.transaction.SpringManagedTransactionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import sample.mybatis.mapper.CityMapper;

public class Sample1 {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("sample.xml");
		
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();	
	    sqlSessionFactoryBean.setMapperLocations(new Resource[]{(new DefaultResourceLoader()).getResource("sample/mybatis/mapper/CityMapper.xml")});
		DataSource ds = context.getBean(DataSource.class);
		sqlSessionFactoryBean.setDataSource(ds);
		sqlSessionFactoryBean.setTransactionFactory(new SpringManagedTransactionFactory());
		
		MapperFactoryBean<CityMapper>  mapperBean =new MapperFactoryBean<CityMapper>();
		
		mapperBean.setMapperInterface(CityMapper.class);
		try {
			mapperBean.setSqlSessionFactory(sqlSessionFactoryBean.getObject());
			
			
			
			DataSourceTransactionManager txManager =new DataSourceTransactionManager();
			txManager.setDataSource(ds);
			
			
			DefaultTransactionDefinition def = new DefaultTransactionDefinition();
			def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);

			TransactionStatus status = txManager.getTransaction(def);
			try {
				  System.out.println(  ((CityMapper) (mapperBean.getObject())).getCity("1"));
			}
			catch (Exception ex) {
			  txManager.rollback(status);
			  throw ex;
			}
			txManager.commit(status);

		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
