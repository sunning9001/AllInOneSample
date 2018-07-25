package com.sun.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.sun.config.ConfigUtil;
import com.sun.config.HttpUtil;
import com.sun.config.InfConstants;
import com.sun.msg.FundConfirmMessageRequest;
import com.sun.msg.FundConfirmMessageResponse;
import com.sun.msg.request.BillDetails;
import com.sun.msg.request.FundConfirmRequest;
import com.sun.util.DateUtil;


public class fundConfirmTest {

	public static void main(String[] args) {

		FundConfirmMessageRequest request = new FundConfirmMessageRequest();

		FundConfirmRequest biz_content = new FundConfirmRequest();

		biz_content.setDate(DateUtil.dateToStirng(new Date()));
		biz_content.setAccountfirm_no("123456789");
		List<BillDetails> list = new ArrayList<BillDetails>();
		BillDetails bill = new BillDetails();
		bill.setTrade_no("11");
		bill.setBillno("00707375");
		bill.setAmount("100");

		BillDetails bill2 = new BillDetails();
		bill2.setTrade_no("22");
		bill2.setBillno("00707422");
		bill2.setAmount("100");
		list.add(bill);
		list.add(bill2);

		biz_content.setTranslist(list);
		request.setBiz_content(biz_content);
		request.setMethod(InfConstants.OuterAccountBillFund);

		String postBody = "request:" + JSONObject.toJSONString(request);

//		String postBody = JSONObject.toJSONString(request);
		FundConfirmMessageResponse response = (FundConfirmMessageResponse) HttpUtil.getInstance().httpExecute(postBody,
				ConfigUtil.getUrl(), FundConfirmMessageResponse.class);

		System.out.println("资金对账-----"+response.toString());
	}
}
