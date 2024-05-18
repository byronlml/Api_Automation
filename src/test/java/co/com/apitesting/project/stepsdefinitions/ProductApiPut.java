package co.com.apitesting.project.stepsdefinitions;

import co.com.apitesting.project.pages.BasePage;
import co.com.apitesting.project.pages.ProductsApi;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.json.simple.parser.ParseException;

import java.io.IOException;

import static org.testng.AssertJUnit.assertEquals;

public class ProductApiPut {

    private Response response;

    ProductsApi productsApi = new ProductsApi();
    BasePage basePage = new BasePage();

    @Given("I hit the url of put products api endpoint")
    public void i_hit_the_url_of_put_products_api_endpoint() {
        productsApi.configureEndpoint();
    }

    @When("I pass the url of products in the request with {string}")
    public void i_pass_the_url_of_products_in_the_request_with(String id) throws IOException, ParseException {
        response = productsApi.updateProduct(id);
    }

    @Then("I catch the response code as {int}")
    public void i_catch_the_response_code_as(int code) {
        assertEquals(response.getStatusCode(), code);
    }

    @Then("I catch the response body with id as {string}")
    public void i_catch_the_response_body_with_id_as(String id) {

        String result = basePage.extractJsonField(response, "id");
        assertEquals(id,  result);
    }

}
