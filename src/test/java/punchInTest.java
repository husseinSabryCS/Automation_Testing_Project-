import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Pages.PunchInPage;

import java.time.Duration;

public class punchInTest {
    private WebDriver driver;
    private PunchInPage punchInPage;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/NT/Downloads/chromedriver-win64/chromedriver.exe");
        driver = new ChromeDriver();
        punchInPage = new PunchInPage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        // Log in to the application
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("admin123");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        punchInPage = new PunchInPage(driver);

        // Open the Punch In page
        punchInPage.open();
    }

    @Test
    public void testPunchIn() {
        // Test input data for punch-in form
        String testDate = "2024-10-13";
        String testTime = "09:30 AM";

        String testNote = "Punching in";

        // Fill in the punch-in form
        punchInPage.enterDate(testDate);
        punchInPage.enterTime(testTime);
        punchInPage.enterNote(testNote);

        // Click the Punch In button
        punchInPage.clickPunchInButton();

        String expectedUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/attendance/viewMyAttendanceRecord";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertEquals(actualUrl, expectedUrl, "Punch In redirection URL mismatch.");
    }

    @AfterClass
    public void tearDown() {
        // Close the browser after all tests are done
        if (driver != null) {
            driver.quit();
        }
    }
}