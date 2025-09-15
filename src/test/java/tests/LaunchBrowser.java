package tests;

import com.microsoft.playwright.*;

public class LaunchBrowser {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch();
            Page page = browser.newPage();
            page.navigate("https://example.com");
            System.out.println("Page title: " + page.title());
            browser.close();
        }
    }
}