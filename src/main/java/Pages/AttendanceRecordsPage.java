package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AttendanceRecordsPage {
    private final WebDriver driver;

    // Elements on the Attendance Records page

    private final By dateField = By.xpath("///input[@placeholder='yyyy-dd-mm']");
    private final By viewButton = By.xpath("//button[@type='submit']");
    // Constructor to pass the WebDriver
    public AttendanceRecordsPage(WebDriver driver) {
        this.driver = driver;
    }

    // Open the Attendance Records page
    public void open() {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/attendance/viewAttendanceRecord");
    }

    // Enter the date
    public void enterDate(String date) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement dateFieldElement = wait.until(ExpectedConditions.visibilityOfElementLocated(dateField));
        dateFieldElement.sendKeys(date);
    }

    // Click the view button
    public void clickViewButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> viewButtonElements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(viewButton));
        for (WebElement viewButton : viewButtonElements) {
            viewButton.click();
        }
    }

    // Get the list of attendance records
    public List<WebElement> getAttendanceRecords() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement attendanceTable = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("attendanceTable")));
        return attendanceTable.findElements(By.tagName("tr"));
    }
}