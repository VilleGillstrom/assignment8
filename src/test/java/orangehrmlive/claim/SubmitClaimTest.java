package orangehrmlive.claim;

import com.microsoft.playwright.Locator;
import common.TestBase;
import orangehrmlive.login.LoginPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;


public class SubmitClaimTest extends TestBase {

    SubmitClaimPage submitClaimPage;

    @BeforeEach
    void loginAndOpenSubmitClaimPage() {
        LoginPage loginpage = new LoginPage(page);
        submitClaimPage = new SubmitClaimPage(page);

        // First login
        loginpage.openPage();
        loginpage.submitValidUsernameAndPassword();

        // Now we can navigate to the submit claim page
        submitClaimPage.openPage();
    }

    @Test
    void canNavigateToSubmitClaimPageAfterLogin() {
        assertThat(page).hasURL("https://opensource-demo.orangehrmlive.com/web/index.php/claim/submitClaim");
    }

    @Test
    void creatingClaimNavigatesToDetailsPage() {
        submitClaim(SubmitClaimPage.ClaimEventType.MedicalReimbursement, "Swedish Krona", "Knee injury");

        Pattern pattern = Pattern.compile("^.*/claim/submitClaim/id/\\d+$");
        assertThat(page).hasURL(pattern);
    }

    @Test
    void createdClaimIsAddedToMyClaimsPage() {
        submitClaim(SubmitClaimPage.ClaimEventType.MedicalReimbursement, "Swedish Krona", "Knee injury");
        Pattern pattern = Pattern.compile("^.*/claim/submitClaim/id/\\d+$");
        page.waitForURL(pattern);

        ClaimDetailsPage claimDetailsPage = new ClaimDetailsPage(page, page.url());
        claimDetailsPage.openPage();
        String claimReferenceId = claimDetailsPage.getClaimReferenceId();

        MyClaimsPage myClaimsPage = new MyClaimsPage(page);
        myClaimsPage.openPage();

        Locator claimReferenceIdCell = myClaimsPage.getCellWithReferenceId(claimReferenceId);
        assertNotNull(claimReferenceIdCell);
    }

    private void submitClaim(SubmitClaimPage.ClaimEventType claimEventType, String currency, String remark) {
        submitClaimPage.setClaimEvent(claimEventType);
        submitClaimPage.setCurrency(currency);
        submitClaimPage.setRemark(remark);
        submitClaimPage.clickCreateButton();
    }

}