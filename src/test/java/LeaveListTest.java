import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Pages.LeaveListPage;

import java.time.Duration;
import java.util.List;

public class LeaveListTest {
    private WebDriver driver;
    private LeaveListPage leaveListPage;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/NT/Downloads/chromedriver-win64/chromedriver.exe");
        driver = new ChromeDriver();
        leaveListPage = new LeaveListPage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        // Log in to the application
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("admin123");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
    }

    @Test
    public void testLeaveList() {
        // Open the Leave List page
        leaveListPage.open();

        leaveListPage.enterFromDate("2024-01-01");
        leaveListPage.enterToDate("2024-10-30");


        leaveListPage.selectShowLeaveWithStatus("Pending Approval");

        // Click the search button
        leaveListPage.clickSearchButton();

        // Get the list of leave records
        List<WebElement> leaveRecords = leaveListPage.getLeaveRecords();

        // Verify that the leave records table is displayed
        Assert.assertTrue(leaveRecords.size() > 1, "Leave records table is empty");


    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}