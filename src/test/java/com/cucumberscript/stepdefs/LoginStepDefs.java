package com.cucumberscript.stepdefs;

import com.cucumberscript.pageObjects.BaseClass;
import com.cucumberscript.pageObjects.HomePage;
import com.cucumberscript.pageObjects.LoginPage;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;


public class LoginStepDefs extends BaseClass{
    LoginPage lgPage = new LoginPage(driver);
    HomePage hPge = new HomePage(driver);

    public LoginStepDefs() throws IOException {
    }


    @Given("user enters the valid email in the email field")
    public void userEntersTheEmailField() {
        lgPage.enterUserNameValid();
    }

    @And("user enters the valid password in the password field")
    public void userEntersThePassword() {
        lgPage.enterPasswordValid();
    }

    @When("user clicks on login button")
    public void userClicksOnLoginButton() {
        lgPage.clickOnLoginButton();
    }

    @Then("user able to login successfully")
    public void userAbleToLoginSuccessfully() {
        hPge.verifyHomePage();
    }

    @Given("^user enters invalid (.*) the email field$")
    public void userEntersInvalidEmailTheEmailField(String mail) {
        lgPage.enterInvalidUserName(mail);
    }

    @And("^user enters (.*) the invalid password field$")
    public void userEntersPasswordTheInvalidPasswordField(String password) {
        lgPage.enterPasswordInvalid(password);
    }

    @Then("^error message (.*) is displayed$")
    public void errorMessageErrorMessageIsDisplayed(String errorMessage) {
        lgPage.errorMessageLoginPage(errorMessage);
    }

    @And("user enters the invalid password in the password field")
    public void userEntersTheInvalidPassword() {
        lgPage.enterPasswordInvalid("invalidPassword");
    }

    @Then("error message is displayed")
    public void errorMessageIsDisplayed() {
        lgPage.errorMessageDisplayedLoginPage();
    }
}
