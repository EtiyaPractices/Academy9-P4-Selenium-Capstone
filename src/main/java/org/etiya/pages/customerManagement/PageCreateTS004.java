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
import java.util.Objects;

public class PageCreateTS004 {
    protected WebDriver driver;
    protected WebDriverWait wait;
    public WebElement firstNameField;
    public WebElement middleNameField;
    public WebElement lastNameField;
    public WebElement dateOfBirthField;
    public WebElement natIDField;
    public WebElement genderField;
    public WebElement motherNameField;
    public WebElement fatherNameField;
    public WebElement errorContainer;

    String firstNameFieldId = ConfigReader.getProperty("customerManagement.properties", "cFirstNameField");
    String middleNameFieldId = ConfigReader.getProperty("customerManagement.properties", "cMiddleNameField");
    String lastNameFieldId = ConfigReader.getProperty("customerManagement.properties", "cLastNameField");
    String dateOfBirthFieldId = ConfigReader.getProperty("customerCreation.properties", "cDobFieldId");
    String natIDFieldId = ConfigReader.getProperty("customerCreation.properties", "cNatIDFieldId");
    String genderFieldId = ConfigReader.getProperty("customerCreation.properties", "cGenderFieldId");
    String motherNameFieldId = ConfigReader.getProperty("customerCreation.properties", "cMotherNameFieldId");
    String fatherNameFieldId = ConfigReader.getProperty("customerCreation.properties", "cFatherNameFieldId");
    String errorContainerFieldId = ConfigReader.getProperty("customerManagement.properties", "createErrorContainer");

    public PageCreateTS004(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.EXPLICIT_WAIT));

        firstNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(firstNameFieldId)));
        middleNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(middleNameFieldId)));
        lastNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(lastNameFieldId)));
        dateOfBirthField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(dateOfBirthFieldId)));
        natIDField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(natIDFieldId)));
        genderField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(genderFieldId)));
        motherNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(motherNameFieldId)));
        fatherNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(fatherNameFieldId)));
    }
    public void enterFirstName(String firstName) {
        firstNameField.clear();
        firstNameField.sendKeys(firstName);
    }
    public void enterMiddleName(String middleName) {
        middleNameField.clear();
        middleNameField.sendKeys(middleName);
    }
    public void enterLastName(String lastName) {
        lastNameField.clear();
        lastNameField.sendKeys(lastName);
    }
    public void enterDateOfBirth(String dateOfBirth) {
        dateOfBirthField.clear();
        dateOfBirthField.sendKeys(dateOfBirth);
    }
    public void enterNatID(String natID) {
        natIDField.clear();
        natIDField.sendKeys(natID);
    }
    public void selectGender(String gender) {
        genderField.clear();
        genderField.sendKeys(gender);
    }
    public void enterMotherName(String motherName) {
        motherNameField.clear();
        motherNameField.sendKeys(motherName);
    }
    public void enterFatherName(String fatherName) {
        fatherNameField.clear();
        fatherNameField.sendKeys(fatherName);
    }
    public boolean isFirstNameFieldEmpty() {
        return firstNameField.getAttribute("value").isEmpty();
    }

    public boolean isMiddleNameFieldEmpty() {
        return Objects.requireNonNull(middleNameField.getAttribute("value")).isEmpty();
    }
    public boolean isLastNameFieldEmpty() {
        return Objects.requireNonNull(lastNameField.getAttribute("value")).isEmpty();
    }
    public boolean isDateOfBirthFieldEmpty() {
        return Objects.requireNonNull(dateOfBirthField.getAttribute("value")).isEmpty();
    }
    public boolean isNatIDFieldEmpty() {
        return Objects.requireNonNull(natIDField.getAttribute("value")).isEmpty();
    }
    public boolean isGenderFieldUnselected() {
        return Objects.equals(genderField.getAttribute("value"), "Select");
    }
    public boolean isMotherNameFieldEmpty() {
        return Objects.requireNonNull(motherNameField.getAttribute("value")).isEmpty();
    }
    public boolean isFatherNameFieldEmpty() {
        return Objects.requireNonNull(fatherNameField.getAttribute("value")).isEmpty();
    }
    public void clickNextButton() {
        WebElement nextButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("nextButtonId")));
        nextButton.click();
    }
    public WebElement getErrorMessageContainer() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("errorMessageContainer")));
    }
}
