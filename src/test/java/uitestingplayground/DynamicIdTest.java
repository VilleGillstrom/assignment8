package uitestingplayground;

import common.TestBase;
import org.junit.jupiter.api.Test;

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