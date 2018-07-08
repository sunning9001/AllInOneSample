package com.sun.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * mybait sql 工具类
 * 
 * @author zhuoyuqing
 *
 */
public class SqlUtil {

	private static final SqlUtil instance = new SqlUtil();

	private static SqlSessionFactory sqlSessionFactory = null;

	private SqlUtil() {

		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();

		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream("GeneratedMapperConfig.xml");
		} catch (IOException e) {
			// TODO 加日志
			e.printStackTrace();
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					// TODO  加日志
					e.printStackTrace();
				}
			}
		}
		sqlSessionFactory = builder.build(inputStream);

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
