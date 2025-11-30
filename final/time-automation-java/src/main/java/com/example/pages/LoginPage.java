
package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    private By username = By.name("username");
    private By password = By.name("password");
    private By loginBtn = By.xpath("//button[@type='submit']");

    public LoginPage(WebDriver driver){ this.driver = driver; }

    public void enterUsername(String user){ driver.findElement(username).sendKeys(user); }
    public void enterPassword(String pass){ driver.findElement(password).sendKeys(pass); }
    public void clickLogin(){ driver.findElement(loginBtn).click(); }
}
