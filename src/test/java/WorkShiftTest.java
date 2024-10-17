import Pages.LoginPage;
import Pages.WorkShiftPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.testng.AssertJUnit.assertTrue;

public class WorkShiftTest {
    private WebDriver driver;
    private LoginPage loginPage;
    private WorkShiftPage workShiftPage;
    String shiftName = "Morning Shift9";
    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        workShiftPage = new WorkShiftPage(driver);
        // Step 1: Login as Admin
        loginPage.open();
        loginPage.enterUsername("Admin");
        loginPage.enterPassword("admin123");
        loginPage.clickLogin();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/admin/workShift");
    }

    @Test
    @DisplayName("Test Adding a New Work Shift")
    public void testAddNewWorkShift() {


        // Step 2: Add a New Work Shift
        workShiftPage.clickAddButton();
        workShiftPage.enterShiftName(shiftName);

        workShiftPage.setWorkingHours("01:00 AM", "01:00 PM");
        workShiftPage.assignEmployee("t");
        workShiftPage.clickSave();

        // Optional: Add assertions to verify success
        // Example: Verify if the shift is added successfully
        assertTrue("Work shift should be added successfully.", workShiftPage.isShiftAdded(shiftName));
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
