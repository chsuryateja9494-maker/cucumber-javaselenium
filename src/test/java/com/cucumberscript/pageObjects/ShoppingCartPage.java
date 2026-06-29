package com.cucumberscript.pageObjects;

import com.cucumberscript.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ShoppingCartPage {
WebDriver driver;
BrowserUtils btls = new BrowserUtils();
    public ShoppingCartPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//table[@class='table table-bordered']//td[@class='text-left']/div/input")
    WebElement qty;

    @FindBy(xpath = "(//table[@class='table table-bordered']/child::tbody/tr/td[@class='text-right'])[9]")
    WebElement unitPrice;

    public void verifyProductAddedInTheCheckOutPage(String product){
        btls.waitForWebElement(driver.findElement(By.xpath("//table[@class='table table-bordered']//td[@class='text-center']/a/img[@title='"+product+"']")));
        assertTrue(driver.findElement(By.xpath("//table[@class='table table-bordered']//td[@class='text-center']/a/img[@title='"+product+"']")).isDisplayed());
        validatePrice();
    }

    public void validatePrice(){
        qty.clear();
        qty.sendKeys("2");
        System.out.println("p "+ qty.getText());
        System.out.println("q "+ unitPrice.getText().replace("$","").strip());
      //  int totalValue = Integer.parseInt(qty.getText())*Integer.parseInt(unitPrice.getText().replace("$","").strip());
        double totalValue = 2*Double.parseDouble(unitPrice.getText().replace("$","").strip());
        System.out.println("totalValue = " + totalValue);

    }

}
