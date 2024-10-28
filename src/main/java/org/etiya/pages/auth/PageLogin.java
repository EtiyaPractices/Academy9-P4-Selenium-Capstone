package org.etiya.pages.auth;

import org.etiya.utils.ConfigReader;
import org.etiya.utils.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageLogin {
    protected WebDriver driver;
    protected WebDriverWait wait;
    private final WebElement usernameField;
    private final WebElement passwordField;
    private final WebElement loginButton;
    String usernameFieldId = ConfigReader.getProperty("auth.properties", "usernameFieldId");
    String passwordFieldId = ConfigReader.getProperty("auth.properties", "passwordFieldId");
    String loginButtonId = ConfigReader.getProperty("auth.properties", "loginButtonId");
    public PageLogin(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.EXPLICIT_WAIT));
        //initialize elements w properties
        usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(usernameFieldId)));
        passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(passwordFieldId)));
        loginButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(loginButtonId)));
    }
    public void enterUsername(String username) {
        usernameField.sendKeys(username);
    }
    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }
    public void clickLoginButton() {
        loginButton.click();
    }
}
