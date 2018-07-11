package com.sun.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

public class DateUtil {

	public static String dateToStirng(Date date) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd") ;
		return sdf.format(date);
	}
	
	public static String dateToStirngTime(Date date) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss") ;
		return sdf.format(date);
	}
	
	@Test
	public void test() {
		String string = dateToStirngTime(new Date());
		System.out.println(string);
	}
}
