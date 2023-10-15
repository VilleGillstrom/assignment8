package uitestingplayground;

import com.microsoft.playwright.Locator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import playwright.testbase.TestBase;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SampleAppTest extends TestBase {

    @Test
    void CorrectPasswordShouldLogIn() {
        SampleAppPage sampleAppPage = new SampleAppPage(page);
        sampleAppPage.openPage();

        sampleAppPage.setUserName("Kvalit");
        sampleAppPage.setPassword("pwd");
        sampleAppPage.clickLogInButton();

        assertTrue(sampleAppPage.isLoggedIn());
    }

}