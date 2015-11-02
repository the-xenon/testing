package xenon.webdriver.proto;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by xenon on 02.11.2015.
 */
public class TestBrowser {
    private WebDriver driver;

    public TestBrowser() {
        driver = new FirefoxDriver();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void navigateTo(String path) {
        driver.get("http://beta:7sidQueplo@beta.ragazzeinvendita.com" + path);
    }

    public RivPageObject getCurrentPageAs(Class<RivPageObject> pageClass) throws IllegalAccessException, InstantiationException {
        return pageClass.newInstance();
    }
}
