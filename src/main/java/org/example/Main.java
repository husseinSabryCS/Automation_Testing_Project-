package org.example;

//import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();


            // Navigate to the login page
            driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

            // Create a WebDriverWait instance
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // Wait for the username field to be visible and interactable
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='username']")));
            driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");

            // Wait for the password field to be visible
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='password']")));
            driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");

            // Wait for the submit button to be clickable
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")));
            driver.findElement(By.xpath("//button[@type='submit']")).click();


        driver.manage().window().maximize();
        Navigationn navigation= new Navigationn( );
        Dashboard_ dash= new Dashboard_();
        dash.test_Quick_Launch_widget(driver);
        navigation.return_main(driver);
        navigation.Admin(driver);
        navigation.return_main(driver);

        //navigation.test_post_creation(driver);
        //navigation.return_main(driver);
        navigation.test_maintenance_access_emp_data(driver);
        navigation.return_main(driver);
        navigation.test_directory_Search(driver);
        navigation.return_main(driver);
        navigation.test_Add_Performance_Tracker(driver);
        navigation.return_main(driver);
        navigation.test_user_info(driver);
         navigation.return_main(driver);

         //dash.access(driver);
         // navigation.return_main(driver);


         //navigation.return_main(driver);

//driver.quit();
    }
}