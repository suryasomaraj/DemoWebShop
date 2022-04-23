package com.demowebshop.test;

import com.demowebshop.automationcore.Base;
import com.demowebshop.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class HomePageTest extends Base {
    HomePage home;

    @Test(priority = 1,enabled = true,description = "TC_001_verifyHomePageTitle",groups = {"smoke"})
    public void verifyHomePageTitle() throws IOException {
        home=new HomePage(driver);
        String actualTitle= home.getHomePageTitle();
        String expectedTitle="Demo Web Shop";
        Assert.assertEquals(actualTitle,expectedTitle,"Invalid Home Page Title");
    }
}
