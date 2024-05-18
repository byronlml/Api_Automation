package co.com.apitesting.project.stepsdefinitions;

import co.com.apitesting.project.pages.BasePage;
import co.com.apitesting.project.pages.ProductsApi;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import static org.testng.AssertJUnit.assertEquals;


public class ProductApiGet {

    private Response response;
    private final ProductsApi productsApi = new ProductsApi();
    BasePage basePage = new BasePage();

    @Given("I configure the url of get products api endpoint")
    public void i_configure_the_url_of_get_products_api_endpoint() {
        productsApi.configureEndpoint();

    }
    @When("I pass the url of products in the request")
    public void i_pass_the_url_of_products_in_the_request() {
        response = productsApi.getProducts();

    }

    @Then("I validate the response code as {int}")
    public void i_validate_the_response_code_as(int code) {
        assertEquals(response.getStatusCode(), code);
    }

    @Then("I verify that the rate of the first product is {string}")
    public void i_verify_that_the_rate_of_the_first_product_is(String rate) {

        String result = basePage.extractJsonField(response, "rating[0].rate");
        assertEquals(rate,  result);
    }

}
