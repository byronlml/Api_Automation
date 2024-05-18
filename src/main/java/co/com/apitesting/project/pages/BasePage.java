package co.com.apitesting.project.pages;

import co.com.apitesting.project.util.JsonReader;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class BasePage {

    public Response createRecord(String url, String path, String data) throws IOException, ParseException {
        return RestAssured.given()
                .baseUri(url)
                .body(JsonReader.getTestData(data))
                .post(path);
    }

    public Response getRecord(String url, String path) {
        return RestAssured.given()
                .baseUri(url)
                .get(path);
    }

    public Response deleteRecord(String url, String path, String id) {
        return RestAssured.given()
                .baseUri(url)
                .delete(path + "/" + id);
    }

    public Response updateRecord(String url, String path, String data, String id) throws IOException, ParseException {
        return RestAssured.given()
                .baseUri(url)
                .body(JsonReader.getTestData(data))
                .put(path + "/" + id);
    }

    public String extractJsonField(Response response, String jsonPathExpression) {
        JsonPath jsonPath = response.jsonPath();
        return jsonPath.getJsonObject(jsonPathExpression).toString();
    }

}
