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
import java.util.Arrays;
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
	public static Map<String, CompanyAccount> acctAgtNumMap = new HashMap<String, CompanyAccount>();

	/**
	 * 初始化并缓存
	 *  
	 * @param list
	 */
	public static void initCompanyMap(List<Company> list) {
		logger.info("initCompanyMap  num={}",list.size());
		codeMap.clear();
		for (Company company : list) {
			codeMap.putIfAbsent(company.getCompanyCode(), company);
		}
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

		logger.debug("updateTransactionByText file:{}",file);
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
		
		try {
			// 迭代所有财务局需要的
			for (Map.Entry<String, CompanyAccount> e : acctAgtNumMap.entrySet()) {

				CompanyAccount ca =e.getValue();
				String agtNum = e.getValue().getAccount();
				String companyCode = e.getKey();
				List<TextAcctDtlEvent> agtEventList = agtMap.get(agtNum);
				if (agtEventList != null) {

					// 做类型转换TextAcctDtlEvent ->CompanyTransaction
					logger.debug("updateTransactionByText find company transactioin account:{},companyCode:{}",ca.getAccount(),companyCode );

					for (TextAcctDtlEvent acctEvent : agtEventList) {

                       
						CompanyTransaction transaction = new CompanyTransaction();
						try {
							
							// 是 string 平台公司名称
							transaction.setCompanyName(codeMap.get(companyCode).getCompanyName());
							// 是 string 平台公司统一信用代码
							transaction.setCompanyCode(companyCode);
							// 是 string 开户行名称
							transaction.setBank(ca.getBank());
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
							String fundFlow =parseTofundFlow(acctEvent.getDEBIT_CRDT_DIR_DESC());
							transaction.setFundFlow(fundFlow);
							// 是 double 交易金额
							
							transaction.setTransactionAmount(new BigDecimal(new BigDecimal(acctEvent.getEVENT_AMT()).movePointRight(6).stripTrailingZeros().toPlainString()).movePointLeft(6).toPlainString());
							// 是 double 账户余额（交易卡余额）

							transaction.setAccountBalance(	new BigDecimal(new BigDecimal(acctEvent.getACCT_BAL()).movePointRight(6).stripTrailingZeros().toPlainString()).movePointLeft(6).toPlainString());
							// 是 varchar 交易方式（字符串格式）
							transaction.setExchangeType("网银");//默认网易

							
							
						} catch (Exception e2) {
							logger.error("TextAcctDtlEvent  map to CompanyTransaction error exception ={} TextAcctDtlEvent={}",e2,acctEvent);
						}
						// 转换完成
						sendList.add(transaction);
						logger.info("send Transaction :{}",transaction);
					}

				} else {
					logger.info("can not find bank account={} company={}",agtNum,e);
				}
			}
		} catch (Exception e) {
			logger.error("updateTransactionByText  Exception {}",e);
		}
		
		try {
			logger.info(" updateTransaction   transaction  info  total=:{}",sendList.size());
			BJBankUitl.updateTransaction(sendList, BJBankUitl.getToken());
		} catch (IOException e1) {
			logger.info(" updateTransactionByText  IOException{}",e1);
		}

	}
	/**
	 * DEBIT_CRDT_DIR_CD=D, DEBIT_CRDT_DIR_DESC=借
	 * DEBIT_CRDT_DIR_CD=C, DEBIT_CRDT_DIR_DESC=贷
	 * 根据  DEBIT_CRDT_DIR_CD 转换成  资金流向1收入2支出
	 * @param   借为支出，贷为收入
	 * @return  资金流向1收入2支出
	 */
	public  static String parseTofundFlow(String DEBIT_CRDT_DIR_DESC) {
		if(DEBIT_CRDT_DIR_DESC!=null && DEBIT_CRDT_DIR_DESC.equalsIgnoreCase("借"))return "2";
		if(DEBIT_CRDT_DIR_DESC!=null && DEBIT_CRDT_DIR_DESC.equalsIgnoreCase("贷"))return "1";
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
			if(time!=null && time.length()>=6) {
				Date d = s.parse(dt+" "+time.substring(0,2)+":"+time.substring(2, 4)+":"+time.substring(4, 6));
				return d.toLocaleString();
			}else {
			    String newtime=	StringUtils.leftPad(time, 6, "0");
				Date d = s.parse(dt+" "+newtime.substring(0,2)+":"+newtime.substring(2, 4)+":"+newtime.substring(4, 6));
				return d.toLocaleString();
			}

		} catch (ParseException e) {
			logger.info(" parseToFormatDate ParseException :{}  dt:{} time:{}",e,dt,time);
		}
		return "";
	}
	/**
	 * 读取账户文本文件,并发送到财政局
	 * 
	 * @param file  账户文件名称
	 */
	public static void updateCompanyAccountByText(String file) {
		
		logger.debug("updateCompanyAccountByText file:{}",file);

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

				try {
					logger.info("  key ={}  companycode ={}  TextCustAcct={}", searchKey, companyCode,textAcc);
					// 是平台公司统一信用代码
					account.setCompanyCode(company.getCompanyCode());
					// 是 string 平台公司名称
					account.setCompanyName(company.getCompanyName());
					// 是 string 账户名称
					account.setAccountName(textAcc.getCUST_NAME());
					// 是 int 账户类型 1基本、2一般、3临时、4专用、5 其他
					Integer accountType =parseToAccountType(textAcc.getACCT_CHAR_CD());
					account.setAccountType(accountType);
					// 是 int 账户状态 1正常、2冻结、3已注销、4 止付
					account.setAccountStatus("1");//账户状态默认正常
					// 是 timestamp 开户时间
					String accountOpenTime =parseToFormatDate(textAcc.getOPEN_DT(),"000000");
					account.setAccountOpenTime(accountOpenTime);
					// 是 string 开户行
					String bank =parseToBank(textAcc.getBELONG_ORG_NUM()) ;
					account.setBank(bank);//默认
					// 是 int 银行账号
					account.setAccount(textAcc.getAGT_NUM());
					// 是 double 账户余额（万元）
					
					account.setAccountBalance(new  BigDecimal(textAcc.getCURR_BAL()).movePointLeft(4).movePointRight(6).stripTrailingZeros().movePointLeft(6).toPlainString());
					// 是 double 可用余额（万元）
					account.setAvailableBalance(new  BigDecimal(textAcc.getCURR_BAL()).movePointLeft(4).movePointRight(6).stripTrailingZeros().movePointLeft(6).toPlainString());
				} catch (Exception e2) {
					logger.error("updateCompanyAccountByText TextCustAcct mapping to CompanyAccount error, exception={}  TextCustAcct={}");
				}
				 sendList.add(account);
				 logger.info("send CompanyAccount :{}",account);
				 
				//缓存银行账号 companyCode -bankNum
				acctAgtNumMap.put(companyCode, account);
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
	 *  开户行名称对应WX_CM_CORP_CUST_DPSIT_ACCT_SUM_M的第5个字段（所属机构号）
	 *  （IOODSZ6037350=北京银行股份有限公司无锡梁溪支行，IOODSZ6037278=北京银行股份有限公司无锡分行营业部）
	 * @param BELONG_ORG_NUM
	 * @return
	 */
	public static String parseToBank(String BELONG_ORG_NUM) {
		if(BELONG_ORG_NUM ==null)return null;
		if(BELONG_ORG_NUM.equalsIgnoreCase("IOODSZ6037350")) {
			return "北京银行股份有限公司无锡梁溪支行";
		}
		if(BELONG_ORG_NUM.equalsIgnoreCase("IOODSZ6037278")) {
			return "北京银行股份有限公司无锡分行营业部";
		}
		return null;
	}

	 /**
	  * 账户类型对应WX_CM_CORP_CUST_DPSIT_ACCT_SUM_M的第13个字段（账户性质代码）
	  *  1对应一般户，如果为空对应专用户
	  * @param ACCT_CHAR_CD  
	  * @return  账户类型 1基本、2一般、3临时、4专用、5 其他
	  */
	 public static Integer parseToAccountType(String ACCT_CHAR_CD) {
		 if(ACCT_CHAR_CD ==null) {
			 return new Integer(4);
		 }

		 if(ACCT_CHAR_CD.equals("1")) {
			 return new Integer(2);
		 }
		 if(ACCT_CHAR_CD.equals("4")) {
			 return new Integer(4);
		 }
		 return new Integer(4);
		 
	 }

	/**
	 * 根据companycode 换成成组织机构号
	 * 91320211794559948P 无锡雪浪科教产业投资发展有限公司
	 * 79455994-8
	 * 其实只要对应91320211794559948P 倒数十位的前8位就行
	 * @param companyCode
	 * @return
	 */
	public static String transactionForSearchKey(String companyCode) {
		if(companyCode==null)return null;
		String s =null;
		try {
			if(companyCode.length()>=17) {
				 s= companyCode.substring(8, 16)+"-"+companyCode.substring(16,17);
			}else {
				logger.info(" special  account companyCode:{}",companyCode);
			}
		} catch (Exception e) {
		    logger.error("transactionForSearchKey  error  companyCode={}",companyCode);
		}
		return s;
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

		logger.info("parseToTextObject to {} class", clazz.getSimpleName());
		List<Object> list = new ArrayList<>();
		for (String[] sArr : paramlist) {
			//特殊处理   && strArr.length ==67 
			if(clazz!=null && clazz.equals(TextCustAcct.class)) {
				if(sArr.length !=67) {
                    //账号信息不是67分割则不处理
					continue;
				}
			}
			//特殊处理   && strArr.length ==12 
			if(clazz!=null && clazz.equals(TextAcctDtlEvent.class)) {
				if(sArr.length ==10) {
                    String[] newSArr=new String[12];
                    for (int i = 0; i < newSArr.length; i++) {
						if(i==4 || i==5) {
						 	newSArr[i]=" ";
						}
						else {
							if(i>5) {
								newSArr[i]=sArr[i-2];
							}else {
								newSArr[i]=sArr[i];
							}
						}
					}
                    sArr =Arrays.copyOf(newSArr, 12);
				}
			}
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
			if (obj != null) {				
				list.add(obj);
				logger.info("parseToTextObject print {} ={}",clazz.getSimpleName(),obj.toString());
			}
		}
		logger.info("parseToTextObject  success size :{}", list.size());
		return list;
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
				if(strArr.length >0) {
					list.add(strArr);
				}
			}
			logger.info("parseTextToLineArr  list  siez:{}",list.size());
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

/*	
		String fileName = "F:\\MyGitHub\\AllInOneSample\\BJBank\\WX_EDW_WX_CORP_CUST_ACCT_DTL_EVENT_20190918_001.txt";
		//String fileName = "F:\\MyGitHub\\AllInOneSample\\BJBank\\WX_EDW_WX_CM_CORP_CUST_DPSIT_ACCT_SUM_M_20190823_0011.txt";

		List<String[]> arr = parseTextToLineArr(fileName);

		List<Object> list = parseToTextObject(arr, TextAcctDtlEvent.class);//TextCustAcct  TextAcctDtlEvent


		for (Object obj : list) {
			System.out.println(obj);
			TextAcctDtlEvent e =(TextAcctDtlEvent)obj;
			
	          
			
			System.out.println(new BigDecimal(new BigDecimal(e.getACCT_BAL()).movePointRight(6).stripTrailingZeros().toPlainString()).movePointLeft(6).toPlainString());
	       
		}
		
		*/
		
		//new BigDecimal(new BigDecimal(textAcc.getCURR_BAL()).movePointRight(6).stripTrailingZeros().toPlainString()).movePointLeft(6).toPlainString()
		
		
		
		
		 String money ="0.83000000000000000000";
		

		
		System.out.println(		new  BigDecimal(money).movePointLeft(4).toPlainString());
		System.out.println(		new  BigDecimal(money).movePointLeft(4).movePointRight(6).stripTrailingZeros().toPlainString());
		System.out.println(		new  BigDecimal(money).movePointLeft(4).movePointRight(6).stripTrailingZeros().movePointLeft(6).toPlainString());
		
		
       System.out.println("---------");
		System.out.println(		parseToFormatDate("2019-08-23","12021"));

	}
	
	public static void testinitData() {
		 codeMap.put("91320211MB04622133", new Company("91320211MB04622133","无锡市梁溪区财政局"));
		 codeMap.put("9132021167201443XA", new Company("9132021167201443XA","无锡市城市环境科技有限公司"));
		 codeMap.put("91320211MA1UX9RX21", new Company("91320211MA1UX9RX21","江苏中利宁电子商务有限公司"));
	}

}
