package Tests;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class LocalTest {

    @Test(priority = 1)
    public void getUsers()
    {
        baseURI = "http://localhost:3000";
        given()
                .get("/users")
        .then()
                .statusCode(200)
                .log().all();
    }

    @Test(priority = 2)
    public void postUser()
    {
        JSONObject request = new JSONObject();

        request.put("email","pavindu@gmail.com");
        request.put("first_name","pavindu");
        request.put("last_name","Shashith");
        request.put("subjectId",2);


        baseURI = "http://localhost:3000";
        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toJSONString())
        .when()
                .post("/users")
        .then()
                .statusCode(201)
                .log().all();

    }

    @Test(priority = 3)
    public void putUser()
    {
        JSONObject request = new JSONObject();

        request.put("email","pavindu@gmail.com");
        request.put("first_name","pavi");
        request.put("last_name","Shashi");
        request.put("subjectId",2);


        baseURI = "http://localhost:3000";
        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toJSONString())
                .when()
                .put("/users/6")
                .then()
                .statusCode(200)
                .log().all();

    }
    @Test(priority = 4)
    public void deleteUsers()
    {
        baseURI = "http://localhost:3000";

        when()
                .delete("/users/6")
        .then()
                .statusCode(200);
    }

}
