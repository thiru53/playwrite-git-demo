package tests;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.*;

public class SampleTest {
    static Playwright playwright;
    static Browser browser;
    static BrowserContext context;
    static Page page;

    @BeforeAll
    static void setup() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(true));
        context = browser.newContext();
        page = context.newPage();
    }

    @AfterAll
    static void teardown() {
        page.close();
        context.close();
        browser.close();
        playwright.close();
    }

    @Test
    void shouldHaveCorrectTitle() {
        page.navigate("https://google.com");
        System.out.println("Page title: " + page.title());
    }
}
