package com.cydeo.pages;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebTableLoginPage {

    public WebTableLoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath="//input[@name='username']")
    public WebElement inputUserName;

    @FindBy(xpath="//input[@name='password']")
    public WebElement inputPassword;

    @FindBy(xpath="//button[.='Login']")
    public WebElement loginButton;

    /**
     * No parameters
     * When we call this method , it will directly login using
     *
     * Username: Test
     * Password:Tester
     */
    public void login(){
        this.inputUserName.sendKeys("Test");
        this.inputPassword.sendKeys("Tester");
        this.loginButton.click();
    }

    /**
     * This method will accept two arguments and login
     * @param username
     * @param password
     */
    public void login(String username, String password){
        inputUserName.sendKeys(username);
        inputPassword.sendKeys(password);
        loginButton.click();
    }

    /**
     * This method will login using credentials from configuration properties
     */
    public void loginWihConfig(){
        inputUserName.sendKeys(ConfigurationReader.getProperty("webTableUsername"));
        inputPassword.sendKeys(ConfigurationReader.getProperty("webTablePassword"));
        loginButton.click();
    }
}
