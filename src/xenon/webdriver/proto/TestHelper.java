package xenon.webdriver.proto;

/**
 * Created by xenon on 02.11.2015.
 */
public class TestHelper {
    public static TestBrowser testBrowser;

    public static TestBrowser getTestBrowser() {
        if (testBrowser == null) {
            testBrowser = new TestBrowser();
        }
        return testBrowser;
    }
}
