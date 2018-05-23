package POISample;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.BorderFormatting;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.ComparisonOperator;
import org.apache.poi.ss.usermodel.ConditionalFormattingRule;
import org.apache.poi.ss.usermodel.FontFormatting;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.PatternFormatting;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.SheetConditionalFormatting;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ConditionalFormatting {
  public static void main(String[] args) throws Exception {
	
	    Workbook wb = new XSSFWorkbook();
	    Sheet sheet = wb.createSheet();

	    SheetConditionalFormatting sheetCF = sheet.getSheetConditionalFormatting();

	    ConditionalFormattingRule rule1 = sheetCF.createConditionalFormattingRule(ComparisonOperator.EQUAL, "0");
	    FontFormatting fontFmt = rule1.createFontFormatting();
	    fontFmt.setFontStyle(true, false);
	    fontFmt.setFontColorIndex(IndexedColors.DARK_RED.index);
	    
	    BorderFormatting bordFmt = rule1.createBorderFormatting();
	    bordFmt.setBorderBottom(BorderStyle.THIN);
	    bordFmt.setBorderTop(BorderStyle.THICK);
	    bordFmt.setBorderLeft(BorderStyle.DASHED);
	    bordFmt.setBorderRight(BorderStyle.DOTTED);

	    PatternFormatting patternFmt = rule1.createPatternFormatting();
	    patternFmt.setFillBackgroundColor(IndexedColors.YELLOW.index);

	    ConditionalFormattingRule rule2 = sheetCF.createConditionalFormattingRule(ComparisonOperator.BETWEEN, "-10", "10");
	    ConditionalFormattingRule [] cfRules =
	    {
	        rule1, rule2
	    };

	    CellRangeAddress[] regions = {
	        CellRangeAddress.valueOf("A1:A5000")
	    };

	    sheetCF.addConditionalFormatting(regions, cfRules);
	    

	    // Write the output to a file
	    FileOutputStream fileOut = new FileOutputStream("C://Users//sunning//Desktop//workbook.xlsx");
	    wb.write(fileOut);
	    fileOut.close();
}
}
