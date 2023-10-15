package uitestingplayground;

import com.microsoft.playwright.Locator;
import org.junit.jupiter.api.Test;
import common.TestBase;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

class ClientSideDelayTest extends TestBase {


    @Test
    void shouldWaitForSlowData() {
        ClientSideDelayPage clientSideDelayPage = new ClientSideDelayPage(page);
        clientSideDelayPage.openPage();

        clientSideDelayPage.clickClientLogicButton();

        Locator calculatedData1 = clientSideDelayPage.calculatedData(1);
        assertThat(calculatedData1).isVisible();
    }

}