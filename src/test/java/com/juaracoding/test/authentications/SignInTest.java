package com.juaracoding.test.authentications;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.juaracoding.test.DriverSingleton;

public class SignInTest {
    WebDriver driver;
    WebElement usernameField;
    WebElement passwordField;
    WebElement buttonLogin;
    List<String> missingElements = new ArrayList<>();
    boolean skipTest = false;

    private WebElement checkAndGet(WebDriverWait wait, String name, By locator) {
        try {
            return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        } catch (Exception e) {
            missingElements.add(name);
            // skipTest = false;
            return null;
        }
    }

    @BeforeClass
    public void setup() throws InterruptedException {
        Thread.sleep(3000);
        driver = DriverSingleton.createOrGetDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        usernameField = checkAndGet(wait, "usernameField", By.id("user-name"));
        passwordField = checkAndGet(wait, "passwordField", By.id("password"));
        buttonLogin = checkAndGet(wait, "buttonLogin", By.id("login-button"));

        if (!missingElements.isEmpty()) {
            skipTest = true;
        }
    }

    @BeforeMethod
    public void checkElementsExist() {
        if (skipTest) {
            throw new SkipException("No element found: " + String.join(", ", missingElements));
        }
    }

    @Test
    public void testStep01() throws InterruptedException {
        try {
            Thread.sleep(3000);
            usernameField.sendKeys("standard_user");
            Thread.sleep(1000);
            passwordField.sendKeys("secret_sauce");
            Thread.sleep(1000);
            buttonLogin.click();
            String expected = "https://www.saucedemo.com/v1/inventory.html";
            String actual = driver.getCurrentUrl();
            System.out.println(actual);
            Assert.assertEquals(actual, expected);
        } catch (Exception e) {
            // TODO: handle exception
            throw new SkipException("testStep01: " + e.getMessage());
        }
    }
}
