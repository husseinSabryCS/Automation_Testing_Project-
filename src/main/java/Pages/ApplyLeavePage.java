package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ApplyLeavePage {
    private final WebDriver driver;

    // Elements on the apply leave page
    //private final By leaveTypeDropdown = By.xpath("//div[contains(text(),'CAN-FMLA')]");
    private final By fromDateField = By.xpath("//input[@class='oxd-input oxd-input--active']");
    private final By toDateField = By.xpath("//input[@class='oxd-input oxd-input--active']");
    private final By commentField = By.xpath("//textarea[@class='oxd-textarea oxd-textarea--active oxd-textarea--resize-vertical']");
    private final By applyButton = By.xpath("//button[@ type='submit']");
    public void selectCanFmla() {
        WebElement canFmlaElement = driver.findElement(By.xpath("//div[contains(text(),'CAN-FMLA')]"));
        canFmlaElement.click();
    }
    // Constructor to pass the WebDriver
    public ApplyLeavePage(WebDriver driver) {
        this.driver = driver;
    }

    // Open the apply leave page
    public void open() {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/leave/applyLeave");
    }

    // Select the leave type
  //  public void selectLeaveType(String leaveType) {
    //    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  //      WebElement leaveTypeDropdownElement = wait.until(ExpectedConditions.visibilityOfElementLocated(leaveTypeDropdown));
      //  leaveTypeDropdownElement.sendKeys(leaveType);
    //}

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

    // Click the apply button
    public void clickApplyButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement applyButtonElement = wait.until(ExpectedConditions.elementToBeClickable(applyButton));
        applyButtonElement.click();
    }

}