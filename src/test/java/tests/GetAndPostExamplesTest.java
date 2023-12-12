package tests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.hasItems;

public class GetAndPostExamplesTest {

    @Test
    public void sample_test_get() {
        baseURI = "https://reqres.in/api";
        given()
            .get("/users?page=2")
        .then()
            .statusCode(200)
            .body("data.first_name", hasItems("Michael","George"));
    }

    @Test
    public void sample_test_post(){
        baseURI = "https://reqres.in/api";

        Map<String, Object> map = new HashMap<String,Object>();
        JSONObject request = new JSONObject();
        request.put("name","suresh");
        request.put("job","teacher");

        given()
            .body(request.toJSONString())
        .when()
            .post("/users")
        .then()
            .statusCode(201).log().all();
    }
}
