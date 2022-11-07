Feature: test google search outline

  @TestOuline
  Scenario Outline: search multiple in google
    Given open browser
    When Search <arg0>
    And Click search button
    Then See result page
    Examples:
      | arg0   |
      | "CMC" |
      |"fsoft"|
      |"review cong ty"|