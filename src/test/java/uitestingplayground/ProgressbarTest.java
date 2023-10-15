package uitestingplayground;

import common.TestBase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProgressbarTest extends TestBase {

    @Test
    void ShouldStopProgressAtRequestedValue() {
        ProgressBarPage progressBarPage = new ProgressBarPage(page);
        progressBarPage.openPage();

        progressBarPage.runProgressBarToValue(75);

        int progressValue = progressBarPage.getProgressBarProgressValue();
        assertEquals(75, progressValue);

    }

}