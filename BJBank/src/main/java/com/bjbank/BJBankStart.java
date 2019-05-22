package com.bjbank;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
//https://blog.csdn.net/hao65103940/article/details/78331092
public class BJBankStart {

    private static final Logger  logger =LoggerFactory.getLogger(BJBankStart.class);
    
    public  static void startTast() {
    	
    	 ExcelCronTrigger cronTask = new ExcelCronTrigger();
		 cronTask.run(Const.cronTime);
		
    	 Runtime.getRuntime().addShutdownHook(new Hook(cronTask.getSched()));
    	
    	
    }
    static class Hook extends Thread{

    	private Scheduler sched;
    	
    	
        public Hook(Scheduler sched) {
			super();
			this.sched = sched;
		}


		@Override
        public void run() {
        	 if(this.sched!=null) {
        		  try {
					this.sched.shutdown();
				} catch (SchedulerException e) {
					logger.info("Hook  shutdown exception");
				}
        	 }
        }
    }
	public static void main(String[] args) throws IOException {

		System.out.println("===============工具开始启动======================");
		System.out.println("===============开始读取配置文件application.conf======================");

		Properties pro = new Properties();
		try {

			FileInputStream in = new FileInputStream(
					System.getProperty("user.dir") + File.separator + "application.conf");
			pro.load(in);
			in.close();
		} catch (Exception e) {
			System.out.println("读取application.conf 文件失败!");
		}
		System.out.println("开始读取application.conf 文件内容!");
		String ip = pro.getProperty("ip");
		System.out.println("读取IP = " + ip);
		Const.IP =ip;
		String username = pro.getProperty("username");
		System.out.println("读取username = " + username);
		Const.username =username;
		String password = pro.getProperty("password");
		System.out.println("读取password =" + password);
		Const.password =password;
		Integer loop = Integer.parseInt(pro.getProperty("loop"));
		System.out.println("读取批量loop配置 =" + loop);
		Const.LOOP =loop;
		
		String companyPath = pro.getProperty("companyPath");
		System.out.println("读取companyPath文件存放位置 =" + companyPath);
		Const.companyPath =companyPath;
		
		String excelPath = pro.getProperty("excelPath");
		System.out.println("读取excelPath文件存放位置 =" + excelPath);
		Const.excelPath =excelPath;
		
		String cronTime = pro.getProperty("cronTime");
		System.out.println("读取cronTime文件存放位置 =" + cronTime);
		Const.cronTime =cronTime;
		System.out.println("===============工具启动成功======================");

		startTast();
		while (true) {
			System.out.println("#####################################################################");
			System.out.println("请选择要操作业务:  a-获取平台单位列表  b-更新平台银行账户 c-更新银行交易流水");
			Scanner scan = new Scanner(System.in);
			String read = scan.nextLine();

			try {
				
				if (read != null
						&& (read.equalsIgnoreCase("a") || read.equalsIgnoreCase("b") || read.equalsIgnoreCase("c"))) {
					
					if(read.equalsIgnoreCase("a")) {
						String token =BJBankUitl.getToken();
						if(token!=null) {
							//  导出excel到指定文件夹目录
							try {
								List<Company> companys = BJBankUitl.getCompanyList(token);
								writeCompanyToExcel(companys);
								System.out.println("下载平台单位列表完成!");
								
							} catch (IOException e) {
								System.out.println("请求数据错误,原因:"+e.getMessage());
							}
						}
					}
					if(read.equalsIgnoreCase("b")) {
						//导入指定文件
						System.out.println("更新平台银行账户,请输入导入excel文件路径  例如:D:/文件夹/文件名称.xlsx");
						String filePath = scan.nextLine();
						String token =BJBankUitl.getToken();
						if(token!=null) {
							BJBankUitl.readCompanyAccountFile(filePath);
						}
					}
					if(read.equalsIgnoreCase("c")) {
						//导入指定文件
						System.out.println("更新银行交易流水,请输入导入excel文件路径  例如:D:/文件夹/文件名称.xlsx");
						String filePath = scan.nextLine();
						String token =BJBankUitl.getToken();
						if(token!=null) {
							BJBankUitl.readCompanyTransaction(filePath);
						}
					}
					
				} else {
					System.out.println("输入错误,选择 a 或者b  或者 c");
				}
			} catch (Exception e) {
				System.out.println("异常,原因:"+e.getMessage());
			}
		}
	}

	/**
	 *  把公司信息写入到excel中
	 * @param jsonArray
	 * @throws IOException
	 */
	public static void writeCompanyToExcel(List<Company> companys) throws IOException {
		String fileName = System.getProperty("user.dir") + File.separator +"平台单位列表-"+ BJBankUitl.getTimeStr()+".xlsx";
		OutputStream out = new FileOutputStream(fileName);
		ExcelWriter writer = EasyExcelFactory.getWriter(out);
        logger.info("writeCompanyToExcel  文件名称:{} 平台数量:{}",fileName,companys.size());
		//设置表头
		List<List<String>> head =new ArrayList<>();
		List<String> h1 =new ArrayList<>();
		h1.add("平台公司统一信用代码");
		head.add(h1);
		List<String> h2 =new ArrayList<>();
		h2.add("平台公司名称");
		head.add(h2);
		//设置sheet
		Sheet sheet1 = new Sheet(1, 0);
		sheet1.setSheetName("平台单位列表");
		sheet1.setAutoWidth(true);
		sheet1.setHead(head);
		
		//循环写入数据
		List<List<String>> dataList =new ArrayList();
		for (Company company : companys) {
			//循环写入到excel中
			List<String> row =new ArrayList<>();
			row.add(company.getCompanyCode());
			row.add(company.getCompanyName());
			dataList.add(row);
		}
		writer.write0(dataList ,sheet1);
		writer.finish();
		out.close();
	}
}