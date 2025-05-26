package com.juaracoding.test.inventories;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
// import org.testng.annotations.BeforeClass;
// import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.juaracoding.test.DriverSingleton;

public class InventoryListTest {

    @Test(priority = 1)
    public void getAllElementTitleTest() {
        List<WebElement> collections = DriverSingleton.createOrGetDriver().findElements(By.className("inventory_item_name"));
        /**
         * Tambahan loop judul (traversing)
         */
        for (WebElement element: collections) {
            System.out.println("Judul: " + element.getText());
        }

        Assert.assertTrue(collections.size() > 0, "Judul tidak tersedia");
    }

    @Test(priority = 2)
    public void getAllElementPriceTest() {
        List<WebElement> collections = DriverSingleton.createOrGetDriver().findElements(By.className("inventory_item_price"));
        /**
         * Tambahan loop harga (traversing)
         */
        for (WebElement element: collections) {
            System.out.println("Harga: " + element.getText());
        }
        if (collections.size() > 0) {
            System.out.println("Horeee benar! pengujian sukses ualalal be");
        }
        Assert.assertTrue(collections.size() > 0, "Harga tidak tersedia!");
    }
}
