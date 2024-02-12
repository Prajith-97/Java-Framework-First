Feature: Validate Menu Bar

#  Scenario: Validate logo on the homepage
#    Given user is on the homepage of the site
#    When user clicks on the logo
#    Then user should get redirected to homepage

  Scenario: Validate dropdown is displayed while mouse hovering menu bar
    Given user is on the homepage of the site
    When user mouse hover "men" on the menu bar
    Then corresponding dropdown should be displayed

  Scenario: Validate mouse hovering through the elements in the dropdown
    Given dropdown is displayed
    When mouse hover the elements "Wallets" in the dropdown
    Then element should appear in light color "lighter"

  Scenario: Validate user is redirected to PLP page
    Given dropdown is displayed
    When user clicks on the particular element "New Arrivals" in the dropdown
    Then user should redirected to corresponding PLP page "Men's New Arrivals"