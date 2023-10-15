package uitestingplayground;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import java.util.regex.Pattern;

public class MouseOverPage extends BasePlaygroundPage {
    private final Locator clickMeLocator;
    private final Locator clickCountLocator;

    public MouseOverPage(Page page) {
        super(page, "http://uitestingplayground.com/mouseover");

        clickMeLocator = page.getByText("Click me");
        clickCountLocator = page.locator("#clickCount");
    }


    public void clickClickMe() {
        clickMeLocator.click();
    }

    public int getClickCount() {
        return Integer.parseInt(clickCountLocator.textContent());
    }
}
