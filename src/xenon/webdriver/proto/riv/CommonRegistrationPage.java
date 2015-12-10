package xenon.webdriver.proto.riv;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CommonRegistrationPage extends RegistrationErrorPage {
    @FindBy(id="login")
    private WebElement loginInput;
    @FindBy(id="nick")
    private WebElement nickInput;
    @FindBy(id="pass")
    private WebElement passwordInput;
    @FindBy(id="pass2")
    private WebElement confirmPasswordInput;
    @FindBy(id="email")
    private WebElement emailInput;
    @FindBy(id="birthday_day")
    private WebElement dayInput;
    @FindBy(id="birthday_month")
    private WebElement monthInput;
    @FindBy(id="birthday_year")
    private WebElement yearInput;
    @FindBy(id="rulez")
    private WebElement rulesConfirmationCheckbox;
    @FindBy(id="registration_submit")
    private WebElement submitButton;

    public CommonRegistrationPage(PageHelper pageHelper) {
        super(pageHelper);
    }

    public LoggedinPage register(RivUser user) {
        fillFieldsAndSubmit(
                user.getLogin(),
                user.getNickname(),
                user.getPassword(),
                user.getPassword(),
                user.getEmail(),
                user.getBirthDay(),
                user.getBirthMonth(),
                user.getBirthYear(),
                true);
        return getPageHelper().getPageAsLoggedinPage();
    }

    public RegistrationErrorPage incorrectRegistration(RivUser user, String passwordConfirmation, boolean confirmRules) {
        fillFieldsAndSubmit(
                user.getLogin(),
                user.getNickname(),
                user.getPassword(),
                passwordConfirmation,
                user.getEmail(),
                user.getBirthDay(),
                user.getBirthMonth(),
                user.getBirthYear(),
                confirmRules);
        return this;
    }

    private void fillFieldsAndSubmit(String login, String nickname, String password, String passwordConfirmation, String email, Integer birthDay, Integer birthMonth, Integer birthYear, boolean confirmRules) {
        loginInput.sendKeys(login);
        nickInput.sendKeys(nickname);
        passwordInput.sendKeys(password);
        confirmPasswordInput.sendKeys(passwordConfirmation);
        emailInput.sendKeys(email);

        Select dayDropdown = new Select(dayInput);
        dayDropdown.selectByIndex(birthDay == null ? 0 : birthDay);
        Select monthDropdown = new Select(monthInput);
        monthDropdown.selectByIndex(birthMonth == null ? 0 : birthMonth);
        Select yearDropdown = new Select(yearInput);
        yearDropdown.selectByValue(birthYear == null ? "" : birthYear.toString());
        // http://sqa.stackexchange.com/questions/12029/how-do-i-work-with-dropdowns-in-selenium-webdriver

        if (confirmRules) {
            rulesConfirmationCheckbox.click();
        }

        submitButton.click();
    }
}
