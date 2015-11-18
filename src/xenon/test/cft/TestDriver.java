package xenon.test.cft;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

import io.selendroid.standalone.SelendroidConfiguration;
import io.selendroid.standalone.SelendroidLauncher;

public class TestDriver {
	private WebDriver driver;
	
	public TestDriver() {
		SelendroidConfiguration config = new SelendroidConfiguration();
		// Add the selendroid-test-app to the standalone server
//		config.addSupportedApp("D:\\Android\\selendroid\\test.apk");
		SelendroidLauncher selendroidServer = new SelendroidLauncher(config);
		selendroidServer.launchSelendroid();
		
		/*DesiredCapabilities capabilities = new DesiredCapabilities();
    	//desiredCapabilities.setCapability("app", "D:\\Android\\selendroid\\test.apk");
    	capabilities.setCapability("appPackage", "ru.nsk.ftc.bender");
    	capabilities.setCapability("appActivity", "ru.ftc.bender.ui.screen.login.ean.ScreenCardEanEnterActivity");
    	capabilities.setCapability("platformName", "Android");
    	capabilities.setCapability("deviceName", "test");
    	
    	try {
			driver = new RemoteWebDriver(
					//new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
					new URL("http://127.0.0.1:4444/wd/hub"), capabilities);
		} catch (MalformedURLException e) {
			throw new RuntimeException("Remote WebDriver's URL is malformed.", e);
		}*/
    	
    	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	public void quit() {
		driver.quit();
	}

	public void initElements(Object object) {
		PageFactory.initElements(driver, object);
	}

	public WebDriver getDriver() {
		return driver;
	}
	
	
}
