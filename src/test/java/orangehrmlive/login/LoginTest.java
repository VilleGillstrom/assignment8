package orangehrmlive.login;


import com.microsoft.playwright.Locator;
import common.TestBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;


public class LoginTest extends TestBase {

    LoginPage loginPage;

    @BeforeEach
    void createAndOpenLoginPage() {
        loginPage = new LoginPage(page);
        loginPage.openPage();
    }

    @Test
    void loginWithCorrectCredentialsNavigatesToDashboard() {
        submitValidCredentials();
        assertThat(page).hasURL("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
    }

    @Test
    void invalidCredentialAlertIsInitiallyNotVisible() {
        Locator alertLocator = loginPage.getWrongCredentialAlertLocator();
        assertThat(alertLocator).not().isVisible();
    }
    @Test
    void loginWithInvalidCredentialsShowsAlert() {
        submitInvalidCredentials();

        Locator alertLocator = loginPage.getWrongCredentialAlertLocator();
        alertLocator.waitFor();
        assertThat(alertLocator).isVisible();
    }

    private void submitValidCredentials() {
        loginPage.submitUsernameAndPassword("Admin", "admin123");
    }
    private void submitInvalidCredentials() {
        loginPage.submitUsernameAndPassword("Invalid", "Credentials");
    }
}