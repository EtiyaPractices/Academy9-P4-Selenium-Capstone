package org.etiya.tests.customerManagement;

import org.etiya.pages.auth.PageLogin;
import org.etiya.pages.customerManagement.PageCreateTS004;
import org.etiya.utils.ConfigReader;
import org.etiya.utils.Driver;
import org.etiya.utils.ScreenshotUtil;
import org.etiya.utils.TestSetup;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import static org.junit.jupiter.api.Assertions.*;

public class TestCreateTS004 {
    private WebDriver driver;
    private PageCreateTS004 customerCreatePage;
    String folderName = "customerCreate";
    String screenshotName;

    @BeforeEach
    public void setUp() {
        TestSetup.initialize();
        driver = Driver.getDriver();
        driver.get(ConfigReader.getProperty("config.properties", "url"));
        PageLogin loginPage = new PageLogin(driver);
        loginPage.enterUsername(ConfigReader.getProperty("auth.properties", "validUsername"));
        loginPage.enterPassword(ConfigReader.getProperty("auth.properties", "validPassword"));
        loginPage.clickLoginButton();
        customerCreatePage = new PageCreateTS004(driver);
    }
    @AfterEach
    public void cleanUp() {
        ScreenshotUtil.takeScreenshot(folderName, screenshotName);
        driver.quit();
    }
    @Test
    public void testFieldsDisplayedAndEmptyOnCustomerInfoTabTC001(){
        screenshotName = "testFieldsDisplayedAndEmptyOnCustomerInfoTabTC001";
        assertTrue(customerCreatePage.firstNameField.isDisplayed()&&customerCreatePage.isFirstNameFieldEmpty());
        assertTrue(customerCreatePage.middleNameField.isDisplayed()&&customerCreatePage.isMiddleNameFieldEmpty());
        assertTrue(customerCreatePage.lastNameField.isDisplayed()&&customerCreatePage.isLastNameFieldEmpty());
        assertTrue(customerCreatePage.dateOfBirthField.isDisplayed()&&customerCreatePage.isDateOfBirthFieldEmpty());
        assertTrue(customerCreatePage.natIDField.isDisplayed()&&customerCreatePage.isNatIDFieldEmpty());
        assertTrue(customerCreatePage.natIDField.isDisplayed()&&customerCreatePage.isNatIDFieldEmpty());
        assertTrue(customerCreatePage.motherNameField.isDisplayed()&&customerCreatePage.isMotherNameFieldEmpty());
        assertTrue(customerCreatePage.fatherNameField.isDisplayed()&&customerCreatePage.isFatherNameFieldEmpty());
    }
    @Test
    public void testDuplicateNatIDErrorTC002(){
        screenshotName = "testDuplicateNatIDErrorTC002";
        customerCreatePage.enterFirstName(ConfigReader.getProperty("customerManagement.properties", "cFirstNameInput"));
        customerCreatePage.enterLastName("Doe");
        customerCreatePage.enterNatID("12345678912");
        customerCreatePage.enterDateOfBirth("01-03-1998");
        customerCreatePage.selectGender("1");

        customerCreatePage.clickNextButton();

        String expectedErrorMessage = "This customer already exists";
        String actualMessage= customerCreatePage.errorContainer.getText();
        assertEquals(expectedErrorMessage, actualMessage, "Error message does not match expected text.");
        
    }
}
