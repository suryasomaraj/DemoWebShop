package com.demowebshop.test;

import com.demowebshop.Utilities.ExcelUtility;
import com.demowebshop.Utilities.RandomDataUtility;
import com.demowebshop.automationcore.Base;
import com.demowebshop.pages.HomePage;
import com.demowebshop.pages.MyAccountPage;
import com.demowebshop.pages.RegisterPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class RegisterPageTest extends Base {
    HomePage home;
    RegisterPage register;
    MyAccountPage account;
    ExcelUtility excel = new ExcelUtility();
    RandomDataUtility randomData = new RandomDataUtility();

    @Test(priority = 4, enabled = true, description = "TC_001_verifyLoginPageTitle",groups = {"sanity"})
    public void verifyRegistration() throws IOException {
        home = new HomePage(driver);
        register = home.clickOnRegisterMenu();
        List<String> dataS = excel.readDataFromExcel("\\src\\main\\resources\\TestData.xlsx", "RegisterPage");
        System.out.println(dataS);
        register.selectGender("Female");
        register.enterFirstName(dataS.get(4));
        register.enterLastName(dataS.get(5));
        String email = randomData.random();
        register.enterEmail(email);
        register.enterPassword(dataS.get(6));
        register.enterConfirmPassword(dataS.get(7));
        account = register.clickRegisterButton();
        String actual = account.getRegisterEmail();
        String expected = email;
        Assert.assertEquals(actual, expected, "Registration Failed");
    }
}
