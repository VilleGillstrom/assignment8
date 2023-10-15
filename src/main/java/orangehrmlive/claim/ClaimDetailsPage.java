package orangehrmlive.claim;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import common.BasePage;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class ClaimDetailsPage extends BasePage {



    public ClaimDetailsPage(Page page, int claimId) {
        super(page, String.format("https://opensource-demo.orangehrmlive.com/web/index.php/claim/submitClaim/id/%s", claimId));
    }


    public ClaimDetailsPage(Page page, String url) {
        super(page, url);
    }


    public String getClaimReferenceId() {
        Locator claimIdLocator = page.locator("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div[1]/form/div[1]/div/div[1]/div/div[2]/input");
        assertThat(claimIdLocator).isInViewport();
        return claimIdLocator.inputValue();
    }
}
