package com.bjbank.listen;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.bjbank.BJBankUitl;
import com.bjbank.Const;

public class AccountExcelListener extends AnalysisEventListener {


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
			BJBankUitl.updateCompanyAccount(data, BJBankUitl.getToken());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
