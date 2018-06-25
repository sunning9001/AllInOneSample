package sample.webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Selenium2BaiduLocationElementExample2 {

	public static void main(String[] args) throws InterruptedException {
		   System.setProperty("webdriver.gecko.driver", ".\\Tools\\geckodriver.exe");  
		   
		 // Create a new instance of the Firefox driver
        // Notice that the remainder of the code relies on the interface, 
        // not the implementation.
        WebDriver driver = new FirefoxDriver();

        // And now use this to visit Google
        driver.get("https://www.baidu.com");
        // Alternatively the same thing can be done like this
        // driver.navigate().to("http://www.google.com");

        // Find the text input element by its name
        WebElement idElement = driver.findElement(By.id("kw"));
        
        
        System.out.println("wd nameElement : " + idElement.getText());

        // Enter something to search for
        idElement.sendKeys("sunning9001");

        // Now submit the form. WebDriver will find the form for us from the element
        idElement.submit();

        // Check the title of the page
        System.out.println("Page title is: " + driver.getTitle());
        
        // Google's search is rendered dynamically with JavaScript.
        // Wait for the page to load, timeout after 10 seconds
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith("sunning9001");
            }
        });

      
     
        // Should see: "cheese! - Google Search"
        System.out.println("Page title is: " + driver.getTitle());
        
        
        driver.wait(10000);
        //Close the browser
        driver.quit();
	}
}
