package uitestingplayground;

import com.microsoft.playwright.Locator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import playwright.testbase.TestBase;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MouseOverTest extends TestBase {

    @Test
    void ClickingClickMeIncreasesCount() {
        MouseOverPage mouseOverPage = new MouseOverPage(page);
        mouseOverPage.openPage();

        assertEquals(0, mouseOverPage.getClickCount());
        mouseOverPage.clickClickMe();
        assertEquals(1, mouseOverPage.getClickCount());
        mouseOverPage.clickClickMe();
        assertEquals(2, mouseOverPage.getClickCount());
    }

}