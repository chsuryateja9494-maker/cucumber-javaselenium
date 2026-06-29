package com.cucumberscript.pageObjects;

import com.cucumberscript.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HomePage {
    WebDriver driver;
    BrowserUtils btls = new BrowserUtils();
    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


    @FindBy(xpath = "//div[@id='content']/child::h2[text()='My Account']")
    WebElement myAccountHeader;

    @FindBy(xpath = "//*[text()='Show AllLaptops & Notebooks']")
    WebElement laptopProducts;

    @FindBy(xpath = "//input[@id='input-quantity']/parent::div")
    WebElement inputQuantity;



    public void verifyHomePage(){
        btls.waitForWebElement(myAccountHeader);
        assertEquals("My Account", myAccountHeader.getText(),"The actual value is "+ myAccountHeader.getText());
    }

    public WebElement productCategoryOnHomePage(String productCategoryHeader){
        return driver.findElement(By.xpath("//ul[@class='nav navbar-nav']/child::li[@class='dropdown']/*[text()='"+ productCategoryHeader +"']"));
    }

    public void clickOnProductCategoryOnHomePage(String productCategoryHeader) {
           btls.hoverAndClick(productCategoryOnHomePage(productCategoryHeader), laptopProducts);
    }


}
