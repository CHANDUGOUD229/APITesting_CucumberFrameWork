Feature: Application login
  Scenario: Home page login Test
    Given  user is on landing page
    When user login in to application with username and password
    Then user should navigate to Homepage
