package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class LoginPage {
    private final Page page;
    private final Locator usernameInput;
    private final Locator passwordInput;
    private final Locator continueButton;
    private final Locator signInButton;

    public LoginPage(Page page)
    {
        this.page = page;
        this.usernameInput = page.locator("#email");
        this.passwordInput = page.locator("#password");
        this.continueButton = page.locator("#send");
        this.signInButton = page.locator("#sign-in").wa;
    }

    public void openLoginPage() {
        String loginUrl = "https://www.epicgames.com/id/login";
        page.navigate(loginUrl);
    }

    public void login(String userName, String password) {
        usernameInput.fill(userName);
        passwordInput.fill(password);
        continueButton.click();
    }

    public void submitEmail(String userName) {
        usernameInput.fill(userName);
        continueButton.click();
    }

    public void submitPassword(String password) {
        usernameInput.fill(password);
        signInButton.click();
    }
}
