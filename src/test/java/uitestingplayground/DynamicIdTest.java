package uitestingplayground;

import org.junit.jupiter.api.Test;
import common.TestBase;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

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