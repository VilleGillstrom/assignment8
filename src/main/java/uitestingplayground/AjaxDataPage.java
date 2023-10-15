package uitestingplayground;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import common.BasePage;

public class AjaxDataPage extends BasePage {
    public AjaxDataPage(Page page) {
        super(page, "http://uitestingplayground.com/ajax");
    }


    public void clickAjaxRequestButton() {
        ajaxRequestButton().click();
    }

    public Locator ajaxDataContainer() {
        return page.locator("#content");
    }

    private Locator ajaxRequestButton() {
        return page.locator("#ajaxButton");
    }

    public Locator ajaxData() {
        return ajaxDataContainer().getByText("Data loaded with AJAX get request.");
    }
}
