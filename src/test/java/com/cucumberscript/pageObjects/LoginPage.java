package com.cucumberscript.pageObjects;

import com.cucumberscript.utilities.BrowserUtils;
import com.cucumberscript.utilities.ExcelUtils;
import com.cucumberscript.utilities.Propertyutils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class LoginPage extends BaseClass {

    WebDriver driver;
    BrowserUtils btls = new BrowserUtils();
    Properties props = Propertyutils.loadUserProperties();

    public LoginPage(WebDriver driver) throws IOException {
        this.driver = driver;
        PageFactory.initElements(driver, this);  //page factory = Factory class to make using Page Objects simpler and easier.
    }

    ExcelUtils etls = new ExcelUtils("C:\\Users\\SuryaChallagundla\\IdeaProjects\\cucumber-javaselenium\\src\\test\\resources\\testData\\UI Test.xlsx");

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
        List<String> usernames = etls.readExcelData("Login","username");
        String username = usernames.get(0);
        System.out.println("username = " + usernames.get(0));
        btls.waitForWebElement(emailAddress).sendKeys(username);
       // btls.waitForWebElement(emailAddress).sendKeys(getValueFromPropertiesFile("emailId"));
    }

    public void enterInvalidUserName(String mail) {
        btls.waitForWebElement(emailAddress).sendKeys(getValueFromPropertiesFile(mail));
    }

    public void enterPasswordValid() {
        password.sendKeys(getValueFromPropertiesFile("password"));
    }

    public void clickOnLoginButton() {
        loginButton.click();
    }

    public void enterPasswordInvalid(String pwd) {
        password.sendKeys(getValueFromPropertiesFile(pwd));
    }

    public void errorMessageLoginPage(String message) {
     //   System.out.println(loginPageErrorMessage.getText());
        assertEquals(message,loginPageErrorMessage.getText());
    } //Warning: No match for E-Mail Address and/or Password.

     public void errorMessageDisplayedLoginPage() {
        System.out.println(btls.waitForWebElement(loginPageErrorMessage).getText());
        assertEquals("Warning: No match for E-Mail Address and/or Password.",loginPageErrorMessage.getText());
    } //Warning: No match for E-Mail Address and/or Password.


}
