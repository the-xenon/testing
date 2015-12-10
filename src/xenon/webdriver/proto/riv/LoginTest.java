package xenon.webdriver.proto.riv;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest {
    PageHelper pageHelper = new PageHelper(DriverFactory.createDriver());
    UserHelper userHelper = new UserHelper();
    
    /*@AfterClass
    public void close() {
        pageHelper.close();
    }*/

    @Test
    public void positiveCommon() {
    	UnloggedIndexPage indexPage = pageHelper.navigateToUnloggedIndexPage();

        RivUser user = userHelper.getExistingCommon();
    	LoggedinPage loggedinPage = indexPage.login(user.getLogin(), user.getPassword());
    	
    	Assert.assertTrue(loggedinPage.hasNicknameFieldWithNick(user.getNickname()));
    	Assert.assertTrue(loggedinPage.hasCreditsField());
    	
    	loggedinPage.logout();
    }

    @Test
    public void positiveModel() {
        UnloggedIndexPage indexPage = pageHelper.navigateToUnloggedIndexPage();

        RivUser user = userHelper.getExistingModel();
        LoggedinPage loggedinPage = indexPage.login(user.getLogin(), user.getPassword());

        Assert.assertTrue(loggedinPage.hasNicknameFieldWithNick(user.getNickname()));
        Assert.assertTrue(loggedinPage.hasRevenueField());

        loggedinPage.logout();
    }

    @Test
    public void negativeEmptyLogin() {
        UnloggedIndexPage indexPage = pageHelper.navigateToUnloggedIndexPage();

        RivUser user = userHelper.getExistingCommon();
        LoginErrorPage errorPage = indexPage.incorrectLogin("", user.getPassword());

        Assert.assertTrue(errorPage.hasErrorFieldWithText("Il campo login non è compilato."));
    }

    @Test
    public void negativeWrongLogin() {
        UnloggedIndexPage indexPage = pageHelper.navigateToUnloggedIndexPage();

        RivUser user = userHelper.getExistingModel();
        LoginErrorPage errorPage = indexPage.incorrectLogin(user.getLogin() + "$", user.getPassword());

        Assert.assertTrue(errorPage.hasErrorFieldWithText("Nessun utente nel sistema"));
    }

    @Test
    public void negativeCommonEmptyPassword() {
        UnloggedIndexPage indexPage = pageHelper.navigateToUnloggedIndexPage();

        RivUser user = userHelper.getExistingCommon();
        LoginErrorPage errorPage = indexPage.incorrectLogin(user.getLogin(), "");

        Assert.assertTrue(errorPage.hasErrorFieldWithText("Password errata"));
    }

    @Test
    public void negativeModelEmptyPassword() {
        UnloggedIndexPage indexPage = pageHelper.navigateToUnloggedIndexPage();

        RivUser user = userHelper.getExistingModel();
        LoginErrorPage errorPage = indexPage.incorrectLogin(user.getLogin(), "");

        Assert.assertTrue(errorPage.hasErrorFieldWithText("Password errata"));
    }

    @Test
    public void negativeModelWrongPassword() {
        UnloggedIndexPage indexPage = pageHelper.navigateToUnloggedIndexPage();

        RivUser user = userHelper.getExistingModel();
        LoginErrorPage errorPage = indexPage.incorrectLogin(user.getLogin(), user.getPassword() + "1");

        Assert.assertTrue(errorPage.hasErrorFieldWithText("Password errata"));
    }

    @Test
    public void negativeCommonWrongPassword() {
        UnloggedIndexPage indexPage = pageHelper.navigateToUnloggedIndexPage();

        RivUser user = userHelper.getExistingModel();
        String correctPassword = user.getPassword();
        String password = correctPassword.substring(0, correctPassword.length() - 2);
        LoginErrorPage errorPage = indexPage.incorrectLogin(user.getLogin(), password);

        Assert.assertTrue(errorPage.hasErrorFieldWithText("Password errata"));
    }
}
