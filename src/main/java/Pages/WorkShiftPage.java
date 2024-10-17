package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class WorkShiftPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // تعريف الـ Locators في الأعلى
    private final By addButton = By.xpath("//button[@class=\"oxd-button oxd-button--medium oxd-button--secondary\"]");
    private final By shiftNameInput = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div/div/div[2]/input");
    private final By fromInput = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[1]/div/div[2]/div/div/input");
    private final By toInput = By.xpath("(//input[@placeholder='hh:mm'])[2]");
    private final By employeeInput = By.xpath("//input[@placeholder='Type for hints...']");
    private final By saveButton = By.xpath("//button[@type=\"submit\"]");

    public WorkShiftPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickAddButton() {
        WebElement addButtonElement = wait.until(ExpectedConditions.visibilityOfElementLocated(addButton));
        addButtonElement.click();
    }

    public void enterShiftName(String shiftName) {
        WebElement shiftNameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(shiftNameInput));
        shiftNameElement.sendKeys(shiftName);
    }

    public void setWorkingHours(String fromTime, String toTime) {
        // انتظار وضمان أن الحقل "من" جاهز للتفاعل
        WebElement fromInputElement = wait.until(ExpectedConditions.elementToBeClickable(fromInput));
        fromInputElement.clear();  // مسح المحتوى إن وجد
        fromInputElement.sendKeys(fromTime);

        // انتظار وضمان أن الحقل "إلى" جاهز للتفاعل
        WebElement toInputElement = wait.until(ExpectedConditions.elementToBeClickable(toInput));
        toInputElement.clear();  // مسح المحتوى إن وجد
        toInputElement.sendKeys(toTime);
    }


    public void assignEmployee(String employeeName) {
        // إدخال أول حرف من اسم الموظف
        WebElement employeeInputElement = wait.until(ExpectedConditions.visibilityOfElementLocated(employeeInput));
        employeeInputElement.sendKeys(employeeName.substring(0, 1));

        // انتظار ظهور الاقتراحات
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@role='option']")));

        // اختيار أول اقتراح
        WebElement firstSuggestion = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[@role='option'][1]")));
        firstSuggestion.click();
    }


    public void clickSave() {
        WebElement saveButtonElement = wait.until(ExpectedConditions.elementToBeClickable(saveButton));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", saveButtonElement);
    }



    public boolean isShiftAdded(String shiftName) {
        try {
            // الانتظار حتى يظهر العنصر الذي يحتوي على اسم الشيفت المضاف
            WebElement shiftElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//div[contains(text(),'" + shiftName + "')]")));
            return shiftElement.isDisplayed(); // إذا ظهر العنصر، نرجع true
        } catch (Exception e) {
            return false; // إذا لم يظهر العنصر، نرجع false
        }
    }

}
