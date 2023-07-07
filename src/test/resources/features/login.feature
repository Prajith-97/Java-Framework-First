Feature: Login Page
  Scenario: Validate login with valid credentials
    Given user is on homepage
    And user enter valid username "standard_user"
    And user enter valid password "secret_sauce"
    When user clicks on the login button
    Then user should redirected to the customer page

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