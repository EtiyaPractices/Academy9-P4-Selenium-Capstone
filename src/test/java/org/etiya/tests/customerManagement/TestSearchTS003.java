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

import java.util.Objects;

public class TestSearchTS003 {
    private WebDriver driver;
    private PageSearchTS003 customerSearchPage;
    String folderName = "customerSearch";
    String screenshotName;
    String customerID;

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
        customerID = customerSearchPage.getCustomerIDAfterSearch();
    }
    @Test
    public void testNoRecordFoundDisplaysErrorMessageTC007(){
        screenshotName = "testNoRecordFoundDisplaysErrorMessageTC007";
        customerSearchPage.enterNatID(ConfigReader.getProperty("customerManagement.properties", "enterNonExistentNatID"));
        customerSearchPage.clickSearchButton();
        customerSearchPage.findErrorMessage();
        String expectedNoCustomerErrorMessage = ConfigReader.getProperty("customerManagement.properties", "expectedNoCustomerErrorMessage");
        assertEquals(expectedNoCustomerErrorMessage, customerSearchPage.getErrorMessage(), "The error message does not match the expected text.");
        assertTrue(Objects.requireNonNull(driver.getCurrentUrl()).contains("customerSearch"), "The user is not on the 'Customer Search' page.");
        assertNotNull(customerSearchPage.createCustomerButton, "The 'Create New Customer' button is not displayed.");
        assertTrue(customerSearchPage.createCustomerButton.isDisplayed(), "The 'Create New Customer' button is not visible on the page.");
    }
    @Test
    public void testValidationOfTheNumericFieldsTC008() {
        screenshotName = "testValidationOfTheNumericFieldsTC008";
        customerSearchPage.enterNatID(ConfigReader.getProperty("customerManagement.properties", "enterNonValidNatID"));
        String expectedFieldDisplay = null;
        assertEquals(expectedFieldDisplay, customerSearchPage.getNatID(),"Field is not empty.");
    }

    @Test
    public void testTheNavigationAfterClickingTheCustomerIDLinkTC009() {
        screenshotName = "testTheNavigationAfterClickingTheCustomerIDLinkTC009";
        testSearchButtonFunctionalityDisplaysCustomerInformationTC006();
        testTheNavigationAfterSeach(driver, customerID);

    }

    @Test
    public void testTheValidationOfTheSizeLimitForMinTC010() {
        screenshotName = "testTheValidationOfTheSizeLimitForMinTC010";
        customerSearchPage.enterNatID(ConfigReader.getProperty("customerManagement.properties", "enterNonValidNatIDForMin"));
        customerSearchPage.enterCustomerID(ConfigReader.getProperty("customerManagement.properties", "enterNonValidCustomerIDForMin"));
        customerSearchPage.enterFirstName(ConfigReader.getProperty("customerManagement.properties", "enterNonValidFirstNameForMin"));
        customerSearchPage.enterMiddleName(ConfigReader.getProperty("customerManagement.properties", "enterNonValidMiddleNameForMin"));
        customerSearchPage.enterLastName(ConfigReader.getProperty("customerManagement.properties", "enterNonValidLastNameForMin"));
        customerSearchPage.enterGsmNumber(ConfigReader.getProperty("customerManagement.properties", "enterNonValidGSMNumberForMin"));
        customerSearchPage.enterAccountNumber(ConfigReader.getProperty("customerManagement.properties", "enterNonValidAccountNumberForMin"));
        customerSearchPage.clickSearchButton();
        customerSearchPage.findErrorMessage();
        String actualResult = customerSearchPage.getErrorMessage();
        assertEquals(generateValidationErrorMessage(customerSearchPage.getFieldLabelForCustomerID()), actualResult, "Messages are not matching."); //For customerID, should add other field's methods

    }

    public void testTheNavigationAfterSeach(WebDriver driver, String customerID) {
        testSearchButtonFunctionalityDisplaysCustomerInformationTC006();
        String currentURL = driver.getCurrentUrl();
        assertEquals("https://www.saucedemo.com/"+customerID, currentURL,"URLs are not matching.");
    }

    public String generateValidationErrorMessage(String fieldName) {
        String errorMessageFor10 = fieldName + "must be 10 characters.";
        String errorMessageFor11 = fieldName + "must be 11 characters.";
        String errorMessageFor2 = fieldName + "must be min 2 characters long.";
        switch (fieldName) {
            case "Nat ID":
                return errorMessageFor11;
            case "Customer ID":
            case "Account Number":
            case "GSM Number":
                return errorMessageFor10;
            case "First Name" :
            case "Middle Name":
            case "Last Name":
                return errorMessageFor2;
            default:
                return "Field name was not found.";
        }

    }

    @Test
    public void testValidationOfFieldsForMaxTC011() {
        screenshotName = "testValidationOfFieldsForMaxTC011";
        customerSearchPage.enterNatID(ConfigReader.getProperty("customerManagement.properties", "enterNonValidNatID"));
        String expectedFieldDisplay = null; //Here we should find a way to compare text size for max
        assertEquals(expectedFieldDisplay, customerSearchPage.getNatID(),"Field is not empty.");
    }




}
