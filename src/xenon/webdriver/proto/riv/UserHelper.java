package xenon.webdriver.proto.riv;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;

public class UserHelper {
    public RivUser getExistingCommon() {
        return new RivUser("xenon22", "xenon22", "password");
    }

    public RivUser getExistingModel() {
        return new RivUser("xenon111", "xenon111", "password");
    }

    public RivUser generateValidCommon() {
        Random random = new Random();
        String login = "x_reg_" + random.nextInt(999);
        Calendar calendar = new GregorianCalendar(1980, 5, 22);
        return new RivUser(
                login,
                login,
                "password",
                "test@test.ntf",
                calendar.get(Calendar.DAY_OF_MONTH),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.YEAR));
    }
}
