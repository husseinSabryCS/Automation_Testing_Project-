package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class LeaveListPage {
    private final WebDriver driver;

    // Elements on the Leave List page
    private final By fromDateField = By.xpath("//input[@class='oxd-input oxd-input--active']");
    private final By toDateField = By.xpath("//input[@class='oxd-input oxd-input--active']");

    private final By showLeaveWithStatusDropdown = By.xpath("//div[@class='oxd-select-text oxd-select-text--active']");
    private final By searchButton = By.xpath("//button[@type='submit']");
    private final By leaveRecordsTable = By.id("leaveTable");

    // Constructor to pass the WebDriver
    public LeaveListPage(WebDriver driver) {
        this.driver = driver;
    }

    // Open the Leave List page
    public void open() {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/leave/viewMyLeaveList");
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



    // Select the show leave with status
    public void selectShowLeaveWithStatus(String status) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement showLeaveWithStatusDropdownElement = wait.until(ExpectedConditions.visibilityOfElementLocated(showLeaveWithStatusDropdown));
        showLeaveWithStatusDropdownElement.sendKeys(status);
    }

    // Click the search button
    public void clickSearchButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement searchButtonElement = wait.until(ExpectedConditions.elementToBeClickable(searchButton));
        searchButtonElement.click();
    }

    // Get the list of leave records
    public List<WebElement> getLeaveRecords() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement leaveRecordsTableElement = wait.until(ExpectedConditions.visibilityOfElementLocated(leaveRecordsTable));
        return leaveRecordsTableElement.findElements(By.tagName("tr"));
    }
}