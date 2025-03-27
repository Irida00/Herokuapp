package com.theinternetherokuapp.tests;

import com.theinternetherokuapp.basetest.BaseTest;
import com.theinternetherokuapp.pageobjects.com.theinternetherokuapp.pageobjects.pages.ContextMenuPage;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * ContextMenuTests page contains test cases for verifying the visibility of the context box, correct heading,
 * and that the alert appears with the expected message upon right-clicking.
 * Tests include:
 * - Page heading is correct
 * - Context box is visible
 * - Right-clicking the box triggers the expected alert
 * - Handle the alert by accepting it
 */


public class ContextMenuTests extends BaseTest {

    @Test
    public void verifyPageHeadingIsCorrect() {
        ContextMenuPage contextMenuPage = new ContextMenuPage(driver);
        contextMenuPage.visit();
        Assert.assertEquals(contextMenuPage.getHeadingText(),  "Context Menu",
                "Page heading is incorrect or missing");
    }

    @Test
    public void ContextBoxIsVisible() {
        ContextMenuPage contextMenuPage = new ContextMenuPage(driver);
        contextMenuPage.visit();
        Assert.assertTrue(contextMenuPage.isHotSpotContextMenuDisplayed(),
                "Context box is missing or not visible.");
    }

    @Test
    public void verifyContextBoxClickDisplaysExpectedAlert() {
        ContextMenuPage contextMenuPage = new ContextMenuPage(driver);
        contextMenuPage.visit();
        contextMenuPage.rightClickHotSpotContextMenu();
        Assert.assertEquals(contextMenuPage.getAlertText(), "You selected a context menu",
                "Alert text is not the expected");
        contextMenuPage.acceptAlert();
    }

    @Test
    public void verifyContextBoxAcceptClickCloseAlert() {
        ContextMenuPage contextMenuPage = new ContextMenuPage(driver);
        contextMenuPage.visit();
        contextMenuPage.rightClickHotSpotContextMenu();
        contextMenuPage.acceptAlert();
        Assert.assertFalse(contextMenuPage.isAlertPresent(), "Alert should not be present");
    }
}
