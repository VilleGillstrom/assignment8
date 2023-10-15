package uitestingplayground;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class SampleAppPage extends BasePlaygroundPage {
    private final Locator userNameLocator;
    private final Locator passwordLocator;
    private final Locator loginStatusLocator;
    private final Locator loginButtonLocator;

    public SampleAppPage(Page page) {
        super(page, "http://uitestingplayground.com/sampleapp");

        userNameLocator = page.locator("[name=UserName]");
        passwordLocator = page.locator("[name=Password]");
        loginButtonLocator = page.locator("#login");
        loginStatusLocator = page.locator("#loginstatus");
    }


    public void setUserName(String userName) {
        userNameLocator.fill(userName);
    }

    public String getUserName() {
        return userNameLocator.textContent();
    }

    public void setPassword(String password) {
        passwordLocator.fill(password);
    }

    public String getPassword() {
        return passwordLocator.textContent();
    }

    public boolean isLoggedIn() {
        return getLoginStatusText().startsWith("Welcome");
    }

    public String getLoginStatusText() {
        return loginStatusLocator.textContent();
    }

    public void clickLogInButton() {
        loginButtonLocator.click();
    }
}
