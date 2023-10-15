package uitestingplayground;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import common.BasePage;

public class ClassAttrPage extends BasePage {

    private final Locator primaryButton;

    public ClassAttrPage(Page page) {
        super(page, "http://uitestingplayground.com/classattr");
        this.primaryButton = page.locator(".btn-primary");
    }

    public void clickPrimaryButton() {
        primaryButton.click();
    }

}
