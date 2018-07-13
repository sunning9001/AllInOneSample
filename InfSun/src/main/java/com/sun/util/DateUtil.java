package com.sun.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sun.BillHandleCenter;

public class DateUtil {

	/**
	 * 打印日志使用
	 */
	private static final Logger logger =LoggerFactory.getLogger(BillHandleCenter.class);
	
	public static String dateToStirng(Date date) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd") ;
		return sdf.format(date);
	}
	
	public static String dateToStirngTime(Date date) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss") ;
		return sdf.format(date);
	}
	
	public static Date stringToDate(String datetime) {
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
	    Date utilDate = null ;
	    try {
	    	utilDate = sdf.parse(datetime);
	    	return  utilDate ;
		} catch (ParseException e) {
			logger.debug("DateUtil ===stringToDate   exception: {}",e);
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return utilDate ;
	    
	}
	
	@Test
	public void test() {
		System.out.println(stringToDate("132"));
	}
}
