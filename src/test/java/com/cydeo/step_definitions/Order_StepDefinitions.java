package com.cydeo.step_definitions;

import com.cydeo.pages.BasePage;
import com.cydeo.pages.OrderPage;
import com.cydeo.pages.ViewAllOrdersPage;
import com.cydeo.pages.WebTableLoginPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Order_StepDefinitions {

    WebTableLoginPage webTableLoginPage=new WebTableLoginPage();
    BasePage basePage=new BasePage();
    OrderPage orderPage=new OrderPage();

    @Given("user is already logged in and on order page")
    public void user_is_already_logged_in_and_on_order_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("webTableUrl"));
        webTableLoginPage.login();
        basePage.order.click();
    }
    @When("user selects the product type {string}")
    public void user_selects_the_product_type(String string) {
        Select select=new Select(orderPage.productDropdown);
        select.selectByVisibleText(string);  //Familybea in the feature file


    }

    //@When"user enters quantity {string}")
    //    public void userEntersQuantity(String string) {
    //
    //    }
    @And("user enters quantity {int}")
    public void userEntersQuantity(int arg0) {

        //clear method will delete whatever is in the input box
        //orderPage.inputQuantity.clear();

        //imitating pressing back_space button from keyboard to delete
        orderPage.inputQuantity.sendKeys(Keys.BACK_SPACE);
        orderPage.inputQuantity.sendKeys(arg0+"");  //accepting int arg and sending it using sendKeys() method
    }                                                              //we need concat with ""
                                                                   //or sendKeys(String.valueOf(arg0)
    @When("user enters costumer name {string}")
    public void user_enters_costumer_name(String string) {
        orderPage.inputName.sendKeys(string);
    }
    @When("user enters street {string}")
    public void user_enters_street(String string) {
        orderPage.inputStreet.sendKeys(string);
    }
    @When("user enters city {string}")
    public void user_enters_city(String string) {
        orderPage.inputCity.sendKeys(string);
    }
    @When("user enters state {string}")
    public void user_enters_state(String string) {
        orderPage.inputState.sendKeys(string);
    }
    @When("user enters zipcode {string}")
    public void user_enters_zipcode(String string) {
        orderPage.inputZip.sendKeys(string);
    }
    @When("user enters credit card type {string}")
    public void user_enters_credit_card_type(String expectedCardType) {
       /* List<WebElement> cardTypes= orderPage.cardType;
        for(WebElement each: cardTypes){
            if(each.getAttribute("value").equals(expectedCardType)){
                each.click(); //until continue to find element that we want to select
            }                 //her seferinde tekrar yazmamak için
        }  */

        //This line will loop through the list and decide which radio button to click
        BrowserUtils.clickRadioButon(orderPage.cardType, expectedCardType);

    }
    @When("user enters credit card number {string}")
    public void user_enters_credit_card_number(String string) {
        orderPage.cardNoInput.sendKeys(string);
    }
    @When("user enters expiry date {string}")
    public void user_enters_expiry_date(String string) {
        orderPage.cardExpInput.sendKeys(string);
    }
    @When("user enters process order button")
    public void user_enters_process_order_button() {
        orderPage.processOrderBtn.click();
    }
    @Then("user should see {string} in first row of the web table")
    public void user_should_see_in_first_row_of_the_web_table(String string) {
        ViewAllOrdersPage viewAllOrdersPage=new ViewAllOrdersPage();

        System.out.println("viewAllOrdersPage.newCustomerCell.getText() = " + viewAllOrdersPage.newCustomerCell.getText());

        String actualName=viewAllOrdersPage.newCustomerCell.getText();
        Assert.assertEquals(string,actualName);
    }


}
