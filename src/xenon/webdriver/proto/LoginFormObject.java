package xenon.webdriver.proto;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by xenon on 31.10.2015.
 */
public class LoginFormObject {
    WebDriver driver;

    @FindBy(name="login")
    private WebElement loginInput;
    @FindBy(name="pass")
    private WebElement passwordInput;
    @FindBy(id="lastField")
    private WebElement submitButton;

    public LoginFormObject(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public UserIndexPage successfulLoginAs(String login, String password) {
        loginInput.sendKeys(login);
        passwordInput.sendKeys(password);
        submitButton.click();
        return new UserIndexPage(this.driver);
    }
}
