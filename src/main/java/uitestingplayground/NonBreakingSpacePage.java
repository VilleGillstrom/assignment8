package uitestingplayground;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class NonBreakingSpacePage extends BasePlaygroundPage {
    private final Locator withSpaceLocator;
    private final Locator withoutSpaceLocator;

    public NonBreakingSpacePage(Page page) {
        super(page, "http://uitestingplayground.com/nbsp");

        withSpaceLocator = page.getByRole(AriaRole.BUTTON).and(page.getByText("My Button"));
        withoutSpaceLocator = page.getByRole(AriaRole.BUTTON).and(page.getByText("MyButton"));
    }

    public void waitForWithSpaceLocator(double timeout) {
        withSpaceLocator.waitFor(new Locator.WaitForOptions().setTimeout(timeout));
    }

    public void waitForWithoutSpaceLocator(double timeout) {
        withoutSpaceLocator.waitFor(new Locator.WaitForOptions().setTimeout(timeout));
    }

}
