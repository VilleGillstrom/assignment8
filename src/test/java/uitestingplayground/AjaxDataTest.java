package uitestingplayground;

import com.microsoft.playwright.Locator;
import org.junit.jupiter.api.Test;
import playwright.testbase.TestBase;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class AjaxDataTest extends TestBase {

    @Test
    void shouldWaitForSlowData() {
        AjaxDataPage ajaxDataPage = new AjaxDataPage(page);
        ajaxDataPage.openPage();

        // Eh, it's all handled by playwright
        ajaxDataPage.clickAjaxRequestButton();
        ajaxDataPage.ajaxData().first().waitFor();

        assertThat(ajaxDataPage.ajaxData().first()).isVisible();
    }

}