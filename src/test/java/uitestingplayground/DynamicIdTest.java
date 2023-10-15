package uitestingplayground;

import org.junit.jupiter.api.Test;
import playwright.testbase.TestBase;
import somewebsite.pages.SignInOrSignUpPage;
import somewebsite.pages.SignInPage;

import java.util.regex.Pattern;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class DynamicIdTest extends TestBase {

    @Test
    void clickDynamicIdButton() {
        DynamicIdPage dynamicIdPage = new DynamicIdPage(page);
        dynamicIdPage.openPage();
        dynamicIdPage.clickDynamicIdButton();

        // Button is focused on successful click
        assertThat(dynamicIdPage.getDynamicIdButton()).isFocused();
    }
}