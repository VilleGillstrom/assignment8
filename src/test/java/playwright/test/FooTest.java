package playwright.test;


import org.junit.jupiter.api.Test;
import pages.LoginPage;
import playwright.testbase.TestBase;

import java.util.regex.Pattern;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;


public class FooTest extends TestBase {

    @Test
    void loginAsUser() {
        LoginPage loginPage = new LoginPage(page);
        loginPage.openLoginPage();
        String userName = "kvalitautomatic@gmail.com";
        //String password = "kvalitgmail";
        String password = "kvalit22epic";

        loginPage.submitEmail(userName);
        assertThat(page).hasTitle(Pattern.compile("^.*Sign in.*$"));

        loginPage.submitPassword(password);
        assertThat(page).hasTitle(Pattern.compile("^.*Account Settings.*$"));

    }

    @Test
    void failedLogin() {
        LoginPage loginPage = new LoginPage(page);
        loginPage.openLoginPage();
        loginPage.login("abc", "abc");

    }
}