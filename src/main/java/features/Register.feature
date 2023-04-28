Feature: Register feature test suite

  Background:
    Given "HomePage" is clicked


  Scenario: Register Page URL is accessible from Home Page
    When "myAccountButton" button is displayed
    And "registerButton" button is clicked
    Then "register" is present within the correct URL

  Scenario Outline: Register page url contains the following word <keyword>
    When "myAccountButton" button is displayed
    And "RegisterButton" button is clicked
    Then "RegisterPage" is opened
    And "<keyword>" is present within the correct URL
    Examples:
      | keyword  |
      | register |

  @FieldValidation @run
  Scenario Outline:  Error message is displayed when using invalid <email> email value
    When "myAccountButton" button is displayed
    And "RegisterButton" button is clicked
    Then "RegisterPage" is opened
    Then "register" is present within the correct URL
    When the register account is populated with below data:
      | firstName       | Snejana              |
      | lastName        | Tiganciuc            |
      | email           | stiganciuc@gmail.com |
      | telephone       | 062152771            |
      | password        | password             |
      | confirmPassword | password             |
    And "privacyButton" button is clicked
    And "continueButton" button is clicked
    Then the following errors are displayed on the screen:
      | <error>                                                                         |
      | Warning:Please include an '@' in the mail address. '<email>' is missing an '@'. |
    Examples:
      | email      | error                                                                   |
      | @gmail.com | Please include an '@' in the mail address. '<email>' is missing an '@'. |

