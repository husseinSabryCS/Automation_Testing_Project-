package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddEmployeePage {
    private final WebDriver driver;

    // Locators for the elements on the "Add Employee" page
    private final By firstNameField = By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[1]/div[1]/div/div/div[2]/div[1]/div[2]/input");
    private final By middleNameField = By.xpath("//input[@class=\"oxd-input oxd-input--active orangehrm-middlename\"]");
    private final By lastNameField = By.xpath("//input[@class=\"oxd-input oxd-input--active orangehrm-lastname\"]");
    private final By employeeIdField = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[1]/div[2]/div/div/div[2]/input");
    private final By imageUploadField = By.xpath("//button[@class=\"oxd-icon-button oxd-icon-button--solid-main employee-image-action\"]");
    private final By createLoginDetailsCheckbox = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[2]/div/label/span");
    private final By usernameField = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[3]/div/div[1]/div/div[2]/input");
    private final By passwordField = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[4]/div/div[1]/div/div[2]/input");
    private final By confirmPasswordField = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[4]/div/div[2]/div/div[2]/input");
    private final By saveButton = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/button[2]");
    private final By successMessage = By.xpath("//div[@class=\"orangehrm-edit-employee-name\"]");

    // Locator for error message
    private final By errorMessageLocator = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[1]/div[1]/div/div/div[2]/div[3]/span ");

    // Constructor to pass the WebDriver
    public AddEmployeePage(WebDriver driver) {
        this.driver = driver;
    }

    // Open the "Add Employee" page
    public void open() {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/pim/addEmployee");
    }

    // Enter first name
    public void enterFirstName(String firstName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement firstNameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameField));
        firstNameInput.sendKeys(firstName);
    }

    // Enter middle name
    public void enterMiddleName(String middleName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement middleNameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(middleNameField));
        middleNameInput.sendKeys(middleName);
    }

    // Enter last name
    public void enterLastName(String lastName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement lastNameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(lastNameField));
        lastNameInput.sendKeys(lastName);
    }

    // Enter employee ID
    public void enterEmployeeId(String employeeId) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement employeeIdInput = wait.until(ExpectedConditions.visibilityOfElementLocated(employeeIdField));
        employeeIdInput.clear();
        employeeIdInput.sendKeys(employeeId);
    }

    // Upload profile image
    public void uploadImage(String imagePath) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement uploadInput = wait.until(ExpectedConditions.visibilityOfElementLocated(imageUploadField));
        uploadInput.sendKeys(imagePath);
    }

    // Check the "Create Login Details" checkbox (if not already checked)
    public void checkCreateLoginDetails() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement checkbox = wait.until(ExpectedConditions.visibilityOfElementLocated(createLoginDetailsCheckbox));
        if (!checkbox.isSelected()) {
            checkbox.click();
        }
    }

    // Enter username (for login details)
    public void enterUsername(String username) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement usernameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField));
        usernameInput.sendKeys(username);
    }

    // Enter password (for login details)
    public void enterPassword(String password) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement passwordInput = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));
        passwordInput.sendKeys(password);
    }

    // Enter confirm password (for login details)
    public void enterConfirmPassword(String confirmPassword) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement confirmPasswordInput = wait.until(ExpectedConditions.visibilityOfElementLocated(confirmPasswordField));
        confirmPasswordInput.sendKeys(confirmPassword);
    }

    // Click the "Save" button to submit the form
    public void clickSave() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement saveBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(saveButton));
        saveBtn.click();
    }

    // Check if the employee was added successfully
    public boolean isEmployeeAdded() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            WebElement successMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));
            return successMsg.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    // Method to get error message when a field is missing
    public String getErrorMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement errorMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessageLocator));
        return errorMsg.getText();
    }
}
