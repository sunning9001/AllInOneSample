package sample;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumKeywordDriverFramework {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", ".\\Tools\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		driver.get("https://www.baidu.com");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 点击登录链接
		driver.findElement(By.xpath(".//*[@id='u1']/a[text()='登录']")).click();

		// 点击账号密码登录
		driver.findElement(By.id("TANGRAM__PSP_10__footerULoginBtn")).click();

		driver.findElement(By.id("TANGRAM__PSP_10__userName")).sendKeys("xxxxx");
		driver.findElement(By.id("TANGRAM__PSP_10__password")).sendKeys("xxxxx");
		driver.findElement(By.id("TANGRAM__PSP_10__submit")).click();
	}
}
