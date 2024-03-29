Feature: Interaction with checkbox on User Table page
  In order to check behavior of one checkbox
  As a logged user
  I want to check that checkbox works correctly

  Scenario: Checking one checkbox on User Table page
    Given I open JDI GitHub site on 'Home Page'
    And I login as user Roman Iovlev
    When I click on "Service" button in Header
    And I click on "User Table" button in Service dropdown
    And I select 'vip' checkbox for 'Sergey Ivan'
    Then There is 'Vip: condition changed to true' text in the row #1
