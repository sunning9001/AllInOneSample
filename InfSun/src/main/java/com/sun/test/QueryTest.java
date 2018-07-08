package com.sun.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.sun.entity.autodao.Fs_dwzbMapper;
import com.sun.entity.automodel.Fs_dwzb;
import com.sun.entity.automodel.Fs_dwzbExample;
import com.sun.entity.automodel.Fs_dwzbExample.Criteria;

public class QueryTest {

	private SqlSessionFactory sqlSessionFactory ;
	 
	@Before
    public void InitialContext() throws IOException{
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        
        InputStream inputStream=Resources.getResourceAsStream("com/afis/jx/entity/GeneratedMapperConfig.xml");
        SqlSessionFactory sqlSessionFactory = builder.build(inputStream);
        this.sqlSessionFactory=sqlSessionFactory;
        
    }
	
	public void fun() {
		SqlSession sqlsession  = sqlSessionFactory.openSession();
		
		Fs_dwzbMapper fs_dwzbMapper =  sqlsession.getMapper(Fs_dwzbMapper.class);
		
		Fs_dwzbExample fs_dwzbExample = new Fs_dwzbExample() ;
		Criteria criteria  = fs_dwzbExample.createCriteria();
		criteria.andDwdmEqualTo("0000");
		List<Fs_dwzb> list = fs_dwzbMapper.selectByExample(fs_dwzbExample);
		
		System.err.println(list);
		
	}
	
	@Test 
	public void fun2() {
		SqlSession sqlsession  = sqlSessionFactory.openSession();
		
		Fs_dwzbMapper fs_dwzbMapper =  sqlsession.getMapper(Fs_dwzbMapper.class);
		
		Fs_dwzbExample fs_dwzbExample = new Fs_dwzbExample() ;
		Criteria criteria  = fs_dwzbExample.createCriteria();
		criteria.andDwdmLike("%1234%");
		criteria.andDwmcLike("%部%");
		
		
		List<Fs_dwzb> list = fs_dwzbMapper.selectByExample(fs_dwzbExample);
		
		for(Fs_dwzb ss :list) {
			
			System.err.println(ss.toString());
		}
		
	}
	
	@Test 
	public void fun3() {
		SqlSession sqlsession  = sqlSessionFactory.openSession();
		
		Fs_dwzbMapper fs_dwzbMapper =  sqlsession.getMapper(Fs_dwzbMapper.class);
		
		Fs_dwzb fs_dwzb = new Fs_dwzb() ;
		fs_dwzb.setDwdm("1234");
		fs_dwzb.setDwmc("无锡测试部门");
		
		fs_dwzbMapper.insert(fs_dwzb);
		
	}
}
