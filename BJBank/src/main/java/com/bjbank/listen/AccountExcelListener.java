package com.bjbank.listen;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.bjbank.BJBankUitl;
import com.bjbank.Const;

public class AccountExcelListener extends AnalysisEventListener {


	private static final Logger logger =LoggerFactory.getLogger(AccountExcelListener.class);
	private List<Object> data = new ArrayList<Object>();

	@Override
	public void invoke(Object object, AnalysisContext context) {
		data.add(object);
		if (data.size() >= Const.LOOP) {
			flushData(data);
			data.clear();
		}
	}

	@Override
	public void doAfterAllAnalysed(AnalysisContext context) {
		flushData(data);
	}

	/**
	 * 发送数据
	 * 
	 * @param data
	 */
	public void flushData(List<Object> data) {
	    try {
	    	logger.info("开始发送公司平台信息,数据量:{}",data.size());
			BJBankUitl.updateCompanyAccount(data, BJBankUitl.getToken());
		} catch (IOException e) {
			System.out.println("发送公司账号信息错误,原因是:"+e.getMessage());
			logger.info("发送公司账号信息错误,原因是:{}",e.getMessage());
			
		}
	}
}
