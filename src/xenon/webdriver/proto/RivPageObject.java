package xenon.webdriver.proto;

import org.openqa.selenium.WebDriver;

/**
 * Created by xenon on 02.11.2015.
 */
public class RivPageObject {
    protected WebDriver driver;

    public RivPageObject(TestBrowser testBrowser) {
        driver = testBrowser.getDriver();
    }
}
