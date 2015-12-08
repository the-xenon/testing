package xenon.webdriver.proto.riv;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by xenon on 05.12.2015.
 */
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

    /*public LoggedinPage register(String login, String nickname, String password, String email, Date birthday) {
        fillFieldsAndSubmit(login, nickname, password, email, birthday);
        return getPageHelper().getPageAsLoggedinPage();
    }

    public RegistrationErrorPage incorrectRegistration(
            String login, String nickname, String password, String email, Date birthday) {
        fillFieldsAndSubmit(login, nickname, password, email, birthday);
        return this;
    }*/

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

    private void fillFieldsAndSubmit(String login, String nickname, String password, String passwordConfirmation, String email, Integer birthDay, Integer birthMonth, Integer birthYear, boolean confirmRules) {
        loginInput.sendKeys(login);
        nickInput.sendKeys(nickname);
        passwordInput.sendKeys(password);
        confirmPasswordInput.sendKeys(passwordConfirmation);
        emailInput.sendKeys(email);

        /*Calendar calendar = Calendar.getInstance();
        calendar.setTime(birthday);

        Select dayDropdown = new Select(dayInput);
        dayDropdown.selectByIndex(calendar.get(Calendar.DAY_OF_MONTH));
        Select monthDropdown = new Select(monthInput);
        monthDropdown.selectByIndex(calendar.get(Calendar.MONTH));
        Select yearDropdown = new Select(yearInput);
        yearDropdown.selectByValue(String.valueOf(calendar.get(Calendar.YEAR)));*/
        Select dayDropdown = new Select(dayInput);
        dayDropdown.selectByIndex(birthDay);
        Select monthDropdown = new Select(monthInput);
        monthDropdown.selectByIndex(birthMonth);
        Select yearDropdown = new Select(yearInput);
        yearDropdown.selectByValue(birthYear.toString());
        // http://sqa.stackexchange.com/questions/12029/how-do-i-work-with-dropdowns-in-selenium-webdriver

        if (confirmRules) {
            rulesConfirmationCheckbox.click();
        }

        submitButton.click();
    }
}
