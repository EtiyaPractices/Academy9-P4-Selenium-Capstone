package org.etiya.tests;

import org.etiya.pages.Page1Login;
import org.etiya.utils.ConfigReader;
import org.etiya.utils.Driver;
import org.etiya.utils.ScreenshotUtil;
import org.etiya.utils.TestSetup;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.openqa.selenium.WebDriver;

public class Test1Login
{
    private Page1Login loginPage;
    private WebDriver driver;
    String screenshotName;

    @BeforeEach
    public void setup(){
        TestSetup.initialize();
        driver = Driver.getDriver();
        driver.get(ConfigReader.getProperty("config.properties", "url"));

        loginPage = new Page1Login(driver);
    }
    @AfterEach
    public void cleanup(){
        ScreenshotUtil.takeScreenshot(screenshotName);
        driver.quit();
    }

    @Test
    public void testSuccessfulLogin() {
        screenshotName = "testSuccessfulLogin";
        String username = ConfigReader.getProperty("login.properties", "validUsername");
        String password = ConfigReader.getProperty("login.properties", "validPassword");

        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();

        String expectedUrl = ConfigReader.getProperty("login.properties", "expectedUrl");
        String actualUrl = driver.getCurrentUrl();
        String errorMsg = ConfigReader.getProperty("login.properties", "successLoginError");
        assertEquals(expectedUrl, actualUrl, errorMsg);
    }

}