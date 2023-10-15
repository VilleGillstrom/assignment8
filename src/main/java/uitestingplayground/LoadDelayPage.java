package uitestingplayground;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class LoadDelayPage extends BasePlaygroundPage {
    public LoadDelayPage(Page page) {
        super(page, "http://uitestingplayground.com/loaddelay");
    }

    public Locator postDelayButton() {
        return page.getByRole(AriaRole.BUTTON).and(page.getByText("Button Appearing After Delay"));
    }


    public void clickPostDelayButton() {
        postDelayButton().click();
    }
}
