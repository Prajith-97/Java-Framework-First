Feature: Login Page
  @smoke
  Scenario: Validate login with valid credentials
    Given user is on homepage
    And user enter valid username "standard_user"
    And user enter valid password "secret_sauce"
    When user clicks on the login button
    Then user should redirected to the customer page

#  Scenario: Validate login with invalid credentials
#    Given user is on homepage
#    And user enter invalid username
#    And user enter invalid password
#    When user clicks on the login button
#    Then error message should be displayed

# Scenario Outline: Validate login for multiple users
#    Given user is on homepage
#    And user enter valid username "<username>" and "<password>"
#    When user clicks on the login button
#    Then user should redirected to the customer page
#   Examples:
#     | username                | password     |
#     | locked_out_user         | secret_sauce |
#     | problem_user            | secret_sauce |
#     | performance_glitch_user | secret_sauce |