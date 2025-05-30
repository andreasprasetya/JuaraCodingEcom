package com.juaracoding.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.juaracoding.test.pages.HomePage;
import com.juaracoding.test.pages.LoginPage;

public class SignInTest extends BaseTest {
    LoginPage loginPage;
    HomePage homePage;

    @Test
    public void testStep01() {
        System.out.println(driver.getCurrentUrl());
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
    }

    @Test
    public void testStep02() throws InterruptedException {
        loginPage.onLogin("mngr623497", "nuganEh");
        System.out.println(driver.getCurrentUrl());
    }

    @Test
    public void testStep03() {
        String actual = homePage.getHeding();
        String expected = "Manger Id : mngr623497";

        Assert.assertEquals(actual, expected);
    }
}