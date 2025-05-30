package com.juaracoding.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CheckboxTest extends BaseTest {
    WebElement option1;
    WebElement option2;

    @Test
    public void initElementTest() {
        option1 = driver.findElement(By.id("vfb-6-0"));
        option2 = driver.findElement(By.id("vfb-6-1"));
    }

    @Test
    public void testStep01() {
        option1.click();
        Assert.assertTrue(option1.isSelected());
    }

    @Test
    public void testStep02() {
        option2.click();
        Assert.assertTrue(option2.isSelected());
    }
}