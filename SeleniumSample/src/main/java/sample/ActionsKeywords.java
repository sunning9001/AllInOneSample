package sample;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ActionsKeywords {

	public static WebDriver driver;

	/**
	 * 以下方法，我们针对dataEngine.xlsx文件中的action_keyword这列的关键字都进行封装
	 * 等关键字框架快设计完了，我们再来调整，读取配置文件去启动不同测试浏览器和测试地址 这样就不会代码写死这两个参数。
	 */
	public static void openBrowser() {

		// 这里，我们暂时都写死用chrome来进行自动化测试
		System.setProperty("webdriver.chrome.driver", ".\\Tools\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	public static void openUrl() {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://www.baidu.com");

	}

	public static void click_Login_link() {
		driver.findElement(By.xpath(".//*[@id='u1']/a[text()='登录']")).click();
		driver.findElement(By.id("TANGRAM__PSP_10__footerULoginBtn")).click();
	}

	public static void input_Username() {
		driver.findElement(By.id("TANGRAM__PSP_10__userName")).sendKeys("xxxxx");
	}

	public static void input_Password() {
		driver.findElement(By.id("TANGRAM__PSP_10__password")).sendKeys("xxxxx");
	}

	public static void click_Submit() {
		driver.findElement(By.id("TANGRAM__PSP_10__submit")).click();
	}

	// 关闭浏览器并退出
	public static void closeBrowser() {
		driver.quit();
	}
}
