package com.theinternetherokuapp.pageobjects.com.theinternetherokuapp.pageobjects.pages;

import com.theinternetherokuapp.pageobjects.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * FormAuthenticationPage represents the Login Page for The Internet HerokuApp.
 * This class provides methods to interact with the username, password fields,
 * and login/logout functionality.
 */

public class FormAuthenticationPage extends BasePage {
    public static final String PAGE_URL = "https://the-internet.herokuapp.com/login";
    private By usernameField = By.id("username");
    private By passwordField = By.id("password");
    private By loginButton = By.xpath("//button[@type='submit']");
    private By logoutButton = By.xpath("//a[@href='/logout']");
    private By errorMessage = By.className("error");
    private By successMessage = By.className("success");

    public FormAuthenticationPage(WebDriver driver) {
        super(driver);
    }

    public void visit() {
        super.visit(PAGE_URL);
    }

    public void enterUsername(String text) {
        super.type(usernameField, text);
    }

    public void enterPassword(String text) {
        super.type(usernameField, text);
    }

    public void clickLoginButton() {
        super.click(loginButton);
    }

    public void clickLogoutButton() {
        super.click(logoutButton);
    }

    public void login(String username, String password) {
        super.type(usernameField, username);
        super.type(passwordField, password);
        super.click(loginButton);
    }

    public boolean isSuccessMessageDisplayed() {
        return super.waitForIsDisplayed(successMessage);
    }

    public boolean isErrorMessageDisplayed() {
        return super.waitForIsDisplayed(errorMessage);
    }

    public boolean isLogoutButtonDisplayed() {
        return super.waitForIsDisplayed(logoutButton);
    }

    public boolean isPasswordMasked() {
        WebElement passwordInput = driver.findElement(passwordField);
        return "password".equals(passwordInput.getDomAttribute("type"));
    }

}
