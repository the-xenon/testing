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

        TestBrowser browser = TestHelper.getTestBrowser();
        browser.navigateTo(Pages.INDEX);
//        IndexPageObject indexPage = browser.getCurrentPageAs(IndexPageObject.class);
        LoginFormObject loginForm = indexPage.openLoginForm();
//        loginForm.loginAs("xenon22", "password");
        //browser.getCurrentPageAsLoggedInObject();
        //LoggedInPageObject loggedInPage = browser.getCurrentPageAs(LoggedInPageObject.class);
        //browser.currentPageIs(LoggedInPageObject.class);
//        browser.navigateTo(Pages.PRIVATE_PHOTOS);
//        PrivatePhotosPageObject privatePhotosPage = browser.getCurrentPageAs(PrivatePhotosPageObject.class);

        //IndexPageObject indexPage = RivSite

        //----------------------------
/*        IndexPageObject indexPage = getIndexPage();
        indexPage.navigate();
        LoginFormObject loginForm = indexPage.openLoginForm();
        //UserIndexPage userIndexPage = loginForm.successfulLoginAs("xenon22", "password");
        RivPageObject rivPageObject = loginForm.loginAs("xenon22", "password");
        LoggedInPageObject loggedInPage = new LoggedInPageObject(rivPageObject);*/

        /*Assert.assertTrue(checkCommonIndexPage(userIndexPage));*/

        //userIndexPage.logout();
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
//            indexPage = new IndexPageObject(driver);
        }
        return indexPage;
    }
}
