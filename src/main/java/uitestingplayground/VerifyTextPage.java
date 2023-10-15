package uitestingplayground;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import java.util.regex.Pattern;

public class VerifyTextPage extends BasePlaygroundPage {
    public VerifyTextPage(Page page) {
        super(page, "http://uitestingplayground.com/verifytext");
    }

    public Locator welcomeElement() {
        return page.getByText(Pattern.compile("^Welcome.*$"));
    }

}
