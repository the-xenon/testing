package xenon.webdriver.proto.riv;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoggedinPage {
	@FindBy(className="login")
    private WebElement loginText;
    @FindBy(id="credits-info")
    private WebElement creditsText;
	@FindBy(id="revenue-info")
	private WebElement revenueText;
    @FindBy(xpath=".//*[@id='logoutLink']/a")
    private WebElement logoutLink;
	@FindBy(className="userNotification1")
	private WebElement notificationField;
    
	public LoggedinPage(PageHelper pageHelper) {
		pageHelper.initElements(this);
	}

	public boolean hasNicknameFieldWithNick(String nickname) {
		return loginText.getText().equals(nickname);
	}

	public boolean hasCreditsField() {
		return creditsText.isDisplayed();
	}

	public boolean hasRevenueField() {
		return revenueText.isDisplayed();
	}

	public boolean hasNotificationFieldWithText(String notification) {
		return notificationField.getText().contains(notification);
	}

	public void logout() {
		logoutLink.click();
	}
	
}
