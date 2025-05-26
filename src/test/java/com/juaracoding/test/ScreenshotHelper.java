package com.juaracoding.test;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

public class ScreenshotHelper {
    public static void takeScreenshot(String fileName, WebDriver driver) {
        try {
            // menyiapkan direktori khusus naro screnshoot
            String screenshotDir = System.getProperty("user.dir") + "/screenshots";
            Files.createDirectories(Paths.get(screenshotDir));

            // Penyimanan file screenshot
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String filePath = screenshotDir + "/" + fileName;
            File destFile = new File(filePath);

            FileUtils.copyFile(srcFile, destFile);

            // Log ke report testng
            Reporter.log("<a href='" + filePath + "' target='_blank'>Screnshoot</a>");
            Reporter.log("<br /><img src='" + filePath + "' style='width: 20vw;' />");

        } catch (Exception e) {
            // TODO: handle exception
            Reporter.log("Gagal ngambil screenshot: " + e.getMessage());
        }
    }
}
