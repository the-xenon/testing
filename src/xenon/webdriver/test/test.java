package xenon.webdriver.test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

/**
 * Created by xenon on 17.10.2015.
 */
public class test {
    public static void main(String[] args) {
        //bookTest();
        rivTest();
    }

    private static void bookTest() {
        WebDriver driver = new FirefoxDriver();
        driver.get("http://www.google.com");

        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys(Keys.SHIFT, "s", "dfd");
        searchBox.submit();

        /*List<WebElement> inputs = driver.findElements(By.tagName("input"));
        for (WebElement input : inputs) {
            if (input.getAttribute("value").equals("ћне повезЄт!")) {
                input.sendKeys(Keys.SHIFT, "sdfd");
            }
        }*/
    }

    private static void rivTest() {
        //ITestStarter starter = new RivTest();
        ITestStarter starter = new BetaRivTest();
        starter.start();
    }
}
