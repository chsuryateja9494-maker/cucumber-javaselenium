package com.cucumberscript.pageObjects;

import com.cucumberscript.utilities.BrowserUtils;
import com.cucumberscript.utilities.Propertyutils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.Properties;

public class LoginPage extends BaseClass {
    BrowserUtils btls = new BrowserUtils();
    WebDriver driver;
    Properties props = Propertyutils.loadUserProperties();

    public LoginPage(WebDriver driver) throws IOException {
        this.driver = driver;
        PageFactory.initElements(driver, this);  //page factory = Factory class to make using Page Objects simpler and easier.
    }

    @FindBy(xpath = "//input[@id='input-email']")
    WebElement emailAddress;

    @FindBy(xpath = "//input[@id='input-password']")
    WebElement password;

    @FindBy(xpath = "//input[@value='Login']")
    WebElement loginButton;

    @FindBy(xpath = "//h2[text()='My Account']//ancestor::div[@id='content']")
    WebElement myAccountHeader;

    @FindBy(xpath = "//*[text()='Warning: No match for E-Mail Address and/or Password.']")
    WebElement loginPageErrorMessage;

    public String getValueFromPropertiesFile(String key){
        return props.getProperty(key);  //look at line 17 for more info.
    }

    public void enterUserNameValid() {
        btls.waitForWebElement(emailAddress).sendKeys(getValueFromPropertiesFile("emailId"));
    }

    public void enterPasswordValid() {
        password.sendKeys(getValueFromPropertiesFile("password"));
    }

    public void clickOnLoginButton() {
        loginButton.click();
    }

    public void enterPasswordInvalid() {
        password.sendKeys(getValueFromPropertiesFile("invalidPassword"));
    }

    public void errorMessageLoginPage() {
        assertEquals("Warning: No match for E-Mail Address and/or Password.",loginPageErrorMessage.getText());
    }


}
