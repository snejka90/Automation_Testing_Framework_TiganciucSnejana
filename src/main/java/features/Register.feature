Feature: Register feature test suite

  Background:
    Given "HomePage" is clicked

  Scenario: Register Page URL is accessible from Home Page
    When dropdown is displayed
    And Register button is clicked
    Then "register" is present within the correct URL

  Scenario Outline: Register page url contains the following word <my account>
    When dropdown is displayed
    And Register button is clicked
    Then "register" is present within the correct URL
    Examples:
      | my account |
      | register   |
      | login      |




