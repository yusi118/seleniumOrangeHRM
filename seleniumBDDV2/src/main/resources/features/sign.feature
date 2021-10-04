Feature: Registration 
 Scenario: Testing the authentication
  Given I got to the Website
  When I specify my credentials
  And click login
  Then I can log into the website
