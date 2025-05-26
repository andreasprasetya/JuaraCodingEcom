package com.juaracoding.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RadioTest extends BaseTest {
    WebElement radio1;
    WebElement radio2;

    @Test
    public void initElementTest() {
        radio1 = driver.findElement(By.id("vfb-7-1"));
        radio2 = driver.findElement(By.id("vfb-7-2"));
    }

    @Test
    public void testStep01() {
        radio1.click();
        Assert.assertTrue(radio1.isSelected());
    }

    @Test
    public void testStep02() {
        radio2.click();
        Assert.assertFalse(radio1.isSelected());
    }

    // https://prod.liveshare.vsengsaas.visualstudio.com/join?F892AE9B337EDCF4C9CF89686BF172672F6A
}
