package xenon.test.cft;

public class LoginTest {
	private TestDriver driver;
	
	public LoginTest(TestDriver driver) {
		this.driver = driver;
	}
	
	public void correctLoginTest() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login("2860054438772", "123456");
	}

}
