package com.theinternetherokuapp.basetest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.util.logging.Logger;

/**
 * BaseTest is the parent class for all test classes in The Internet HerokuApp test suite.
 * It sets up and tears down the WebDriver for every test.
 *
 * Features:
 * - WebDriver initialization with support for Chrome and Firefox.
 * - Test setup and teardown using `@BeforeMethod` and `@AfterMethod`.
 * - Ensures browser is started and closed properly after each test.
 *
 * - Default browser: Chrome.
 * This class ensures consistent test execution and prevents redundant WebDriver setups.
 */

public class BaseTest {
    protected WebDriver driver;
    private static final Logger logger = Logger.getLogger(BaseTest.class.getName());

    @BeforeMethod(alwaysRun = true)
    @Parameters("browser")
    public void setUp(@Optional("chrome") String browser) {
        logger.info("Running test in: " + browser);
        driver = createDriver(browser);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
        logger.info("Browser is closed!");
    }

    private WebDriver createDriver(String browser) {
        switch (browser.toLowerCase()) {
            case "chrome":
                return new ChromeDriver();
            case "firefox":
                return new FirefoxDriver();
            default:
                logger.warning("Configuration for " + browser + " is missing. Running tests in Chrome!");
                return new ChromeDriver();
        }
    }
}
