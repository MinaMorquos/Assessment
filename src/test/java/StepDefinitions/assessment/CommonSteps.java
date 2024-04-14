package StepDefinitions.assessment;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.example.PageView.UI.CommonView;

public class CommonSteps {
    CommonView view = new CommonView();


    @Then("user assert he is in page {string}")
    public void userAssertHeIsInPage(String pageName) {
        view.assertPageOpened(pageName);
    }
    @And("user clicks on button with text {string} and type {string}")
    public void userClicksOnSubmitButton(String text,String type) {
        view.clickOnButton(text,type);
    }
}
