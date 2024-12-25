Feature: Example Scenario
  Background:
    Given setting driver

  Scenario Outline: Login to page and login test
    Given go to login page
    And user types username as <"username">
    And user types password as <"password">
    When click button
    Then assert to success massage
    Examples:
      | "username" | "password" |
      |"student"   |"Password123"|
      |"Mehmet"    |"125"|

  Scenario: home page loading test
    Given go to home page
     When wait for two second
     Then  see "Hello" text
