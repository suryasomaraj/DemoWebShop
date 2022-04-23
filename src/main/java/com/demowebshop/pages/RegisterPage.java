package com.demowebshop.pages;

import com.demowebshop.Utilities.ObjectUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class RegisterPage extends ObjectUtility {
    WebDriver driver;

    public RegisterPage(WebDriver driver){
        /**Page Constructor**/
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    /**Page Elements**/
    private final String _registerGender= "input#gender-male";
    @FindBy(css=_registerGender) private WebElement registerGender;

    private final String _registerFirstName= "input#FirstName";
    @FindBy(css=_registerFirstName) private WebElement registerFirstName;

    private final String _registerLastName= "input#LastName";
    @FindBy(css=_registerLastName) private WebElement registerLastName;

    private final String _registerEmail= "input#Email";
    @FindBy(css=_registerEmail) private WebElement registerEmail;

    private final String _registerPassword= "input#Password";
    @FindBy(css=_registerPassword) private WebElement registerPassword;

    private final String _registerConfirmPassword= "input#ConfirmPassword";
    @FindBy(css=_registerConfirmPassword) private WebElement registerConfirmPassword;

    private final String _registerButton= "input#register-button";
    @FindBy(css=_registerButton) private WebElement registerButton;

    /**User Action Methods**/

    public void selectGender(String gender) {
        List<WebElement> radio = driver.findElements(By.xpath("//label[@class='forcheckbox']"));
        for (int i = 0; i < radio.size(); i++) {
            if (radio.get(i).getText().equals(gender)) {
                radio.get(i).click();
            } else {
                System.out.println("Invalid");
            }
        }
    }

    public void enterFirstName(String firstName){
        page.enterText(registerFirstName,firstName);
    }

    public void enterLastName(String lastName){
        page.enterText(registerLastName,lastName);
    }

    public void enterEmail(String email){
        page.enterText(registerEmail,email);
    }

    public void enterPassword(String password){
        page.enterText(registerPassword,password);
    }

    public void enterConfirmPassword(String confirmPassword){page.enterText(registerConfirmPassword,confirmPassword);
    }
    public MyAccountPage clickRegisterButton(){
        page.clickOnElement(registerButton);
        return new MyAccountPage(driver);
    }
    }

