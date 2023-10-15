package uitestingplayground;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class ProgressBarPage extends BasePlaygroundPage {
    public ProgressBarPage(Page page) {
        super(page, "http://uitestingplayground.com/progressbar");
    }

    public Locator progressBar() {
        return page.locator("#progressBar");
    }

    public Locator startButton() {
        return page.locator("#startButton");
    }


    public Locator stopButton() {
        return page.locator("#stopButton");
    }


    public int getProgressBarProgressValue() {
        String attrValue = progressBar().getAttribute("aria-valuenow");
        return Integer.parseInt(attrValue);
    }

    public void waitForProgressBarValue(int value) {
        page.waitForCondition(() -> getProgressBarProgressValue() == value);
    }

    // This function will start the progressbar and run till value is reached
    public void runProgressBarToValue(int value) {
        clickStartButton();
        waitForProgressBarValue(value);
        clickStopButton();
    }

    public void clickStartButton() {
        startButton().click();
    }
    public void clickStopButton() {
        stopButton().click();
    }
}
