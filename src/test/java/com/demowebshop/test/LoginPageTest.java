package com.demowebshop.test;

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
    @Test
    public void getExcelRead() throws IOException {
        LoginPage login=new LoginPage(driver);
        List<String> dataS=login.getExpectedExcelData();
        System.out.println(dataS.get(3));
    }
    @Test
    public void verifyDataLoginPage() throws IOException {
        home=new HomePage(driver);
        login=home.clickOnLoginMenu();
        List<String> dataS=login.getExpectedExcelData();
        login.enterLoginEmail(dataS.get(3));
        login.enterLoginPassword(dataS.get(4));
        account=login.clickOnLoginButton();
        String actual=account.getUserName();
        String expected=dataS.get(3);
        Assert.assertEquals(actual,expected,"User Login Failed");
    }
    @Test
    public void verifyLoginPageTitle() {
        home=new HomePage(driver);
        login=home.clickOnLoginMenu();
        String expectedTitle = "Demo Web Shop. Login";
        String actualTitle =login.getLoginPageTitle();
        Assert.assertEquals(actualTitle,expectedTitle,"Page title not equal");
    }
}
