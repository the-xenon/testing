package xenon.webdriver.test;

/**
 * Created by xenon on 17.10.2015.
 */
public class test {
    public static void main(String[] args) {
        //bookTest();
        rivTest();
    }

    private static void bookTest() {
        (new BookTest()).start();
    }

    private static void rivTest() {
        //ITestStarter starter = new RivTest();
        ITestStarter starter = new BetaRivTest();
        starter.start();
    }
}
