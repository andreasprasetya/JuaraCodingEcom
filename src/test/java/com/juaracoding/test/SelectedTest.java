package com.juaracoding.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class SelectedTest extends BaseTest {
    Select selectBox;
    WebElement selectorBox;

    @Test
    public void initElementTest() {
        selectorBox = driver.findElement(By.name("country"));
        selectBox = new Select(selectorBox);
    }

    @Test
    public void testStep01() throws InterruptedException {
        Thread.sleep(1000);
        selectBox.selectByVisibleText("INDONESIA");
    }

    @Test
    public void testStep02() throws InterruptedException {
        Thread.sleep(1000);
        selectBox.selectByIndex(1);
    }

    @Test
    public void testStep03() throws InterruptedException {
        Thread.sleep(1000);
        // selectorBox
        selectBox.deselectByIndex(1);
    }

    public static class ByLinkText {
    }
}
