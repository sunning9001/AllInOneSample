package com.bjbank;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.excel.annotation.ExcelProperty;

public class TextUtil {

	private static Logger logger = LoggerFactory.getLogger(TextUtil.class);
	/*
	 * code -name映射
	 */
	public static Map<String, Company> codeMap = new HashMap<String, Company>();
	/*
	 * name -code映射
	 */
	public static Map<String, Company> nameMap = new HashMap<String, Company>();
	
	
	//ORG_ORG_CD	companyCode -AgtNum
   	public static Map<String, String> acctAgtNumMap =new HashMap<String, String>();

	/**
	 * 初始化并缓存
	 * 
	 * @param list
	 */
	public void initCompanyMap(List<Company> list) {

		codeMap.clear();
		nameMap.clear();
		for (Company company : list) {
			codeMap.putIfAbsent(company.getCompanyCode(), company);
			nameMap.putIfAbsent(company.getCompanyName(), company);
		}
	}

	/**
	 * 根据公司名称获取公司
	 * 
	 * @param companyName
	 * @return
	 */
	public Company getCompanyByName(String companyName) {
		return nameMap.get(companyName);
	}

	/**
	 * 根据信用代码获取
	 * 
	 * @param companyCode
	 * @return
	 */
	public Company getCompanyByCodee(String companyCode) {
		return codeMap.get(companyCode);
	}

	public static void updateTransactionByText(String file) {
		
		//1、读取指定文件  
		
		List<String[]> list=parseTextToLineArr(file);
		
		//2.转换成  TextAcctDtl list
		 List<Object> objList= parseToTextCompanyTransaction(list,TextAcctDtlEvent.class);
		 
		//3.  银行账号作为key    Map<Key,List<TextAcctDtl>> 因为同一个账号下面可以有多币流水
		 
		 Map<String, List<TextAcctDtlEvent>>  agtMap =new HashMap<>();
		for (Object obj : objList) {
			TextAcctDtlEvent acctDtl =(TextAcctDtlEvent)obj;
			
			String agtNum = acctDtl.getACCT_AGT_NUM();
			
			List<TextAcctDtlEvent> eventList = agtMap.get(agtNum);
			if(eventList ==null) {
				eventList =new ArrayList<>();
			}
			eventList.add(acctDtl);
			agtMap.putIfAbsent(agtNum, eventList);
		}
		//发送所有流水
		
		List<Object> sendList =new ArrayList<Object>();
		 //迭代所有财务局需要的
	  for(Map.Entry<String, String> e:acctAgtNumMap.entrySet()) {
		  
		  String agtNum = e.getValue();
		  String companyCode =e.getKey();
		  List<TextAcctDtlEvent> agtEventList = agtMap.get(agtNum);
		  if(agtEventList!=null) {
			  
			  //做类型转换TextAcctDtlEvent ->CompanyTransaction
			  
			  for (TextAcctDtlEvent acctEvent : agtEventList) {
				  
				  CompanyTransaction transaction =new CompanyTransaction();
				  
				  //::TODO 转换
				  
					// 是 string 平台公司名称
					transaction.setCompanyName(nameMap.get(companyCode).getCompanyName());
				
					// 是 string 平台公司统一信用代码
					transaction.setCompanyCode(companyCode);
					// 是 string 开户行名称
					//transaction.setBank("");
					// 是 int 银行账号
					transaction.setAccount(agtNum);
					// 是 timestamp 交易时间
					transaction.setDealTime(acctEvent.getBOOK_ENTRY_TIME());
					// 是 int 交易币种(1.人民币，2.美元，3.欧元，4.日元，5.英镑，6.港币，7.韩元，8.其他)
					//transaction.setTransactionCurrency("");
					// 是 int 对方账户
					transaction.setReciprocalAccount(acctEvent.getCNTPTY_ACCT());
					// 是 string 对方户名
					transaction.setReciprocalName(acctEvent.getCNTPTY_USER_NAME());
					// 是 string 摘要
					transaction.setContent(acctEvent.getCORP_MEMO_DESC());
					// 是 int 资金流向1收入2支出
					transaction.setFundFlow(acctEvent.getDEBIT_CRDT_DIR_CD());
					// 是 double 交易金额
					//transaction.setTransactionAmount(acctEvent.getEVENT_AMT());
					// 是 double 账户余额（交易卡余额）
					//transaction.setAccountBalance(acctEvent.getACCT_BAL());
					// 是 varchar 交易方式（字符串格式）
					transaction.setExchangeType("");
					
					
				//转换完成
				  
				  sendList.add(transaction);
			}
			  
		  }else
		  {
			  logger.debug("==========================");
		  }
	  }
	  
	  try {
		BJBankUitl.updateCompanyAccount(sendList, BJBankUitl.getToken());
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
		 
		 
	}
	/**
	 * 根据text文本来更新账号信息
	 * @param file
	 */
	public static void updateCompanyAccountByText(String file) {
		
		//1、读取指定文件
		//2、转换成  ORG_ORG_CD	组织机构代码
		Map<String, TextCustAcct> orgMap =new HashMap<String, TextCustAcct>();
		
		List<Object> sendList =new ArrayList<Object>();
		//迭代所有财务局需要的账号
		for (Map.Entry<String, Company> e: codeMap.entrySet()) {
			
			String companyCode =e.getKey();
			Company  company =e.getValue();
			String searchKey = transactionForSearchKey(companyCode);
			TextCustAcct textAcc = orgMap.get(searchKey);
			if(textAcc!=null) {
				
				//转换  TextCompanyAccount ->CompanyAccount
				CompanyAccount account =new CompanyAccount();
				
			    // 是平台公司统一信用代码
			    account.setCompanyCode(company.getCompanyCode());
			    // 是 string 平台公司名称
			    account.setCompanyName(company.getCompanyName());
			    // 是 string 账户名称
			    account.setAccountName(textAcc.getCUST_NAME());
			     // 是 int 账户类型 1基本、2一般、3临时、4专用、5 其他
			   // account.setAccountType(textAcc.getACCT_CHAR_CD());
                // 是 int 账户状态 1正常、2冻结、3已注销、4 止付
			    //account.setAccountStatus("");
               // 是 timestamp 开户时间
			    account.setAccountOpenTime(textAcc.getOPEN_DT());
			    // 是 string 开户行
			    account.setBank("");
			    // 是 int 银行账号
			    account.setAccount(textAcc.getAGT_NUM());
			  // 是 double 账户余额（万元）
			 //   account.setAccountBalance(textAcc.getCURR_BAL());
	           // 是 double 可用余额（万元）
			    //account.setAvailableBalance(textAcc.getCURR_BAL());
			    sendList.add(account);
			}
			else {
				logger.debug(" can not  find  company  account org key ={}  companycode ={}",searchKey,companyCode);
			}
			
			
		}
		try {
			BJBankUitl.updateCompanyAccount(sendList,  BJBankUitl.getToken());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//2、根据所有平台查找账号
		//3、转换数据CompanyAccount
		//4、调研 updateCompanyAccount(List<Object> list, String token) 
		
	}
	/**
	 *  根据companycode 换成成组织机构号
	 * @param companyCode
	 * @return
	 */
	public static String transactionForSearchKey(String companyCode) {
		return null;
	}
	public static List<Object> parseToTextCompanyTransaction(List<String[]> paramlist, Class clazz) {

		List<Object> list = new ArrayList<>();

		for (String[] sArr : paramlist) {

			// 遍历每一行,按照顺序

			Object obj = null;
			for (int i = 0; i < sArr.length; i++) {

				try {
					obj = clazz.newInstance();
					Field[] fields = clazz.getDeclaredFields();
					for (Field f : fields) {

						TextIndex a = f.getAnnotation(TextIndex.class);
						if (a != null) {

							if (a.index() == i) {
								f.setAccessible(true);
								f.set(obj, sArr[i]);
								continue;
							}
						}
					}
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			if (obj != null)
				list.add(obj);
		}
		return list;
	}

	public static List<String[]> parseTextToLineArr(String fileName) {

		fileName = "F:\\MyGitHub\\AllInOneSample\\BJBank\\src\\main\\java\\WX_EDW_WX_CM_CORP_CUST_DPSIT_ACCT_SUM_M_20190823_test.txt";

		List<String[]> list = new ArrayList<String[]>();
		FileInputStream inputStream = null;
		BufferedReader bufferedReader = null;
		try {
			inputStream = new FileInputStream(fileName);
			// 设置inputStreamReader的构造方法并创建对象设置编码方式为gbk
			bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "utf-8"));

			String str = null;
			while ((str = bufferedReader.readLine()) != null) {
				// 使用\001 来分割字符串
				String[] strArr = StringUtils.splitByWholeSeparator(str, "\001");

				list.add(strArr);
			}

		} catch (FileNotFoundException e) {
			logger.debug("parseTextToLineArr FileNotFoundException:{}", e);
		} catch (UnsupportedEncodingException e) {
			logger.debug("parseTextToLineArr UnsupportedEncodingException:{}", e);

		} catch (IOException e) {
			logger.debug("parseTextToLineArr readLine  IOException :{}", e);
		} finally {
			if (bufferedReader != null)
				try {
					bufferedReader.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			if (inputStream != null)
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		return list;

	}
}
