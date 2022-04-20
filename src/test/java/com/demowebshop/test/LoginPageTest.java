package com.demowebshop.test;

import com.demowebshop.automationcore.Base;
import com.demowebshop.pages.HomePage;
import com.demowebshop.pages.LoginPage;
import com.demowebshop.pages.MyAccountPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends Base {
    HomePage home;
    LoginPage login;
    MyAccountPage account;

    @Test(priority = 2,enabled = true,description = "TC_001_verifyPageLogin")
    public void verifyPageLogin(){
        home=new HomePage(driver);
        login=home.clickOnLoginMenu();
        login.enterLoginEmail("suryasomaraj94@gmail.com");
        login.enterLoginPassword("qwerty@123");
        account=login.clickOnLoginButton();
        String actual=account.getUserName();
        String expected="suryasomaraj94@gmail.com";
        Assert.assertEquals(actual,expected,"User Login Failed");
    }
}
