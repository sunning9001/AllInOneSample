/** 
 *  @Copyright:  http://www.wiotplanet.com  尚贤谷物联网科技发展有限公司 Inc. All rights reserved.
 *  @CreateTime: 2020年8月21日下午2:38:04
 *  @CreateUser: sunning 
 *  
 *
*/
package com.bjbank;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

/**
 *
 *   TODO: 描述这个类用来做什么事情TODO
 *
 *  @CreateTime  : 2020年8月21日下午2:38:04
 *  @CreateAuthor: sunning
 *  @Email       : sunning9001@126.com
 *
 */
public class AccountMatchUtil {

	public static Map<String, AccountMatch> map =new HashMap<String, AccountMatch>();
	
	public static void addAccountMatch(AccountMatch am) {
		if(am!=null) {
			map.put(am.getAccount(), am);
		}
	}
	/**
	 * 
	 *
	 * @TODO:     匹配一个账号库，匹配到的上传，匹配不到不上传。
	 * @CreateTime:  2020年8月21日下午2:38:50 
	 * @CreateAuthor: sunning
	 * @param str     银行账号
	 * @return
	 */
	public static boolean isMatchAccount(String str) {
		if(str!=null) {
			String account = StringUtils.trimToNull(str);
		   return	map.containsKey(account);
		}
		return false;
	}
}
