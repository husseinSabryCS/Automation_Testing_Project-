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
    @DisplayName("Test Search Functionality in Admin Page")
    public void testUserSearchByUsername() {
        // Step 1: Login with valid admin credentials
        loginPage.enterUsername("Admin");
        loginPage.enterPassword("admin123");
        loginPage.clickLogin();


        // Step 4: Search by Username
//        adminPage.searchByUsername(username);
//        assertTrue(adminPage.isUserFound(username), "User 'Admin' should be found.");

        // Step 5: Search by Role
        adminPage.searchByRole("ESS");
        assertTrue(adminPage.isSearchResultContainsRole("ESS"), "ESS role users should be found.");
/*
        // Step 6: Search by Employee Name
        adminPage.searchByEmployeeName("Linda");
        assertTrue(adminPage.isUserFound("Linda"), "Employee 'Linda' should be found.");

        // Step 7: Search by Status
        adminPage.searchByStatus("Enabled");
        assertTrue(adminPage.isSearchResultContainsStatus("Enabled"), "Enabled users should be listed.");

        // Step 8: Search without entering any data
        adminPage.clickSearch();
//        assertTrue(adminPage.isSearchResultDisplayed(), "Search should display all users.");

        // Step 9: Search with non-existent data
        adminPage.searchByUsername("NonExistentUser");
        assertTrue(adminPage.isNoRecordFound(), "'No records found' message should be displayed.");

        // Step 10: Combined search with Username and Role
        adminPage.searchByUsernameAndRole("Admin", "Admin");
        assertTrue(adminPage.isUserFound("Admin"), "User 'Admin' with role 'Admin' should be found.");

        // Step 11: Search with partial data (e.g., part of username)
        adminPage.searchByUsername("Adm");
        assertTrue(adminPage.isSearchResultContainsPartialUsername("Adm"), "Users with partial match should be found.");

        // Step 12: Test performance (response time should be reasonable)
        long startTime = System.currentTimeMillis();
        adminPage.clickSearch();
        long endTime = System.currentTimeMillis();
        assertTrue((endTime - startTime) < 3000, "Search should complete in less than 3 seconds.");

        // Step 13: Verify 'No records found' message
        adminPage.searchByUsername("InvalidUser");
        assertTrue(adminPage.isNoRecordFound(), "'No records found' should appear for invalid user.");

        // Step 14: Role-based access check (handled by role-based login logic)
        // Ensure you test this with another user account with limited access.

        // Step 15 & 16: Verify search results and pagination
        assertTrue(adminPage.isPaginationWorking(), "Pagination should work properly.");*/
    }



    @AfterEach
    public void tearDown() {
        // Close the browser after each test
        if (driver != null) {
//driver.quit();
        }
    }
}
