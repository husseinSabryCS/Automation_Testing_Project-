package Pages;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
    // Click "Add User" Button
    public void clickAddUser() {
        waitUntilClickable(addUserButton).click();
    }
    private final By usernameField = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[4]/div/div[2]/input");
    // Enter Username
    public void enterUsername(String username) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField));
        waitUntilVisible(usernameField).sendKeys(username);
    }
    private final By employeeNameLocator = By.cssSelector("input[placeholder='Type for hints...']");

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

    private final By passwordField = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[1]/div/div[2]/input");

    // Enter Password
    public void enterPassword(String password) {
        waitUntilVisible(passwordField).sendKeys(password);
    }
    private final By confirmPasswordField = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[2]/div/div[2]/input");

    // Enter Confirm Password
    public void enterConfirmPassword(String confirmPassword) {
        waitUntilVisible(confirmPasswordField).sendKeys(confirmPassword);
    }
    private final By statusDropdown = By.xpath("(//div[@class='oxd-select-text-input'])[2]");

    // Select Status from Dropdown
    public void selectStatus(String status) {

        waitUntilClickable(statusDropdown).click();
        waitUntilClickable(By.xpath("//span[text()='" + status + "']")).click();
    }
    private final By roleDropdown = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[1]/div/div[2]/div/div/div[1]");

    // Select Role from Dropdown
    public void


    selectRole(String role) {
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
    private final By saveButton = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[3]/button[2]");

    // Click Save Button
    public void clickSave() {
        waitUntilClickable(saveButton).click();
    }


    private final By usernameFieldsearch = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[1]/div/div[2]/input");

    // Search by Username
    public void searchByUsername(String username) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameFieldsearch));
        waitUntilVisible(usernameFieldsearch).sendKeys(username);

        clickSearch();
    }
    private final By systemUsers = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[2]/div[3]");

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
    private final By StatusLocatorsearch = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[4]/div/div[2]/div/div/div[1]");
    public void selectStatussearch(String status) {
        waitUntilClickable(StatusLocatorsearch).click();
        waitUntilClickable(By.xpath("//span[text()='" + status + "']")).click();
}
    private final By roleDropdownsearch  = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[2]/div/div[2]/div/div/div[1]");

    public void selectRoleSearch(String role) {
        // Wait for the role dropdown to become clickable
        WebElement roleDropdownElement = waitUntilClickable(roleDropdownsearch);
        roleDropdownElement.click(); // Open the dropdown

        // Wait for the dropdown options to load
        By dropdownOptionsLocator = By.xpath("//div[contains(@class, 'oxd-select-dropdown')]//span[text()='" + role + "']");
        WebElement roleOption = waitUntilClickable(dropdownOptionsLocator);

        // Scroll into view and click the role option
        Actions actions = new Actions(driver);
        actions.moveToElement(roleOption).click().perform();
    }




    private final By employeeDropdownOptionsLocator = By.xpath("//div[@role='listbox']//span");



    private final By adminMenu = By.xpath("//span[text()='Admin']");
    private final By employeeNameField = By.xpath("//input[@placeholder='Type for hints...']");
    private final By searchButton = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[2]/button[2]");
    private final By noRecordMessage = By.xpath("//div[text()='No Records Found']");










    private  final By employeeNameLocatorSearch =By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[3]/div/div[2]/div/div/input");
    private final By employeeDropdownOptionsLocatorSearch=By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[3]/div/div[2]/div/div/input");
    public void typeEmployeeNameAndSelectFirstSearch(String employeeName) {
        // Type the employee name (partial name)
        WebElement employeeNameInput = driver.findElement(employeeNameLocatorSearch);
        employeeNameInput.sendKeys(employeeName);  // Type the partial employee name

        // Wait for the dropdown to populate and become visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Increase the wait time if necessary
        wait.until(ExpectedConditions.visibilityOfElementLocated(employeeDropdownOptionsLocatorSearch));

        // Get all options from the dropdown
        List<WebElement> dropdownOptions = driver.findElements(employeeDropdownOptionsLocatorSearch);

        // Check if the dropdown has any options, then click the first one
        if (!dropdownOptions.isEmpty()) {
            WebElement firstOption = dropdownOptions.get(0);  // Get the first option in the list
            firstOption.click();  // Select the first employee
        } else {
            System.out.println("No options available in the dropdown");
        }

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


    // Search by Role
    public void searchByRole(String role) {
        // 1. افتح القائمة المنسدلة
        waitUntilClickable(roleDropdownsearch).click();

        // 2. ابحث عن الخيارات المتاحة داخل القائمة
        List<WebElement> roleOptions = wait.until(ExpectedConditions
                .visibilityOfAllElementsLocatedBy(By.xpath("//div[contains(@class, 'oxd-select-option')]")));

        // 3. تحقق وابحث عن الخيار المطلوب بناءً على النص
        for (WebElement option : roleOptions) {
            if (option.getText().trim().equalsIgnoreCase(role)) {
                option.click(); // انقر على الخيار
                break;
            }
        }

        // 4. انقر على زر البحث
    }


    // Click Search button
    public void clickSearch() {
        driver.findElement(searchButton).click();
    }


}

