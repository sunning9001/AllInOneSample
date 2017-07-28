package sample;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.example.City;
import org.mybatis.mapper.CityMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) throws IOException, SQLException {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
		
		DataSource ds = context.getBean(DataSource.class);
		
		System.out.println();
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		SqlSession sqlsession = sqlSessionFactory.openSession(ds.getConnection());
		
		CityMapper cityMapper = sqlsession.getMapper(CityMapper.class);
		System.out.println("======vvvvvvvv========");
		City city = cityMapper.selectCityById("1");
		
		System.out.println(city);
	}
	
}
