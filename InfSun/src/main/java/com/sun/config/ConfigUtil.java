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
