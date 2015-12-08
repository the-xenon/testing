package xenon.webdriver.proto.riv;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

	public static WebDriver createDriver() {
		/*WebDriver driver = new FirefoxDriver();*/
		System.setProperty("webdriver.chrome.driver", "..\\..\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		return driver;
	}

}
