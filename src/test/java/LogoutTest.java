import Pages.LoginPage;
import Pages.LogoutPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LogoutTest {
    private WebDriver driver;
    private LoginPage loginPage;
    private LogoutPage logoutPage;

    @BeforeEach
    public void setUp() {
        // Initialize ChromeDriver, LoginPage, and LogoutPage before each test
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        logoutPage = new LogoutPage(driver);
    }

    @Test
    public void testLogout() {
        // Log in first
        loginPage.open();
        loginPage.enterUsername("Admin");
        loginPage.enterPassword("admin123");
        loginPage.clickLogin();

        // Perform the logout operation
        logoutPage.openUserMenu();
        logoutPage.clickLogout();

        // Verify that the user is redirected to the login page
        assertTrue(logoutPage.isAtLoginPage(), "Logout failed or not redirected to login page.");
    }

    @AfterEach
    public void tearDown() {
        // Close the browser after each test
        if (driver != null) {
            driver.quit();
        }
    }
}
