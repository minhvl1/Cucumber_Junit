Feature: test google search

  @Test
  Scenario:search MINH in google
    Given open browser
    When Search "minh"
    And Click search button
    Then See result page

  @Test2
  @Smoke
  Scenario:search CMC in google
    Given open browser
    When Search "CMC"
    And Click search button
    Then See result page

  @Test3
  @Smoke
  Scenario:search FPT in google
    Given open browser
    When Search "FPT"
    And Click search button
    Then See result page

  @Test4
  @Smoke
  Scenario:search CMC in google
    Given open browser
    When Search "Viettel"
    And Click search button
    Then See result page

