package uitestingplayground;

import com.microsoft.playwright.*;
import com.microsoft.playwright.assertions.LocatorAssertions;
import com.microsoft.playwright.impl.LocatorUtils;
import com.microsoft.playwright.options.BoundingBox;
import org.junit.jupiter.api.Test;
import playwright.testbase.TestBase;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

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