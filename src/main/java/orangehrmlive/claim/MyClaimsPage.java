package orangehrmlive.claim;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import common.BasePage;

public class MyClaimsPage extends BasePage {



    public MyClaimsPage(Page page) {
        super(page, "https://opensource-demo.orangehrmlive.com/web/index.php/claim/viewClaim");
    }
    public Locator getCellWithReferenceId(String referenceId) {
        page.waitForCondition(() -> page.getByRole(AriaRole.CELL).count() > 0);
        return page.getByRole(AriaRole.CELL).and(page.getByText(referenceId));
    }
}
