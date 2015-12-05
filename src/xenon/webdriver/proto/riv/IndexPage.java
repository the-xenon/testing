package xenon.webdriver.proto.riv;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IndexPage extends BaseGuestRivPage {
	@FindBy(id="loginField")
    private WebElement loginInput;
    @FindBy(id="passwordField")
    private WebElement passwordInput;
    @FindBy(id="loginButton")
    private WebElement loginButton;

    @FindBy(className="ui-icon-closethick")
    private List<WebElement> autologinCloseButtons;
    
	public IndexPage(PageHelper pageHelper) {
        super(pageHelper);

        checkAutologinDialogAndClose();
	}

	public LoggedinPage login(String login, String password) {
		loginInput.sendKeys(login);
		passwordInput.sendKeys(password);
		loginButton.click();
		
		return getPageHelper().getPageAsLoggedinPage();
	}

    public LoginErrorPage incorrectLogin(String login, String password) {
        loginInput.sendKeys(login);
        passwordInput.sendKeys(password);
        loginButton.click();

        return getPageHelper().getPageAsErrorPage();
    }

    private boolean checkAutologinDialogAndClose() {
        if (autologinCloseButtons.size() != 0) {
            autologinCloseButtons.get(0).click();
            return true;
        }
        return false;
    }
}
