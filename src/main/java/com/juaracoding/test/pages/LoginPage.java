package com.juaracoding.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    @FindBy(name = "uid")
    WebElement usernameField;

    @FindBy(name = "password")
    WebElement passwordField;

    @FindBy(name = "btnLogin")
    WebElement loginButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setUsername(String value) {
        usernameField.sendKeys(value);
    }

    public void setPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void onClick() {
        loginButton.click();
    }

    public void onLogin(String username, String password) throws InterruptedException {
        Thread.sleep(2000);
        setUsername(username);
        Thread.sleep(2000);
        setPassword(password);
        Thread.sleep(2000);
        onClick();
    }
}
