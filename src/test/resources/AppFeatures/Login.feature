
Feature: Login
    
  Scenario Outline: User Login

  Given user navigates to "url"
  And enters the login credentials "<username>" "<password>"
  And clicks on the "Log in" button
  Then the user verifies that the page title is displayed "<page title>"
  
  Examples:
    | username  | password  | page title |
    | admin     | password  | Live Store |