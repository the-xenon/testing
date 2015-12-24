package xenon.webdriver.proto.riv;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

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
