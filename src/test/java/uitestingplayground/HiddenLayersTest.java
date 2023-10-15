package uitestingplayground;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.TimeoutError;
import common.TestBase;
import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class HiddenLayersTest extends TestBase {
    @Test
    void shouldShowBlueButtonAfterClickingGreenButton() {
        HiddenLayersPage hiddenLayersPage = new HiddenLayersPage(page);
        hiddenLayersPage.openPage();

        hiddenLayersPage.clickGreenButton();

        assertThat(hiddenLayersPage.blueButton()).isVisible();
    }

    @Test
    void shouldMakeGreenButtonUnclickableAfterClickingGreenButton() {
        HiddenLayersPage hiddenLayersPage = new HiddenLayersPage(page);
        hiddenLayersPage.openPage();

        hiddenLayersPage.clickGreenButton();

        // Wish I found a better way than checking for timeout,
        // but didn't find a reasonable way to test for click intercepts.
        Locator.ClickOptions clickOptions = new Locator.ClickOptions().setTrial(true).setTimeout(500);
        assertThrows(TimeoutError.class, () -> hiddenLayersPage.greenButton().click(clickOptions));
    }
}