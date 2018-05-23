package POISample;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataFormats {
	public static void main(String[] args) throws Exception {
		    Workbook wb = new XSSFWorkbook();
		    Sheet sheet = wb.createSheet("format sheet");
		    CellStyle style;
		    DataFormat format = wb.createDataFormat();
		    Row row;
		    Cell cell;
		    int rowNum = 0;
		    int colNum = 0;

		    row = sheet.createRow(rowNum++);
		    cell = row.createCell(colNum);
		    cell.setCellValue(11111.25);
		    style = wb.createCellStyle();
		    style.setDataFormat(format.getFormat("0.0"));
		    cell.setCellStyle(style);

		    row = sheet.createRow(rowNum++);
		    cell = row.createCell(colNum);
		    cell.setCellValue(11111.25);
		    style = wb.createCellStyle();
		    style.setDataFormat(format.getFormat("#,##0.0000"));
		    cell.setCellStyle(style);

			FileOutputStream fileOut = new FileOutputStream("C://Users//sunning//Desktop//workbook.xlsx");
		    wb.write(fileOut);
		    fileOut.close();
	}
}
