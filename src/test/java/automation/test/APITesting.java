package automation.test;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class APITesting {

    RequestSpecification request = RestAssured.given();

    @BeforeClass
    public static void setupURL() {
        // here we setup the default URL and API base path to use throughout the tests
        RestAssured.baseURI = "https://reqres.in/api/unknown";
    }

    String apiURL = "https://reqres.in/api/users";

    @Test
    public void verfiyNameExists() {
        given().when().get("https://reqres.in/api/users?per_page=8").then().body(containsString("Lindsay"));
    }

    @Test
    public void verifyNameStructured() {
        given().when().get("https://reqres.in/api/users?per_page=8").then().body("data[0].first_name", equalTo("George"));
    }

    @Test
    public void verifyTopLevelURL() {
        given().when().get("https://reqres.in/api/users?per_page=8").then()
                .body("data[0].first_name", equalTo("George"))
                .body("data[0].id", equalTo(1))
                .body("data[0].last_name", equalTo("Bluth"))
                .statusCode(200);
    }

    @Test
    public void listOfNames() {
        given().when().get("https://reqres.in/api/users?per_page=8").then()
                .body("data.findAll { it.id < 3 }.first_name", hasItems("George", "Janet"))
                .statusCode(200);
    }

    @Test
    public void paramSyntax() {
        given()
                .param("per_page", "8").
                expect().
                statusCode(200).
                body("data.findAll.size()", equalTo(8)).
                when().
                get(apiURL);
    }

    @Test
    public void postMessageAndPrintResponse() {
        Map<String, String> requestParams = new HashMap<>();
        requestParams.put("resource", "test");

        Response response = request.contentType("application/json").body(requestParams).post(baseURI);
        System.out.printf("printtt" + response.body().asString());
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 201);
    }

}
