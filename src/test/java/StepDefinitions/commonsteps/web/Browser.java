package StepDefinitions.commonsteps.web;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.example.common.base.BaseBrowser;


public class Browser{
    BaseBrowser baseBrowser = new BaseBrowser();

    @Given("User opens url {string}")
    public void userOpensUrl(String url) {
        baseBrowser.navigateToHome(url);
    }

    @Given("user opens browser {string}")
    public void userOpensBrowser(String browserName) {
        baseBrowser.setUpDriver(browserName);
    }

    @And("user close the browser")
    public void userCloseTheBrowser() {
        baseBrowser.closeDriver();
    }
}
