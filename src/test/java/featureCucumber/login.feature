Feature: login
  As a user
  I want to login with invalid data
  So that I can test login behavior

  Scenario Outline: User attempts to login
    Given the user is on the login page
    When the user logs in with "<username>" and "<password>"
    Then the user should see the message "<expectedMessage>"

  Examples:
    | username        | password       | expectedMessage                                                           |
    | locked_out_user | secret_sauce   | Epic sadface: Sorry, this user has been locked out.                       |
    | invalidUser     | secret_sauce   | Epic sadface: Username and password do not match any user in this service |
    | standard_user   | invalidPassword| Epic sadface: Username and password do not match any user in this service |
    |                 | secret_sauce   | Epic sadface: Username is required                                        |
    | standard_user   |                | Epic sadface: Password is required                                        |