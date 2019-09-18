package com.bjbank;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExcelJob implements Job {

	private static Logger logger = LoggerFactory.getLogger(ExcelJob.class);

	public ExcelJob() {
	}

	public void execute(JobExecutionContext context) throws JobExecutionException {

		JobKey jobKey = context.getJobDetail().getKey();
		logger.info("ExcelJob says: " + jobKey + " executing at " + new Date());
		
		try {
			//默认使用excel格式触发
			if(Const.fileChoose==Const.fileChooseEnum.excel.fileChoose)
			{				
				String  filePath =Const.excelPath+"数据源-"+BJBankUitl.getYesterdayTimeStr()+".xlsx";
				// 获取获取上传文件
				logger.info("获取文件准备上传excel文件");
				BJBankUitl.readCompanyAccountFile(filePath);
				
				BJBankUitl.readCompanyTransaction(filePath);	
			}
			if(Const.fileChoose==Const.fileChooseEnum.text.fileChoose)
			{
				String token =BJBankUitl.getToken();
				if(token!=null) {
					//首先获取所有平台文件
					BJBankUitl.getCompanyList(token);
					String  acctFileName =Const.excelPath+"WX_EDW_WX_CM_CORP_CUST_DPSIT_ACCT_SUM_M_"+BJBankUitl.getYesterdayTimeStr()+".txt";
					// 获取获取上传文件
					logger.info("获取文件准备上传txt文件:{}",acctFileName);
					TextUtil.updateCompanyAccountByText(acctFileName);
					
					String  eventFileName =Const.excelPath+"WX_EDW_WX_CM_CORP_CUST_DPSIT_ACCT_SUM_M_"+BJBankUitl.getYesterdayTimeStr()+".txt";
					// 获取获取上传文件
					logger.info("获取文件准备上传txt文件:{}",eventFileName);
					TextUtil.updateTransactionByText(eventFileName);
				}
			}
			
		} catch (Exception e) {
			logger.debug("ExcelJob Exception: {}",e.getMessage());
		}

		
	}

}