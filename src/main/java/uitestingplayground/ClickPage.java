package uitestingplayground;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import common.BasePage;

public class ClickPage extends BasePage {
    public ClickPage(Page page) {
        super(page, "http://uitestingplayground.com/click");
    }


    public Locator badButton() {
        return page.locator("#badButton");
    }
    public void clickBadButton() {
        badButton().click();
    }

}
