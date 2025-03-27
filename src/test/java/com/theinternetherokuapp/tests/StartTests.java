package com.theinternetherokuapp.tests;

import com.theinternetherokuapp.basetest.BaseTest;
import com.theinternetherokuapp.pageobjects.com.theinternetherokuapp.pageobjects.pages.AddRemoveElementsPage;
import com.theinternetherokuapp.pageobjects.com.theinternetherokuapp.pageobjects.pages.FormAuthenticationPage;
import com.theinternetherokuapp.pageobjects.com.theinternetherokuapp.pageobjects.pages.StartPage;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * StartPage represents the main landing page of The Internet HerokuApp.
 * This page provides navigation to various test pages and includes:
 *
 * Features:
 * - A header with the main page title.
 * - A navigation menu with multiple links to different test pages.
 * - A footer section.
 *
 * Tests include:
 * - Ensure the page loads with the correct URL.
 * - Page heading is correct
 * - Verify the presence of navigation links.
 * - Confirm that the footer is displayed.
 */

public class StartTests extends BaseTest {
    @Test
    public void verifyStartPageLoadsWithCorrectURL() {
        StartPage startPage = new StartPage(driver);
        startPage.visit();
        Assert.assertEquals(driver.getCurrentUrl(), StartPage.PAGE_URL, "Incorrect URL");
    }

    @Test
    public void verifyStartPageHeadingText() {
        StartPage startPage = new StartPage(driver);
        startPage.visit();
        Assert.assertEquals(startPage.getHeadingText(), "Welcome to the-internet",
                "Page heading is incorrect or missing");
    }

    @Test
    public void verifyAddRemoveElementsLinkIsVisible() {
        StartPage startPage = new StartPage(driver);
        startPage.visit();
        Assert.assertTrue(startPage.isLinkDisplayed("add_remove_elements"), "Add/Remove Elements link is not visible!");
    }

    @Test
    public void verifyAddRemoveElementsLinkNavigatesCorrectly() {
        StartPage startPage = new StartPage(driver);
        startPage.visit();
        startPage.clickLink("add_remove_elements");
        Assert.assertEquals(driver.getCurrentUrl(), AddRemoveElementsPage.PAGE_URL,
                "Link does not navigates to the proper address");
    }

    @Test
    public void verifyCanReturnToStartPageFromAddRemoveElementsPage() {
        StartPage startPage = new StartPage(driver);
        startPage.visit();
        startPage.clickLink("add_remove_elements");
        startPage.returnToStartPage();
        Assert.assertEquals(driver.getCurrentUrl(), StartPage.PAGE_URL,
                "Return to the start page failed");
    }

    @Test
    public void verifyFormAuthenticationLinkIsVisible() {
        StartPage startPage = new StartPage(driver);
        startPage.visit();
        Assert.assertTrue(startPage.isLinkDisplayed("form_authentication"),
                "Form Authentication link is not visible!");
    }

    @Test
    public void verifyFormAuthenticationLinkNavigatesCorrectly() {
        StartPage startPage = new StartPage(driver);
        startPage.visit();
        startPage.clickLink("form_authentication");
        Assert.assertEquals(driver.getCurrentUrl(), FormAuthenticationPage.PAGE_URL,
                "Link does not navigates to the proper address");
    }

    @Test
    public void verifyCanReturnToStartPageFromFormAuthenticationPage() {
        StartPage startPage = new StartPage(driver);
        startPage.visit();
        startPage.clickLink("form_authentication");
        startPage.returnToStartPage();
        Assert.assertEquals(driver.getCurrentUrl(), StartPage.PAGE_URL,
                "Return to the start page failed");
    }

    @Test(enabled = false)
    public void verifyChallengingDOMLinkIsVisible() {
        StartPage startPage = new StartPage(driver);
        startPage.visit();
        Assert.assertTrue(startPage.isLinkDisplayed("add_remove_elements"), "Add/Remove Elements link is not visible!");
    }

    @Test(enabled = false)
    public void verifyChallengingDOMLinkNavigatesCorrectly() {
        StartPage startPage = new StartPage(driver);
        startPage.visit();
        startPage.clickLink("add_remove_elements");
        Assert.assertEquals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/add_remove_elements/");
    }

    @Test(enabled = false)
    public void verifyCanReturnToStartPageFromChallengingDOMPage() {
        StartPage startPage = new StartPage(driver);
        startPage.visit();
        startPage.clickLink("add_remove_elements");
        startPage.returnToStartPage();
        Assert.assertEquals(driver.getCurrentUrl(), StartPage.PAGE_URL);
    }

    @Test(enabled = false)
    public void verifyContextMenuLinkIsVisible() {
        StartPage startPage = new StartPage(driver);
        startPage.visit();
        Assert.assertTrue(startPage.isLinkDisplayed("add_remove_elements"), "Add/Remove Elements link is not visible!");
    }

    @Test(enabled = false)
    public void verifyContextMenuLinkNavigatesCorrectly() {
        StartPage startPage = new StartPage(driver);
        startPage.visit();
        startPage.clickLink("add_remove_elements");
        Assert.assertEquals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/add_remove_elements/");
    }

    @Test(enabled = false)
    public void verifyCanReturnToStartPageFromContextMenuPage() {
        StartPage startPage = new StartPage(driver);
        startPage.visit();
        startPage.clickLink("add_remove_elements");
        startPage.returnToStartPage();
        Assert.assertEquals(driver.getCurrentUrl(), StartPage.PAGE_URL);
    }

    @Test(enabled = false)
    public void verifyDisappearingElementsLinkIsVisible() {
        StartPage startPage = new StartPage(driver);
        startPage.visit();
        Assert.assertTrue(startPage.isLinkDisplayed("add_remove_elements"), "Add/Remove Elements link is not visible!");
    }

    @Test(enabled = false)
    public void verifyDisappearingElementsLinkNavigatesCorrectly() {
        StartPage startPage = new StartPage(driver);
        startPage.visit();
        startPage.clickLink("add_remove_elements");
        Assert.assertEquals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/add_remove_elements/");
    }

    @Test(enabled = false)
    public void verifyCanReturnToStartPageFromDisappearingElementsPage() {
        StartPage startPage = new StartPage(driver);
        startPage.visit();
        startPage.clickLink("add_remove_elements");
        startPage.returnToStartPage();
        Assert.assertEquals(driver.getCurrentUrl(), StartPage.PAGE_URL);
    }

    @Test(enabled = false)
    public void verifyFileDownloaderLinkIsVisible() {
        StartPage startPage = new StartPage(driver);
        startPage.visit();
        Assert.assertTrue(startPage.isLinkDisplayed("add_remove_elements"), "Add/Remove Elements link is not visible!");
    }

    @Test(enabled = false)
    public void verifyFileDownloaderLinkNavigatesCorrectly() {
        StartPage startPage = new StartPage(driver);
        startPage.visit();
        startPage.clickLink("add_remove_elements");
        Assert.assertEquals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/add_remove_elements/");
    }

    @Test(enabled = false)
    public void verifyCanReturnToStartPageFromFileDownloaderPage() {
        StartPage startPage = new StartPage(driver);
        startPage.visit();
        startPage.clickLink("add_remove_elements");
        startPage.returnToStartPage();
        Assert.assertEquals(driver.getCurrentUrl(), StartPage.PAGE_URL);
    }

    @Test
    public void verifyFooterLinkNavigatesCorrectly() {
        StartPage startPage = new StartPage(driver);
        startPage.visit();
        String originalWindow = driver.getWindowHandle();
        startPage.clickLink("footer_elemental_selenium");
        //Switch to the new window
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(originalWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        Assert.assertEquals(driver.getCurrentUrl(), "https://elementalselenium.com/");
    }
}
