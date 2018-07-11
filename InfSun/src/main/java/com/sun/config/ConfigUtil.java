package com.sun.config;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
/**
 * 读取application.conf 配置文件,application.conf需要在classpath路径下面
 * @author sunning
 *
 */
public class ConfigUtil {
	
	private static final String zoneCode ="zone_code";
	private static final String url ="url";

	public  static final String version="1.0";
	public  static final String paylistfmt="01";
	public  static final String unit="个";
	
	public  static final String stdtype="无限制";
	public  static final String standard = "0.0-0.0";
	
	public  static final String unpaid = "1"; //未缴款
	public  static final String paid = "2";  //已缴款
	public  static final String abandoned = "3";  //已作废
	
	public  static final String delay_amount = "0";  //滞纳金
	
	private static Config conf;

	static {
		conf = ConfigFactory.load();
	}

	public static String getStringConfigProperties(String name) {
		return conf.getString(name);
	}
	public static int getIntConfigProperties(String name) {
		return conf.getInt(name);
	}
	/**
	 *  获取非税节点的行政区划分
	 * @return
	 */
	public static String getZoneCode() {
		return getStringConfigProperties(zoneCode);
	}
	/**
	 * 获取支付平台URL
	 * @return
	 */
	public static String getUrl() {
		return getStringConfigProperties(url);
	}
}
