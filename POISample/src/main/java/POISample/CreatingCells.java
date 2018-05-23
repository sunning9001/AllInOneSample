package POISample;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CreatingCells {

	public static void main(String[] args) throws Exception {
		
		 Workbook wb = new XSSFWorkbook();
		    //Workbook wb = new XSSFWorkbook();
		    CreationHelper createHelper = wb.getCreationHelper();
		    Sheet sheet = wb.createSheet("new sheet");

		    // Create a row and put some cells in it. Rows are 0 based.
		    Row row = sheet.createRow(0);
		    // Create a cell and put a value in it.
		    Cell cell = row.createCell(0);
		    cell.setCellValue(1);

		    // Or do it on one line.
		    row.createCell(1).setCellValue(1.2);
		    row.createCell(2).setCellValue(
		         createHelper.createRichTextString("This is a string"));
		    row.createCell(3).setCellValue(true);

		    // Write the output to a file
		    FileOutputStream fileOut = new FileOutputStream("C://Users//sunning//Desktop//workbook.xlsx");
		    wb.write(fileOut);
		    fileOut.close();
	}
}
