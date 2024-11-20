import Pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Pages.ApplyLeavePage;

import java.time.Duration;
import Pages.LoginPage;

public class ApplyLeaveTest {
    private WebDriver driver;
    private ApplyLeavePage applyLeavePage;
    private LoginPage loginPage;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        applyLeavePage = new ApplyLeavePage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        loginPage.open();
        loginPage.enterUsername("Admin");
        loginPage.enterPassword("admin123");
        loginPage.clickLogin();

        // Open the Apply Leave page
        applyLeavePage.open();
    }
    @Test
    public void testCanFmlaSelection() {



        applyLeavePage.selectCanFmla();


    }

    @Test
    public void testApplyLeave() {
        applyLeavePage.enterFromDate("2024-11-01");
        applyLeavePage.enterToDate("2024-11-05");
        applyLeavePage.enterComment("Vacation leave");
        applyLeavePage.clickApplyButton();

        String successMessage = driver.findElement(By.id("successMessage"))
                .getText();
        Assert.assertTrue(successMessage.contains("successfully applied"), "Leave application was not successful.");
    }



    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}