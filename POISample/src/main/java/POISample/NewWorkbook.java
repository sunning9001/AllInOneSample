package POISample;

import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class NewWorkbook {
	public static void main(String[] args) throws Exception {

	    Workbook wb = new XSSFWorkbook();
	    FileOutputStream fileOut = new FileOutputStream("C://Users//sunning//Desktop//workbook.xlsx");
	    wb.write(fileOut);
	    fileOut.close();
	
	}
}
