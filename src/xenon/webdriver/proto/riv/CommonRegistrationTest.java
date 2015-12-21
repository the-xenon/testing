package xenon.webdriver.proto.riv;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CommonRegistrationTest {
    PageHelper pageHelper = new PageHelper(DriverFactory.createDriver());
    UserHelper userHelper = new UserHelper();

    final String MSG_SUCCESS_REGISTRATION = "Ciao! Ti diamo il benvenuto sul sito di webcam girls più amato dagli italiani. La tua iscrizione su RIV è avvenuta correttamente.";
    final String MSG_LOGIN_SHORT = "Login: La lunghezza del campo deve essere: 3..25";
    final String MSG_LOGIN_EMPTY = "Non hai compilato i seguenti campi: Login";
    final String MSG_LOGIN_INVALID = "Login: Formato Campo non valido";

    //@Test
    public void positive() {
        CommonRegistrationPage regPage = pageHelper.navigateToCommonRegistrationPage();

        RivUser user = userHelper.generateValidCommon();
        LoggedinPage loggedinPage = regPage.register(user);

        Assert.assertTrue(loggedinPage.hasNicknameFieldWithNick(user.getNickname()));
        Assert.assertTrue(loggedinPage.hasCreditsField());
        Assert.assertTrue(loggedinPage.hasNotificationFieldWithText(MSG_SUCCESS_REGISTRATION));

        loggedinPage.logout();
    }

    @DataProvider(name = "wrongLogin")
    public Object[][] wrongLoginData() {
        return new Object[][] {
                {"", MSG_LOGIN_EMPTY},
                {"a", MSG_LOGIN_SHORT}, {"gj", MSG_LOGIN_SHORT},
                //5 digits in login
                {"abcd82715efg", MSG_LOGIN_INVALID}, {"h8ijk27lmno15pr", MSG_LOGIN_INVALID},
                //space in login
                {"stuv wx", MSG_LOGIN_INVALID},
                //invalid symbol in login
                {"typical$user", MSG_LOGIN_INVALID}, {"invalid:symbol", MSG_LOGIN_INVALID}
        };
    }

    @Test(dataProvider = "wrongLogin")
    public void negativeWrongLogin(String login, String errorMessage) {
        CommonRegistrationPage regPage = pageHelper.navigateToCommonRegistrationPage();

        RivUser user = userHelper.generateValidCommon();
        user.setLogin(login);
        RegistrationErrorPage errorPage = regPage.incorrectRegistration(user, user.getPassword(), true);

        Assert.assertTrue(
                errorPage.hasErrorFieldWithText(errorMessage),
                "Unable to find error message '" + errorMessage + "' for wrong login '" + login +"'.");
    }
/*
    @Test
    public void negativeEmptyNick() {
        CommonRegistrationPage regPage = pageHelper.navigateToCommonRegistrationPage();

        RivUser user = userHelper.generateValidCommon();
        user.setNickname("");
        RegistrationErrorPage errorPage = regPage.incorrectRegistration(user, user.getPassword(), true);

        Assert.assertTrue(errorPage.hasErrorFieldWithText(
                "Non hai compilato i seguenti campi: Nick"
        ));
    }

    @Test
    public void negativeEmptyPassword() {
        CommonRegistrationPage regPage = pageHelper.navigateToCommonRegistrationPage();

        RivUser user = userHelper.generateValidCommon();
        user.setPassword("");
        RegistrationErrorPage errorPage = regPage.incorrectRegistration(user, user.getPassword(), true);

        Assert.assertTrue(errorPage.hasErrorFieldWithText(
                "Non hai compilato i seguenti campi: Password"
        ));
    }



    @Test
    public void negativeEmptyEmail() {
        CommonRegistrationPage regPage = pageHelper.navigateToCommonRegistrationPage();

        RivUser user = userHelper.generateValidCommon();
        user.setEmail("");
        RegistrationErrorPage errorPage = regPage.incorrectRegistration(user, user.getPassword(), true);

        Assert.assertTrue(errorPage.hasErrorFieldWithText(
                "Non hai compilato i seguenti campi: Email"
        ));
    }*/

    @Test
    public void negativeEmptyPasswordConfirmation() {
        CommonRegistrationPage regPage = pageHelper.navigateToCommonRegistrationPage();

        RivUser user = userHelper.generateValidCommon();
        RegistrationErrorPage errorPage = regPage.incorrectRegistration(user, "", true);

        Assert.assertTrue(errorPage.hasErrorFieldWithText(
                "Non hai compilato i seguenti campi: Conferma password"
        ));
    }

    @Test
    public void negativeEmptyBirthdayDay() {
        CommonRegistrationPage regPage = pageHelper.navigateToCommonRegistrationPage();

        RivUser user = userHelper.generateValidCommon();
        user.setBirthDay(null);
        RegistrationErrorPage errorPage = regPage.incorrectRegistration(user, user.getPassword(), true);

        Assert.assertTrue(errorPage.hasErrorFieldWithText(
                "Non hai compilato i seguenti campi: Compleanno"
        ));
    }

    @Test
    public void negativeEmptyBirthdayMonth() {
        CommonRegistrationPage regPage = pageHelper.navigateToCommonRegistrationPage();

        RivUser user = userHelper.generateValidCommon();
        user.setBirthMonth(null);
        RegistrationErrorPage errorPage = regPage.incorrectRegistration(user, user.getPassword(), true);

        Assert.assertTrue(errorPage.hasErrorFieldWithText(
                "Non hai compilato i seguenti campi: Compleanno"
        ));
    }

    @Test
    public void negativeEmptyBirthdayYear() {
        CommonRegistrationPage regPage = pageHelper.navigateToCommonRegistrationPage();

        RivUser user = userHelper.generateValidCommon();
        user.setBirthYear(null);
        RegistrationErrorPage errorPage = regPage.incorrectRegistration(user, user.getPassword(), true);

        Assert.assertTrue(errorPage.hasErrorFieldWithText(
                "Non hai compilato i seguenti campi: Compleanno"
        ));
    }

    @Test
    public void negativeWithoutRulesConfirmation() {
        CommonRegistrationPage regPage = pageHelper.navigateToCommonRegistrationPage();

        RivUser user = userHelper.generateValidCommon();
        RegistrationErrorPage errorPage = regPage.incorrectRegistration(user, user.getPassword(), false);

        Assert.assertTrue(errorPage.hasErrorFieldWithText(
                "Non hai compilato i seguenti campi: Confermo di aver letto ed accettato tutte i regolamenti"
        ));
    }
}
