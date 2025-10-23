package base;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import java.util.Properties;
import java.io.FileInputStream;

public class BaseTest {
    protected static Properties config;

    @BeforeClass
    public void setup() throws Exception {
        config = new Properties();
        config.load(new FileInputStream("src/main/resources/config.properties"));
        RestAssured.baseURI = config.getProperty("base.url");
    }
}
