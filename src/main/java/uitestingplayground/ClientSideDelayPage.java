package uitestingplayground;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import common.BasePage;

public class ClientSideDelayPage extends BasePage {
    public ClientSideDelayPage(Page page) {
        super(page, "http://uitestingplayground.com/clientdelay");
    }

    public Locator clientLogicButton() {
        return page.locator("#ajaxButton");
    }

    public void clickClientLogicButton() {
        clientLogicButton().click();
    }

    // child starts at 1
    public Locator calculatedData(int childIndex) {
        Locator calculatedData = page.locator(String.format("#content > p:nth-child(%s)", childIndex));
        calculatedData.waitFor(new Locator.WaitForOptions().setTimeout(20000)); // Should take 15s, give it 20s
        return calculatedData;
    }
}
