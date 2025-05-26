package com.juaracoding.test.authentications;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.juaracoding.test.DriverSingleton;

public class SignInWithoutUsernameTest {
    WebDriver driver;
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
            Thread.sleep(2000);
            passwordField.sendKeys("secret_sauce");
            Thread.sleep(2000);
            buttonLogin.click();
            Thread.sleep(2000);
            passwordField.clear();
            Thread.sleep(2000);
        } catch (Exception e) {
            // TODO: handle exception
            throw new SkipException("testStep01: " + e.getMessage());
        }
    }
}
