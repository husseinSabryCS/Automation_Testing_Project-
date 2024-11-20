package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PunchInPage {
    private final WebDriver driver;

    // Elements on the Punch In page
    private final By dateField = By.xpath("//input[@class='oxd-input oxd-input--active']");
    private final By timeField = By.xpath("//input[@placeholder='hh:mm']");
    private final By noteField = By.xpath("//textarea[@class='oxd-textarea oxd-textarea--active oxd-textarea--resize-vertical']");
    private final By punchInButton = By.xpath("//button[@type='submit']");

    // Constructor to pass the WebDriver
    public PunchInPage(WebDriver driver) {
        this.driver = driver;
    }

    // Open the Punch In page
    public void open() {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/attendance/proxyPunchInPunchOut?employeeId=69&date=2024-10-13");
    }

    // Enter the date
    public void enterDate(String date) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement dateFieldElement = wait.until(ExpectedConditions.visibilityOfElementLocated(dateField));
        dateFieldElement.clear();
        dateFieldElement.sendKeys(date);
    }

    // Enter the time
    public void enterTime(String time) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement timeFieldElement = wait.until(ExpectedConditions.visibilityOfElementLocated(timeField));
        timeFieldElement.clear();
        timeFieldElement.sendKeys(time);
    }



    // Enter the note
    public void enterNote(String note) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement noteFieldElement = wait.until(ExpectedConditions.visibilityOfElementLocated(noteField));
        noteFieldElement.sendKeys(note);
    }

    // Click the punch in button
    public void clickPunchInButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement punchInButtonElement = wait.until(ExpectedConditions.elementToBeClickable(punchInButton));
        punchInButtonElement.click();
    }
}