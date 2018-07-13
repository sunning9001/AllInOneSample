package com.sun.test;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.sun.config.ConfigUtil;
import com.sun.config.HttpUtil;
import com.sun.config.InfConstants;
import com.sun.msg.fundConfirmMessageRequest;
import com.sun.msg.fundConfirmMessageResponse;
import com.sun.msg.request.BillDetails;
import com.sun.msg.request.BillfundRequest;

public class fundConfirmTest {

	public static void main(String[] args) {

		fundConfirmMessageRequest request = new fundConfirmMessageRequest();

		BillfundRequest biz_content = new BillfundRequest();

		List<BillDetails> list = new ArrayList<BillDetails>();
		BillDetails bill = new BillDetails();
		bill.setBillno("00707375");
		bill.setAmount("100");

		BillDetails bill2 = new BillDetails();
		bill.setBillno("00707422");
		bill.setAmount("100");
		list.add(bill);
		list.add(bill2);

		request.setBiz_content(biz_content);
		request.setMethod(InfConstants.OuterAccountBillFund);

		String postBody = "wp_outer_account_billfund_response:" + JSONObject.toJSONString(request);

//		String postBody = JSONObject.toJSONString(request);
		fundConfirmMessageResponse response = (fundConfirmMessageResponse) HttpUtil.getInstance().httpExecute(postBody,
				ConfigUtil.getUrl(), fundConfirmMessageResponse.class);

		System.out.println(response.toString());
	}
}
