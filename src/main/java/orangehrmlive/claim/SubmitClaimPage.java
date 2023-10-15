package orangehrmlive.claim;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import common.BasePage;

import java.util.regex.Pattern;

public class SubmitClaimPage extends BasePage {


    public enum ClaimEventType {
        Accommodation("Accommodation"),
        MedicalReimbursement("Medical Reimbursement"),
        TravelAllowance("Travel Allowance");

        ClaimEventType(String optionString) {
            this.optionString = optionString;
        }

        public final String optionString;
    }

    private final Locator createButtonLocator;

    public SubmitClaimPage(Page page) {
        super(page, "https://opensource-demo.orangehrmlive.com/web/index.php/claim/submitClaim");

        createButtonLocator = page.getByRole(AriaRole.BUTTON).and(page.getByText("Create"));
    }


    public void setClaimEvent(ClaimEventType claimType) {
        clickEventDropDown();

        Locator optionLocator = page.getByRole(AriaRole.LISTBOX)
                                    .getByRole(AriaRole.OPTION)
                                    .getByText(claimType.optionString);

        optionLocator.click();
    }



    public void setCurrency(String currency) {
        clickCurrencyDropDown();
        Locator optionLocator = page.getByRole(AriaRole.LISTBOX)
                                    .getByRole(AriaRole.OPTION)
                                    .getByText(Pattern.compile(currency, Pattern.CASE_INSENSITIVE));

        optionLocator.click();
    }

    public void setRemark(String remark) {
        Locator remarkTextAreaLocator = page.locator(".oxd-textarea");
        remarkTextAreaLocator.fill(remark);
    }

    private void clickEventDropDown() {
        Locator eventDropdownLocator = page.locator(".oxd-select-wrapper").nth(0);
        eventDropdownLocator.click();
    }
    private void clickCurrencyDropDown() {
        Locator currencyDropdownLocator = page.locator(".oxd-select-wrapper").nth(1);
        currencyDropdownLocator.click();
    }

    public void clickCreateButton() {
        createButtonLocator.click();
    }


}
