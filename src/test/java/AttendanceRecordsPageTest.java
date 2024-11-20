import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Pages.AttendanceRecordsPage;

import java.time.Duration;
import java.util.List;

public class AttendanceRecordsPageTest {
    private WebDriver driver;
    private AttendanceRecordsPage attendanceRecordsPage;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        attendanceRecordsPage = new AttendanceRecordsPage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        // Log in to the application
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php");
        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("admin123");
        driver.findElement(By.cssSelector("button[type='submit']")).click();


        // Open the Attendance Records page
        attendanceRecordsPage.open();
    }

    @Test
    public void testEmployeeAttendanceRecords() {
        // Open the Employee Attendance Records page
        attendanceRecordsPage.open();

        // Enter a date
        attendanceRecordsPage.enterDate("2024-10-18");

        // Click the view button
        attendanceRecordsPage.clickViewButton();

        // Get the list of attendance records
        List<WebElement> attendanceRecords = attendanceRecordsPage.getAttendanceRecords();

        // Verify that the attendance records table is displayed
        Assert.assertTrue(attendanceRecords.size() > 1, "Attendance Records table is empty");


    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}