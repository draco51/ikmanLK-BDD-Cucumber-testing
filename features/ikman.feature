Feature: ikmanLK test

  Scenario: Test IkmanLK Website
    Given I am on IkmanLK Website
    When I click on the Property link
    When I click on the Houese link
    When I click on the Colombo link
    When I select the Price range
    When I select No of Beds as 3
    Then Get the No of Total Ads
    Then Print all the prices of Ads
    Then I Close the browser
    

