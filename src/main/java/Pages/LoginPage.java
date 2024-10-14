package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private final WebDriver driver;

    // Elements on the login page
    private final By usernameField = By.xpath("//input[@name='username']");
    private final By passwordField = By.xpath("//input[@name=\"password\"]");
    private final By loginButton = By.xpath("//button[@type='submit']");

    // Constructor to pass the WebDriver
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Open the login page
    public void open() {
        driver.get("https://opensource-demo.orangehrmlive.com/");
    }

    // Enter the username
    public void enterUsername(String username) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement usernameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField));
        usernameInput.sendKeys(username);
    }

    // Error message element on the login page
    private final By errorMessage = By.xpath("//span[contains(@class, 'oxd-text--span')]");
    private final By errorAlertMessage = By.xpath("//div[@class=\"oxd-alert-content oxd-alert-content--error\"]");

    // Retrieve the error message
    public String getErrorMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement errorElement = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage));
        return errorElement.getText();
    }

    // Retrieve the alert error message
    public String getAlertErrorMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement errorElement = wait.until(ExpectedConditions.visibilityOfElementLocated(errorAlertMessage));
        return errorElement.getText();
    }

    // Enter the password
    public void enterPassword(String password) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement passwordInput = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));
        passwordInput.sendKeys(password);
    }

    // Click the login button
    public void clickLogin() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement loginBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton));
        loginBtn.click();
    }
}
