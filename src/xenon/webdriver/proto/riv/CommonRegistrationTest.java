package xenon.webdriver.proto.riv;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by xenon on 05.12.2015.
 */
public class CommonRegistrationTest {
    PageHelper pageHelper = new PageHelper(DriverFactory.createDriver());
    UserHelper userHelper = new UserHelper();

    //@Test
    public void correctRegistrationTest() {
        CommonRegistrationPage regPage = pageHelper.navigateToCommonRegistrationPage();

        RivUser user = userHelper.generateValidCommon();
        LoggedinPage loggedinPage = regPage.register(user);

        Assert.assertTrue(loggedinPage.hasNicknameFieldWithNick(user.getNickname()));
        Assert.assertTrue(loggedinPage.hasCreditsField());
        Assert.assertTrue(loggedinPage.hasNotificationFieldWithText(
                "Ciao! Ti diamo il benvenuto sul sito di webcam girls più amato dagli italiani. La tua iscrizione su RIV è avvenuta correttamente."
        ));

        loggedinPage.logout();
    }

    @Test
    public void regEmptyLoginTest() {
        CommonRegistrationPage regPage = pageHelper.navigateToCommonRegistrationPage();

        RivUser user = userHelper.generateValidCommon();
        user.setLogin("");
        RegistrationErrorPage errorPage = regPage.incorrectRegistration(user, user.getPassword(), true);

        Assert.assertTrue(errorPage.hasErrorFieldWithText(
                "Non hai compilato i seguenti campi: Login"
        ));
    }

    @Test
    public void regShortLoginTest() {
        CommonRegistrationPage regPage = pageHelper.navigateToCommonRegistrationPage();

        RivUser user = userHelper.generateValidCommon();
        user.setLogin("a");
        RegistrationErrorPage errorPage = regPage.incorrectRegistration(user, user.getPassword(), true);

        Assert.assertTrue(errorPage.hasErrorFieldWithText(
                "Login: La lunghezza del campo deve essere: 3..25"
        ));
    }
}
