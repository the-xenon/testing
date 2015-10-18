package xenon.webdriver.test;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by xenon on 18.10.2015.
 */
public class BookTest implements ITestStarter {
    @Override
    public void start() {
        WebDriver driver = new FirefoxDriver();
        driver.get("http://www.google.com");

        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys(Keys.SHIFT, "s", "dfd");
        searchBox.submit();

        /*List<WebElement> inputs = driver.findElements(By.tagName("input"));
        for (WebElement input : inputs) {
            if (input.getAttribute("value").equals("��� ������!")) {
                input.sendKeys(Keys.SHIFT, "sdfd");
            }
        }*/
    }

    private static void navigateTest() {
        WebDriver driver = new FirefoxDriver();
        driver.get("http://www.ragazzeinvendita.com/");
        driver.get("http://google.com");

        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("this is test");
        searchBox.submit();

        driver.navigate().back();
        driver.navigate().back();
    }

    private static void windosYandlingTest() {
        WebDriver driver = new FirefoxDriver();
        driver.get("http://www.ragazzeinvendita.com/");

        String window1 = driver.getWindowHandle();
        System.out.println("First window handle: " + window1);

        WebElement startChatButton = driver.findElement(By.className("startTheChatButton"));
        startChatButton.click();

        String window2 = driver.getWindowHandle();
        System.out.println("Second window handle: " + window2);

        driver.switchTo().window(window1);
    }

    private static void screenshotTest() {
        WebDriver driver = new FirefoxDriver();
        driver.get("http://google.com");
        File screenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        System.out.println(screenShot.getAbsolutePath());
    }

    private static void capabilitiesTest() {
        Map<String, Boolean> capabilities = new HashMap<String, Boolean>();
        capabilities.put("javascriptEnabled", false);
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities(capabilities);
        WebDriver driver = new FirefoxDriver(desiredCapabilities);
        driver.get("http://google.com");
    }

    private static void elementTests() {
        WebDriver driver = new FirefoxDriver();
        //driver.get("http://www.ragazzeinvendita.com/");
        //driver.get("http://www.google.com/");
        driver.get("http://www.yandex.ru/");

        WebElement searchString = driver.findElement(By.id("text"));
        searchString.sendKeys("this is test, oh yes - this is test");

        Actions builder = new Actions(driver);
        builder.moveToElement(searchString).contextClick().moveByOffset(70, 0);
        //builder.moveToElement(searchString, 40, 15).clickAndHold().sendKeys("[additional]");
        //builder.moveToElement(searchString, 40, 15).clickAndHold().moveByOffset(30, 0);
        //builder.clickAndHold(searchString).moveByOffset(30, 0);
        //WebElement e = driver.findElement(By.className("input__clear"));
        //builder.moveByOffset(e.getLocation().getX() + 10, e.getLocation().getY() + 10).click();
        builder.perform();

        //builder.click();
        //builder.perform();

		/*Action compositeAction = builder.build();
		compositeAction.perform();*/
    }
}
