package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AssignLeavePage {
    private final WebDriver driver;

    // Elements on the assign leave page
    private final By employeeDropdown = By.cssSelector("input[placeholder='Type for hints...']");
    private final By leaveTypeDropdown = By.cssSelector("i[class='oxd-icon bi-caret-down-fill oxd-select-text--arrow']");
    private final By fromDateField = By.cssSelector("input[class='oxd-input oxd-input--active']");
    private final By toDateField = By.cssSelector("input[class='oxd-input oxd-input--active']");
    private final By commentField = By.cssSelector("textarea[class='oxd-textarea oxd-textarea--active oxd-textarea--resize-vertical']");
    private final By assignButton = By.cssSelector("button[type='submit']");

    // Constructor to pass the WebDriver
    public AssignLeavePage(WebDriver driver) {
        this.driver = driver;
    }

    // Open the assign leave page
    public void open() {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/leave/assignLeave");
    }

    // Select the employee
    public void selectEmployeeByName(String employeeName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement employeeDropdownElement = wait.until(ExpectedConditions.visibilityOfElementLocated(employeeDropdown));
        employeeDropdownElement.sendKeys(employeeName);
    }

    // Select the leave type
    public void selectLeaveType(String leaveType) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement leaveTypeDropdownElement = wait.until(ExpectedConditions.visibilityOfElementLocated(leaveTypeDropdown));
        leaveTypeDropdownElement.sendKeys(leaveType);
    }

    // Enter the from date
    public void enterFromDate(String fromDate) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement fromDateFieldElement = wait.until(ExpectedConditions.visibilityOfElementLocated(fromDateField));
        fromDateFieldElement.sendKeys(fromDate);
    }

    // Enter the to date
    public void enterToDate(String toDate) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement toDateFieldElement = wait.until(ExpectedConditions.visibilityOfElementLocated(toDateField));
        toDateFieldElement.sendKeys(toDate);
    }

    // Enter the comment
    public void enterComment(String comment) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement commentFieldElement = wait.until(ExpectedConditions.visibilityOfElementLocated(commentField));
        commentFieldElement.sendKeys(comment);
    }

    // Click the assign button
    public void clickAssignButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement assignButtonElement = wait.until(ExpectedConditions.elementToBeClickable(assignButton));
        assignButtonElement.click();
    }

    public String getSuccessMessage() {
        // Locate the success message element
        WebElement successMessageElement = driver.findElement(By.id("successMessageId"));
        return successMessageElement.getText();
    }

}