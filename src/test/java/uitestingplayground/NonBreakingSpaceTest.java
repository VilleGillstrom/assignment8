package uitestingplayground;

import com.microsoft.playwright.TimeoutError;
import org.junit.jupiter.api.Test;
import common.TestBase;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class NonBreakingSpaceTest extends TestBase {


    /**
     * Playwright's .getByText() seems to handle non-breaking spaces nicely, so I test opposite of the described
     * scenario. &nbsp; is handled.
     */
    @Test
    void LocatorWithSpaceIsFound() {
        NonBreakingSpacePage nonBreakingSpacePage = new NonBreakingSpacePage(page);
        nonBreakingSpacePage.openPage();

        assertDoesNotThrow(() -> nonBreakingSpacePage.waitForWithSpaceLocator(1000));
    }

    @Test
    void LocatorWithoutSpaceIsNotFound() {
        NonBreakingSpacePage nonBreakingSpacePage = new NonBreakingSpacePage(page);
        nonBreakingSpacePage.openPage();

        assertThrows(TimeoutError.class,() -> nonBreakingSpacePage.waitForWithoutSpaceLocator(1000));
    }
}