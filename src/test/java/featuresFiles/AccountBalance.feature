Feature: Withdraw cash from account
  In order to pay for my daily expenses
  As an account holder
  I want to withdraw cash

  Scenario Outline: Withdraw cash from account in credit
    Given I have a balance of <Total Amount> in my accountNumber "<AccountNumber>"
    When I request <Requested Amount>
    Then <Requested Amount> should be dispensed
    Examples:
    |Total Amount| Requested Amount| AccountNumber|
    |100| 20| ICICI09476|