package xenon.webdriver.proto.riv;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by xenon on 31.10.2015.
 */
public class IndexPageTest {
    PageHelper pageHelper = new PageHelper(DriverFactory.createDriver());
    UserHelper userHelper = new UserHelper();
    
    /*@AfterClass
    public void close() {
        pageHelper.close();
    }*/

    @Test
    public void authCorrectLoginPasswordCommonTest() {
    	IndexPage indexPage = pageHelper.navigateToIndexPage();

        RivUser user = userHelper.getValidCommon();
    	LoggedinPage loggedinPage = indexPage.login(user.getLogin(), user.getPassword());
    	
    	Assert.assertTrue(loggedinPage.hasNicknameField(user.getNickname()));
    	Assert.assertTrue(loggedinPage.hasCreditsField());
    	
    	loggedinPage.logout();
    }

    @Test
    public void authCorrectLoginPasswordModelTest() {
        IndexPage indexPage = pageHelper.navigateToIndexPage();

        RivUser user = userHelper.getValidModel();
        LoggedinPage loggedinPage = indexPage.login(user.getLogin(), user.getPassword());

        Assert.assertTrue(loggedinPage.hasNicknameField(user.getNickname()));
        Assert.assertTrue(loggedinPage.hasRevenueField());

        loggedinPage.logout();
    }

    @Test
    public void authEmptyLoginTest() {
        IndexPage indexPage = pageHelper.navigateToIndexPage();

        RivUser user = userHelper.getValidCommon();
        LoginErrorPage errorPage = indexPage.incorrectLogin("", user.getPassword());

        Assert.assertTrue(errorPage.hasErrorField("Il campo login non è compilato."));
    }

    @Test
    public void authWrongLoginTest() {
        IndexPage indexPage = pageHelper.navigateToIndexPage();

        RivUser user = userHelper.getValidModel();
        LoginErrorPage errorPage = indexPage.incorrectLogin("aksgh2jghksfgk2hg4k2j4gh", user.getPassword());

        Assert.assertTrue(errorPage.hasErrorField("Nessun utente nel sistema"));
    }

    @Test
    public void authEmptyPasswordTest() {
        IndexPage indexPage = pageHelper.navigateToIndexPage();

        RivUser user = userHelper.getValidCommon();
        LoginErrorPage errorPage = indexPage.incorrectLogin(user.getLogin(), "");

        Assert.assertTrue(errorPage.hasErrorField("Password errata"));
    }

    @Test
    public void authWrongPasswordTest() {
        IndexPage indexPage = pageHelper.navigateToIndexPage();

        RivUser user = userHelper.getValidModel();
        LoginErrorPage errorPage = indexPage.incorrectLogin(user.getLogin(), "aksgh2jghksfgk2hg4k2j4gh");

        Assert.assertTrue(errorPage.hasErrorField("Password errata"));
    }
}
