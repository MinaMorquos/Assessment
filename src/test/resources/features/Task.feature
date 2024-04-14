@Ui
Feature: CreateUser

  Scenario: Create then delete user
    Given user opens browser "edge"
    And   User opens url "https://opensource-demo.orangehrmlive.com"
    Then  user types "Admin" in input with name "username"
    Then  user types "admin123" in input with name "password"
    And   user clicks on button with text "Login" and type "submit"
    Then  user assert he is in page "Dashboard"
    And   user clicks on "Admin" tab from the menu
    Then  user assert he is in page "Admin"
    And   user gets the total record number
    And   user clicks on button with text "Add" and type "button"
    And   user clicks on "User Role" drop down list and select "Admin"
    And   user clicks on "Status" drop down list and select "Enabled"
    And   user selects employee from "Employee Name"
    And   user writes "EUN" in "Username" input
    And   user writes "P@assword123" in "Password" input
    And   user writes "P@assword123" in "Confirm Password" input
    And   user clicks on button with text "Save" and type "submit"
    And   user validates the user is created successfully and records number is increased by 1
    And   user search with created username
    And   user clicks on button with text "Search" and type "submit"
    And   user clicks on delete button
    And   user clicks on button with text "Reset" and type "button"
    And   user validates the user is deleted successfully and records number is decreased by 1
    And   user close the browser

