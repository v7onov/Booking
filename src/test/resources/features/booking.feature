Feature: Search hotel

  @hotel
  Scenario Outline: User searches for hotel
    Given User is on search page
    When User enters <hotel> text to Search field
    And User clicks search button
    Then <hotel> option presents and is first in the list
    And Hotel's rate is 8.1
    Examples:
      | hotel                                 |
      |Crowne Plaza Yas Island, an IHG Hotel|

