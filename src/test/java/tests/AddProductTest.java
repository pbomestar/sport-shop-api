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
//        Product product = new Product();
//        product.setId(111);
//        product.setTitle("Nike Football");
//        product.setPrice(49.99);
//        product.setDescription("High quality football for training");
//        product.setCategory("sports");
//        product.setImage("https://picsum.photos/200");

        String newProduct = """
            {
              "title": "Nike Football",
              "price": 49.99,
              "description": "High quality football for training",
              "image": "https://picsum.photos/200",
              "category": "sports"
            }
            """;

        given()
                .contentType(ContentType.JSON)
                .body(newProduct)
                .when()
                .post("/products")
                .then()
                .statusCode(201)
                .body("title", equalTo("Nike Football"));
    }
}
