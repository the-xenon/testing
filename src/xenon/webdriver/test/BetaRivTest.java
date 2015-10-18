package xenon.webdriver.test;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.security.UserAndPassword;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import xenon.webdriver.test.ITestStarter;

/**
 * Created by xenon on 10.10.2015.
 */
public class BetaRivTest implements ITestStarter {
    private WebDriver driver;

    @Override
    public void start() {
        driver = new FirefoxDriver();
        //driver.get("http://beta.ragazzeinvendita.com");
        driver.get("http://beta:7sidQueplo@beta.ragazzeinvendita.com");

        checkAdultWarningDialogAndClose();

        /*WebDriverWait wait = new WebDriverWait(driver, 20);
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.authenticateUsing(new UserAndPassword("beta", "7sidQueplo"));*/
    }

    private void checkAdultWarningDialogAndClose() {
        WebElement enterButton = driver.findElement(By.className("agree-button"));
        enterButton.click();
    }
}
