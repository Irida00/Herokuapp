package com.theinternetherokuapp.pageobjects.base;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * BasePage is the parent class for all page objects in The Internet HerokuApp test suite.
 * It contains common web interaction methods used by all pages.
 *
 * Features:
 * - Methods for clicking elements, typing input, and verifying visibility.
 * - Wrapper functions for WebDriver interactions.
 * - Wait utilities for handling dynamic elements.
 *
 * This class follows the Page Object Model (POM) to maintain reusable and maintainable test code.
 */

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    protected void visit(String url) {
        driver.get(url);
    }

    protected String getPageSource() {
        return driver.getPageSource();
    }

    protected WebElement waitForElement(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected boolean waitForIsDisplayed(By locator) {
        try {
            waitForElement(locator);
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    protected boolean waitForIsHidden(By locator) {
        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    protected boolean isDisplayed(By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    protected void click(By locator) {
        waitForElement(locator).click();
    }

    protected void type(By locator, String text) {
        WebElement field = waitForElement(locator);
        field.clear();
        field.sendKeys(text);
    }

    protected String getText(By locator) {
        return waitForElement(locator).getText();
    }

    protected void refresh() {
        driver.navigate().refresh();
    }

    protected void back() {
        driver.navigate().back();
    }

}
