Feature: User Registration on Basketball England


  Scenario Outline: Create user - last name missing
    Given I am on the registration page
    When I fill in the registration form without last name "<firstName>", "<lastName>", "<email>", "<password>", and "<confirmPassword>"
    Then I should see an error message "Last Name is required"

    Examples:
      | firstName | lastName | email              | password  | confirmPassword |
      | Dipti     |         | pestuser@gmail.com | Test@1234 | Test@1234       |

  Scenario Outline: Create user - password does not match
    Given I am on the registration page
    When I fill in the registration form with mismatched password "<firstName>", "<lastName>", "<email>", "<password>", and "<confirmPassword>"
    Then I should see a password mismatch error

    Examples:
      | firstName | lastName  | email              | password  | confirmPassword  |
      | John      | Doe       | john@example.com   | Test@1234 | Mismatch@1234    |

  Scenario Outline: Create user - terms and conditions are not approved
    Given I am on the registration page
    When I fill without term and condition "<firstName>", "<lastName>", "<email>", "<password>", and "<confirmPassword>"
    Then I should see a terms and conditions error

    Examples:
      | firstName | lastName | email                | password  | confirmPassword |
      | Alice     | Brown    | alice@example.com    | Test@1234 | Test@1234       |
  Scenario Outline: Create user registration with account creation
    Given I am on the registration page
    When I fill in the registration form with "<firstName>", "<lastName>", "<email>", "<password>", and "<confirmPassword>"
    Then I should see "<expectedOutcome>"

    Examples:
      | firstName | lastName  | email               | password  | confirmPassword | expectedOutcome                                              |
      | Dipti     | Shrivastava | grepy08@gmail.com  | Test@1234 | Test@1234       | THANK YOU FOR CREATING AN ACCOUNT WITH BASKETBALL ENGLAND |
