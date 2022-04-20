package com.demowebshop.pages;

import com.demowebshop.Utilities.ObjectUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
    public void enterLoginPassword(String pasword){
        page.enterText(loginPassword,pasword);

    }
    public MyAccountPage clickOnLoginButton(){
        page.clickOnElement(loginButton);
        return new MyAccountPage(driver);
    }





}
