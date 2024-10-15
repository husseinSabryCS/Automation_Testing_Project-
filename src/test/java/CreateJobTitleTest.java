import Pages.JobTitlePage;
import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CreateJobTitleTest {

    WebDriver driver;
   private JobTitlePage jobTitlePage;
    private LoginPage loginPage;
    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
//        LoginPage loginPage = new LoginPage(driver);
        driver.manage().window().maximize();
        loginPage.open();
        loginPage.enterUsername("Admin");
        loginPage.enterPassword("admin123");
        loginPage.clickLogin();
driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/admin/viewJobTitleList");

        // Initialize the JobTitlePage object
        jobTitlePage = new JobTitlePage(driver);
    }

    @Test
    public void createJobTitleWithDescriptionAndUploadFile() throws InterruptedException {
        // Login with valid admin account


        // اضغط على زر "Add"
        jobTitlePage.clickAddButton();

        // أدخل تفاصيل الوظيفة
        String jobTitle = "Senior Software Engineer";
        jobTitlePage.enterJobTitle(jobTitle);

        String description = "Responsible for developing and maintaining software solutions.";
        jobTitlePage.enterJobDescription(description);

        // ارفع الملف
        String filePath = "C:/Users/omare/Desktop/job_specifications.txt";
        jobTitlePage.uploadJobSpecFile(filePath);

        // اضغط على "Save"
        jobTitlePage.clickSaveButton();

        // انتظر 2 ثانية للتأكد من حفظ البيانات
        Thread.sleep(2000);
    }

    @AfterTest
    public void tearDown() {
//        driver.quit();
    }
}
