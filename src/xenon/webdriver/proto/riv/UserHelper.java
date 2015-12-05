package xenon.webdriver.proto.riv;

/**
 * Created by xenon on 29.11.2015.
 */
public class UserHelper {
    public RivUser getValidCommon() {
        return new RivUser("xenon22", "xenon22", "password");
    }

    public RivUser getValidModel() {
        return new RivUser("xenon111", "xenon1111", "password");
    }
}
