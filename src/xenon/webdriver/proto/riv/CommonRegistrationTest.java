package xenon.webdriver.proto.riv;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CommonRegistrationTest {
    PageHelper pageHelper = new PageHelper(DriverFactory.createDriver());
    UserHelper userHelper = new UserHelper();

    //@Test
    public void positive() {
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
/*
    @Test
    public void negativeEmptyLogin() {
        CommonRegistrationPage regPage = pageHelper.navigateToCommonRegistrationPage();

        RivUser user = userHelper.generateValidCommon();
        user.setLogin("");
        RegistrationErrorPage errorPage = regPage.incorrectRegistration(user, user.getPassword(), true);

        Assert.assertTrue(errorPage.hasErrorFieldWithText(
                "Non hai compilato i seguenti campi: Login"
        ));
    }

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
    public void negativeEmptyPasswordConfirmation() {
        CommonRegistrationPage regPage = pageHelper.navigateToCommonRegistrationPage();

        RivUser user = userHelper.generateValidCommon();
        RegistrationErrorPage errorPage = regPage.incorrectRegistration(user, "", true);

        Assert.assertTrue(errorPage.hasErrorFieldWithText(
                "Non hai compilato i seguenti campi: Conferma password"
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
    }*/


    @Test
    public void negative1SymbolLogin() {
        CommonRegistrationPage regPage = pageHelper.navigateToCommonRegistrationPage();

        RivUser user = userHelper.generateValidCommon();
        user.setLogin("a");
        RegistrationErrorPage errorPage = regPage.incorrectRegistration(user, user.getPassword(), true);

        Assert.assertTrue(errorPage.hasErrorFieldWithText(
                "Login: La lunghezza del campo deve essere: 3..25"
        ));
    }

    @Test
    public void negative2SymbolsLogin() {
        CommonRegistrationPage regPage = pageHelper.navigateToCommonRegistrationPage();

        RivUser user = userHelper.generateValidCommon();
        user.setLogin("GJ");
        RegistrationErrorPage errorPage = regPage.incorrectRegistration(user, user.getPassword(), true);

        Assert.assertTrue(errorPage.hasErrorFieldWithText(
                "Login: La lunghezza del campo deve essere: 3..25"
        ));
    }

    @Test
    public void negative4MoreDigitsInLogin() {
        CommonRegistrationPage regPage = pageHelper.navigateToCommonRegistrationPage();

        RivUser user = userHelper.generateValidCommon();
        user.setLogin("test82715user");
        RegistrationErrorPage errorPage = regPage.incorrectRegistration(user, user.getPassword(), true);

        Assert.assertTrue(errorPage.hasErrorFieldWithText(
                "Login: Formato Campo non valido"
        ));
    }

    @Test
    public void negativeSpaceInLogin() {
        CommonRegistrationPage regPage = pageHelper.navigateToCommonRegistrationPage();

        RivUser user = userHelper.generateValidCommon();
        user.setLogin("this is");
        RegistrationErrorPage errorPage = regPage.incorrectRegistration(user, user.getPassword(), true);

        Assert.assertTrue(errorPage.hasErrorFieldWithText(
                "Login: Formato Campo non valido"
        ));
    }

    @Test
    public void negativeWrongSymbolInLogin() {
        CommonRegistrationPage regPage = pageHelper.navigateToCommonRegistrationPage();

        RivUser user = userHelper.generateValidCommon();
        user.setLogin("$wrongsymbol");
        RegistrationErrorPage errorPage = regPage.incorrectRegistration(user, user.getPassword(), true);

        Assert.assertTrue(errorPage.hasErrorFieldWithText(
                "Login: Formato Campo non valido"
        ));
    }
}
