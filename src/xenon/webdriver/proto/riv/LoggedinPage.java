package xenon.webdriver.proto.riv;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoggedinPage {
	@FindBy(className="login")
    private WebElement loginText;
    @FindBy(id="credits-info")
    private WebElement creditsText;
    @FindBy(xpath=".//*[@id='logoutLink']/a")
    private WebElement logoutLink;
    
    private PageFactory pageFactory;
     
	public LoggedinPage(PageFactory pageFactory) {
		this.pageFactory = pageFactory;
		pageFactory.initElements(this);
	}

	public boolean hasNicknameField(String nickname) {
		return loginText.getText().equals(nickname);
	}

	public boolean hasCreditsField() {
		return creditsText.isDisplayed();
	}

	public void logout() {
		logoutLink.click();
	}
	
}
