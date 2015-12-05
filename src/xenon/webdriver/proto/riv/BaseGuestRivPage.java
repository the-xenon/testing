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
    @FindBy(className="ui-icon-closethick")
    private List<WebElement> autologinCloseButtons;

    public BaseGuestRivPage(PageHelper pageHelper) {
        super(pageHelper);

        checkAdultWarningDialogAndClose();
//        checkAutologinDialogAndClose();
    }

    private boolean checkAdultWarningDialogAndClose() {
        if (warningEnterButton.isDisplayed()) {
            warningEnterButton.click();
            return true;
        }
        return false;
    }

    private boolean checkAutologinDialogAndClose() {
        if (autologinCloseButtons.size() != 0) {
            autologinCloseButtons.get(0).click();
            return true;
        }
        return false;
    }
}
