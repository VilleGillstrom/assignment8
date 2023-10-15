package uitestingplayground;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class TextInputPage extends BasePlaygroundPage {
    public TextInputPage(Page page) {
        super(page, "http://uitestingplayground.com/textinput");
    }

    public Locator updatingButton() {
        return page.locator("#updatingButton");
    }

    public Locator newButtonNameTextField() {
        return page.locator("#newButtonName");
    }


    public void clickUpdatingButton() {
        updatingButton().click();
    }
}
