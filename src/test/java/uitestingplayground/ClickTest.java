package uitestingplayground;

import com.microsoft.playwright.Locator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import common.TestBase;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class ClickTest extends TestBase {


    @Test
    void shouldEmulateHumanClickWithClick() {
        ClickPage clickPage = new ClickPage(page);
        clickPage.openPage();

        clickPage.clickBadButton();

        Executable waitForButtonBgColorChange = () -> page.waitForCondition(() ->
            {
                String green = "rgb(33, 136, 56)";
                Locator badBtn = clickPage.badButton();
                Object bgColor = badBtn.evaluate("element => getComputedStyle(element)['background-color']");
                return bgColor.equals(green);
            }
        );

        assertDoesNotThrow(waitForButtonBgColorChange);
    }

}