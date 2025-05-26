package com.juaracoding.test;

import java.time.Duration;

import javax.xml.crypto.dom.DOMURIReference;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ActionTest extends BaseTest {

    @Test(enabled = false)
    public void testStep01() throws InterruptedException {
        WebElement linkHome = driver.findElement(By.linkText("Home"));
        Actions builder = new Actions(driver);

        Action moveToHome = builder.moveToElement(linkHome).build();
        moveToHome.perform();
        Thread.sleep(10000);
    }

    @Test(enabled = false)
    public void testStep02() {
        WebElement linkHome = driver.findElement(By.linkText("Home"));
        WebElement inputUsername = driver.findElement(By.xpath("//*[@name='userName']"));
        WebElement inputPassword = driver.findElement(By.xpath("//*[@name='password']"));
        Actions builder = new Actions(driver);

        Action moveToHome = builder.moveToElement(linkHome)
                .pause(Duration.ofSeconds(2))
                .moveToElement(inputUsername)
                .pause(Duration.ofSeconds(2))
                .click()
                .sendKeys("Auah")
                .pause(Duration.ofSeconds(2))
                .build();
        moveToHome.perform();
    }

}
