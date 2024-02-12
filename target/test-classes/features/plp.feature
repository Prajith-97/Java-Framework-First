Feature: Sample Page

  @smoke
  Scenario: Validate login with valid credential
    Given user is on homepage
    And user enter valid username "standard_user"
    And user enter valid password "secret_sauce"
    When user clicks on the login button
    Then user should redirected to the customer page

  @regression @unit
  Scenario: Validate mouse-hover sort dropdown
    When user clicks on the dropdown box
    Then dropdown should appear
    And user mouseover through the dropdown

#  @comfort
#  Scenario: Add product to cart
#    When user clicks on the add to cart button
#    Then product should get added to the cart
#
#  Scenario: Select product from the plp
#    When user selects the product
#    Then user redirects to the pdp page



