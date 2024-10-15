package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class JobTitlePage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Locators
    private final By addButton = By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary']");
    private final By jobTitleField = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/input");
    private final By jobDescriptionField = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[2]/textarea");
    private final By jobSpecFileUpload = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[2]/textarea");
    private final By saveButton = By.xpath("//button[@class=\"oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space\"]");

    // Constructor
    public JobTitlePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // WebDriverWait initialization
    }

    // Methods for interacting with the page
    public void clickAddButton() {
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(addButton));
        button.click();
    }

    public void enterJobTitle(String jobTitle) {
        WebElement titleField = wait.until(ExpectedConditions.visibilityOfElementLocated(jobTitleField));
//        titleField.clear();  // Optional: clear the field before entering text
        titleField.sendKeys(jobTitle);
    }

    public void enterJobDescription(String description) {
        WebElement descriptionField = wait.until(ExpectedConditions.visibilityOfElementLocated(jobDescriptionField));
        descriptionField.clear();  // Optional: clear the field before entering text
        descriptionField.sendKeys(description);
    }

    public void uploadJobSpecFile(String filePath) {
        WebElement uploadField = wait.until(ExpectedConditions.presenceOfElementLocated(jobSpecFileUpload));
        uploadField.sendKeys(filePath);  // Send the file path directly to the input field
    }

    public void clickSaveButton() {
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(saveButton));
        button.click();
    }
}
