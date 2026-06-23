package com.cucumberscript.pageObjects;

import com.cucumberscript.utilities.BrowserUtils;
import com.cucumberscript.utilities.Propertyutils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.time.Duration;
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

    public String getValueFromPropertiesFile(String key){
        return props.getProperty(key);  //look at line 17 for more info.
    }

    public void enterUserName() throws InterruptedException {
        btls.waitForWebElement(emailAddress).sendKeys(getValueFromPropertiesFile("emailId"));
    }

    public void enterPassword() {
        password.sendKeys(getValueFromPropertiesFile("password"));
    }

    public void clickOnLoginButton() {
        loginButton.click();
    }


}
