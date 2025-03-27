package com.theinternetherokuapp.tests;

import com.theinternetherokuapp.basetest.BaseTest;
import com.theinternetherokuapp.pageobjects.com.theinternetherokuapp.pageobjects.pages.ContextMenuPage;
import com.theinternetherokuapp.pageobjects.com.theinternetherokuapp.pageobjects.pages.FormAuthenticationPage;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * FormAuthenticationTests contains test cases for login and logout functionality
 * on the Form Authentication Page of The Internet HerokuApp.
 *
 * Tests include:
 * - Page heading is correct
 * - Successful login with valid credentials
 * - Login failure with invalid credentials
 * - Login failure with empty fields
 * - Logout functionality
 * - Password masking check
 */

public class FormAuthenticationTests extends BaseTest {
    @Test
    public void verifySuccessfulLogin() {
        String validUsername = "tomsmith";
        String validPassword = "SuperSecretPassword!";
        FormAuthenticationPage formAuthenticationPage = new FormAuthenticationPage(driver);
        formAuthenticationPage.visit();
        formAuthenticationPage.login(validUsername, validPassword);
        Assert.assertTrue(formAuthenticationPage.isSuccessMessageDisplayed(), "Expected success message, but it is missing");
        Assert.assertTrue(formAuthenticationPage.isLogoutButtonDisplayed(), "Expected 'Logout' button, but it is not visible");
    }

    @Test
    public void verifyPageHeadingIsCorrect() {
        FormAuthenticationPage formAuthenticationPage = new FormAuthenticationPage(driver);
        formAuthenticationPage.visit();
        Assert.assertEquals(formAuthenticationPage.getHeadingText(),  "Login Page",
                "Page heading is incorrect or missing");
    }

    @Test
    public void verifyLoginFailsWithInvalidCredentials() {
        String invalidUsername = "invalid username";
        String invalidPassword = "invalid password";
        FormAuthenticationPage formAuthenticationPage = new FormAuthenticationPage(driver);
        formAuthenticationPage.visit();
        formAuthenticationPage.login(invalidUsername, invalidPassword);
        Assert.assertTrue(formAuthenticationPage.isErrorMessageDisplayed(), "Expected error message, but it was not found");
    }

    @Test
    public void verifyLoginWithEmptyFields() {
        String emptyUsername = "";
        String emptyPassword = "";
        FormAuthenticationPage formAuthenticationPage = new FormAuthenticationPage(driver);
        formAuthenticationPage.visit();
        formAuthenticationPage.login(emptyUsername, emptyPassword);
        Assert.assertTrue(formAuthenticationPage.isErrorMessageDisplayed(), "Expected error message, but it was not found");
    }

    @Test
    public void verifyLogoutFunctionality() {
        String validUsername = "tomsmith";
        String validPassword = "SuperSecretPassword!";
        FormAuthenticationPage formAuthenticationPage = new FormAuthenticationPage(driver);
        formAuthenticationPage.visit();
        formAuthenticationPage.login(validUsername, validPassword);
        formAuthenticationPage.clickLogoutButton();
        Assert.assertEquals(driver.getCurrentUrl(), FormAuthenticationPage.PAGE_URL,
                "Logout failed!");
        Assert.assertTrue(formAuthenticationPage.isSuccessMessageDisplayed(),
                "Expected logout success message, but it was not found");
    }

    @Test
    public void verifyPasswordMasking() {
        FormAuthenticationPage formAuthenticationPage = new FormAuthenticationPage(driver);
        formAuthenticationPage.visit();
        Assert.assertTrue(formAuthenticationPage.isPasswordMasked(), "Password field is not masked! Expected type 'password'");
    }
}
