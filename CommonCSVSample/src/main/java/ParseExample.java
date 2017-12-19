import java.io.FileReader;
import java.io.Reader;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

public class ParseExample {

	public static void main(String[] args) throws Exception {

		Reader in = new FileReader("example.csv");

		Iterable<CSVRecord> records = CSVFormat.RFC4180.withFirstRecordAsHeader().parse(in);
		for (CSVRecord record : records) {
		    String a = record.get("a");
		    String b = record.get("b");
		    String c = record.get("c");
		    
		    System.out.println("a:"+a);
		    System.out.println("b:"+b);
		    System.out.println("c:"+c);
		}
	}
}
