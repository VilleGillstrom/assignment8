package uitestingplayground;

import org.junit.jupiter.api.Test;
import playwright.testbase.TestBase;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

class LoadDelayTest extends TestBase {


    @Test
    void shouldWaitForPageToLoadBeforeClickingButton() {
        LoadDelayPage loadDelayPage = new LoadDelayPage(page);
        loadDelayPage.openPage();

        // Eh, it's all handled by playwright
        loadDelayPage.clickPostDelayButton();
    }

}