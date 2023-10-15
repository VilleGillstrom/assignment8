package uitestingplayground;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class ClassAttrPage extends BasePlaygroundPage {

    private final Locator primaryButton;

    public ClassAttrPage(Page page) {
        super(page, "http://uitestingplayground.com/classattr");
        this.primaryButton = page.locator(".btn-primary");
    }

    public void clickPrimaryButton() {
        primaryButton.click();
    }

}
