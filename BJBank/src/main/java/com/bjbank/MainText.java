package com.bjbank;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.commons.lang3.StringUtils;

public class MainText {

	public static void main(String[] args) throws IOException {


		////String file ="F:\\MyGitHub\\AllInOneSample\\BJBank\\src\\main\\java\\WX_EDW_WX_CM_CORP_CUST_DPSIT_ACCT_SUM_M_20190823_test.txt";
			String file ="F:\\MyGitHub\\AllInOneSample\\BJBank\\src\\main\\java\\WX_EDW_WX_CORP_CUST_ACCT_DTL_EVENT_20190823_test.txt";
		
		FileInputStream inputStream = new FileInputStream(file);
                 //设置inputStreamReader的构造方法并创建对象设置编码方式为gbk
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"utf-8"));
			
		String str = null;
		while((str = bufferedReader.readLine()) != null)
		{
			//使用\001 来分割字符串
			String[] strArr = StringUtils.splitByWholeSeparator(str,"\001");
			
			for (int i = 0; i < strArr.length; i++) {
				
				System.out.println("顺序 = "+i +" 内容:"+strArr[i]);
			}
			System.out.println("===================================");
		}
			

	}
}
