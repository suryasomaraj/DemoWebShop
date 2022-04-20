package com.demowebshop.test;

import com.demowebshop.automationcore.Base;
import com.demowebshop.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends Base {
    HomePage home;
    @Test(priority = 2,enabled = true,description = "TC_001_verifyHomePageTitle")
    public void verifyHomePageTitle(){
        home=new HomePage(driver);
        String actualTitle= home.getHomePageTitle();
        String expectedTitle="Demo Web Shop";
        Assert.assertEquals(actualTitle,expectedTitle,"Invalid Home Page Title");
    }
  /*  public void verifyPageLogin(){
        home=new HomePage(driver);
        login=home.clickOnLoginMenu();
        login.enterLoginEmail("suryasomaraj94@gmail.com");
        login.enterLoginPassword("qwerty@123");
        account=login.clickOnLoginButton();
        String actual=account.getUserName();
        String expected="suryasomaraj94@gmail.com";
        Assert.assertEquals(actual,expected,"User Login Failed");
    }*/

}
