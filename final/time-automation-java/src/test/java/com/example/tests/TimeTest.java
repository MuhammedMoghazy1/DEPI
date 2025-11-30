
package com.example.tests;

import com.example.pages.LoginPage;
import com.example.pages.TimesheetPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TimeTest {
    private WebDriver driver;
    private LoginPage loginPage;
    private TimesheetPage timesheetPage;

    @BeforeClass
    public void setUp(){

        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        timesheetPage = new TimesheetPage(driver);
        driver.manage().window().maximize();
        System.setProperty("baseUrl", "https://ammar-osondemand.orangehrm.com");
    }

    @Test
    public void testLoginAndOpenTimesheet(){
        driver.get(System.getProperty("baseUrl") + "/auth/login");
        loginPage.enterUsername(System.getProperty("testUser","admin"));
        loginPage.enterPassword(System.getProperty("testPass","admin123"));
        loginPage.clickLogin();
        try { Thread.sleep(3000); } catch (InterruptedException e){}
        timesheetPage.openTimesheet();
        Assert.assertTrue(timesheetPage.isLoaded(), "Timesheet page did not load");
    }

    @AfterClass
    public void tearDown(){
        if(driver != null) driver.quit();
    }
}
