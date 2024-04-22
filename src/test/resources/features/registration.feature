# Namn: Ali Garcia
# MyStepdefs.java
# Datum : 240422

Feature: Registration

  Scenario: Successful registration
    Given I have entered date of birth "09/08/1967"
    And I have entered first name "Ali"
    And I have entered last name "Garcia"
    And I have entered email and confirmed email "ali.garcia@live.se"
    And I have entered password "ali.garcia@@@" and confirmed password "ali.garcia@@@"
    And I have entered terms and conditions
    And I have checked Over 18 and code of conduct
    When I press the join button
    Then I am registered

  Scenario: Registration - Missing last name
    Given I have entered date of birth "09/08/1966"
    And I have entered first name "Ali"
    And I have entered last name ""
    And I have entered email and confirmed email "ali.garcia@live.se"
    And I have entered password "ali.garcia@" and confirmed password "ali.garcia@"
    And I have entered terms and conditions
    And I have checked Over 18 and code of conduct
    When I press the join button
    Then I am not registered and get error code "Last Name is required"

  Scenario: Registration - The Passwords don't match
    Given I have entered date of birth "09/08/1966"
    And I have entered first name "Ali"
    And I have entered last name "Garcia"
    And I have entered email and confirmed email "ali.garcia@live.se"
    And I have entered password "ali.garcia@" and confirmed password "ali.garcia"
    And I have entered terms and conditions
    And I have checked Over 18 and code of conduct
    When I press the join button
    Then I am not registered and get error code "Password did not match"

  Scenario: Registration - Terms and conditions is not checked
    Given I have entered date of birth "09/08/1966"
    And I have entered first name "Ali"
    And I have entered last name "Garcia"
    And I have entered email and confirmed email "ali.garcia@live.se"
    And I have entered password "ali.garcia@" and confirmed password "ali.garcia@"
    #And I have entered terms and conditions
    And I have checked Over 18 and code of conduct
    When I press the join button
    Then I am not registered and get error code "You must confirm that you have read and accepted our Terms and Conditions"