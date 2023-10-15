package common;

import com.microsoft.playwright.Page;

public abstract class BasePage {

    protected final Page page;
    protected final String url;



    public BasePage(Page page, String url)
    {
        this.page = page;
        this.url = url;
    }

    public void openPage() {
        page.navigate(url);
    }


}
