package sample.lambda;

public class ConverterSample {

	public static void main(String[] args) {
		
		Converter<Integer,String> ct =t -> Integer.toBinaryString(t);
		
	    System.out.println(ct.convert(5999999));
	    

	    //Java 8 enables you to pass references of methods or constructors via the :: keyword.
	    Converter<String, Integer> si =Integer::valueOf;
	    
	    System.out.println(si.convert("1111111111"));
	    
	    
	    final int num = 1;
	    Converter<Integer, String> stringConverter =
	            (from) -> String.valueOf(from + num);

	    stringConverter.convert(2);     // 3
	}
}
