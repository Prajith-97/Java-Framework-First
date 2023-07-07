Feature: Sample Page
  Scenario: Validate login with valid credential
    Given user is on homepage
    And user enter valid username "standard_user"
    And user enter valid password "secret_sauce"