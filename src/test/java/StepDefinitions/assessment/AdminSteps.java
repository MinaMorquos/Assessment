package StepDefinitions.assessment;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.example.PageView.UI.AdminView;

public class AdminSteps {
    AdminView adminView = new AdminView();

    @Then("user clicks on {string} tab from the menu")
    public void userClicksOnAdminTabFromTheMenu(String tabName) {
        adminView.clickOnTabWithName(tabName);
    }

    @And("user gets the total record number")
    public void userGetsTheTotalRecordNumber() {
        adminView.getTotalRecords();
    }

    @And("user clicks on {string} drop down list and select {string}")
    public void userClicksOnDropDownListAndSelect(String labelName, String optionText) {
        adminView.fillDDLUnderLabelWithName(labelName,optionText);
    }

    @And("user writes {string} in {string} input")
    public void userWritesInInput(String text, String labelName) {
        adminView.fillInputUnderLabelWithName(text,labelName);
    }

    @And("user selects employee from {string}")
    public void userSelectsEmployeeFrom(String labelName){
        adminView.selectEmployee(labelName);
    }

    @And("user validates the user is created successfully and records number is increased by {int}")
    public void userValidatesTheUserIsCreatedSuccessfully(int num) {
        adminView.validateUserIsCreated();
        adminView.validateRecordsNumberIsChanged(num);
    }

    @And("user search with created username")
    public void userSearchWithCreatedUsername() {
        adminView.typeCreatedUser();
    }

    @And("user clicks on delete button")
    public void userClicksOnDeleteButton() {
        adminView.clickOnDeleteIcon();
        adminView.clickOnDeleteIconFromAlert();
    }

    @And("user validates the user is deleted successfully and records number is decreased by {int}")
    public void userValidatesTheUserIsDeletedSuccessfullyAndRecordsNumberIsDecreasedBy(int num) {
        adminView.validateUserIsDeleted();
        adminView.validateRecordsNumberIsChanged(1-num);
    }
}
