package getRequest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.equalToIgnoringCase;




public class TestGet extends BaseClass {
    public static String responseJson;
   // String URL = "http://localhost:3000/posts/1";


    @Test
    public void TestGet(){



        Response response=
        RestAssured
                .when()
                .get(baseURI+"1")

                .then()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .contentType(ContentType.JSON)
                .extract().response();


        responseJson = response.asString();

        String id=response.jsonPath().getString("id");
        String title=response.jsonPath().getString("title");
        String author=response.jsonPath().getString("author");

    }

    @Test
    public void testGet2(){

            System.out.println(baseURL+"1");

        given()
                .accept(ContentType.JSON)
                .when()
                .get(baseURL+"1")
                .then()
                .body("title",equalToIgnoringCase("json-server"),
                        "id",equalTo(1),
                        "author",equalToIgnoringCase("typicode"));

    }

}
