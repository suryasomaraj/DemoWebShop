package com.demowebshop.pages;

import com.demowebshop.Utilities.ObjectUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.List;

public class LoginPage extends ObjectUtility {
    WebDriver driver;
    public LoginPage(WebDriver driver){
        /**Page Constructor**/
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }


    /**Page Elements**/
    private final String _loginEmail= "//input[@id='Email']";
    @FindBy(xpath=_loginEmail) private WebElement loginEmail;


    private final String _loginPassword= "//input[@id='Password']";
    @FindBy(xpath=_loginPassword) private WebElement loginPassword;


    private final String _loginButton= "input[value='Log in']";
    @FindBy(css=_loginButton) private WebElement loginButton;


    /**User Action Methods**/
    public void enterLoginEmail(String emailId){
        page.enterText(loginEmail,emailId);

    }
    public void enterLoginPassword(String password){
        page.enterText(loginPassword,password);

    }
    public MyAccountPage clickOnLoginButton(){
        page.clickOnElement(loginButton);
        return new MyAccountPage(driver);
    }
    public List<String> getExpectedExcelData() throws IOException {
        List<String> expectedData=excel.readDataFromExcel("\\src\\main\\resources\\TestData.xlsx","LoginPage");
        return expectedData;
    }
    public String getLoginPageTitle(){
        String loginTitle=page.getPageTitle(driver);
        return loginTitle;
    }
}
