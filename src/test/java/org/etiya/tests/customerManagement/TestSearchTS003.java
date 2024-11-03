package org.etiya.tests.customerManagement;

import org.etiya.pages.auth.PageLogin;
import org.etiya.pages.customerManagement.PageSearchTS003;
import org.etiya.utils.ConfigReader;
import org.etiya.utils.Driver;
import org.etiya.utils.ScreenshotUtil;
import org.etiya.utils.TestSetup;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.openqa.selenium.WebDriver;

public class TestSearchTS003 {
    private WebDriver driver;
    private PageSearchTS003 customerSearchPage;
    String folderName = "customerSearch";
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
        customerSearchPage = new PageSearchTS003(driver);
    }
    @AfterEach
    public void cleanUp() {
        ScreenshotUtil.takeScreenshot(folderName, screenshotName);
        driver.quit();
    }
    @Test
    public void testAllFieldsDisplayedTC001(){
        screenshotName = "testAllFieldsDisplayedTC001";
        assertTrue(customerSearchPage.customerIDField.isDisplayed());
        assertTrue(customerSearchPage.natIDField.isDisplayed());
        assertTrue(customerSearchPage.gsmNumberField.isDisplayed());
        assertTrue(customerSearchPage.accountNumberField.isDisplayed());
        assertTrue(customerSearchPage.firstNameField.isDisplayed());
        assertTrue(customerSearchPage.middleNameField.isDisplayed());
        assertTrue(customerSearchPage.lastNameField.isDisplayed());
        assertTrue(customerSearchPage.searchButton.isDisplayed());
        assertTrue(customerSearchPage.clearButton.isDisplayed());
    }
    @Test
    public void testSearchButtonInactiveWhenFieldsAreEmptyTC002(){
        screenshotName = "testSearchButtonInactiveWhenFieldsAreEmptyTC002";
        assertFalse(customerSearchPage.isSearchButtonEnabled(), "Search button should be inactive when all fields are empty.");
    }
    @Test
    public void testSearchButtonIsActiveAfterEnteringNatIDTC003(){
        screenshotName = "testSearchButtonIsActiveAfterEnteringNatIDTC003";
        customerSearchPage.enterNatID(ConfigReader.getProperty("customerManagement.properties", "enterExistingNatID"));
        assertTrue(customerSearchPage.isSearchButtonEnabled(), "Search button should be active after entering data in any field.");
    }
    @Test
    public void testClearAllButtonInactiveWhenFieldsAreEmptyTC004(){
        screenshotName = "testClearAllButtonInactiveWhenFieldsAreEmptyTC004";
        assertFalse(customerSearchPage.isClearButtonEnabled(), "Clear All button should be inactive when all fields are empty.");
    }
    @Test
    public void testClearAllButtonIsActiveAfterEnteringNatIDTC005(){
        screenshotName = "testClearAllButtonIsActiveAfterEnteringNatIDTC005";
        customerSearchPage.enterNatID(ConfigReader.getProperty("customerManagement.properties", "enterExistingNatID"));
        assertTrue(customerSearchPage.isClearButtonEnabled(), "Clear All button should be active after entering data in any field.");
    }
    @Test
    public void testSearchButtonFunctionalityDisplaysCustomerInformationTC006(){
        screenshotName = "testSearchButtonFunctionalityDisplaysCustomerInformationTC006";
        customerSearchPage.enterCustomerID(ConfigReader.getProperty("customerManagement.properties", "enterExistingCustomerID"));
        customerSearchPage.clickSearchButton();

        String expectedCustomerID = ConfigReader.getProperty("customerManagement.properties", "expectedCustomerID");
        String expectedNatID = ConfigReader.getProperty("customerManagement.properties", "expectedNatID");
        String expectedGsmNumber = ConfigReader.getProperty("customerManagement.properties", "expectedGsmNumber");
        String expectedAccountNumber = ConfigReader.getProperty("customerManagement.properties", "expectedAccountNumber");
        String expectedFirstName = ConfigReader.getProperty("customerManagement.properties", "expectedFirstName");
        String expectedMiddleName = ConfigReader.getProperty("customerManagement.properties", "expectedMiddleName");
        String expectedLastName = ConfigReader.getProperty("customerManagement.properties", "expectedLastName");

        assertEquals(expectedCustomerID, customerSearchPage.getCustomerID(), "Customer ID does not match.");
        assertEquals(expectedNatID, customerSearchPage.getNatID(), "NAT ID does not match.");
        assertEquals(expectedGsmNumber, customerSearchPage.getGsmNumber(), "GSM Number does not match.");
        assertEquals(expectedAccountNumber, customerSearchPage.getAccountNumber(), "Account Number does not match.");
        assertEquals(expectedFirstName, customerSearchPage.getFirstName(), "First Name does not match.");
        assertEquals(expectedMiddleName, customerSearchPage.getMiddleName(), "Middle Name does not match.");
        assertEquals(expectedLastName, customerSearchPage.getLastName(), "Last Name does not match.");
    }

}
