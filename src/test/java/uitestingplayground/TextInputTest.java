package uitestingplayground;

import common.TestBase;
import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

class TextInputTest extends TestBase {


    @Test
    void shouldUpdateButtonTextWithTextFieldValue() {
        TextInputPage textInputPage = new TextInputPage(page);
        textInputPage.openPage();

        String buttonTextToSet = "A New String";
        textInputPage.newButtonNameTextField().fill(buttonTextToSet);
        textInputPage.clickUpdatingButton();

        assertThat(textInputPage.updatingButton()).hasText(buttonTextToSet);
    }

}