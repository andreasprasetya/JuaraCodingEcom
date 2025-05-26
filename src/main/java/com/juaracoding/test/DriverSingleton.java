package com.juaracoding.test;

import org.openqa.selenium.WebDriver;

public class DriverSingleton {
    public static WebDriver driver;

    public static WebDriver createOrGetDriver() {
        if (driver == null) {
            driver = BrowserManager.build();
        }

        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
