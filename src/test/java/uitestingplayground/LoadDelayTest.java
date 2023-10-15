package uitestingplayground;

import common.TestBase;
import org.junit.jupiter.api.Test;

class LoadDelayTest extends TestBase {


    @Test
    void shouldWaitForPageToLoadBeforeClickingButton() {
        LoadDelayPage loadDelayPage = new LoadDelayPage(page);
        loadDelayPage.openPage();

        // Eh, it's all handled by playwright
        loadDelayPage.clickPostDelayButton();
    }

}