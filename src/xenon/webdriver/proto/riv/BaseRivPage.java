package xenon.webdriver.proto.riv;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by xenon on 05.12.2015.
 */
public abstract class BaseRivPage {
    private PageHelper pageHelper;

    public BaseRivPage(PageHelper pageHelper) {
        this.pageHelper = pageHelper;
        pageHelper.initElements(this);
    }

    protected PageHelper getPageHelper() {
        return pageHelper;
    }
}
