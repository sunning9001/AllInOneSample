/** 
 *  @Copyright:  http://www.wiotplanet.com  尚贤谷物联网科技发展有限公司 Inc. All rights reserved.
 *  @CreateTime: 2020年8月24日上午11:15:32
 *  @CreateUser: sunning 
 *  
 *
*/
package com.bjbank;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.metadata.Sheet;
import com.bjbank.listen.AccountMatchExcelListener;

/**
 *
 * TODO: 描述这个类用来做什么事情TODO
 *
 * @CreateTime : 2020年8月24日上午11:15:32
 * @CreateAuthor: sunning
 * @Email : sunning9001@126.com
 *
 */
public class AccountMatchSchedule {

	private static final Logger logger = LoggerFactory.getLogger(AccountMatchSchedule.class);

	private static long lastModified = 0; // 文件最后一次更新时间
	
	

	/**
	 *
	 * @TODO: 描述一下这个方法是干什么的
	 * @CreateTime: 2020年8月24日上午11:19:16
	 * @CreateAuthor: sunning
	 */
	public  static  void   scheduleStart() {
		ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

		final Runnable beeper = new Runnable() {
			public void run() {
                 readAccountMatchFile(Const.matchPath);
				
			}
		};
        scheduler.scheduleAtFixedRate(beeper, 0, 10, TimeUnit.SECONDS);

	}

	/**
	 * 读取 公司账号数据文件
	 * 
	 * @param filePath
	 * @throws IOException
	 */
	public static void readAccountMatchFile(String filePath) {
		InputStream inputStream = null;
		try {
			File file = new File(filePath);
			long now = file.lastModified();
			if (now != lastModified) {
                
				System.out.println("读取匹配库文件"+filePath);
				lastModified =now;
				logger.debug("readAccountMatchFile:{}", filePath);
				inputStream = new FileInputStream(file);

				AccountMatchExcelListener excelListener = new AccountMatchExcelListener();
				// sheet number from 1, headLineMun from 0
				EasyExcelFactory.readBySax(inputStream, new Sheet(1, 1, AccountMatch.class), excelListener);

			}else {
				System.out.println("读取匹配库文件"+filePath);
				logger.debug("错误,未读取匹配库文件{}",filePath);
			}
		} catch (IOException e) {
			System.out.println("读取excel文件发生错误,原因:" + e.getMessage());
			logger.info("readCompanyAccountFile  exception:{}", e.getMessage());
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}
	
	public static void main(String[] args) {
		AccountMatchSchedule.scheduleStart();
	}

}
