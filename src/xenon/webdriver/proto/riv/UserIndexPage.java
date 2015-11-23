package xenon.webdriver.proto.riv;

import org.openqa.selenium.WebDriver;

/**
 * Created by xenon on 31.10.2015.
 */
public class UserIndexPage {
    WebDriver driver;

    public UserIndexPage(WebDriver driver) {
        this.driver = driver;
    }

    public void logout() {
        //TODO Logout using menu link
        driver.get("http://beta.ragazzeinvendita.com/action.php?do=logout");
    }
}
