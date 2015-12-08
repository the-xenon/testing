package xenon.webdriver.proto.riv;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by xenon on 08.12.2015.
 */
public class RegistrationErrorPage extends BaseGuestRivPage {
    @FindBy(className="error")
    private WebElement errorField;

    public RegistrationErrorPage(PageHelper pageHelper) {
        super(pageHelper);
    }

    public boolean hasErrorFieldWithText(String error) {
        return errorField.getText().contains(error);
    }
}
