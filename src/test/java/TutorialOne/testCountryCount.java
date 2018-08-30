package TutorialOne;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;


public class testCountryCount {

    @Test
    public void testCountryCount(){
        String baseURL="http://services.groupkt.com/country/search?text=ania";
        String expectedCountry="Romania";
        List<Object> response=get(baseURL).jsonPath().getList("RestResponse.result.name");

        System.out.println("Response count -"+response.size());
        if(response.contains(expectedCountry)){
            System.out.println("Found the country -"+expectedCountry);
        } else {
            System.out.println("Unable to find the country -"+expectedCountry);
        }
    }
    @Test
    public void testParameters(){
        String baseURL="http://services.groupkt.com/country/search";
        Response response=
        given()
                .queryParam("text","ania")
                .get(baseURL)

               .then()
                .contentType(ContentType.JSON)
                .extract().response();

        System.out.println(response);
    }
    @Test
    public void testCountryCount2(){
        String baseURL="http://services.groupkt.com/country/search?text=ania";
        given()
                .get(baseURL)
                .then()
                .body("RestResponse.result.name.size()",greaterThanOrEqualTo(5));
    }
}
