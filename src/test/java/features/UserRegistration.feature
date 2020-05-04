 Feature: User Registration
 		I want to check that the user can register to our e-commerce website
 		Scenario Outline: User Registration
 		Given user is on the home page
 		When user click on the Register link
 		And  user enter "<firstname>" , "<lastname>" , "<email>" , "<password>"
 		Then the registration page displayed successfuly message
 		
 		Examples:
		| firstname | lastname | email | password |
		| aaa | ccc | abc@test.com | 12345678 |
		| bbb | ddd | cba@test.com | 87654321 |