Feature: user login

  @smoke
  Scenario: user should be able to login with valid credentials
    Given user enters the valid email in the email field
    And user enters the valid password in the password field
    When user clicks on login button
    Then user able to login successfully

#  Scenario Outline: user not able to login with invalid credentials
#    Given user enters invalid <email> the email field
#    And user enters <password> the invalid password field
#    When user clicks on login button
#    Then error message <error message> is displayed
#    Examples:
#      | email                       | password | error message                                         |
#      | chsuryateja9494@gmail.com   | test@234 | Warning: No match for E-Mail Address and/or Password. |
#      | chsuryateja9494@gmail.com1  | test@568 | Warning: No match for E-Mail Address and/or Password. |
#      | chsuryateja9494@gmail.com22 | test@120 | Warning: No match for E-Mail Address and/or Password. |


  @smoke  @Regression
  Scenario: user should be able to login with valid credentials
    Given user enters the valid email in the email field
    And user enters the invalid password in the password field
    When user clicks on login button
    Then error message is displayed


