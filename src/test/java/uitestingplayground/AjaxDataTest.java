package uitestingplayground;

import org.junit.jupiter.api.Test;
import common.TestBase;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

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