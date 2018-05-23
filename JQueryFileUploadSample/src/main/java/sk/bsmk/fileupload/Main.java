package sk.bsmk.fileupload;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
	/**
	 * 校验手机号码
	 * @param mobiles
	 * @return
	 */
	public static boolean isMobileNO(String mobiles){
		Pattern p = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");
		Matcher m = p.matcher(mobiles);
		return m.matches();
	}
	
	public static void main(String[] args) {
		System.out.println(isMobileNO("15251509035"));
	}
}
