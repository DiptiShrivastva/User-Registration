 for running file in 
 mvn test -Dbrowser=chrome
 mvn test -Dbrowser=firefox
 Hook set up because it can close and re-open browser
 Feature: User Registration on Basketball England

 Scenario Outline: Create user registration with different scenarios
 Given I am on the registration page
 When I fill in the registration form with "<firstName>", "<lastName>", "<email>", "<password>", and "<confirmPassword>"
 And I accept the terms and conditions
 And I click on CONFIRM AND JOIN
 Then I should see either "<expectedOutcome1>" or "<expectedOutcome2>"

     Examples:
       | firstName | lastName  | email                  | password  | confirmPassword | expectedOutcome1                                            | expectedOutcome2  |
       | Dipti     | Shrivastava | ceena08@gmail.com  | Test@1234 | Test@1234       | THANK YOU FOR CREATING AN ACCOUNT WITH BASKETBALL ENGLAND | CREATE AN ACCOUNT |

 Scenario: Create user - last name missing
 Given I am on the registration page
 When I fill in the registration form with "<firstName>", "<lastName>", "<email>", "<password>",and "<confirmPassword>"
 And I accept the terms and conditions
 And I click on CONFIRM AND JOIN
 Then I should see an error message "Last Name is required"
 
Examples:
 | firstName | lastName  | email                  | password  | confirmPassword |                                            
 | Dipti     |  | ceena08@gmail.com  | Test@1234 | Test@1234       | 

 Scenario: Create user - password does not match
 Given I am on the registration page
 When I fill in the registration form with "<firstName>", "<lastName>", "<email>", "<password>",and "<confirmPassword>"
 And I accept the terms and conditions
 And I click on CONFIRM AND JOIN
 Then I should see a password mismatch error

 Examples:
 | firstName | lastName  | email                  | password  | confirmPassword |                                            
 | Dipti     |  | ceena08@gmail.com  | Test@1234 | Test@1234       |

 Scenario: Create user - terms and conditions are not approved
 Given I am on the registration page
 When I fill in the registration form with "<firstName>", "<lastName>", "<email>", "<password>",and "<confirmPassword>"
 And I do not accept the terms and conditions
 And I click on CONFIRM AND JOIN
 Then I should see a terms and conditions error
 Examples:
 | firstName | lastName  | email                  | password  | confirmPassword |                                            
 | Dipti     |  | ceena08@gmail.com  | Test@1234 | Test@1234       |