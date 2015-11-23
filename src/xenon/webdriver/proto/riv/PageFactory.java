package xenon.webdriver.proto.riv;

import org.openqa.selenium.WebDriver;

public class PageFactory {
	private WebDriver driver;

	public PageFactory(WebDriver driver) {
		this.driver = driver;
	}

	public IndexPage navigateToIndexPage() {
		navigateTo(Pages.LOGOUT);
		navigateTo(Pages.INDEX);
		return new IndexPage(this);
	}

	private void navigateTo(String path) {
		driver.get("http://www.ragazzeinvendita.com" + path);
	}

	public void initElements(Object page) {
		org.openqa.selenium.support.PageFactory.initElements(driver, page);
		
	}

	public LoggedinPage getPageAsLoggedinPage() {
		return new LoggedinPage(this);
	}
	
}
