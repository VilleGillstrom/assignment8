package uitestingplayground;

import com.microsoft.playwright.Locator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import common.TestBase;

import static org.junit.jupiter.api.Assertions.*;

class VerifyTextTest extends TestBase {

    @Test
    void ShouldFindWelcomeText() {
        VerifyTextPage verifyTextPage = new VerifyTextPage(page);
        verifyTextPage.openPage();

        Executable getWelcomeElement = () -> verifyTextPage.welcomeElement().waitFor(new Locator.WaitForOptions().setTimeout(1000));

        assertDoesNotThrow(getWelcomeElement, "Unable to find welcome element");

    }

}