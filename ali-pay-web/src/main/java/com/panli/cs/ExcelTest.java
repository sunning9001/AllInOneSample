package com.panli.cs;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.metadata.Sheet;

public class ExcelTest {
	
	public static void main(String[] args) throws FileNotFoundException {
		
		
		
		EasyExcelFactory.readBySax(new FileInputStream(""), new Sheet(2, 1), null);
	}
	
}