package uitestingplayground;

import com.microsoft.playwright.Locator;
import org.junit.jupiter.api.Test;
import playwright.testbase.TestBase;

import java.util.Arrays;
import java.util.List;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DynamicTableTest extends TestBase {


    @Test
    void SomeTest() {
        DynamicTablePage dynamicTablePage = new DynamicTablePage(page);
        dynamicTablePage.openPage();

        String tableValue = dynamicTablePage.getTableValue("Chrome", "CPU");
        String paragraphText = dynamicTablePage.chromeCPUParagraph().textContent();
        assertTrue(paragraphText.contains(tableValue));
    }

}