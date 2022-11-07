Feature: test google search

  Scenario:search MINH in google
    Given open browser
    When Search "minh"
    And Click search button
    Then See result page

@Smoke
  Scenario:search CMC in google
    Given open browser
    When Search "CMC"
    And Click search button
    Then See result page
