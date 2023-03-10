package com.cydeo.step_definitions;

/*
In the class, we will be able to pass pre- and post- conditions to each scenario and each step
 */

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    //import from io.cucumber.java not from junit
    //@Before
    public void setupScenario(){
        System.out.println("====Setting up browser using cucumber @Before");
    }

    //@Before(value = "@login", order = 1)
    public void setupScenarioForLogins(){
        System.out.println("==> This will only apply to scenarios with @login tag");
    }

    //@Before(value = "@db", order = -1)
    public void setupForDatabaseScenario(){
        System.out.println("==> This will only apply to scenarios with @db tag");
    }

    @After
    public void tearDownScenario(Scenario scenario){

        //scenario.isFailed()-->if scenario fails this method will return TRUE boolean value
        if(scenario.isFailed()){
            byte [] screenshot = ((TakesScreenshot)Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
        //BrowserUtils.sleep(3);
        Driver.closeDriver();

        //System.out.println("====Closing browser using cucumber @After");
        //System.out.println("====Scenario ended/ Take screenshot if ");
    }

    //@BeforeStep
    public void setupStep(){
        System.out.println("------> applying setup using @BeforeStep");
    }

    //@AfterStep
    public void afterSetup(){
        System.out.println("------> applying tearDown using @AfterStep");
    }
}
