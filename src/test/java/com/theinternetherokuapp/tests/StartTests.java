package com.theinternetherokuapp.tests;

import com.theinternetherokuapp.basetest.BaseTest;
import com.theinternetherokuapp.pageobjects.com.theinternetherokuapp.pageobjects.pages.StartPage;
import org.testng.Assert;
import org.testng.annotations.Test;

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
        Assert.assertEquals(startPage.getHeadingText(), "Welcome to the-internet");
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
        Assert.assertEquals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/add_remove_elements/");
    }

    @Test
    public void verifyCanReturnToStartPageFromAddRemoveElementsPage() {
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
