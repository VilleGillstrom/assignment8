package uitestingplayground;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class ScrollbarsPage extends BasePlaygroundPage {
    public ScrollbarsPage(Page page) {
        super(page, "http://uitestingplayground.com/scrollbars");
    }


    public Locator hidingButton() {
        return page.locator("#hidingButton");
    }
}
