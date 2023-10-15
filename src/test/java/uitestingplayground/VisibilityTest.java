package uitestingplayground;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.BoundingBox;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import playwright.testbase.TestBase;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class VisibilityTest extends TestBase {

    VisibilityPage visibilityPage;
    @BeforeEach
    public void openVisibilityPage() {
        visibilityPage =  new VisibilityPage(page);
        visibilityPage.openPage();
    }

    @Test
    void HideButtonShouldMakeRemovedButtonNotVisible() {
        Locator zeroWidthBtn = visibilityPage.removedBtn();

        assertThat(zeroWidthBtn).isVisible();
        visibilityPage.clickHideBtn();
        assertThat(zeroWidthBtn).not().isVisible();
    }

    @Test
    void HideButtonShouldMakeZeroWidthButtonNotVisible() {
        Locator zeroWidthBtn = visibilityPage.zeroWidthBtn();
        assertThat(zeroWidthBtn).isVisible();
        visibilityPage.clickHideBtn();
        assertThat(zeroWidthBtn).not().isVisible();
    }

    @Test
    void HideButtonShouldMakeOverlappedButtonOverlapped() {
        Locator overLappedBtn = visibilityPage.overLappedBtn();
        Locator hidingLayer = visibilityPage.hidingLayer();

        boolean isCoveredBefore = isBoxCovered(overLappedBtn.boundingBox(), hidingLayer.boundingBox());
        assertFalse(isCoveredBefore, "HidingLayer should not cover overlappedBox before clicking Hide Button");

        visibilityPage.clickHideBtn();

        boolean isCoveredAfter = isBoxCovered(overLappedBtn.boundingBox(), hidingLayer.boundingBox());
        assertTrue(isCoveredAfter, "HidingLayer should cover overlappedBox");
    }

    @Test
    void HideButtonShouldMakeTransparentButtonTransparent() {
        Locator transparentButton = visibilityPage.transparentBtn();

        Object opacityBefore = transparentButton.evaluate("element => getComputedStyle(element)['opacity']");
        assertEquals("1", opacityBefore);

        visibilityPage.clickHideBtn();

        Object opacityAfter = transparentButton.evaluate("element => getComputedStyle(element)['opacity']");
        assertEquals("0", opacityAfter);
    }

    @Test
    void HideButtonShouldMakeVisibilityHiddenButtonHidden() {
        Locator visibilityHiddenBtn = visibilityPage.visibilityHiddenBtn();
        assertThat(visibilityHiddenBtn).not().isHidden();
        visibilityPage.clickHideBtn();
        assertThat(visibilityHiddenBtn).isHidden();
    }

    @Test
    void HideButtonShouldMakeDisplayNoneButtonNotVisible() {
        Locator displayNoneBtn = visibilityPage.displayNoneBtn();
        // IsVisible() checks for display : none
        assertThat(displayNoneBtn).isVisible();
        visibilityPage.clickHideBtn();
        assertThat(displayNoneBtn).not().isVisible();
    }

    @Test
    void HideButtonShouldMakeOffscreenButtonNotVisible() {
        Locator offscreenBtn = visibilityPage.offscreenBtn();

        assertThat(offscreenBtn).isInViewport();
        visibilityPage.clickHideBtn();
        assertThat(offscreenBtn).not().isInViewport();
    }

    private boolean isBoxCovered(BoundingBox Box, BoundingBox CoveringBox) {

        // Using round, BoundingBox was off by a tiny little bit compared to when inspecting in browser
        int Ax1 = (int) Math.round(Box.x - Box.width / 2);
        int Ax2 = (int) Math.round(Box.x + Box.width / 2);
        int Ay1 = (int) Math.round(Box.y - Box.height / 2);
        int Ay2 = (int) Math.round(Box.y + Box.height / 2);
        int Bx1 = (int) Math.round(CoveringBox.x - CoveringBox.width / 2);
        int Bx2 = (int) Math.round(CoveringBox.x + CoveringBox.width / 2);
        int By1 = (int) Math.round(CoveringBox.y - CoveringBox.height / 2);
        int By2 = (int) Math.round(CoveringBox.y + CoveringBox.height / 2);

        boolean coversWidth = Ax1 >= Bx1 && Ax2 <= Bx2;
        boolean coversHeight = Ay1 >= By1 && Ay2 <= By2;

        return coversWidth && coversHeight;
    }



}