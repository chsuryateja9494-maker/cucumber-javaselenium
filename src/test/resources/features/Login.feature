Feature: user login

  Scenario: user should be able to login with valid credentials
    Given user enters the email field
    And user enters the password
    When user clicks on login button
    Then user able to login successfully

#  Scenario: user not able to login with invalid credentials
#    Given user enters the invalid email field
#    And user enters the invalid password field
#    When user clicks on login button
#    Then error message is displayed

