package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LogoutPage {
    private final WebDriver driver;

    // Elements related to the Logout button
    private final By userMenu = By.xpath("//p[@class='oxd-userdropdown-name']");
    private final By logoutButton = By.xpath("//a[text()='Logout']");

    // Constructor to pass the WebDriver
    public LogoutPage(WebDriver driver) {
        this.driver = driver;
    }

    // Click on the user menu
    public void openUserMenu() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement menu = wait.until(ExpectedConditions.elementToBeClickable(userMenu));
        menu.click();
    }

    // Perform the logout operation
    public void clickLogout() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement logout = wait.until(ExpectedConditions.elementToBeClickable(logoutButton));
        logout.click();
    }

    // Verify redirection to the login page
    public boolean isAtLoginPage() {
        return driver.getCurrentUrl().contains("auth/login");
    }
}
