import Pages.LoginPage;
import Pages.AdminPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AdminTest {
    private WebDriver driver;
    private LoginPage loginPage;
    private AdminPage adminPage;
    String username = "Admin";
    @BeforeEach
    public void setUp() {
        // Initialize ChromeDriver, LoginPage, and AdminPage before each test
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        adminPage = new AdminPage(driver);

         driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewSystemUsers");
    }

    @Test
    public void testAddUser() {
        // Login with valid admin account
        loginPage.open();
        loginPage.enterUsername("Admin");
        loginPage.enterPassword("admin123");
        loginPage.clickLogin();

        // Navigate to Admin page and add a user
        adminPage.clickAddUser();
     adminPage.enterUsername("newUser123");

     adminPage.typeEmployeeNameAndSelectFirst("L");
        adminPage.enterPassword("Password123!");

        adminPage.enterConfirmPassword("Password123!");
        adminPage.selectStatus("Enabled");
        adminPage.selectRole("ESS");
        adminPage.clickSave();

        // Check for success message (you may need to adjust the check depending on the UI)
//         assertTrue(adminPage.isUserAddedSuccessfully(), "User should be added successfully.");
    }
    @Test
    @DisplayName("Test Search Functionality in Admin Page ByUsername")
    public void testUserSearchByUsername() {
        // Step 1: Login with valid admin credentials
        loginPage.enterUsername("Admin");
        loginPage.enterPassword("admin123");
        loginPage.clickLogin();


        // Step 4: Search by Username
        adminPage.searchByUsername(username);
        assertTrue(adminPage.isUserFound(username), "User 'Admin' should be found.");
    }
    @Test
    @DisplayName("Test Search Functionality in Admin Page by Status")
    public void testUserSearchByStatus() {
        loginPage.enterUsername("Admin");
        loginPage.enterPassword("admin123");
        loginPage.clickLogin();
        adminPage.selectStatussearch("Disabled");
        adminPage.clickSearch();

    }
    @Test
    @DisplayName("Test Search Functionality in Admin Page by Role")
    public void testUserSearchByRole() {
        loginPage.enterUsername("Admin");
        loginPage.enterPassword("admin123");
        loginPage.clickLogin();
        adminPage.selectRoleSearch("ESS");
        adminPage.clickSearch();

    }
    @Test
    @DisplayName("Test Search Functionality in Admin Page by Role")
    public void testUserSearchByEmployeeName() {
        loginPage.enterUsername("Admin");
        loginPage.enterPassword("admin123");
        loginPage.clickLogin();
         adminPage.typeEmployeeNameAndSelectFirstSearch("J");
        adminPage.clickSearch();

    }






    @AfterEach
    public void tearDown() {
        // Close the browser after each test
        if (driver != null) {
//driver.quit();
        }
    }
}
