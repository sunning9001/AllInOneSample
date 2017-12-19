import java.util.List;

import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.seg.Segment;
import com.hankcs.hanlp.seg.common.Term;

public class HanLPSample {
	public static void main(String[] args) {

		String[] testCase = new String[] { 
				"我爱无锡高运金融信息服务有限公司哦 ", 
				"我每个月总有几天去江苏交易场所登记结算有限公司出差",
				 };
		Segment segment = HanLP.newSegment().enableOrganizationRecognize(true);
		for (String sentence : testCase) {
			List<Term> termList = segment.seg(sentence);
			for (Term term : termList) {
				if(term.toString().contains("/nt"))
				System.out.println(term.toString());
			}
		}
	}
}
