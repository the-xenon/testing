package xenon.webdriver.proto;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by xenon on 31.10.2015.
 */
public class IndexPageObject extends RivPageObject {
    @FindBy(id="loginLink")
    WebElement loginButton;
    @FindBy(className="agree-button")
    WebElement warningEnterButton;

    public IndexPageObject(TestBrowser testBrowser) {
        super(testBrowser);
    }

    public void navigate() {
        driver.get("http://beta:7sidQueplo@beta.ragazzeinvendita.com");
        PageFactory.initElements(driver, this);

        checkAdultWarningDialogAndClose();
    }

    private void checkAdultWarningDialogAndClose() {
        if (warningEnterButton.isDisplayed()) {
            warningEnterButton.click();
        }
    }

    public LoginFormObject openLoginForm() {
        loginButton.click();
        return new LoginFormObject(driver);
    }
}
