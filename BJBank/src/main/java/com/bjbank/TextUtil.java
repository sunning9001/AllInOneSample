package com.bjbank;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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


	// ORG_ORG_CD companyCode -AgtNum
	public static Map<String, String> acctAgtNumMap = new HashMap<String, String>();

	/**
	 * 初始化并缓存
	 *  
	 * @param list
	 */
	public static void initCompanyMap(List<Company> list) {
		logger.info("initCompanyMap  num={}",list.size());
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
    /**
     * 读取交易文本文件,并发送到财政局
     * @param file
     */
	public static void updateTransactionByText(String file) {

		if(codeMap.size()==0) {
			logger.info(" fisrt  download  company list file  ,company list total={}",codeMap.size());
			return;
		}
		if(acctAgtNumMap.size()==0) {
			logger.info(" fisrt  read  company account  file  ,ompany account  file total={}",acctAgtNumMap.size());
			return;
		}
		// 1、读取指定文件,转换成行数组
		List<String[]> list = parseTextToLineArr(file);

		// 2.转换成 TextAcctDtl list
		List<Object> objList = parseToTextObject(list, TextAcctDtlEvent.class);

		// 3. 银行账号作为key Map<Key,List<TextAcctDtl>> 因为同一个账号下面可以有多币流水
		Map<String, List<TextAcctDtlEvent>> agtMap = new HashMap<>();
		for (Object obj : objList) {
			TextAcctDtlEvent acctDtl = (TextAcctDtlEvent) obj;
			String agtNum = acctDtl.getACCT_AGT_NUM();
			List<TextAcctDtlEvent> eventList = agtMap.get(agtNum);
			if (eventList == null) {
				eventList = new ArrayList<>();
			}
			eventList.add(acctDtl);
			agtMap.putIfAbsent(agtNum, eventList);
		}
		// 发送所有流水

		List<Object> sendList = new ArrayList<Object>();
		// 迭代所有财务局需要的
		for (Map.Entry<String, String> e : acctAgtNumMap.entrySet()) {

			String agtNum = e.getValue();
			String companyCode = e.getKey();
			List<TextAcctDtlEvent> agtEventList = agtMap.get(agtNum);
			if (agtEventList != null) {

				// 做类型转换TextAcctDtlEvent ->CompanyTransaction

				for (TextAcctDtlEvent acctEvent : agtEventList) {

					CompanyTransaction transaction = new CompanyTransaction();

					// 是 string 平台公司名称
					transaction.setCompanyName(nameMap.get(companyCode).getCompanyName());
					// 是 string 平台公司统一信用代码
					transaction.setCompanyCode(companyCode);
					// 是 string 开户行名称
					 transaction.setBank("北京银行股份有限公司无锡梁溪支行");
					// 是 int 银行账号
					transaction.setAccount(agtNum);
					// 是 timestamp 交易时间
					String dealTime =parseToFormatDate(acctEvent.getBOOKENTRY_DT(), acctEvent.getBOOK_ENTRY_TIME());
					transaction.setDealTime(dealTime);
					// 是 int 交易币种(1.人民币，2.美元，3.欧元，4.日元，5.英镑，6.港币，7.韩元，8.其他)
					transaction.setTransactionCurrency(1); //默认人民币
					// 是 int 对方账户
					transaction.setReciprocalAccount(acctEvent.getCNTPTY_ACCT());
					// 是 string 对方户名
					transaction.setReciprocalName(acctEvent.getCNTPTY_USER_NAME());
					// 是 string 摘要
					transaction.setContent(acctEvent.getCORP_MEMO_DESC());
					// 是 int 资金流向1收入2支出
					String fundFlow =parseTofundFlow(acctEvent.getDEBIT_CRDT_DIR_CD());
					transaction.setFundFlow(fundFlow);
					// 是 double 交易金额
					transaction.setTransactionAmount(new BigDecimal(acctEvent.getEVENT_AMT()));
					// 是 double 账户余额（交易卡余额）
					transaction.setAccountBalance(new BigDecimal(acctEvent.getACCT_BAL()));
					// 是 varchar 交易方式（字符串格式）
					transaction.setExchangeType("网银");//默认网易
					// 转换完成
					sendList.add(transaction);
					
			
				}

			} else {
				logger.info("==========================");
			}
		}
		try {
			BJBankUitl.updateCompanyAccount(sendList, BJBankUitl.getToken());
		} catch (IOException e1) {
			logger.info(" updateTransactionByText  IOException{}",e1);
		}

	}
	/**
	 * DEBIT_CRDT_DIR_CD=D, DEBIT_CRDT_DIR_DESC=借
	 * DEBIT_CRDT_DIR_CD=C, DEBIT_CRDT_DIR_DESC=贷
	 * 根据  DEBIT_CRDT_DIR_CD 转换成  资金流向1收入2支出
	 * @param s
	 * @return
	 */
	public  static String parseTofundFlow(String s) {
		if(s!=null && s.equalsIgnoreCase("C"))return "1";
		if(s!=null && s.equalsIgnoreCase("D"))return "2";
		return null;
	}
    /**
     * 
     * @param dt
     * @param time
     * @return   yyyy-MM-dd HH:mm:ss
     */
	public static String  parseToFormatDate(String dt,String time) {
		
		java.text.SimpleDateFormat s = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			Date d = s.parse(dt+" "+time.substring(0,2)+":"+time.substring(2, 4)+":"+time.substring(4, 6));
			return d.toLocaleString();
		} catch (ParseException e) {
			logger.info(" parseToFormatDate ParseException ");
		}
		return null;
	}
	/**
	 * 读取账户文本文件,并发送到财政局
	 * 
	 * @param file  账户文件名称
	 */
	public static void updateCompanyAccountByText(String file) {

		if(codeMap.size()==0) {
			logger.info(" fisrt  download  company list file  ,company list total={}",codeMap.size());
			return;
		}
		logger.info("updateCompanyAccountByText red file name:{}",file);
		// 1、读取指定文件
		List<String[]> strArr = parseTextToLineArr(file);
		
		//2、转换成  TextCustAcct list 
		List<Object> custAcctList = parseToTextObject(strArr, TextCustAcct.class);
		// 3、转换成 ORG_ORG_CD 组织机构代码
		Map<String, TextCustAcct> orgMap = new HashMap<String, TextCustAcct>();

		for (Object obj : custAcctList) {
			TextCustAcct textCustAcct =(TextCustAcct)obj;
			orgMap.putIfAbsent(textCustAcct.getORG_ORG_CD(), textCustAcct);
		}
		
		List<Object> sendList = new ArrayList<Object>();
		// 迭代所有财务局需要的账号
		for (Map.Entry<String, Company> e : codeMap.entrySet()) {

			String companyCode = e.getKey();
			Company company = e.getValue();
			//根据 ORG_ORG_CD 组织机构代码 匹配 companyCode
			String searchKey = transactionForSearchKey(companyCode);
			TextCustAcct textAcc = orgMap.get(searchKey);
			if (textAcc != null) {

				// 转换 TextCompanyAccount ->CompanyAccount
				CompanyAccount account = new CompanyAccount();

				// 是平台公司统一信用代码
				account.setCompanyCode(company.getCompanyCode());
				// 是 string 平台公司名称
				account.setCompanyName(company.getCompanyName());
				// 是 string 账户名称
				account.setAccountName(textAcc.getCUST_NAME());
				// 是 int 账户类型 1基本、2一般、3临时、4专用、5 其他
				// account.setAccountType(textAcc.getACCT_CHAR_CD());
				// 是 int 账户状态 1正常、2冻结、3已注销、4 止付
				// account.setAccountStatus("");
				// 是 timestamp 开户时间
				String accountOpenTime =parseToFormatDate(textAcc.getOPEN_DT(),"000000");
				account.setAccountOpenTime(accountOpenTime);
				// 是 string 开户行
				account.setBank("北京银行股份有限公司无锡梁溪支行");//默认
				// 是 int 银行账号
				account.setAccount(textAcc.getAGT_NUM());
				// 是 double 账户余额（万元）
				 account.setAccountBalance(new BigDecimal(textAcc.getCURR_BAL()));
				// 是 double 可用余额（万元）
				 account.setAvailableBalance(new BigDecimal(textAcc.getCURR_BAL()));
				 sendList.add(account);
				 
				 
				//缓存银行账号 companyCode -bankNum
				acctAgtNumMap.put(companyCode, textAcc.getAGT_NUM());
			} else {
				logger.info(" can not  find  company  account org key ={}  companycode ={}", searchKey, companyCode);
			}
		}
		try {
			logger.info(" updateCompanyAccountByText   company  account info  total=:{}",sendList.size());
			BJBankUitl.updateCompanyAccount(sendList, BJBankUitl.getToken());
		} catch (IOException e1) {
			logger.error("updateCompanyAccountByText  IOException:{}",e1);
		}
	}
    /**
     * 把文本原始对象转换成 待发送对象
     * @param textObj
     * @return
     */
	public CompanyTransaction  textToCompanyAccount(TextAcctDtlEvent textObj) {
		CompanyTransaction transaction =new CompanyTransaction();
		
		
		return transaction;
	}
    /**
     * 把文本原始对象转换成 待发送对象
     * @param textObj
     * @return
     */
	public CompanyAccount  textToCompanyAccount(TextCustAcct textObj) {
		CompanyAccount account =new CompanyAccount();
		return account;
	}
	/**
	 * 根据companycode 换成成组织机构号
	 * 
	 * @param companyCode
	 * @return
	 */
	public static String transactionForSearchKey(String companyCode) {
		return companyCode;
	}

	/**
	 * 把每一行数据string[] 转换成对应的TextAcctDtlEvent 或者 TextCustAcct 转换方式通过 注解TextIndex
	 * 顺序与string[] 数组顺序一致
	 * 
	 * @param paramlist
	 * @param clazz     TextAcctDtlEvent,TextCustAcct
	 * @return
	 */
	public static List<Object> parseToTextObject(List<String[]> paramlist, Class clazz) {

		logger.info("parseToTextCompanyTransaction to {} class", clazz.getSimpleName());
		List<Object> list = new ArrayList<>();
		for (String[] sArr : paramlist) {
			// 遍历每一行,按照顺序
			Object obj =null;
			try {
				obj	= clazz.newInstance();
				for (int i = 0; i < sArr.length; i++) {
					Field[] fields = clazz.getDeclaredFields();
					for (Field f : fields) {
						TextIndex a = f.getAnnotation(TextIndex.class);
						if (a != null) {
							if (a.index() == i) {
								f.setAccessible(true);
								//去除了空格
								f.set(obj, StringUtils.trim(sArr[i]));
								break;
							}
						}
					}
				}
			} catch (InstantiationException e) {
				logger.info("parseToTextCompanyTransaction InstantiationException {} ", e);
			} catch (IllegalAccessException e) {
				logger.info("parseToTextCompanyTransaction IllegalAccessException {} ", e);

			}
			if (obj != null)
				list.add(obj);
		}
		logger.info("parseToTextCompanyTransaction  success size :{}", list.size());
		return list;
	}
    /**
     * 时间格式处理   YYYY-MM-DD  HH:MM:SS
     */
	public void xxx() {
		
		
		
		
	    
		
	}
	/**
	 * 解析text文本,按照每行来解析,并把每行数据依照SOH来分割成string[]
	 * 
	 * @param fileName 文件名称
	 * @return 行数据 list
	 */
	public static List<String[]> parseTextToLineArr(String fileName) {

		logger.info("parseTextToLineArr  read file name:{}", fileName);
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
				if(strArr.length >0)
				  list.add(strArr);
			}
		} catch (FileNotFoundException e) {
			logger.info("parseTextToLineArr FileNotFoundException:{}", e);
		} catch (UnsupportedEncodingException e) {
			logger.info("parseTextToLineArr UnsupportedEncodingException:{}", e);

		} catch (IOException e) {
			logger.info("parseTextToLineArr readLine  IOException :{}", e);
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
		logger.info("parseTextToLineArr  file {} contain {} num data", fileName, list.size());
		return list;
	}

	public static void main(String[] args) throws ParseException {

	  String fileName = "F:\\MyGitHub\\AllInOneSample\\BJBank\\src\\main\\java\\WX_EDW_WX_CM_CORP_CUST_DPSIT_ACCT_SUM_M_20190823_test.txt";

		List<String[]> arr = parseTextToLineArr(fileName);

		List<Object> list = parseToTextObject(arr, TextCustAcct.class);

		for (Object obj : list) {
			System.out.println(obj);
		}
		
		
	}
}
