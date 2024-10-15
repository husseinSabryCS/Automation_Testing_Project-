package Pages;

import org.openqa.selenium.*;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AdminPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    // Constructor for WebDriver and WebDriverWait
    public AdminPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Element Locators
    private final By addUserButton = By.xpath("//button[text()=' Add ']");
    private final By usernameField = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[4]/div/div[2]/input");
    private final By roleDropdown = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/div/div/div[1]");
    private final By employeeNameLocator = By.cssSelector("input[placeholder='Type for hints...']");
    private final By employeeDropdownOptionsLocator = By.xpath("//div[@role='listbox']//span");
    private final By passwordField = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[1]/div/div[2]/input");
    private final By confirmPasswordField = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[2]/div/div[2]/input");
    private final By statusDropdown = By.xpath("(//div[@class='oxd-select-text-input'])[2]");
    private final By saveButton = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[3]/button[2]");
//search locators
    private final By adminMenu = By.xpath("//span[text()='Admin']");
    private final By systemUsers = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]");
    private final By usernameFieldsearch = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/input");
    private final By roleDropdownsearch  = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[2]/div/div[2]/div/div/div[1]");
    private final By employeeNameField = By.xpath("//input[@placeholder='Type for hints...']");
    private final By statusDropdownsearch  = By.xpath("//select[@name='status']");
    private final By searchButton = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button[2]");
    private final By noRecordMessage = By.xpath("//div[text()='No Records Found']");
    private final By paginationNext = By.xpath("//a[text()='Next']");
    // Click "Add User" Button
    public void clickAddUser() {
        waitUntilClickable(addUserButton).click();
    }

    // Enter Username
    public void enterUsername(String username) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField));
        waitUntilVisible(usernameField).sendKeys(username);
    }

    // Select Role from Dropdown
    public void selectRole(String role) {
        // Wait for the role dropdown to become clickable
        WebElement roleDropdownElement = waitUntilClickable(roleDropdown);
        roleDropdownElement.click(); // Open the dropdown

        // Wait for the dropdown options to load
        By dropdownOptionsLocator = By.xpath("//div[contains(@class, 'oxd-select-dropdown')]//span[text()='" + role + "']");
        WebElement roleOption = waitUntilClickable(dropdownOptionsLocator);

        // Scroll into view and click the role option
        Actions actions = new Actions(driver);
        actions.moveToElement(roleOption).click().perform();
    }

    // Select Status from Dropdown
    public void selectStatus(String status) {
        waitUntilClickable(statusDropdown).click();
        waitUntilClickable(By.xpath("//span[text()='" + status + "']")).click();
    }

    // Type Employee Name and Select First Option from Suggestions
    public void typeEmployeeNameAndSelectFirst(String employeeName) {
        WebElement employeeInput = waitUntilVisible(employeeNameLocator);
        employeeInput.sendKeys(employeeName);

        wait.until(ExpectedConditions.visibilityOfElementLocated(employeeDropdownOptionsLocator));
        List<WebElement> options = driver.findElements(employeeDropdownOptionsLocator);

        if (!options.isEmpty()) {
            options.get(0).click();
        } else {
            System.out.println("No employee options available.");
        }
    }

    // Enter Password
    public void enterPassword(String password) {
        waitUntilVisible(passwordField).sendKeys(password);
    }

    // Enter Confirm Password
    public void enterConfirmPassword(String confirmPassword) {
        waitUntilVisible(confirmPasswordField).sendKeys(confirmPassword);
    }



    // Click Save Button
    public void clickSave() {
        waitUntilClickable(saveButton).click();
    }

    // Helper Method to Wait for Element to be Clickable
    private WebElement waitUntilClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    // Helper Method to Wait for Element to be Visible
    private WebElement waitUntilVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // Navigate to System Users section
    public void navigateToSystemUsers() {
        wait.until(ExpectedConditions.elementToBeClickable(adminMenu)).click();
        wait.until(ExpectedConditions.elementToBeClickable(systemUsers)).click();
    }

    // Search by Username
    public void searchByUsername(String username) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameFieldsearch));
        waitUntilVisible(usernameFieldsearch).sendKeys(username);

        clickSearch();
    }

    // Search by Role
    public void searchByRole(String role) {
        // 1. افتح القائمة المنسدلة
        waitUntilClickable(roleDropdownsearch).click();

        // 2. انتظر حتى يظهر العنصر المطلوب بناءً على النص (role)
        WebElement roleOption = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[contains(@class, 'oxd-select-option') and text()='" + role + "']")));

        // 3. انقر على الخيار من القائمة
        roleOption.click();

        // 4. انقر على زر البحث
        clickSearch();
    }

    // Search by Employee Name
    public void searchByEmployeeName(String employeeName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(employeeNameField)).sendKeys(employeeName);
        clickSearch();
    }

    // Search by Status
    public void searchByStatus(String status) {
        wait.until(ExpectedConditions.elementToBeClickable(statusDropdown)).sendKeys(status);
        clickSearch();
    }

    // Combined Search
    public void searchByUsernameAndRole(String username, String role) {
        searchByUsername(username);
        searchByRole(role);
    }

    // Click Search button
    public void clickSearch() {
        driver.findElement(searchButton).click();
    }

    // Check if user is found
    // Check if the user is found in the table
    public boolean isUserFound(String username) {
        // Wait for the table to be visible
        wait.until(ExpectedConditions.visibilityOfElementLocated(systemUsers));

        // XPath for the first row's username column
        By firstRowUsername = By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div/div/div[2]/div");

        // Wait for the first row to be visible
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstRowUsername));

        // Verify the text matches the expected username
        String displayedUsername = driver.findElement(firstRowUsername).getText();
        return displayedUsername.equals(username);
    }

    // Check if search result contains partial username
    public boolean isSearchResultContainsPartialUsername(String partialUsername) {
        List<WebElement> results = driver.findElements(By.xpath("//td[contains(text(), '" + partialUsername + "')]"));
        return !results.isEmpty();
    }

    // Check if no records found
    public boolean isNoRecordFound() {
        return driver.findElement(noRecordMessage).isDisplayed();
    }

    // Check if pagination works
    public boolean isPaginationWorking() {
        return driver.findElement(paginationNext).isDisplayed();
    }

    // Check if search result contains the specified role
    public boolean isSearchResultContainsRole(String role) {
        return driver.findElement(By.xpath("//td[text()='" + role + "']")).isDisplayed();
    }

    // Check if search result contains the specified status
    public boolean isSearchResultContainsStatus(String status) {
        return driver.findElement(By.xpath("//td[text()='" + status + "']")).isDisplayed();
    }


}
