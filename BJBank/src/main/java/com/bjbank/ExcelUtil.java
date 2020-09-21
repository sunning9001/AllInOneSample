/** 
 *  @Copyright:  http://www.wiotplanet.com  尚贤谷物联网科技发展有限公司 Inc. All rights reserved.
 *  @CreateTime: 2020年8月21日上午10:55:04
 *  @CreateUser: sunning 
 *  
 *
*/
package com.bjbank;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.PropertyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 *
 * TODO: 描述这个类用来做什么事情TODO
 *
 * @CreateTime : 2020年8月21日上午10:55:04
 * @CreateAuthor: sunning
 * @Email : sunning9001@126.com
 *
 */
public class ExcelUtil {

	private static final Logger logger = LoggerFactory.getLogger(ExcelUtil.class);

	public static void main(String[] args) {
		List<Object> list = new ArrayList<>();
		CompanyAccount ca = new CompanyAccount();
		ca.setCompanyCode("aaaaa");
		ca.setAccount("1111111111111");
		ca.setAccountBalance("2222");
		list.add(ca);

		Map<String, String> map1 = new HashMap<>();
		map1.put("companyCode", "aaaaa");
		map1.put("errorMsg", "errorMsg");

		Map<String, String> map2 = new HashMap<>();
		map2.put("companyCode", "aaaaa1");
		map2.put("errorMsg", "errorMsg1");

		List<Object> result = new ArrayList<>();
		result.add(map1);
		result.add(map2);

		JSONArray array = JSONArray.parseArray(JSONObject.toJSONString(result));

		
		
//
//		String json  ="{\"data\":[]}";
//		JSONObject jsonObj = JSONObject.parseObject(json);
//		
//		 JSONArray array = jsonObj.getJSONArray("data");
//		 
//		 System.out.println(array.toJSONString());
//		 System.out.println(array.size());
        writeResultToExcel(list, CompanyAccount.class, array, "aaaa");
	}

	public static String getTimeDateStr() {
		java.text.SimpleDateFormat s = new java.text.SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");

		String dateStr = s.format(new Date());
		return dateStr;
	}

	/**
	 * 
	 *
	 * @TODO: 把发送结果
	 * @CreateTime: 2020年8月21日上午10:58:00
	 * @CreateAuthor: sunning
	 * @param list      发送源数据
	 * @param clazz
	 * @param jsonArray 发送的错误数据
	 * 
	 *                  0 => { "companyCode"=>"XXXXXX",//错误数据的平台统一信用代码
	 *                  "errorMsg"=>"错误详情" }， 1 => { "companyCode"=>"XXXXXX",
	 *                  "errorMsg"=>"错误详情" }
	 *
	 */
	public static <T> void writeResultToExcel(List<Object> list, Class<T> clazz, JSONArray jsonArray, String fileName) {
		try {

			Map<String, Object> map = new HashMap<String, Object>();
			// 判断类型
			if (clazz.equals(CompanyAccount.class)) {
				// list -> map
				for (Object obj : list) {
					if (obj instanceof CompanyAccount) {
						CompanyAccount ca = (CompanyAccount) obj;
						map.put(ca.getCompanyCode(), ca);
					}
				}
			}
			if (clazz.equals(CompanyTransaction.class)) {
				// list -> map
				for (Object obj : list) {
					if (obj instanceof CompanyTransaction) {
						CompanyTransaction ca = (CompanyTransaction) obj;
						map.put(ca.getCompanyCode(), ca);
					}
				}

			}
			// 默认全部是正确结果,只有返回错误才是错误结果
			// List<Object> writeList = new ArrayList<Object>();
			if (jsonArray != null && jsonArray.size() > 0 ) {
				// 处理jsonArray
				for (int i = 0; i < jsonArray.size(); i++) {
					JSONObject jsonObj = jsonArray.getJSONObject(i);

					String companyCode = jsonObj.getString("companyCode");
					String errorMsg = jsonObj.getString("errorMsg");

					if (companyCode != null && companyCode != "") {

						// 默认都是成功写入状态
						Object matchca = map.get(companyCode);
						if (matchca != null) {
							try {
								if (errorMsg != null)
									PropertyUtils.setSimpleProperty(matchca, errorMsg, errorMsg);
							} catch (Exception e) {
								logger.debug("writeResultToExcel PropertyUtils exception:{}", e.getMessage());
							}

						}
					}
				}
			}
			String writeFileName = Const.companyPath + fileName + getTimeDateStr() + ".xlsx";
			// 这里 需要指定写用哪个class去写
			ExcelWriter excelWriter = null;
			try {
				if(clazz.equals(CompanyAccount.class)) {
					excelWriter = EasyExcel.write(writeFileName, CompanyAccount.class).build();
				}else {
					excelWriter = EasyExcel.write(writeFileName, CompanyTransaction.class).build();
				}
				
				WriteSheet writeSheet = EasyExcel.writerSheet("结果明细").build();
				excelWriter.write(list, writeSheet);
			} catch (Exception e) {
				logger.debug("writeResultToExcel exception:{}", e.getMessage());
			} finally {
				// 千万别忘记finish 会帮忙关闭流
				if (excelWriter != null) {
					excelWriter.finish();
				}
			}
		} catch (Exception e) {
			logger.debug("writeResultToExcel Exception:{}",e.getMessage());
		}
	}
	
	
}
