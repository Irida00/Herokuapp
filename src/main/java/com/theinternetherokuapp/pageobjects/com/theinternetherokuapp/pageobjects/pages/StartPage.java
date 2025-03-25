package com.theinternetherokuapp.pageobjects.com.theinternetherokuapp.pageobjects.pages;

import com.theinternetherokuapp.pageobjects.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Map;

/**
 * StartPage represents the main homepage of the HerokuApp test site.
 * This page contains navigation links to various test pages such as:
 * - Add/Remove Elements
 * - Basic Auth
 * - Challenging DOM
 * - Context Menu
 * - File Downloader
 *
 * This class provides methods to:
 * - Verify visibility of navigation links.
 * - Click links to navigate to other test pages.
 * - Verify if the homepage is correctly loaded.
 */

public class StartPage extends BasePage {
    private By heading = By.className("heading");
    public static final String PAGE_URL = "https://the-internet.herokuapp.com/";
    private static final Map<String, By> LINK_LOCATORS = Map.of(
            "add_remove_elements", By.partialLinkText("Add/Remove Elements"),
            "form_authentication", By.partialLinkText("Form Authentication"),
            "challenging_dom", By.partialLinkText("Challenging DOM"),
            "context_menu", By.partialLinkText("Context Menu"),
            "disappearing_elements", By.partialLinkText("Disappearing Elements"),
            "footer_elemental_selenium", By.linkText("Elemental Selenium")
    );

    public StartPage(WebDriver driver) {
        super(driver);
    }

    private By getLocator(String key) {
        return LINK_LOCATORS.get(key);
    }

    public void clickLink(String linkName) {
        driver.findElement(getLocator(linkName)).click();
    }

    public void returnToStartPage() {
        super.back();
    }

    public boolean isLinkDisplayed(String linkName) {
        return waitForIsDisplayed((getLocator(linkName)));
    }

    public void visit() {
        super.visit(PAGE_URL);
    }

    public String getHeadingText() {
        return getText(heading);
    }
}
