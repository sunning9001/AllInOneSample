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
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.metadata.Sheet;
import com.bjbank.listen.ExcludeAccountExcelListener;

/**
 *
 * TODO: 描述这个类用来做什么事情TODO
 *
 * @CreateTime : 2020年8月24日上午11:15:32
 * @CreateAuthor: sunning
 * @Email : sunning9001@126.com
 *
 */
public class ExcludeAccountSchedule {

	private static final Logger logger = LoggerFactory.getLogger(ExcludeAccountSchedule.class);

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
                 readExcludeExcelFile(Const.excludePath);
				
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
	public static void readExcludeExcelFile(String filePath) {
		InputStream inputStream = null;
		try {
			File file = new File(filePath);
			long now = file.lastModified();
			if (now != lastModified) {
                
				System.out.println("读取排除库文件"+filePath);
				lastModified =now;
				logger.debug("readExcludeExcelFile:{}", filePath);
				inputStream = new FileInputStream(file);

				ExcludeAccountExcelListener excelListener = new ExcludeAccountExcelListener();
				// sheet number from 1, headLineMun from 0
				EasyExcelFactory.readBySax(inputStream, new Sheet(1, 1, ExcludeAccount.class), excelListener);

			}
		} catch (IOException e) {
			System.out.println("读取excel文件发生错误,原因:" + e.getMessage());
			logger.info("readExcludeExcelFile  exception:{}", e.getMessage());
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
		ExcludeAccountSchedule.scheduleStart();
	}

}
