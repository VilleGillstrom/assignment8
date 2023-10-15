package uitestingplayground;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class VisibilityPage extends BasePlaygroundPage {
    public VisibilityPage(Page page) {
        super(page, "http://uitestingplayground.com/visibility");
    }

    public Locator hideBtn() {
        return page.locator("#hideButton");
    }

    public Locator removedBtn() {
        return page.locator("#removedButton");
    }

    public Locator zeroWidthBtn() {
        return page.locator("#zeroWidthButton");
    }

    public Locator overLappedBtn() {
        return page.locator("#overlappedButton");
    }

    public Locator transparentBtn() {
        return page.locator("#transparentButton");
    }

    public Locator visibilityHiddenBtn() {
        return page.locator("#invisibleButton");
    }

    public Locator displayNoneBtn() {
        return page.locator("#notdisplayedButton");
    }

    public Locator offscreenBtn() {
        return page.locator("#offscreenButton");
    }

    public void clickHideBtn() {
        hideBtn().click();
    }

    public Locator hidingLayer() {
        return page.locator("#hidingLayer");
    }

}
