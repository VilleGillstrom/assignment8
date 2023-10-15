package uitestingplayground;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import common.BasePage;

public class HiddenLayersPage extends BasePage {

    public HiddenLayersPage(Page page) {
        super(page, "http://uitestingplayground.com/hiddenlayers");
    }

    public Locator greenButton() {
        return page.locator("#greenButton");
    }

    public Locator blueButton() {
        return page.locator("#blueButton");
    }

    public void clickGreenButton() {
        greenButton().click();
    }

    public void clickBlueButton() {
        blueButton().click();
    }

}
