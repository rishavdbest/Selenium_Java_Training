Feature: Login feature 

Scenario: User Login Scenario
	Given User is on Application Login Page
	When Application Login Page Title is Swag Labs
#	Then user enters "problem_user" and "secret_sauce"
	Then user enters "<username>" and "<password>"
	And user clicks on login button
	When user able to see the alert of password breach
	
Examples:
  | username      | password      |
  | standard_user | secret_sauce  |
  | problem_user  | secret_sauce  |
  | locked_out_user  | secret_sauce  |
  | performance_glitch_user | secret_sauce  |