package uitestingplayground;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public abstract class BasePlaygroundPage {

    protected final Page page;
    protected final String url;



    public BasePlaygroundPage(Page page, String url)
    {
        this.page = page;
        this.url = url;
    }

    public void openPage() {
        page.navigate(url);
    }


}
