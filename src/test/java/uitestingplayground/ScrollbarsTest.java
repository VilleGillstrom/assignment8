package uitestingplayground;

import com.microsoft.playwright.Locator;
import org.junit.jupiter.api.Test;
import common.TestBase;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

class ScrollbarsTest extends TestBase {


    @Test
    void HidingButtonShouldInitiallyNotBeInViewport() {
        ScrollbarsPage scrollbarsPage = new ScrollbarsPage(page);
        scrollbarsPage.openPage();

        Locator hidingButton = scrollbarsPage.hidingButton();
        assertThat(hidingButton).not().isInViewport();
    }


    @Test
    void HidingButtonShouldBeInViewportAfterScrolling() {
        ScrollbarsPage scrollbarsPage = new ScrollbarsPage(page);
        scrollbarsPage.openPage();

        Locator hidingButton = scrollbarsPage.hidingButton();
        hidingButton.scrollIntoViewIfNeeded();
        assertThat(hidingButton).isInViewport();
    }

}