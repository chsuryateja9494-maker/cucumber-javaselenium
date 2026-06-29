Feature: Add Products to Shopping Cart

  Background:
    Given user enters the valid email in the email field
    And user enters the valid password in the password field
    And user clicks on login button
    And user able to login successfully


  @smoke1
  Scenario: User is able to add products into the shopping cart
    Given user clicks on Show All Notebooks and Laptops link
    And User clicks on Add to cart of required product
    When user clicks on Add to Cart button for Macbook product
    And user enters the quantity of the product
    And user clicks on Shopping Cart link
    Then Macbook product is added to the shopping cart