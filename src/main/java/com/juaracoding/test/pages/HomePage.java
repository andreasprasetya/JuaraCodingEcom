package com.juaracoding.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;
    @FindBy(xpath = "/html/body/table/tbody/tr/td/table/tbody/tr[3]/td")
    WebElement heading;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getHeding() {
        return heading.getText();
    }
}
//https://prod.liveshare.vsengsaas.visualstudio.com/join?7FB0374FCF7F47D68E91F281D65426541DFB