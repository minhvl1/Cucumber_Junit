Feature: test google search

  @Test
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

  @Smoke
  Scenario:search FPT in google
    Given open browser
    When Search "FPT"
    And Click search button
    Then See result page

  @Smoke
  Scenario:search CMC in google
    Given open browser
    When Search "Viettel"
    And Click search button
    Then See result page

