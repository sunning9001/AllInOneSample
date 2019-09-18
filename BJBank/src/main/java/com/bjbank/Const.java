package com.bjbank;

/**
 * 配置常量
 * 
 * @author sunning
 *
 */
public class Const {

	// public static final String DEV_IP="http://2.20.102.63/";
	public static String IP = "http://2.20.102.51:10066/";
	public static String username = "bjwxyh_admin";
	public static String password = "bjwxyh292804";
	public static int LOOP = 2; // 多少条数据作为一批
	public static String companyPath = "";// 文件生成路径
	public static String excelPath = "";// 上传文件模板路径
	public static String cronTime = "";// 定时任务时间
	public static int fileChoose = 1;// 文件格式 1-excel 默认 2-text文件格式

	public static enum fileChooseEnum {
		excel(1),text(2);
		int fileChoose;

		fileChooseEnum(int fileChoose) {
			this.fileChoose = fileChoose;
		}
	}

	public static final String status = "status";
	public static final String msg = "msg";

	public static final String success_msg = "success";

}
