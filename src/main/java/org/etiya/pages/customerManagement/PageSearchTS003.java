package org.etiya.pages.customerManagement;

import org.etiya.utils.ConfigReader;
import org.etiya.utils.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageSearchTS003 {
    protected WebDriver driver;
    protected WebDriverWait wait;
    public WebElement customerIDField;
    public WebElement natIDField;
    public WebElement gsmNumberField;
    public WebElement accountNumberField;
    public WebElement firstNameField;
    public WebElement middleNameField;
    public WebElement lastNameField;
    public WebElement searchButton;
    public WebElement clearButton;
    public WebElement customerIDDisplay;
    public WebElement natIDDisplay;
    public WebElement gsmNumberDisplay;
    public WebElement accountNumberDisplay;
    public WebElement firstNameDisplay;
    public WebElement middleNameDisplay;
    public WebElement lastNameDisplay;
    public WebElement errorContainer;
    public WebElement createCustomerButton;
    public WebElement fieldTitleCustomerID;
    public WebElement fieldTitleNatID;
    public WebElement fieldTitleAccountNumber;
    public WebElement fieldTitleFirstName;
    public WebElement fieldTitleLastName;
    public WebElement fieldTitleMiddleName;
    public WebElement fieldTitleGSMNumber;

    String customerIDFieldId = ConfigReader.getProperty("customerManagement.properties", "customerIDField");
    String natIDFieldId = ConfigReader.getProperty("customerManagement.properties", "natIDField");
    String gsmNumberFieldId = ConfigReader.getProperty("customerManagement.properties", "gsmNumberField");
    String accountNumberFieldId = ConfigReader.getProperty("customerManagement.properties", "accountNumberField");
    String firstNameFieldId = ConfigReader.getProperty("customerManagement.properties", "firstNameField");
    String middleNameFieldId = ConfigReader.getProperty("customerManagement.properties", "middleNameField");
    String lastNameFieldId = ConfigReader.getProperty("customerManagement.properties", "lastNameField");
    String searchBtnId = ConfigReader.getProperty("customerManagement.properties", "searchBtn");
    String clearBtnId = ConfigReader.getProperty("customerManagement.properties", "clearBtn");
    String errorContainerFieldId = ConfigReader.getProperty("customerManagement.properties", "searchErrorContainer");

    String customerIDDisplayId = ConfigReader.getProperty("customerManagement.properties", "customerIDDisplay");
    String natIDDisplayId = ConfigReader.getProperty("customerManagement.properties", "natIDDisplay");
    String gsmNumberDisplayId = ConfigReader.getProperty("customerManagement.properties", "gsmNumberDisplay");
    String accountNumberDisplayId = ConfigReader.getProperty("customerManagement.properties", "accountNumberDisplay");
    String firstNameDisplayId = ConfigReader.getProperty("customerManagement.properties", "firstNameDisplay");
    String middleNameDisplayId = ConfigReader.getProperty("customerManagement.properties", "middleNameDisplay");
    String lastNameDisplayId = ConfigReader.getProperty("customerManagement.properties", "lastNameDisplay");

    String createCustomerButtonId = ConfigReader.getProperty("customerManagement.properties", "createCustomerButton");

//    String fieldTitleIdCustomerID = ConfigReader.getProperty("customerManagement.properties", "fieldTitleIdCustomerID");
//    String fieldTitleIdNatID = ConfigReader.getProperty("customerManagement.properties", "fieldTitleIdNatID");
//    String fieldTitleIdAccountNumberID = ConfigReader.getProperty("customerManagement.properties", "fieldTitleIdAccountNumberID");
//    String fieldTitleIdGSMNumberID = ConfigReader.getProperty("customerManagement.properties", "fieldTitleIdGSMNumberID");
//    String fieldTitleIdFirstNameID = ConfigReader.getProperty("customerManagement.properties", "fieldTitleIdFirstNameID");
//    String fieldTitleIdMiddleNameID = ConfigReader.getProperty("customerManagement.properties", "fieldTitleIdMiddleNameID");
//    String fieldTitleIdLastNameID = ConfigReader.getProperty("customerManagement.properties", "fieldTitleIdLastNameID");


    public PageSearchTS003(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.EXPLICIT_WAIT));
        customerIDField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(customerIDFieldId)));
        natIDField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(natIDFieldId)));
        gsmNumberField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(gsmNumberFieldId)));
        accountNumberField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(accountNumberFieldId)));
        firstNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(firstNameFieldId)));
        middleNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(middleNameFieldId)));
        lastNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(lastNameFieldId)));
        searchButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(searchBtnId)));
        clearButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(clearBtnId)));
    }
    public boolean isSearchButtonEnabled() { return searchButton.isEnabled(); }
    public boolean isClearButtonEnabled() { return clearButton.isEnabled(); }
    public void enterCustomerID(String customerID) { customerIDField.sendKeys(customerID); }
    public void enterNatID(String natID) { natIDField.sendKeys(natID); }
    public void enterGsmNumber(String gsmNumber) { gsmNumberField.sendKeys(gsmNumber); }
    public void enterAccountNumber(String accountNumber) { accountNumberField.sendKeys(accountNumber); }
    public void enterFirstName(String firstName) { firstNameField.sendKeys(firstName); }
    public void enterMiddleName(String middleName) { middleNameField.sendKeys(middleName); }
    public void enterLastName(String lastName) { lastNameField.sendKeys(lastName); }
    public void clickSearchButton() { searchButton.click(); }
    public void clickClearButton() { clearButton.click(); }
    public String getCustomerID() {
        customerIDDisplay = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(customerIDDisplayId)));
        return customerIDDisplay.getText();
    }
    public String getNatID() {
        natIDDisplay = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(natIDDisplayId)));
        return natIDDisplay.getText();
    }
    public String getGsmNumber() {
        gsmNumberDisplay = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(gsmNumberDisplayId)));
        return gsmNumberDisplay.getText();
    }
    public String getAccountNumber() {
        accountNumberDisplay = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(accountNumberDisplayId)));
        return accountNumberDisplay.getText();
    }
    public String getFirstName() {
        firstNameDisplay = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(firstNameDisplayId)));
        return firstNameDisplay.getText();
    }
    public String getMiddleName() {
        middleNameDisplay = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(middleNameDisplayId)));
        return middleNameDisplay.getText();
    }
    public String getLastName() {
        lastNameDisplay = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(lastNameDisplayId)));
        return lastNameDisplay.getText();
    }
    public void findErrorMessage(){
        errorContainer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(errorContainerFieldId)));
    }
    public String getErrorMessage() {
        return errorContainer.getText();
    }
    public WebElement findCreateCustomerButton() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(createCustomerButtonId)));
    }

    public String getCustomerIDAfterSearch() {
        return getCustomerID();
    }

    public String getFieldLabelForCustomerID() {
        WebElement label = driver.findElement(By.xpath("//label[@for='" + fieldTitleCustomerID.getAttribute("id") + "']"));
        return label.getText();
    }
    public String getFieldLabelForNatID() {
        WebElement label = driver.findElement(By.xpath("//label[@for='" + fieldTitleNatID.getAttribute("id") + "']"));
        return label.getText();
    }
    public String getFieldLabelForAccountNumber() {
        WebElement label = driver.findElement(By.xpath("//label[@for='" + fieldTitleAccountNumber.getAttribute("id") + "']"));
        return label.getText();
    }
    public String getFieldLabelForFirstName() {
        WebElement label = driver.findElement(By.xpath("//label[@for='" + fieldTitleFirstName.getAttribute("id") + "']"));
        return label.getText();
    }
    public String getFieldLabelForMiddleName() {
        WebElement label = driver.findElement(By.xpath("//label[@for='" + fieldTitleMiddleName.getAttribute("id") + "']"));
        return label.getText();
    }
    public String getFieldLabelForLastName() {
        WebElement label = driver.findElement(By.xpath("//label[@for='" + fieldTitleLastName.getAttribute("id") + "']"));
        return label.getText();
    }
    public String getFieldLabelForGSMNumber() {
        WebElement label = driver.findElement(By.xpath("//label[@for='" + fieldTitleGSMNumber.getAttribute("id") + "']"));
        return label.getText();
    }
    public String getCustomerIDFieldValue() {
        return customerIDField.getAttribute("value");
    }

}
