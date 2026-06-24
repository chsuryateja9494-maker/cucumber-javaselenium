package com.cucumberscript.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.jupiter.api.Assertions.*;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


    @FindBy(xpath = "//div[@id='content']/child::h2[text()='My Account']")
    WebElement myAccountHeader;



    public void verifyHomePage(){
        assertEquals("My Account", myAccountHeader.getText(),"The actual value is "+ myAccountHeader.getText());
    }



}
