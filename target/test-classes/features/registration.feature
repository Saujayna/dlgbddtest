Feature: Car Reg Validation
  As a user i would like to verify if a car reg exists on the test system

  Background:
    Given I use chrome browser
    And  I launch the DLG Test page

  @Valid
  Scenario: Validate car reg exists on the system
    When I submit the car reg 'OV12UYY'
    Then the car reg 'OV12UYY' should exist

  @Invalid
  Scenario: Validate car reg doesnt exist on the system
    When I submit the car reg 'EJ06ASM'
    Then the car reg 'EJ06ASM' should not exist

  @Valid
  Scenario: Validate the car reg dates of the cover
    When I submit the car reg 'OV12UYY'
    And the cover start should be '09 FEB 2022 : 16 : 26'
    And the cover end should be '18 FEB 2022 : 23 : 59'

  @Valid
  Scenario Outline: Parameterized Tests to validate large sets of car regs
    When I submit the car reg '<CarReg>'
    Then the car reg '<CarReg>' should exist
    And the cover start should be '<CoverStartDate>'
    And the cover end should be '<CoverEndDate>'
    Examples:
      | CarReg  | CoverStartDate        | CoverEndDate          |
      | OV12UYY | 09 FEB 2022 : 16 : 26 | 18 FEB 2022 : 23 : 59 |
      | OV12UYY | 09 FEB 2022 : 16 : 26 | 18 FEB 2022 : 23 : 59 |
    ##Add More Test data if needed to validate.
