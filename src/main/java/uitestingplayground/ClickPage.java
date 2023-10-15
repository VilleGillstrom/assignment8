package uitestingplayground;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class ClickPage extends BasePlaygroundPage {
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
