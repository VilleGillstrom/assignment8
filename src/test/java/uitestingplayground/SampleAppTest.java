package uitestingplayground;

import common.TestBase;
import org.junit.jupiter.api.Test;

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