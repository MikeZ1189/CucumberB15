Feature: Add employee

  Background:
    When user enters valid email and valid password
    And click on login button
    When user clicks on PIM option
    And user clicks on add employee button


  @smoke @testcase2
  Scenario: Adding a new employee
    #Given open the browser and launch HRMS application
    #When user enters valid email and valid password
    #And click on login button
    #When user clicks on PIM option
    #And user clicks on add employee button
    #And user enters firstName and middleName and lastName
    #And user clicks on save button
    #And close the browser

  @database
  Scenario: adding the employee from front end and verifying it from back end
    #When user enters valid email and valid password
    #And click on login button
    #When user clicks on PIM option
    #And user clicks on add employee button
    And user enters "nesha" and "sania" and  "standart"
    And user captures the employee id
    And user clicks on save button
    And query the information in backend
    Then verify the results from frontend and backend