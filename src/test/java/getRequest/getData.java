package getRequest;

import static io.restassured.RestAssured .*;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class getData {
String URL="http://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22";
    public static String jsonAsString;
    public static Response response;

@Test
    public void testResponseCode(){

      Response resp=get(URL);
      int code=resp.getStatusCode();

      System.out.print("The staus is "+ code);
        Assert.assertEquals(code,200);
    }

    @Test
    public void testBody(){
        Response response=get(URL);


        String data=response.asString();
        long time=response.getTime();
        int status= response.statusCode();


        response =
                when().
                        get(URL).
                        then().
                        contentType(ContentType.JSON).  // check that the content type return from the API is JSON
                        extract().response(); // extract the response

        // We convert the JSON response to a string, and save it in a variable called 'jsonAsString'
       jsonAsString = response.asString();

       String dt=response.jsonPath().getString("dt");
       String country=response.jsonPath().getString("sys.country");


        System.out.println("The Country "+ jsonAsString);
        System.out.println("dt VALUE "+ dt);
        System.out.println("County "+ country);
        System.out.println("The Status "+ status);
        System.out.println("The Response is "+ data);
        System.out.println("The response time "+ time);

    }

}
