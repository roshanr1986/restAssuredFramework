package TutorialOne;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.equalTo;

import static io.restassured.RestAssured.*;

public class TestOneBasicFeatures {

   // @Test
    public void getStatusCode() {
        given().
                get("http://jsonplaceholder.typicode.com/posts/3").
         then().
                statusCode(HttpStatus.SC_OK).
                log().all();
    }

    //@Test
    public void testCountry(){
        String URL="http://services.groupkt.com/country/get/iso2code/US";
        Response response=get(URL);


        given().
                get(URL).
                then().
                contentType(ContentType.JSON). // check that the content type return from the API is JSON
                extract().response(); //extracting the response
        Assert.assertEquals(response.jsonPath().getString("RestResponse.result.name"),"United States of America");

    }
    //@Test
    public void testCountryMethod2(){
        String URL="http://services.groupkt.com/country/get/iso2code/US";
        String expectedName="United States of America";
        String expectedAlpha3Code="USA";
        given().
                get(URL).
                then().
                body("RestResponse.result.name",equalTo(expectedName)).
                body("RestResponse.result.alpha3_code",equalTo(expectedAlpha3Code)).
                log().all();
    }

    @Test
    public void testExtractImageUrl(){
        //extracting the url returned and test if that is available in the server.
        String imageLink=

        when().
                get("http://jsonplaceholder.typicode.com/photos/1").
         then()
                .contentType(ContentType.JSON)
                .body("albumId",equalTo(1))
                .extract().path("url");

        System.out.println("Image URL is - "+imageLink);

        when()
                .get(imageLink)
                .then()
                .statusCode(HttpStatus.SC_OK);

    }
}
