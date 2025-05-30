package com.juaracoding.test;

import java.nio.channels.Pipe.SourceChannel;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class ByLinkText extends BaseTest {

    @Test(enabled = false)
    public void testStep01() throws InterruptedException {
        Thread.sleep(2000);
        WebElement linkPertama = driver.findElement(By.linkText("click here"));
        System.out.println(linkPertama.getAttribute("href"));
        System.out.println(linkPertama.getAttribute("style"));
        // linkPertama.click()

        List<WebElement> daftarLinks = driver.findElements(By.linkText("click here"));

        for (WebElement element : daftarLinks) {
            System.out.println("Link HREF => " + element.getAttribute("href"));
        }

        System.out.println(driver.getTitle());
    }

    @Test(enabled = false)
    public void testStep02() {
        WebElement linkPertama = driver.findElement(By.partialLinkText("here"));
        System.out.println(linkPertama.getAttribute("href"));
        System.out.println(linkPertama.getAttribute("style"));

        List<WebElement> daftarLinks = driver.findElements(By.partialLinkText("go"));
        System.out.println(daftarLinks.size());
    }

    @Test
    public void testStep03() {
        WebElement linkPertama = driver.findElement(By.partialLinkText("tag"));
        System.out.println(linkPertama.getAttribute("href"));
        System.out.println(linkPertama.getAttribute("style"));
        System.out.println(linkPertama.getText());

        System.out.println("---------------------------");

        List<WebElement> daftarLinks = driver.findElements(By.partialLinkText("tag"));
        System.out.println(daftarLinks.size());
    }

}