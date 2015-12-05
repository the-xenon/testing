package xenon.webdriver.proto.riv;

import org.testng.annotations.Test;

/**
 * Created by xenon on 05.12.2015.
 */
public class CommonRegistrationTest {
    PageHelper pageHelper = new PageHelper(DriverFactory.createDriver());
    UserHelper userHelper = new UserHelper();

    @Test
    public void correctRegistrationTest() {
        CommonRegistrationPage regPage = pageHelper.navigateToCommonRegistrationPage();

        RivUser user = userHelper.generateValidCommon();
        regPage.register(user.getLogin(), user.getNickname(), user.getPassword(), user.getEmail(), user.getBirthday());

    }
}
