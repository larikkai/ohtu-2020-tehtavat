Feature: User can log in with valid username/password-combination

    Scenario: nonexistent user can not login to 
        Given login is selected
        When  incorrect username "student" and incorrect password "password" are given
        Then  user is not logged in and error message is given