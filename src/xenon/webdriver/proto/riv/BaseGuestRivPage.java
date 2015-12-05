package xenon.webdriver.proto.riv;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by xenon on 05.12.2015.
 */
public abstract class BaseGuestRivPage extends BaseRivPage {
    @FindBy(className="enterButton")
    private WebElement warningEnterButton;

    public BaseGuestRivPage(PageHelper pageHelper) {
        super(pageHelper);

        checkAdultWarningDialogAndClose();
    }

    private boolean checkAdultWarningDialogAndClose() {
        if (warningEnterButton.isDisplayed()) {
            warningEnterButton.click();
            return true;
        }
        return false;
    }
}
