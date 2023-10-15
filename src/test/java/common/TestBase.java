package common;


import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestBase {
    // Made all non-static so I can run tests in parallel
    protected Playwright playwright;
    protected Browser browser;
    protected BrowserContext context;
    protected Page page;

    @BeforeAll
    void launchBrowser() {
        playwright = Playwright.create();
        //BrowserType.LaunchOptions launchOptions = getHeadfulLaunchOptions();
        BrowserType.LaunchOptions launchOptions = getHeadlessLaunchOptions();
        browser = playwright.chromium().launch(launchOptions);
    }

    @AfterAll
    void closeBrowser() {
        playwright.close();
    }

    @BeforeEach
    void createContextAndPage() {
        context = browser.newContext();
        page = context.newPage();
    }

    @AfterEach
    void closeContext() {
        context.close();
    }

    private static BrowserType.LaunchOptions getHeadlessLaunchOptions() {
        BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions();
        launchOptions.setHeadless(true);
        return launchOptions;
    }

    private static BrowserType.LaunchOptions getHeadfulLaunchOptions() {
        BrowserType.LaunchOptions launchOptions = new BrowserType.LaunchOptions();
        launchOptions.setHeadless(false);
        launchOptions.setSlowMo(400);
        launchOptions.setTimeout(1000);
        return launchOptions;
    }

}
