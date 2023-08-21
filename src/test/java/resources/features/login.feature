Feature: Login

  I want to login to the Orange HRM site

  Scenario Outline: Login to the Orange HRM site
    Given I navigate to the Login page
    When I enter username "<username>" and password "<password>"
  #  Then the Dashboard page is displayed
    Examples:
      | username | password |
      | Admin    | admin123 |