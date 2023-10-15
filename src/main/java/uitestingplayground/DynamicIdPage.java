package uitestingplayground;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

public class DynamicIdPage extends BasePlaygroundPage {

    private final Locator dynamicIdButton;


    public DynamicIdPage(Page page)
    {
        super(page, "http://uitestingplayground.com/dynamicid");
        this.dynamicIdButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Button with Dynamic ID"));
    }

    public void openPage() {
        page.navigate(url);
    }
    public void clickDynamicIdButton() {
        dynamicIdButton.click();
    }

    public Locator getDynamicIdButton() {
        return dynamicIdButton;
    }
}

