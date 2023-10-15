package uitestingplayground;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import common.BasePage;

import java.util.regex.Pattern;

public class VerifyTextPage extends BasePage {
    public VerifyTextPage(Page page) {
        super(page, "http://uitestingplayground.com/verifytext");
    }

    public Locator welcomeElement() {
        return page.getByText(Pattern.compile("^Welcome.*$"));
    }

}
