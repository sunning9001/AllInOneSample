package sample;

public class DriverScript {

	public static void main(String[] args) throws Exception {

		String excel_path = ".\\Tools\\dataEngine.xlsx";
		// 加载读取excel文件
		ExcelUtils.setExcelFile(excel_path, "Test Steps");

		for (int iRow = 1; iRow <= 7; iRow++) {

			
			String sActionKeyword = ExcelUtils.getCellData(iRow, 3);
            System.out.println(" i = " +iRow + " sActionKeyword  =" + sActionKeyword);
			// 和excel文件中关键字进行对比
			if (sActionKeyword.equals("openBrowser")) {
				// 如果Excel文件中存在openBrowser的关键字就会调用openBrowser()方法，进行相关操作；下面其他关键字同理。
				ActionsKeywords.openBrowser();
			} else if (sActionKeyword.equals("openUrl")) {
				ActionsKeywords.openUrl();
			} else if (sActionKeyword.equals("click_Login_link")) {
				ActionsKeywords.click_Login_link();
			} else if (sActionKeyword.equals("input_Username")) {
				ActionsKeywords.input_Username();
			} else if (sActionKeyword.equals("input_Password")) {
				ActionsKeywords.input_Password();
			} else if (sActionKeyword.equals("click_Submit")) {
				ActionsKeywords.click_Submit();
			} else if (sActionKeyword.equals("closeBrowser")) {
				ActionsKeywords.closeBrowser();
			}

		}

	}
}
