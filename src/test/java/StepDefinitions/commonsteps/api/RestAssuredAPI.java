package StepDefinitions.commonsteps.api;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.asynchttpclient.Response;
import static  org.example.PageView.API.RestAssuredAPIView.getInstance;

public class RestAssuredAPI {
    private static Response getResponse;
    private static Response postResponse;


    @Given("the base URL is {string}")
    public void theBaseURLIs(String baseUrl) {
        getInstance().setBaseUrl(baseUrl);
    }

    @And("the endpoint is {string}")
    public void theEndpointIs(String endPoint) {
        getInstance().setEndPoint(endPoint);
    }
}
