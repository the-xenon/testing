package xenon.webdriver.proto.riv;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by xenon on 29.11.2015.
 */
public class UserHelper {
    public RivUser getExistingCommon() {
        return new RivUser("xenon22", "xenon22", "password");
    }

    public RivUser getExistingModel() {
        return new RivUser("xenon111", "xenon1111", "password");
    }

    public RivUser generateValidCommon() {
        Calendar calendar = new GregorianCalendar(1980, 5, 22);
        return new RivUser("x_riv_reg", "x_riv_reg", "password", "test@test.1", calendar.getTime());
    }
}
