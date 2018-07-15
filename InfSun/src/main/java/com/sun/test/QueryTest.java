package com.sun.test;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.sun.bean.UpdateBean;
import com.sun.bean.UtilMapper;
import com.sun.entity.autodao.Fs_kphzMapper;
import com.sun.entity.autodao.Fs_sfxmMapper;
import com.sun.entity.automodel.Fs_kphz;
import com.sun.entity.automodel.Fs_kphzExample;
import com.sun.entity.automodel.Fs_sfxm;
import com.sun.entity.automodel.Fs_sfxmExample;
import com.sun.entity.automodel.Fs_sfxmExample.Criteria;
import com.sun.util.SqlUtil;

public class QueryTest {

	@Test
	public void testBigDecimal() {
		
		BigDecimal b1 = new BigDecimal("100.00");
		System.out.println(b1.toString());
		if(! b1.toString().equals("100.00")) {
			System.out.println("100.00 == 100.00");
		}else {
			System.out.println("nonono");
		}
		
//		BigDecimal b2 = new BigDecimal("100.00");
//		if(b2.toString() == "100.00") {
//			System.out.println("100.00 == 100.00");
//		}

	}
	
	@Test
	 public void  testUtilMapper() {
		    SqlUtil sqlutil = SqlUtil.getInstance(); 
			SqlSession sqlsession = sqlutil.getSqlSession();
			
			 UtilMapper utilMapper = sqlsession.getMapper(UtilMapper.class);
			 String ss = utilMapper.selectMonth("00707375");
			 
			 Fs_kphzMapper fs_kphzMapper  = sqlsession.getMapper(Fs_kphzMapper.class);
			 
			 Fs_kphzExample ex = new Fs_kphzExample();
			 ex.createCriteria().andPjhEqualTo("00707375");
			 List<Fs_kphz> list =  fs_kphzMapper.selectByExample(ex);
//			 
//			 UpdateBean bean = new UpdateBean();
//			 bean.setJkrq(new Date());
//			 bean.setPjh("00707375");
//			 bean.setPjzt("3");
//			 bean.setTable_name("fs_kp01");
//			 utilMapper.updateJkztAndJkrq(bean);
			 
			 sqlsession.commit();
			 sqlsession.close();
			 
			 for(Fs_kphz hz: list) {
				 System.out.println("---"+hz.toString());
			 }
			 
			 System.out.println(ss);
			
			 
			 
	 }
	    //对表  fs_sfxm 操作，此表包含的类型多，方便校验数据库类型 money datetime decimal
	    
	    /**
	      *   查询
	     */
		@Test   
		public void fun4() {
			
			SqlUtil sqlutil = SqlUtil.getInstance(); 
			SqlSession sqlsession = sqlutil.getSqlSession();
			
			
			Fs_sfxmMapper fs_sfxmMapper = sqlsession.getMapper(Fs_sfxmMapper.class);
			
			Fs_sfxmExample fs_sfxmExample = new Fs_sfxmExample() ;
			Criteria criteria = fs_sfxmExample.createCriteria();
			criteria.andDmEqualTo("88");
			List<Fs_sfxm> list = fs_sfxmMapper.selectByExample(fs_sfxmExample);
			System.err.println("用自动生成的方法查询结果======="+list.get(0).toString());   //定为1
			
			
//			Fs_sfxm result2 = fs_sfxmMapper.selectByDm("88");
//			System.err.println("自己写的方法查询整个实体======="+result2.toString());     //定为 2
//					
//			String result3 = fs_sfxmMapper.selectByDm2("88");
//			System.err.println("自己写的方法查询单个字段======="+result3.toString());     //定为3 
			
			//结果 ，关于日期Date，money类型的  1和3的查询结果同数据库一致，2的查询结果无date 和money类型
			
			sqlsession.close();  //关闭session 
		}
		
		/**
		 *  新增
		 */
		@Test
		public void fun5() {
			SqlUtil sqlutil = SqlUtil.getInstance(); 
			SqlSession sqlsession = sqlutil.getSqlSession();
			
			Fs_sfxmMapper fs_sfxmMapper = sqlsession.getMapper(Fs_sfxmMapper.class);
			
			Fs_sfxm fsxm = new Fs_sfxm() ;
			fsxm.setDm("88") ; //必填字段
			fsxm.setDefDt1(new Date()); // 日期字段
			
			BigDecimal bd = new BigDecimal("88.8888");
			fsxm.setDefNum1(bd);  //数据库 money字段
			
			//保存
			int  result = fs_sfxmMapper.insert(fsxm);
			System.err.println(result);
			
			sqlsession.commit();
			sqlsession.close();
			
			fun4();
		}
		
		
		
		/**
		 *  修改  总结：用updateByExampleSelective 方法
		   updateByExampleSelective 方法 不改变其他字段内容
		 */
		
		@Test
		public void fun6() {
			
			SqlUtil sqlutil = SqlUtil.getInstance(); 
			SqlSession sqlsession = sqlutil.getSqlSession();
			
			Fs_sfxmMapper fs_sfxmMapper = sqlsession.getMapper(Fs_sfxmMapper.class);
			
			Fs_sfxmExample fs_sfxmExample = new Fs_sfxmExample() ;
			Criteria criteria = fs_sfxmExample.createCriteria();
			criteria.andDmEqualTo("88");
			
			Fs_sfxm fsxm = new Fs_sfxm() ;
			fsxm.setMc("无锡") ; 
			fsxm.setDefDt2(new Date()); 
			fs_sfxmMapper.updateByExampleSelective(fsxm, fs_sfxmExample);
			
			sqlsession.commit();
			sqlsession.close();
			
			fun4();
		}
		
		
		
		
		/**
		 *   删除
		 */
		@Test
		public void func7() {
			SqlUtil sqlutil = SqlUtil.getInstance(); 
			SqlSession sqlsession = sqlutil.getSqlSession();
			
			Fs_sfxmMapper fs_sfxmMapper = sqlsession.getMapper(Fs_sfxmMapper.class);
			Fs_sfxmExample fs_sfxmExample = new Fs_sfxmExample() ;
			Criteria criteria = fs_sfxmExample.createCriteria();
			criteria.andDmEqualTo("88");
			
			fs_sfxmMapper.deleteByExample(fs_sfxmExample);
			sqlsession.commit();
			sqlsession.close();
			
			fun4();
		}
	
}
