package com.bjbank.listen;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.fastjson.JSONObject;
import com.bjbank.BJBankUitl;
import com.bjbank.CompanyAccount;
import com.bjbank.Const;

public class AccountExcelListener extends AnalysisEventListener {

	private static final Logger logger = LoggerFactory.getLogger(AccountExcelListener.class);
	private List<Object> data = new ArrayList<Object>();

	@Override
	public void invoke(Object object, AnalysisContext context) {

		if (object instanceof CompanyAccount) {
			CompanyAccount ca = (CompanyAccount) object;
			if (ca.getAccount() != null) {

			
				try {
	

					data.add(ca);

					if (data.size() >= Const.LOOP) {
						flushData(data);
						data.clear();
					}
				} catch (Exception e) {
					logger.info(" 时间转换错误 :{}", JSONObject.toJSONString(object));
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
			logger.info("开始发送公司平台信息,数据量:{}", data.size());
			BJBankUitl.updateCompanyAccount(data, BJBankUitl.getToken());
		} catch (IOException e) {
			System.out.println("发送公司账号信息错误,原因是:" + e.getMessage());
			logger.info("发送公司账号信息错误,原因是:{}", e.getMessage());

		}
	}
}
