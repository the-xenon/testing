package xenon.webdriver.proto.riv;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by xenon on 29.11.2015.
 */
public class LoginErrorPage {
    @FindBy(className="error")
    private WebElement errorField;

    public LoginErrorPage(PageHelper pageHelper) {
        pageHelper.initElements(this);
    }

    public boolean hasErrorFieldWithText(String error) {
        if (errorField.isDisplayed()) {
            return errorField.getText().contains(error);
        }
        return false;
    }

    public boolean hasErrorField() {
        return errorField.isDisplayed();
    }

    public String getErrorFieldText() {
        return errorField.getText();
    }
}
