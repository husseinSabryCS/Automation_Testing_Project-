import Pages.LoginPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginTest {
    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeEach
    public void setUp() {
        // Initialize ChromeDriver and LoginPage before each test
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
    }

    @Test
    public void testAdminLogin() {
        loginPage.open();
        loginPage.enterUsername("Admin");
        loginPage.enterPassword("admin123");
        loginPage.clickLogin();

        String expectedUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
        String actualUrl = driver.getCurrentUrl();
        assertEquals(expectedUrl, actualUrl, "Login failed or wrong URL.");
    }

    @Test
    public void testLoginWithEmptyUsernameValidPassword() {
        loginPage.open();
        loginPage.enterPassword("admin123");
        loginPage.clickLogin();

        String errorMessage = loginPage.getErrorMessage();
        assertTrue(errorMessage.contains("Required"), "Expected username required message.");
    }

    @Test
    public void testLoginWithEmptyUsernameAndEmptyPassword() {
        loginPage.open();
        loginPage.clickLogin();

        String errorMessage = loginPage.getErrorMessage();
        assertTrue(errorMessage.contains("Required"), "Expected both username and password required messages.");
    }

    @Test
    public void testLoginWithValidUsernameEmptyPassword() {
        loginPage.open();
        loginPage.enterUsername("Admin");
        loginPage.clickLogin();

        String errorMessage = loginPage.getErrorMessage();
        assertTrue(errorMessage.contains("Required"), "Expected password required message.");
    }

    @Test
    public void testLoginWithValidUsernameInvalidPassword() {
        loginPage.open();
        loginPage.enterUsername("Admin");
        loginPage.enterPassword("wrongpassword");
        loginPage.clickLogin();

        String errorMessage = loginPage.getAlertErrorMessage();
        System.out.println(errorMessage);
        assertTrue(errorMessage.contains("Invalid credentials"), "Invalid credentials");
    }

    @AfterEach
    public void tearDown() {
        // Close browser after each test
        if (driver != null) {
            driver.quit();
        }
    }
}
