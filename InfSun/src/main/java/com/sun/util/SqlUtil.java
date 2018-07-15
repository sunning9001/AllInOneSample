package com.sun.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sun.httpserver.HttpServer;

/**
 * mybait sql 工具类
 * 
 * @author zhuoyuqing
 *
 */
public class SqlUtil {

	 private static final Logger logger =LoggerFactory.getLogger(HttpServer.class);
		
	private static final SqlUtil instance = new SqlUtil();

	private static SqlSessionFactory sqlSessionFactory ;

	private SqlUtil() {

		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		InputStream inputStream = null;
		try {
			
			inputStream = Resources.getResourceAsStream("mybatis-config.xml");
			sqlSessionFactory = builder.build(inputStream);
			
		} catch (IOException e) {
			logger.debug("SqlUtil sqlSession---     {}",e);
			e.printStackTrace();
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					logger.debug("inputStream close()---     {}",e);
					e.printStackTrace();
				}
			}
		}

	}

	public static SqlUtil getInstance() {
		return instance;
	}

	/**
	 * 操作数据库时，每次都要调用这个方法，SqlSession使用后要关闭资源的。
	 * 
	 * @return
	 */
	public SqlSession getSqlSession() {
		return sqlSessionFactory.openSession();
	}

}
