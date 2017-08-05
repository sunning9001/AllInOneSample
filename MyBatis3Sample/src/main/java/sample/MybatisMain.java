package sample;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.example.City;
import org.mybatis.mapper.CityMapper;
import org.springframework.context.ApplicationContext;



public class MybatisMain {

	public static void main(String[] args) throws IOException, SQLException {
		
		
		ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
		
		DataSource ds = context.getBean(DataSource.class);
		
        Connection connection =ds.getConnection();
		System.out.println(connection.getTransactionIsolation());
		
		System.out.println(connection.getMetaData().getDefaultTransactionIsolation());
		
		System.out.println();
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		SqlSession sqlsession = sqlSessionFactory.openSession(connection);
		sqlsession.commit(false);
		
		CityMapper cityMapper = sqlsession.getMapper(CityMapper.class);
		System.out.println("======vvvvvvvv========");
		City city = cityMapper.selectCityById("1");
		System.out.println(city);
	
		City newCity1 =new City();
		newCity1.setName("2");
		newCity1.setCountry("2");
		newCity1.setState("2");
		cityMapper.insert(newCity1 );
		
		System.out.println("***"+cityMapper.selectCityById("2"));
		
	
		
		try {
			City newCity2 = new City();
			newCity2.setName("3");
			newCity2.setCountry("3");
			newCity2.setState("3");
			cityMapper.insert(newCity2);
			throw new Exception();
		} catch (Exception e) {
			// TODO: handle exception
			sqlsession.rollback(true);
		}
		
		System.out.println(("***"+cityMapper.selectCityById("3")));
	}
	
}
