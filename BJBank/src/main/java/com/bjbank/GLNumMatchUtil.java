/** 
 *  @Copyright:  http://www.wiotplanet.com  尚贤谷物联网科技发展有限公司 Inc. All rights reserved.
 *  @CreateTime: 2020年8月21日下午2:12:15
 *  @CreateUser: sunning 
 *  
 *
*/
package com.bjbank;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 *   1）根据第6个字段科目号（GL_NUM）（五位数字）进行筛选，凡是匹配201-203开头的数据上传
 *	 2）剩下的数据要去匹配一个账号库，匹配到的上传，匹配不到不上传。
 *	 注：筛选关键字——科目号和账号库可在配置文件中维护
 *
 *  @CreateTime  : 2020年8月21日下午2:12:15
 *  @CreateAuthor: sunning
 *  @Email       : sunning9001@126.com
 *
 */
public class GLNumMatchUtil {

	private static Logger logger =LoggerFactory.getLogger(GLNumMatchUtil.class);
	private static  Set<String> glNumSet =new HashSet<>(); 
	
	public static void setGlNumSet(String str) {
		if(Const.glnum!=null && Const.glnum!="") {
			String[] array = StringUtils.split(StringUtils.trim(str), "|");
			
			for (String string : array) {
				 glNumSet.add(string);
			}
			
		}else {
			logger.debug("GLNumUtil  未配置科目号");
		}
	}
	/**
	 * 
	 *
	 * @TODO:     根据第6个字段科目号（GL_NUM）（五位数字）进行筛选，凡是匹配201-203开头的数据上传
	 * @CreateTime:  2020年8月21日下午2:29:23 
	 * @CreateAuthor: sunning
	 * @param str
	 * @return
	 */
	public static boolean isMatchGlNum(String str) {
		if(str!=null && str!="") {
			for (String glNum : glNumSet) {
				if(str.startsWith(glNum)) {
					return true;
				}
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		glNumSet.add("201asfdasfd");
		glNumSet.add("202asfdas312331fd");
		glNumSet.add("203asfdas312331fd");

		
		System.out.println(isMatchGlNum("201"));
		System.out.println(isMatchGlNum("202"));
		System.out.println(isMatchGlNum("203"));
	}
}
