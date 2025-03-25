package com.theinternetherokuapp.pageobjects.com.theinternetherokuapp.pageobjects.pages;

import com.theinternetherokuapp.pageobjects.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * AddRemoveElementsPage represents the Add/Remove Elements test page in The Internet HerokuApp.
 * It allows adding and removing elements dynamically.
 */

public class AddRemoveElementsPage extends BasePage {
    private By heading = By.tagName("h3");
    public static final String PAGE_URL = "https://the-internet.herokuapp.com/add_remove_elements/";
    private By addElementButton = By.xpath("//button[@onclick='addElement()']");
    private By deleteButton = By.xpath("//button[@onclick='deleteElement()']");

    public AddRemoveElementsPage(WebDriver driver) {
        super(driver);
    }

    public void visit() {
        super.visit(PAGE_URL);
    }

    public String getHeadingText() {
        return getText(heading);
    }

    public void clickAddElementButton() {
        super.click(addElementButton);
    }

    public void clickDeleteButton() {
        super.click(deleteButton);
    }

    public boolean isAddElementButtonPresent() {
        return super.isDisplayed(addElementButton);
    }

    public int getAddElementButtonCount() {
        return driver.findElements(addElementButton).size();
    }

    public boolean isDeleteButtonPresent() {
        return super.waitForIsDisplayed(deleteButton);
    }

    public int getDeleteButtonCount() {
        return driver.findElements(deleteButton).size();
    }

    public boolean isDeleteButtonHidden() {
        return super.waitForIsHidden(deleteButton);
    }


}
