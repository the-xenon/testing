package xenon.webdriver.test;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.security.UserAndPassword;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
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

        driver.findElement(By.id("loginLink")).click();
        driver.findElement(By.name("login")).sendKeys("xenon22");
        driver.findElement(By.name("pass")).sendKeys("password");
        driver.findElement(By.id("lastField"));

        WebDriverWait wait = new WebDriverWait(driver, 200);
        //Wait<WebDriver> wait = new WebDriverWait(driver, 250);

        /*WebDriverWait wait = new WebDriverWait(driver, 20);
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.authenticateUsing(new UserAndPassword("beta", "7sidQueplo"));*/
    }

    private void checkAdultWarningDialogAndClose() {
        WebElement enterButton = driver.findElement(By.className("agree-button"));
        enterButton.click();
    }
}
