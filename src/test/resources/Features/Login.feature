Feature: Login Functionalities
  @smoke
  Scenario: Valid Admin login
    #Given open the browser and launch HRMS application
    When user enters valid email and valid password
    And click on login button
    Then user is logged in successfully into the application
    #And close the browser

  @smoke2
  Scenario: Valid Admin login
    #Given open the browser and launch HRMS application
    When user enters valid "admin" and valid "Hum@nhrm123"
    And click on login button
    Then user is logged in successfully into the application
    #And close the browser

  @scenarioOutline
  #Parameterization/Data Driven
  Scenario Outline: Login with multiple credentials using scenario outline
  #Given open the browser and launch HRMS application
    When user enters valid "<username>" and valid "<password>"
    And click on login button
    Then user is logged in successfully into the application
    #And close the browser
  Examples:
  | username | password |
  | admin    | Hum@nhrm123 |
  | ADMIN    | Hum@nhrm123 |
  | Jason    | Hum@nhrm123 |

    @dataTable
  Scenario: Login with multiple credentials using data table
    When user enters username and password and verifies login
      | username | password |
      | admin    | Hum@nhrm123 |
      | ADMIN    | Hum@nhrm123 |
      | Jason    | Hum@nhrm123 |


    #Hooks --> for defining pre and post steps in any Cucumber framework
    #      --> This is always created inside the StepDefinitions folder
    #      --> This class cannot be inherited
    #      --> Hooks will take care of pre and post conditions irrespective of what goes in between the test steps

    # Background --> This is used to define all the common steps that multiple
           #         scenarios have in the same feature file, till the time flow is not broken
  # to get data we can:
  #1. Hard code
  #2. config file
  # --------------Cucumber itself provides multiple option through which we can feed data from
  # feature file into step definition
  #3. Regular expression --> put the data in double quates ("")
  #4. Scenario outline --> provides you an alternative to DDT Data Driven Testing. It also supports parameterization.

  #-------- PARAMETERIZATION -----------
  # executing the same test case with multiple data

  #rules for scenario outline
  # if you want to use parameterization
  # if you want to implement data driven testing
  # scenario outline is always used along with the keyword 'Examples'

  #Data Table