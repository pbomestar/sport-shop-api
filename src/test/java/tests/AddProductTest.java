package tests;

import base.BaseTest;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import pojos.Product;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class AddProductTest extends BaseTest {

    @Test
    public void createProduct() {
        Product product = new Product();
        product.setTitle("Nike Football");
        product.setPrice(49.99);
        product.setDescription("High quality football for training");
        product.setCategory("sports");

        given()
                .contentType(ContentType.JSON)
                .body(product)
                .when()
                .post("/products")
                .then()
                .statusCode(200)
                .body("title", equalTo("Nike Football"));
    }
}
