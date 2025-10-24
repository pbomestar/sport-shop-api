package tests;

import base.BaseTest;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import pojos.Product;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetProductTest extends BaseTest {

    @Test
    public void getProduct() {
        Product product = new Product();

        given()
                .contentType(ContentType.JSON)
                .body(product)
                .when()
                .get("/products/1")
                .then()
                .statusCode(200)
                .body("id", equalTo(1));
    }
}
