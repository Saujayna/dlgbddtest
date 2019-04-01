# dlgbddtest

#### Background:
For this test excercise i have choosen the Cucumber-Selenium-Java environment in IntelliJ IDE to write the tests in a BDD fashion.

Cucumber - To express the user feature/scenarios in simple english format (uses Gherkin underneath)
Selenium - A WebApi that interacts with Web UI components for test automation.
Java - Programming Language
IntelliJ - IDE to write these tests

##### Test Framework:
I have opted the Page Object Model along with the Page Factory Pattern to accomplish this excercise.
Maven to manage dependencies

Below files can be found at

Feature Files -  src/test/resources/features
StepDefinitions -  src/test/java/ord/dlg/stepdefs
POM & Page Factory -  src/test/java/ord/dlg/pom

Old style TDD test is also written using JUnit - src/test/java/ord/dlg/test (For this excercise i would like you to consider BDD style test over a TDD style test, i have written this in case for some reason you were unable to run BDD test)

#### Test Objective:
Test validates if a car reg exist on the test system
Test validates if a car reg does NOT exist on the test system
Additionally tests also validate the Cover Start and End dates for valid reg's
Parameterized test can be used with large sets of data as part of Examples, inorder to validate the car reg without the need of writing plenty of scenarios


#### Run Tests:
As a prerequiste JDK 12 or above should be installed
Unzip the folder
Import the project into IDE (preferably IntelliJ or Eclipse)

Run below commands from terminal
mvn clean install
mvn build

Navigate to the feature files located at src/test/resources/features
Right Click the 'registration.feature' file and choose Run 'Feature:registration', this should run all the scenarios in that feature
Alternatively, if only specific features have to be run then right click on the scenario you would like to run and Select - Run 'Scenario-XYZ'
