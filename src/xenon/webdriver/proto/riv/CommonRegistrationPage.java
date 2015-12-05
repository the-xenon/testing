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
public class CommonRegistrationPage extends BaseGuestRivPage {
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

    public void register(String login, String nickname, String password, String email, Date birthday) {
        loginInput.sendKeys(login);
        nickInput.sendKeys(nickname);
        passwordInput.sendKeys(password);
        confirmPasswordInput.sendKeys(password);
        emailInput.sendKeys(email);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(birthday);

        Select dayDropdown = new Select(dayInput);
        dayDropdown.selectByIndex(calendar.get(Calendar.DAY_OF_MONTH));
        Select monthDropdown = new Select(monthInput);
        monthDropdown.selectByIndex(calendar.get(Calendar.MONTH));
        Select yearDropdown = new Select(yearInput);
        yearDropdown.selectByValue(String.valueOf(calendar.get(Calendar.YEAR)));

        rulesConfirmationCheckbox.click();
    }
}
