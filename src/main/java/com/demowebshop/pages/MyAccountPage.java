package com.demowebshop.pages;

import com.demowebshop.Utilities.ObjectUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage extends ObjectUtility {
    WebDriver driver;
    /**Page Constructor**/
    public MyAccountPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    /**Page Elements**/
    private final String _accountUserName="//div[@class='header-links']//a[@class='account']";
    @FindBy(xpath=_accountUserName) private WebElement accountUserName;
    private final String _getRegisteredEmail="//div[@class='header-links']//a[@class='account']";
    @FindBy(xpath=_getRegisteredEmail) private WebElement getRegisteredEmail;


    /**User Action Methods**/
    public String getUserName(){
        String emailId=page.getElementText(accountUserName);
        return emailId;
    }
    public String getRegisterEmail(){
        String emailId=page.getElementText(getRegisteredEmail);
        return emailId;
    }
}
