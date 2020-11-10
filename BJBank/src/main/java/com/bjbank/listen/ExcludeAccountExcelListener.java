package com.bjbank.listen;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.fastjson.JSONObject;
import com.bjbank.ExcludeAccount;
import com.bjbank.ExcludeAccountUtil;

public class ExcludeAccountExcelListener extends AnalysisEventListener {

	private static final Logger logger = LoggerFactory.getLogger(ExcludeAccountExcelListener.class);


	@Override
	public void invoke(Object object, AnalysisContext context) {

		if (object instanceof ExcludeAccount) {
			ExcludeAccount ca = (ExcludeAccount) object;
			if (ca.getAccount() != null) {
				try {
                    ExcludeAccountUtil.addAccountMatch(ca);
				} catch (Exception e) {
					logger.info(" AccountMatchExcelListener :{}", JSONObject.toJSONString(object));
					e.printStackTrace();
				}
			}

		}
	}

	@Override
	public void doAfterAllAnalysed(AnalysisContext context) {
		
	}

}
