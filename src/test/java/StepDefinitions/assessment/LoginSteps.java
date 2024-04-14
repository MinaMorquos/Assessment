package StepDefinitions.assessment;

import io.cucumber.java.en.Then;
import org.example.PageView.UI.LoginView;

public class LoginSteps {
    LoginView loginView = new LoginView();

    @Then("user types {string} in input with name {string}")
    public void userTypesInInputWithName(String text, String name) {
         loginView.typeInInputWithName(name,text);
    }


}
