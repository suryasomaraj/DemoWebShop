package com.demowebshop.test;

import com.demowebshop.Utilities.ExcelUtility;
import com.demowebshop.automationcore.Base;
import com.demowebshop.pages.HomePage;
import com.demowebshop.pages.LoginPage;
import com.demowebshop.pages.MyAccountPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class LoginPageTest extends Base {
    HomePage home;
    LoginPage login;
    MyAccountPage account;
    ExcelUtility excel=new ExcelUtility();

    @Test(priority = 2,enabled = true,description = "TC_001_verifyPageLogin",groups = {"sanity"})
    public void verifyPageLogin() throws IOException {
        home=new HomePage(driver);
        login=home.clickOnLoginMenu();
        List<String> dataS=excel.readDataFromExcel("\\src\\main\\resources\\TestData.xlsx","LoginPage");
        login.enterLoginEmail(dataS.get(3));
        login.enterLoginPassword(dataS.get(4));
        account=login.clickOnLoginButton();
        String actual=account.getUserName();
        String expected=dataS.get(3);
        Assert.assertEquals(actual,expected,"User Login Failed");
    }

    @Test(priority = 3,enabled = true,description = "TC_001_verifyLoginPageTitle",groups = {"smoke"})
    public void verifyLoginPageTitle() throws IOException {
        home=new HomePage(driver);
        login=home.clickOnLoginMenu();
        List<String> dataS=excel.readDataFromExcel("\\src\\main\\resources\\TestData.xlsx","LoginPage");
        String actualTitle =login.getLoginPageTitle();
        String expectedTitle = dataS.get(5);
        Assert.assertEquals(actualTitle,expectedTitle,"Page title not equal");
    }
}
