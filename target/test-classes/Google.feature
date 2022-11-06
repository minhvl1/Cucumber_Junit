Feature: test google search

  Scenario:search MINH in google
    Given open browser
    When Search "minh"
    And Click search button
    Then See result page
