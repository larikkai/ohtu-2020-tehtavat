Feature: A new user account can be created if a proper unused username and password are given

    Scenario: creation is successful with valid username and password
        Given command new user is selected
        When  a valid username "liisa" and password "salainen1" and matching password confirmation are entered
        Then  a new user is created
    
    Scenario: creation fails with too short username and valid password
        Given command new user is selected
        When  too short username "pe" and correct password "password1" are given
        Then user is not created and error "username should have at least 3 characters"

    Scenario: creation fails with correct username and too short password
        Given command new user is selected
        When  correct username "student" and too short password "pass" are given
        Then user is not created and error "password should have at least 8 characters"
    
    Scenario: creation fails when password and password confirmation do not match
        Given command new user is selected
        When  correct username "student", not maching password "password1" and passConfirmation "password2" are given
        Then user is not created and error "password and password confirmation do not match" is reported
    
    Scenario: creation fails when password contains only letters
        Given command new user is selected
        When  nome "student666" and invalid password "password"
        Then user is not created and error "password cannot contain only letters"