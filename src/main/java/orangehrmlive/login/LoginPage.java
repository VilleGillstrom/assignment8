package orangehrmlive.login;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import common.BasePage;

public class LoginPage extends BasePage {
    private final Locator usernameFieldLocator;
    private final Locator passwordFieldLocator;
    private final Locator loginButtonLocator;
    private final Locator wrongCredentialAlertLocator;


    public LoginPage(Page page)
    {
        super(page, "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        this.usernameFieldLocator = page.locator("[name='username']");
        this.passwordFieldLocator = page.locator("[name='password']");
        this.loginButtonLocator = page.getByRole(AriaRole.BUTTON).and(page.locator(".orangehrm-login-button"));
        this.wrongCredentialAlertLocator = page.getByRole(AriaRole.ALERT);
    }

    public void openLoginPage() {
        page.navigate(url);
    }

    public Locator getWrongCredentialAlertLocator() {
        return wrongCredentialAlertLocator;
    }

    public void setUsername(String userName) {
        usernameFieldLocator.fill(userName);
    }

    public void submitUsernameAndPassword(String userName, String password) {
        setUsername(userName);
        setPassword(password);
        clickLoginButton();
    }

    private void clickLoginButton() {
        loginButtonLocator.click();
    }

    private void setPassword(String password) {
        passwordFieldLocator.fill(password);
    }


    public void submitValidUsernameAndPassword() {
        submitUsernameAndPassword("Admin", "admin123");
    }


}
