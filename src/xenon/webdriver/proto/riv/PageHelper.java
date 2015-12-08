package xenon.webdriver.proto.riv;

import org.openqa.selenium.WebDriver;

public class PageHelper {
	private WebDriver driver;

	public PageHelper(WebDriver driver) {
		this.driver = driver;
	}

	private void navigateTo(String path) {
		// driver.get("http://beta:7sidQueplo@beta.ragazzeinvendita.com");
		driver.get("http://riv3.xenon.nginx-test.vda-team.com/it" + path);
	}

	public void initElements(Object page) {
		org.openqa.selenium.support.PageFactory.initElements(driver, page);
		
	}

	public LoggedinPage getPageAsLoggedinPage() {
		return new LoggedinPage(this);
	}

	public LoginErrorPage getPageAsErrorPage() {
		return new LoginErrorPage(this);
	}

	public IndexPage navigateToIndexPage() {
		navigateTo(Pages.LOGOUT);
		navigateTo(Pages.INDEX);
		return new IndexPage(this);
	}

	public CommonRegistrationPage navigateToCommonRegistrationPage() {
		navigateTo(Pages.LOGOUT);
		navigateTo(Pages.COMMON_REGISTRATION);
		return new CommonRegistrationPage(this);
	}
}
