package com.cucumberscript.stepdefs;

import com.cucumberscript.pageObjects.BaseClass;
import com.cucumberscript.pageObjects.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;


public class LoginStepDefs extends BaseClass {
    LoginPage logPge = new LoginPage(driver);

    public LoginStepDefs() throws IOException {
    }


    @Given("user enters the email field")
    public void userEntersTheEmailField() throws InterruptedException {
        logPge.enterUserName();
    }

    @And("user enters the password")
    public void userEntersThePassword() {
        logPge.enterPassword();
    }

    @When("user clicks on login button")
    public void userClicksOnLoginButton() {
        logPge.clickOnLoginButton();
    }

    @Then("user able to login successfully")
    public void userAbleToLoginSuccessfully() {
        
   
    }

    @Given("user enters the invalid email field")
    public void userEntersTheInvalidEmailField() {
        
   
    }

    @And("user enters the invalid password field")
    public void userEntersTheInvalidPasswordField() {
        
   
    }

    @Then("error message is displayed")
    public void errorMessageIsDisplayed() {
        
   
    }
}
