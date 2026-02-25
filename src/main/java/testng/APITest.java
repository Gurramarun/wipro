package testng;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class APITest {

    @BeforeClass
    public void setup() {
        baseURI = "https://dummyjson.com";
    }

    @Test
    public void getAllProductsTest() {

        Response response = 
                given()
                .when()
                    .get("/products")
                .then()
                    .log().all()                  // Print full response
                    .statusCode(200)              // Validate status code
                    .body("products[0].id", equalTo(1)) // Validate first product id
                    .body("products.size()", greaterThan(0)) // Validate products list not empty
                    .extract()
                    .response();

        // Extract and print some values
        int firstProductId = response.jsonPath().getInt("products[0].id");
        String firstProductTitle = response.jsonPath().getString("products[0].title");

        System.out.println("First Product ID: " + firstProductId);
        System.out.println("First Product Title: " + firstProductTitle);
    }

    @Test
    public void getSingleProductTest() {

        given()
        .when()
            .get("/products/2")
        .then()
            .log().all()
            .statusCode(200)
            .body("id", equalTo(2))
            .body("title", notNullValue());
    }
}