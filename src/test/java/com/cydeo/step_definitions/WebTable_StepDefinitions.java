package com.cydeo.step_definitions;

import com.cydeo.pages.WebTableLoginPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Map;

public class WebTable_StepDefinitions {

    WebTableLoginPage webTableLoginPage=new WebTableLoginPage();
    @Given("user is on the login page of the web table app")
    public void user_is_on_the_login_page_of_the_web_table_app() {
        String url= ConfigurationReader.getProperty("webTableUrl");
        Driver.getDriver().get(url);
    }
    @When("user enters username {string}")
    public void user_enters_username(String string) {
        webTableLoginPage.inputUserName.sendKeys(string);
    }
    @When("user enters password {string}")
    public void user_enters_password(String string) {
        webTableLoginPage.inputPassword.sendKeys(string);
    }
    @When("user clicks to login button")
    public void user_clicks_to_login_button() {
        webTableLoginPage.loginButton.click();
    }
    @Then("user should see url contains order")
    public void user_should_see_url_contains_order() {
        BrowserUtils.verifyURLContains("orders");
    }

    @When("user enters username {string} password {string} and logins")
    public void userEntersUsernamePasswordAndLogins(String username, String pw) {
        //webTableLoginPage.inputUserName.sendKeys(username);
        //webTableLoginPage.inputPassword.sendKeys(pw);
        //webTableLoginPage.loginButton.click();
        webTableLoginPage.login(username, pw);  //just 1 line with the method we create  in pom pages (2.)
    }

        @When("user enters below credentials")
        public void user_enters_below_credentials(Map<String, String> credentials) {
           //webTableLoginPage.inputUsername.sendKeys(credentials.get("username")); //key+value
           //webTableLoginPage.inputPassword.sendKeys(credentials.get("password"));
           //webTableLoginPage.loginButton.click();

            webTableLoginPage.login(credentials.get("username"), credentials.get("password")); //all of them above
        }



}
