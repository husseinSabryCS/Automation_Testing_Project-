package org.example;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Dashboard_ {

    @Test
    public void access(WebDriver driver) {

        String headerText = driver.findElement(By.xpath("//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']")).getText();
        Assert.assertEquals(headerText , "Dashboard");
    }
    @Test
    public void test_Quick_Launch_widget(WebDriver driver) {

        //My Timesheet button
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@title=\"My Timesheet\"]")));
        driver.findElement(By.xpath("//button[@title=\"My Timesheet\"]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6[@class='oxd-text oxd-text--h6 orangehrm-main-title']")));
        String headerText =driver.findElement(By.xpath("//h6[@class='oxd-text oxd-text--h6 orangehrm-main-title']")).getAttribute("innerText");
        Assert.assertEquals(headerText , "My Timesheet");


        //Timesheets
        driver.navigate().back();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@title=\"Timesheets\"]")));
        driver.findElement(By.xpath("//button[@title=\"Timesheets\"]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-level']")));
        headerText =driver.findElement(By.xpath("//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-level']")).getAttribute("innerText");
        Assert.assertEquals(headerText , "Timesheets");

        //Leave List
        driver.navigate().back();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@title=\"Leave List\"]")));
        driver.findElement(By.xpath("//button[@title=\"Leave List\"]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[@class='oxd-text oxd-text--h5 oxd-table-filter-title']")));
        headerText =driver.findElement(By.xpath("//h5[@class='oxd-text oxd-text--h5 oxd-table-filter-title']")).getAttribute("innerText");
        Assert.assertEquals(headerText , "Leave List");

        //My Leave
        driver.navigate().back();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@title=\"My Leave\"]")));
        driver.findElement(By.xpath("//button[@title=\"My Leave\"]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[@class='oxd-text oxd-text--h5 oxd-table-filter-title']")));
        headerText =driver.findElement(By.xpath("//h5[@class='oxd-text oxd-text--h5 oxd-table-filter-title']")).getAttribute("innerText");
        Assert.assertEquals(headerText , "My Leave List");

        //Apply Leave
        driver.navigate().back();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@title=\"Apply Leave\"]")));
        driver.findElement(By.xpath("//button[@title=\"Apply Leave\"]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6[@class='oxd-text oxd-text--h6 orangehrm-main-title']")));
        headerText =driver.findElement(By.xpath("//h6[@class='oxd-text oxd-text--h6 orangehrm-main-title']")).getAttribute("innerText");
        Assert.assertEquals(headerText , "Apply Leave");

        //Assign Leave
        driver.navigate().back();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@title=\"Assign Leave\"]")));
        driver.findElement(By.xpath("//button[@title=\"Assign Leave\"]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6[@class='oxd-text oxd-text--h6 orangehrm-main-title']")));
        headerText =driver.findElement(By.xpath("//h6[@class='oxd-text oxd-text--h6 orangehrm-main-title']")).getAttribute("innerText");
        Assert.assertEquals(headerText , "Assign Leave");

        //my time
        driver.navigate().back();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class=\"oxd-icon-button oxd-icon-button--solid-main orangehrm-attendance-card-action\"]")));
        driver.findElement(By.xpath("//button[@class=\"oxd-icon-button oxd-icon-button--solid-main orangehrm-attendance-card-action\"]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-level']")));
        headerText =driver.findElement(By.xpath("//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-level']")).getAttribute("innerText");
        Assert.assertEquals(headerText , "Attendance");
        // it is cosiderd as a bug as the header should be "Time"


    }


}
