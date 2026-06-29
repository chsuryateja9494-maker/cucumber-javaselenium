package com.cucumberscript.pageObjects;

import com.cucumberscript.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static org.junit.jupiter.api.Assertions.*;


public class ProductsPage {
    WebDriver driver;
    BrowserUtils btls = new BrowserUtils();
    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='form-group']/child::input[@id='input-quantity']")
    WebElement productQuantityInput;

    @FindBy(xpath = "//div[@class='form-group']/child::button[@id='button-cart']")
    WebElement addToCartButton;

    @FindBy(xpath = "//a[@title='Shopping Cart']/child::span")
    WebElement shoppingCartLink;

    @FindBy(xpath = "//div[contains(@class, 'alert alert-success alert-dismissible')]")
    WebElement addToCartSucessMessage;


    public WebElement clicksOnAddToCartForRequiredProduct(String product){
        return driver.findElement(By.xpath("//a[text()='"+product+"']/ancestor::div[@class='product-thumb']/child::div/div[@class='button-group']/child::button[contains(@onclick, 'cart.add')]"));
    }

    public void addElementToCart(String product){
        clicksOnAddToCartForRequiredProduct(product).click();
        validateTheItemAdded(product);
        clickOnProduct(product);
    }

    public void clickOnProduct(String product){
         driver.findElement(By.xpath("//div[@class='caption']//a[text()='"+product+"']")).click();
    }

    public void entersTheQuantityOfTheProduct(String count, String product){
        btls.waitForWebElement(productQuantityInput);
        btls.hoverAndClick(productQuantityInput, productQuantityInput);
        productQuantityInput.sendKeys(count);
        btls.clickElementByText("Add to Cart");
        validateTheItemAdded(product);
    }

    public void clickOnAddToCartButtonForTheProductAtFinalizingProductPage(){
        btls.waitForWebElement(addToCartButton);
        btls.hoverAndClick(addToCartButton, addToCartButton);
    }

    public void validateTheItemAdded(String product){
        btls.waitForWebElement(addToCartSucessMessage);
        System.out.println("product = " + addToCartSucessMessage.getText());
        System.out.println("Success: You have added "+product+ " to your shopping cart!");
        assertTrue(addToCartSucessMessage.getText().strip().contains("Success: You have added "+product+ " to your shopping cart!"));
    }

    public void clicksOnShoppingCartLink(){
        shoppingCartLink.click();
    }
    }
