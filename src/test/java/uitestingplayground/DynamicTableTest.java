package uitestingplayground;

import common.TestBase;
import org.junit.jupiter.api.Test;

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