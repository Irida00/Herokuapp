package com.theinternetherokuapp.tests;

import com.theinternetherokuapp.basetest.BaseTest;
import com.theinternetherokuapp.pageobjects.com.theinternetherokuapp.pageobjects.pages.AddRemoveElementsPage;

import com.theinternetherokuapp.pageobjects.com.theinternetherokuapp.pageobjects.pages.FormAuthenticationPage;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * AddRemoveElementsTests verifies the functionality of adding and removing elements
 * on the Add/Remove Elements page of The Internet HerokuApp.
 *
 * Tests include:
 * - Page heading is correct
 * - Verifying only one "Add Element" button should be present initially
 * - Verifying no delete button exists before adding elements
 * - Adding an element and verifying the delete button appears
 * - Ensuring multiple elements can be added and removed
 * - Clicking the delete button removes the element
 */

public class AddRemoveElementsTests extends BaseTest {

    @Test
    public void verifyPageHeadingIsCorrect() {
        AddRemoveElementsPage addRemovePage = new AddRemoveElementsPage(driver);
        addRemovePage.visit();
        Assert.assertEquals(addRemovePage.getHeadingText(),  "Add/Remove Elements",
                "Page heading is incorrect or missing");
    }

    @Test
    public void verifyOnlyOneAddElementButtonIsPresentInitially() {
        AddRemoveElementsPage addRemovePage = new AddRemoveElementsPage(driver);
        addRemovePage.visit();
        Assert.assertEquals(1, addRemovePage.getAddElementButtonCount(),
                "Expected only one 'Add Element' button, but found: " + addRemovePage.getAddElementButtonCount());
    }

    @Test
    public void verifyNoDeleteButtonIsPresentInitially() {
        AddRemoveElementsPage addRemovePage = new AddRemoveElementsPage(driver);
        addRemovePage.visit();
        Assert.assertTrue(addRemovePage.isDeleteButtonHidden(),
                "Expected 'Delete' button to be hidden, but it's visible");
    }

    @Test
    public void verifyDeleteButtonAppearsAfterClickingAddElement() {
        AddRemoveElementsPage addRemovePage = new AddRemoveElementsPage(driver);
        addRemovePage.visit();
        addRemovePage.clickAddElementButton();
        Assert.assertTrue(addRemovePage.isDeleteButtonPresent(),
                "Expected 'Delete' button to be visible, but it's hidden");
    }

    @Test
    public void verifyMultipleDeleteButtonsAppearAfterMultipleClicks() {
        AddRemoveElementsPage addRemovePage = new AddRemoveElementsPage(driver);
        addRemovePage.visit();
        addRemovePage.clickAddElementButton();
        addRemovePage.clickAddElementButton();
        Assert.assertEquals(2, addRemovePage.getDeleteButtonCount(),
                "Expected two 'Delete' buttons, but found: " + addRemovePage.getDeleteButtonCount());
    }

    @Test
    public void verifyDeleteButtonIsRemovedAfterClickingIt() {
        AddRemoveElementsPage addRemovePage = new AddRemoveElementsPage(driver);
        addRemovePage.visit();
        addRemovePage.clickAddElementButton();
        addRemovePage.clickDeleteButton();
        Assert.assertTrue(addRemovePage.isDeleteButtonHidden(), "Delete button is still visible after clicking it");
    }
}
