package co.com.apitesting.project.stepsdefinitions;

import co.com.apitesting.project.pages.ProductsApi;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import static org.testng.AssertJUnit.assertEquals;

public class ProductApiDelete {

    private Response response;
    ProductsApi productsApi = new ProductsApi();

    @Given("I hit the url of delete products api endpoint")
    public void i_hit_the_url_of_delete_products_api_endpoint() {
        productsApi.configureEndpoint();
    }
    @When("I pass the url of delete products in the request with {string}")
    public void i_pass_the_url_of_delete_products_in_the_request_with(String id) {

        response = productsApi.deleteProducts(id);
        System.out.println(response);
    }

    @Then("I get the response code as {int}")
    public void i_get_the_response_code_as(int code) {
        assertEquals(response.getStatusCode(), code);
    }
}
