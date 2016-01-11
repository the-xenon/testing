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
    final String MSG_NICK_EMPTY = "Non hai compilato i seguenti campi: Nick";
    final String MSG_PASSWORD_EMPTY = "Non hai compilato i seguenti campi: Password";
    final String MSG_EMAIL_EMPTY = "Non hai compilato i seguenti campi: Email";
    final String MSG_BIRTHDAY_EMPTY = "Non hai compilato i seguenti campi: Compleanno";
    final String MSG_RULES_NON_CHECKED = "Non hai compilato i seguenti campi: Confermo di aver letto ed accettato tutte i regolamenti";
    final String MSG_PASSWORD_CONFIRMATION_WRONG = "La Password e la conferma Password sono differenti";
    final String MSG_PASSWORD_CONFIRMATION_EMPTY = "Non hai compilato i seguenti campi: Conferma password";

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
                "Unable to find error message '" + errorMessage + "' for wrong login '" + login +"'."
        );
    }

    @DataProvider(name = "wrongNick")
    public Object[][] wrongNickData() {
        return new Object[][] {
                {"", MSG_NICK_EMPTY}
        };
    }

    @Test(dataProvider = "wrongNick")
    public void negativeWrongNick(String nick, String errorMessage) {
        CommonRegistrationPage regPage = pageHelper.navigateToCommonRegistrationPage();

        RivUser user = userHelper.generateValidCommon();
        user.setNickname(nick);
        RegistrationErrorPage errorPage = regPage.incorrectRegistration(user, user.getPassword(), true);

        Assert.assertTrue(
                errorPage.hasErrorFieldWithText(errorMessage),
                "Unable to find error message '" + errorMessage + "' for wrong nick '" + nick +"'."
        );
    }

    @DataProvider(name = "wrongPassword")
    public Object[][] wrongPasswordData() {
        return new Object[][] {
                {"", MSG_PASSWORD_EMPTY}
        };
    }

    @Test(dataProvider = "wrongPassword")
    public void negativeWrongPassword(String password, String errorMessage) {
        CommonRegistrationPage regPage = pageHelper.navigateToCommonRegistrationPage();

        RivUser user = userHelper.generateValidCommon();
        user.setPassword(password);
        RegistrationErrorPage errorPage = regPage.incorrectRegistration(user, user.getPassword(), true);

        Assert.assertTrue(
                errorPage.hasErrorFieldWithText(errorMessage),
                "Unable to find error message '" + errorMessage + "' for wrong password '" + password +"'."
        );
    }

    @DataProvider(name = "wrongEmail")
    public Object[][] wrongEmailData() {
        return new Object[][] {
                {"", MSG_EMAIL_EMPTY}
        };
    }

    @Test(dataProvider = "wrongEmail")
    public void negativeWrongEmail(String email, String errorMessage) {
        CommonRegistrationPage regPage = pageHelper.navigateToCommonRegistrationPage();

        RivUser user = userHelper.generateValidCommon();
        user.setEmail(email);
        RegistrationErrorPage errorPage = regPage.incorrectRegistration(user, user.getPassword(), true);

        Assert.assertTrue(
                errorPage.hasErrorFieldWithText(errorMessage),
                "Unable to find error message '" + errorMessage + "' for wrong email '" + email +"'."
        );
    }

    @DataProvider(name = "wrongPasswordConfirmation")
    public Object[][] wrongPasswordConfirmationData() {
        return new Object[][] {
                {"", MSG_PASSWORD_CONFIRMATION_EMPTY},
                {"wrongconfirmation", MSG_PASSWORD_CONFIRMATION_WRONG}
        };
    }

    @Test(dataProvider = "wrongPasswordConfirmation")
    public void negativeEmptyPasswordConfirmation(String password, String errorMessage) {
        CommonRegistrationPage regPage = pageHelper.navigateToCommonRegistrationPage();

        RivUser user = userHelper.generateValidCommon();
        RegistrationErrorPage errorPage = regPage.incorrectRegistration(user, password, true);

        Assert.assertTrue(
                errorPage.hasErrorFieldWithText(errorMessage),
                "Unable to find error message '" + errorMessage + "' for wrong password confirmation '" + password +"'."
        );
    }

    @Test
    public void negativeEmptyBirthDay() {
        CommonRegistrationPage regPage = pageHelper.navigateToCommonRegistrationPage();

        RivUser user = userHelper.generateValidCommon();
        user.setBirthDay(null);
        RegistrationErrorPage errorPage = regPage.incorrectRegistration(user, user.getPassword(), true);

        Assert.assertTrue(
                errorPage.hasErrorFieldWithText(MSG_BIRTHDAY_EMPTY),
                "Unable to find error message '" + MSG_BIRTHDAY_EMPTY + "' for empty birth day"
        );
    }

    @Test
    public void negativeEmptyBirthMonth() {
        CommonRegistrationPage regPage = pageHelper.navigateToCommonRegistrationPage();

        RivUser user = userHelper.generateValidCommon();
        user.setBirthMonth(null);
        RegistrationErrorPage errorPage = regPage.incorrectRegistration(user, user.getPassword(), true);

        Assert.assertTrue(
                errorPage.hasErrorFieldWithText(MSG_BIRTHDAY_EMPTY),
                "Unable to find error message '" + MSG_BIRTHDAY_EMPTY + "' for empty birth month"
        );
    }

    @Test
    public void negativeEmptyBirthYear() {
        CommonRegistrationPage regPage = pageHelper.navigateToCommonRegistrationPage();

        RivUser user = userHelper.generateValidCommon();
        user.setBirthYear(null);
        RegistrationErrorPage errorPage = regPage.incorrectRegistration(user, user.getPassword(), true);

        Assert.assertTrue(
                errorPage.hasErrorFieldWithText(MSG_BIRTHDAY_EMPTY),
                "Unable to find error message '" + MSG_BIRTHDAY_EMPTY + "' for empty birth year"
        );
    }

    @Test
    public void negativeWithoutRulesConfirmation() {
        CommonRegistrationPage regPage = pageHelper.navigateToCommonRegistrationPage();

        RivUser user = userHelper.generateValidCommon();
        RegistrationErrorPage errorPage = regPage.incorrectRegistration(user, user.getPassword(), false);

        Assert.assertTrue(
                errorPage.hasErrorFieldWithText(MSG_RULES_NON_CHECKED),
                "Unable to find error message '" + MSG_RULES_NON_CHECKED + "' for non checked rules confirmation checkbox"
        );
    }
}
