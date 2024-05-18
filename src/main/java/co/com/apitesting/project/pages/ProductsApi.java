package co.com.apitesting.project.pages;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.simple.parser.ParseException;


import java.io.IOException;

import static co.com.apitesting.project.util.Constants.*;


public class ProductsApi {

    BasePage basePage = new BasePage();
    public void configureEndpoint() {
        RestAssured.given().baseUri(BASEURL);
    }

    public Response getProducts() {
        return basePage.getRecord(BASEURL, PRODUCTS_PATH);
    }

    public Response deleteProducts(String id) {
        return basePage.deleteRecord(BASEURL, PRODUCTS_PATH, id);
    }

    public Response createProduct() throws IOException, ParseException {
        return basePage.createRecord(BASEURL, PRODUCTS_PATH, PRODUCT_DATA);
    }

    public Response updateProduct(String id) throws IOException, ParseException {
        return basePage.updateRecord(BASEURL, PRODUCTS_PATH, PRODUCT_DATA, id);
    }

}
