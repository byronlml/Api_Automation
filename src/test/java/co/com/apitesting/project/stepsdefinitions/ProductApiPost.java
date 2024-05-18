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

public class ProductApiPost {

    private Response response;

    private final ProductsApi productsApi = new ProductsApi();
    BasePage basePage = new BasePage();


    @Given("I configure the url of post products api endpoint")
    public void i_configure_the_url_of_post_products_api_endpoint() {
        productsApi.configureEndpoint();

    }

    @When("I pass the request body of product")
    public void i_pass_the_request_body_of_product_title_price_description_image_and_category() throws IOException, ParseException {

        response = productsApi.createProduct();
    }

    @Then("I receive the response code as {int}")
    public void i_receive_the_response_code_as(int code) {
        assertEquals(response.getStatusCode(), code);
    }

    @Then("I receive the response body with id as {string}")
    public void i_receive_the_response_body_with_id_as(String id) {

        String result = basePage.extractJsonField(response, "id");
        assertEquals(id,  result);
    }
}
