package com.sun.test;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.alibaba.fastjson.JSONObject;
import com.sun.bean.UpdateBean;
import com.sun.bean.UtilMapper;
import com.sun.config.ConfigUtil;
import com.sun.config.HttpUtil;
import com.sun.config.InfConstants;
import com.sun.config.ResponseCode;
import com.sun.entity.autodao.Fs_kphzMapper;
import com.sun.entity.autodao.Fs_pjdzMapper;
import com.sun.entity.autodao.Fs_pjjfMapper;
import com.sun.entity.autodao.Fs_sfxmMapper;
import com.sun.entity.automodel.Fs_kphz;
import com.sun.entity.automodel.Fs_kphzExample;
import com.sun.entity.automodel.Fs_pjdz;
import com.sun.entity.automodel.Fs_pjdzExample;
import com.sun.entity.automodel.Fs_pjjf;
import com.sun.entity.automodel.Fs_pjjfExample;
import com.sun.entity.automodel.Fs_sfxm;
import com.sun.entity.automodel.Fs_sfxmExample;
import com.sun.entity.automodel.Fs_sfxmExample.Criteria;
import com.sun.msg.BillfundResultsMessageRequest;
import com.sun.msg.BillfundResultsMessageResponse;
import com.sun.msg.request.FailDetails;
import com.sun.msg.request.FundResultsRequest;
import com.sun.util.DateUtil;
import com.sun.util.SqlUtil;
import com.sun.util.StatusConvertUtil;

public class QueryTest {

	@Test
	public void testFundResults() {
		String tradeDay ="20180717";
		String accountfirm_no = "123456789";
		String bankindex = "wsws";
		excuteFundConfirmResult(tradeDay,accountfirm_no,bankindex);
	}
	
    public  void  excuteFundConfirmResult(String tradeDay,String accountfirm_no,String bankindex) {
		
		//创建对账结果  请求对象
		BillfundResultsMessageRequest request = new BillfundResultsMessageRequest();
		
		SqlSession sqlSession = SqlUtil.getInstance().getSqlSession();
		
		//根据业务日期 和流水号查询 票据对账表
		Fs_pjdzMapper pjdzMapper = sqlSession.getMapper(Fs_pjdzMapper.class);
		Fs_pjdzExample fs_pjdzExample = new Fs_pjdzExample() ;
		fs_pjdzExample.createCriteria().andDateEqualTo(tradeDay);
		fs_pjdzExample.createCriteria().andAccconfirmNoEqualTo(accountfirm_no);
		List<Fs_pjdz> pjdzList = pjdzMapper.selectByExample(fs_pjdzExample);
		
		Fs_pjdz fs_pjdz = null;
		if( pjdzList != null &&  pjdzList.size()>0) {
			fs_pjdz = pjdzList.get(0);
		}
		if(fs_pjdz == null) {
			//根据业务日期和流水号未查询到 票据对账记录 
			//todo---------------------------------------------------------------------------如果当天没有接收到对账请求 ，会出现这种情况   商量修改
		}
		
		request.setZone_code(ConfigUtil.getZoneCode());
		request.setMethod(InfConstants.AccountBillFundConfirm);
		request.setTimestamp(DateUtil.dateToStirngTime(new Date()));
		//银行编号
		request.setBankindex(bankindex); 
		
		FundResultsRequest biz_content = new FundResultsRequest() ;
		biz_content.setDate(tradeDay);
		biz_content.setAccountfirm_no(accountfirm_no);
		List<FailDetails> faillist = new ArrayList<FailDetails>();
		int success = 0;
		int fail = 0 ;
		for(int i=0 ;i<pjdzList.size() ;i++) {
			Fs_pjdz pjdz = pjdzList.get(i);
			String billno = pjdz.getBillno();
			
			Fs_pjjfMapper jfmapper = sqlSession.getMapper(Fs_pjjfMapper.class);
			Fs_pjjfExample pjjfExample = new Fs_pjjfExample() ;
			pjjfExample.createCriteria().andBillnoEqualTo(billno);
			List<Fs_pjjf> pjjfList = jfmapper.selectByExample(pjjfExample);
			
			Fs_pjjf pjjf =null ;
			if(pjjfList != null && pjjfList.size() >0) {
				pjjf = pjjfList.get(0);
			}
			
			if(pjjf != null) {
				success ++ ;
				
			}else {
				fail ++ ;
				FailDetails failDetails = new FailDetails() ;
				//交易流水号
				String trade_no = pjdz.getTradeNo();
				
				//根据票据号查询
				Fs_kphzMapper kpViewMapper = sqlSession.getMapper(Fs_kphzMapper.class);
				Fs_kphzExample example =new Fs_kphzExample();
				example.createCriteria().andPjhEqualTo(billno);
				List<Fs_kphz> billList = kpViewMapper.selectByExample(example );
				
				//判断金额是否足够, 对账金额 小于 库中金额，则不满足情况
				BigDecimal total = new BigDecimal("0") ;
				for (Fs_kphz hz: billList) {
					 BigDecimal je = hz.getJe().setScale(2,BigDecimal.ROUND_HALF_UP);
					 total = total.add(je);
				}
				BigDecimal actualAmount = new BigDecimal(pjdz.getAmount()) ;
				//错误码 。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。如果金额也满足，code 可能为 空,需要解决
				String code = "" ;
				String msg = "" ;
				if(actualAmount.compareTo(total) < 0) {
					code = ResponseCode.confirm01 ;
					msg = ResponseCode.getCodeDesc(code);
				}
				
				failDetails.setTrade_no(trade_no);
				failDetails.setCode(code);
				failDetails.setMsg(msg);
				
				faillist.add(failDetails);
				
			}
			
			biz_content.setSucceedcount(success);
			biz_content.setFailcount(fail);
			biz_content.setFaillist(faillist);
			
			
		}
		
		request.setBiz_content(biz_content);
		
		//向公共支付平台请求消息
		//转换成JSON String
		String postBody =JSONObject.toJSONString(request);
		System.out.println("postBody-----------"+postBody);
		BillfundResultsMessageResponse response = (BillfundResultsMessageResponse) HttpUtil.getInstance().httpExecute(postBody , ConfigUtil.getUrl(), BillfundResultsMessageResponse.class);
		
		System.out.println(response.toString());
	}

	@Test
	public void testStatus() {
		String fs = StatusConvertUtil.getPayPlatformStatus("3");
		System.out.println(fs);
		String fs2 = StatusConvertUtil.getPayPlatformStatus("2");
		System.out.println(fs2);
		String fs3 = StatusConvertUtil.getPayPlatformStatus("1");
		System.out.println(fs3);
		
		String  fs4 = StatusConvertUtil.getSFStatus("1");
		System.out.println(fs4);
		
		String  fs5 = StatusConvertUtil.getSFStatus("2");
		System.out.println(fs5);
		String  fs6 = StatusConvertUtil.getSFStatus("0");
		System.out.println(fs6);
		
		
	}
	@Test
	public void testBigDecimal() {
		
		BigDecimal b1 = new BigDecimal("100.00");
		System.out.println(b1.toString());
		if(! b1.toString().equals("100.00")) {
			System.out.println("100.00 == 100.00");
		}else {
			System.out.println("nonono");
		}
		
		
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
