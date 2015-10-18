package xenon.webdriver.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

/**
 * Created by xenon on 10.10.2015.
 */
public class RivTest implements ITestStarter {
    private WebDriver driver;
    private String login = "xenon22";
    private String password = "password";

    @Override
    public void start() {
        driver = new FirefoxDriver();
        driver.get("http://www.ragazzeinvendita.com");

        checkAdultWarningDialogAndClose();
        fillLoginFormAndSubmit();
        if (checkAutologinDialogAndClose()) {
            clearLoginForm();
            fillLoginFormAndSubmit();
        }
        testResult();
    }

    private void fillLoginFormAndSubmit() {
        driver.findElement(By.id("loginField")).sendKeys(login);
        driver.findElement(By.id("passwordField")).sendKeys(password);
        driver.findElement(By.id("loginButton")).click();
    }

    private void clearLoginForm() {
        driver.findElement(By.id("loginField")).clear();
        driver.findElement(By.id("passwordField")).clear();
    }

    private void checkAdultWarningDialogAndClose() {
        WebElement warningEnterButton = driver.findElement(
                By.className("enterButton"));
        warningEnterButton.click();
    }

    private boolean checkAutologinDialogAndClose() {
        List<WebElement> elements = driver.findElements(By.className("ui-icon-closethick"));
        if (elements.size() != 0) {
            elements.get(0).click();
            return true;
        }
        return false;
    }

    private void testResult() {
        WebElement loginField = driver.findElement(By.className("login"));
        if (!loginField.getText().equals(login)) {
            throw new RuntimeException("Login is not equal to entered");
        }
        driver.findElement(By.id("credits-info"));
        driver.findElement(By.id("logoutLink"));
    }
}
