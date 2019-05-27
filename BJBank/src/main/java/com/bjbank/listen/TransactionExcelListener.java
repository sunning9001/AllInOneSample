package com.bjbank.listen;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.fastjson.JSONObject;
import com.bjbank.BJBankUitl;
import com.bjbank.CompanyTransaction;
import com.bjbank.Const;

public class TransactionExcelListener extends AnalysisEventListener {

	private static final Logger logger = LoggerFactory.getLogger(TransactionExcelListener.class);
	private List<Object> data = new ArrayList<Object>();

	@Override
	public void invoke(Object object, AnalysisContext context) {


        if(object instanceof CompanyTransaction) {
        	CompanyTransaction ca =(CompanyTransaction)object;
        	if(ca.getAccount()!=null) {
        	
        	String tempTime = ca.getDealTimeTemp();
        	
        	SimpleDateFormat s = new SimpleDateFormat("yyyyMMdd");
        	
        	 try {
				Date dealTime = s.parse(tempTime);
				
				ca.setDealTime(dealTime);

				data.add(ca);

				if (data.size() >= Const.LOOP) {
					flushData(data);
					data.clear();
				}
			} catch (ParseException e) {
				logger.info(" 时间转换错误:{}",JSONObject.toJSONString(object));
				e.printStackTrace();
			}
        	}
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
			logger.info("开始发送公司交易流水信息,数据量:{}", data.size());
			BJBankUitl.updateTransaction(data, BJBankUitl.getToken());
		} catch (IOException e) {
			System.out.println("发送交易流水信息错误,原因是:" + e.getMessage());
			logger.info("发送交易流水信息错误,原因是:{}", e.getMessage());

		}
	}
}
