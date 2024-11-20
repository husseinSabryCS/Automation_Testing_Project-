import org.openqa.selenium.By;
import Pages.LoginPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Pages.AssignLeavePage;

import java.time.Duration;

public class AssignLeaveTest {
    private WebDriver driver;
    private AssignLeavePage assignLeavePage;

    private LoginPage loginPage;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        // Set the path to the ChromeDriver executable
        loginPage = new LoginPage(driver);

        // Initialize the ChromeDriver

        assignLeavePage = new AssignLeavePage(driver);



        // Log in to the application
        loginPage.open();
        loginPage.enterUsername("Admin");
        loginPage.enterPassword("admin123");
        loginPage.clickLogin();
        // Open the Assign Leave page
        assignLeavePage.open();
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }

    }
    @Test
    public void testAssignLeave() {
        // Wait for the page to load and the title to be correct
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.titleContains("Assign Leave"));

        // Wait for the employee dropdown to be visible
        WebElement employeeSelect = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='assignleave_employee']")));

        // Select an employee from the dropdown
        employeeSelect.click();
        assignLeavePage.selectEmployeeByName("John Doe");

        // Fill in the leave details
       // assignLeavePage.selectLeaveType("Annual Leave");
        assignLeavePage.enterFromDate("2024-10-01");
        assignLeavePage.enterToDate("2024-10-05");
        assignLeavePage.enterComment ("...");
        assignLeavePage.clickAssignButton();

        // Verify that the leave request was submitted successfully
        String successMessage = assignLeavePage.getSuccessMessage();
        Assert.assertEquals(successMessage, "Leave assigned successfully");
    }


    @AfterClass
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}