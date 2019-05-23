package com.bjbank;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobKey;

public class ExcelJob implements Job {

	private static Logger logger = LoggerFactory.getLogger(ExcelJob.class);

	public ExcelJob() {
	}

	public void execute(JobExecutionContext context) throws JobExecutionException {

		JobKey jobKey = context.getJobDetail().getKey();
		logger.info("ExcelJob says: " + jobKey + " executing at " + new Date());
		
		try {
			String  filePath =Const.excelPath+"数据源-"+BJBankUitl.getTimeStr()+".xlsx";
			// 获取获取上传文件
			logger.info("获取文件准备上传");
			BJBankUitl.readCompanyAccountFile(filePath);
			
			BJBankUitl.readCompanyTransaction(filePath);	
		} catch (Exception e) {
			logger.debug("ExcelJob Exception: {}",e.getMessage());
		}

		
	}

}