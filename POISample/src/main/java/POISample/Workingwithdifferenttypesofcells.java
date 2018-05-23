package POISample;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Calendar;
import java.util.Date;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Workingwithdifferenttypesofcells {
	public static void main(String[] args) throws Exception {
		  
		    
		    Workbook wb = new XSSFWorkbook();
	
		    Sheet sheet = wb.createSheet("new sheet");
		    Row row = sheet.createRow(2);
		    row.createCell(0).setCellValue(1.1);
		    row.createCell(1).setCellValue(new Date());
		    row.createCell(2).setCellValue(Calendar.getInstance());
		    row.createCell(3).setCellValue("a string");
		    row.createCell(4).setCellValue(true);
		    row.createCell(5).setCellType(CellType.ERROR);

		    // Write the output to a file
		    FileOutputStream fileOut = new FileOutputStream("C://Users//sunning//Desktop//workbook.xlsx");
		    wb.write(fileOut);
		    fileOut.close();
	}
}
