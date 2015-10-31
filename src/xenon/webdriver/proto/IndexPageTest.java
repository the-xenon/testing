package xenon.webdriver.proto;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by xenon on 31.10.2015.
 */
public class IndexPageTest {
    private IndexPageObject indexPage;
    private WebDriver driver;

    @Test
    public void authCorrectLoginPasswordCommonTest() {
        IndexPageObject indexPage = getIndexPage();
        indexPage.navigate();
        LoginFormObject loginForm = indexPage.openLoginForm();
        UserIndexPage userIndexPage = loginForm.successfulLoginAs("xenon22", "password");

        /*Assert.assertTrue(checkCommonIndexPage(userIndexPage));*/

        userIndexPage.logout();
    }

    @Test
    public void AuthCorrectLoginPasswordModelTest() {
        IndexPageObject indexPage = getIndexPage();
        indexPage.navigate();
        LoginFormObject loginForm = indexPage.openLoginForm();
        UserIndexPage userIndexPage = loginForm.successfulLoginAs("xenon111", "password");

        //Assert.assertTrue(checkModelIndexPage(userIndexPage));

        userIndexPage.logout();
    }

    private IndexPageObject getIndexPage() {
        return getIndexPage(false);
    }

    private IndexPageObject getIndexPage(boolean renew) {
        if (driver == null || renew) {
            driver = new FirefoxDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
        if (indexPage == null || renew) {
            indexPage = new IndexPageObject(driver);
        }
        return indexPage;
    }
}
