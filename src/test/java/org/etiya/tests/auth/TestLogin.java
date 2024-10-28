package org.etiya.tests.auth;

import org.etiya.pages.auth.PageLogin;
import org.etiya.utils.ConfigReader;
import org.etiya.utils.Driver;
import org.etiya.utils.ScreenshotUtil;
import org.etiya.utils.TestSetup;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.openqa.selenium.WebDriver;

public class TestLogin
{
    private PageLogin loginPage;
    private WebDriver driver;
    String folderName = "auth";
    String screenshotName;

    @BeforeEach
    public void setup(){
        TestSetup.initialize();
        driver = Driver.getDriver();
        driver.get(ConfigReader.getProperty("config.properties", "url"));

        loginPage = new PageLogin(driver);
    }
    @AfterEach
    public void cleanup(){
        ScreenshotUtil.takeScreenshot(folderName,screenshotName);
        driver.quit();
    }

    @Test
    public void testSuccessfulLogin() {
        screenshotName = "testSuccessfulLogin";
        String username = ConfigReader.getProperty("auth.properties", "validUsername");
        String password = ConfigReader.getProperty("auth.properties", "validPassword");

        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();

        String expectedUrl = ConfigReader.getProperty("config.properties", "url") + ConfigReader.getProperty("auth.properties", "expectedPath");
        String actualUrl = driver.getCurrentUrl();
        String errorMsg = ConfigReader.getProperty("auth.properties", "successLoginError");
        assertEquals(expectedUrl, actualUrl, errorMsg);
    }
}