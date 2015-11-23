package xenon.webdriver.proto.riv;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IndexPage {
	@FindBy(id="loginField")
    private WebElement loginInput;
    @FindBy(id="passwordField")
    private WebElement passwordInput;
    @FindBy(id="loginButton")
    private WebElement loginButton;
    
    @FindBy(className="enterButton")
    private WebElement warningEnterButton;
    @FindBy(className="ui-icon-closethick")
    private List<WebElement> autologinCloseButtons;
    
    private PageFactory pageFactory;
     
	public IndexPage(PageFactory pageFactory) {
		this.pageFactory = pageFactory;
		pageFactory.initElements(this);
		
		checkAdultWarningDialogAndClose();
		checkAutologinDialogAndClose();
	}

	public LoggedinPage login(String login, String password) {
		loginInput.sendKeys(login);
		passwordInput.sendKeys(password);
		loginButton.click();
		
		return pageFactory.getPageAsLoggedinPage();
	}
	
	private void checkAdultWarningDialogAndClose() {
        warningEnterButton.click();
    }
	
	private boolean checkAutologinDialogAndClose() {
        if (autologinCloseButtons.size() != 0) {
        	autologinCloseButtons.get(0).click();
            return true;
        }
        return false;
    }
}
