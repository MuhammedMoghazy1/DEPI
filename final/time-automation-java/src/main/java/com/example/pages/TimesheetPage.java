
package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TimesheetPage {
    private WebDriver driver;
    private By timesheetMenu = By.id("menu_time_viewTimeModule");
    private By myTimesheetUrl = By.cssSelector("a[href*='viewMyTimesheet']");

    public TimesheetPage(WebDriver driver){ this.driver = driver; }

    public void openTimesheet(){ 

        driver.get(System.getProperty("baseUrl") + "/time/viewMyTimesheet"); 
    }

    public boolean isLoaded(){
        return driver.getTitle().toLowerCase().contains("timesheet") || driver.getPageSource().contains("Timesheets");
    }
}
