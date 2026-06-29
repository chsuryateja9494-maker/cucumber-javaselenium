package com.cucumberscript.stepdefs;

import com.cucumberscript.pageObjects.HomePage;
import com.cucumberscript.pageObjects.ProductsPage;
import com.cucumberscript.pageObjects.ShoppingCartPage;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.cucumberscript.pageObjects.BaseClass.driver;

public class ProductStepDefs {
    HomePage hPge = new HomePage(driver);
    ProductsPage pPge = new ProductsPage(driver);
    ShoppingCartPage sPge = new ShoppingCartPage(driver);

    @Given("user clicks on Show All Notebooks and Laptops link")
    public void userClicksOnShowAllNotebooksAndLaptopsLink() {
        hPge.clickOnProductCategoryOnHomePage("Laptops & Notebooks");
    }


    @And("user enters the quantity of the product")
    public void userEntersTheQuantityOfTheProduct() {
        pPge.entersTheQuantityOfTheProduct("2","MacBook");
    }

    @When("user clicks on Add to Cart button for Macbook product")
    public void userClicksOnAddToCartButtonForMacbookProduct() {
        pPge.clickOnAddToCartButtonForTheProductAtFinalizingProductPage();
    }

    @And("user clicks on Shopping Cart link")
    public void userClicksOnShoppingCartLink() {
        pPge.clicksOnShoppingCartLink();
    }

    @Then("Macbook product is added to the shopping cart")
    public void macbookProductIsAddedToTheShoppingCart() throws InterruptedException {
        sPge.verifyProductAddedInTheCheckOutPage("MacBook");
    }

    @And("User clicks on Add to cart of required product")
    public void userClicksOnAddToCartOfRequiredProduct() {
        pPge.addElementToCart("MacBook");
    }
}
