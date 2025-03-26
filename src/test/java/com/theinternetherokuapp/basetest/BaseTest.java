package com.theinternetherokuapp.basetest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
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
 * - Supports headless mode for faster execution.
 * - Ensures browser is started and closed properly after each test.
 *
 * - Default browser: Chrome.
 * This class ensures consistent test execution and prevents redundant WebDriver setups.
 */

public class BaseTest {
    protected WebDriver driver;
    private static final Logger logger = Logger.getLogger(BaseTest.class.getName());

    @BeforeMethod(alwaysRun = true)
    @Parameters({"browser", "headless"})
    public void setUp(@Optional("chrome") String browser, @Optional("true") String headless) {
        boolean isHeadless = Boolean.parseBoolean(headless);
        logger.info("Running test in: " + browser + " | Headless mode: " + isHeadless);
        driver = createDriver(browser, isHeadless);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver !=null) {
            driver.quit();
            logger.info("Browser is closed!");
        }
    }

    private WebDriver createDriver(String browser, boolean headless) {
        switch (browser.toLowerCase()) {
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                if (headless) {
                    chromeOptions.addArguments("--headless");
                    chromeOptions.addArguments("--disable-gpu");
                    chromeOptions.addArguments("--window-size=1920,1080");
                }
                return new ChromeDriver(chromeOptions);
            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                if (headless) {
                    firefoxOptions.addArguments("--headless");
                }
                return new FirefoxDriver(firefoxOptions);
            default:
                logger.warning("Configuration for " + browser + " is missing. Running tests in Chrome!");
                return new ChromeDriver();
        }
    }
}
