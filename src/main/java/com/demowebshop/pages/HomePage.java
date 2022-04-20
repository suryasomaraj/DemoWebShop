package com.demowebshop.pages;

import com.demowebshop.Utilities.ObjectUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends ObjectUtility {
    WebDriver driver;
    /**Page Constructor**/

    public HomePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    /**Page Elements**/
    private final String _loginMenu= "li>a.ico-login";
    @FindBy(css=_loginMenu) private WebElement loginMenu;



    /**User Action Methods**/

    public String getHomePageTitle(){
        String title=page.getPageTitle(driver);
        return  title;
    }
    public LoginPage clickOnLoginMenu(){
        page.clickOnElement(loginMenu);
        return new LoginPage(driver);
    }


}
