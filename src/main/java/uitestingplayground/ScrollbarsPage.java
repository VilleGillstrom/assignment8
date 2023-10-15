package uitestingplayground;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import common.BasePage;

public class ScrollbarsPage extends BasePage {
    public ScrollbarsPage(Page page) {
        super(page, "http://uitestingplayground.com/scrollbars");
    }


    public Locator hidingButton() {
        return page.locator("#hidingButton");
    }
}
