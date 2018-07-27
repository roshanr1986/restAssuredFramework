import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Post_Delete_Put_Example {

    @Test
    public void test1(){

        //creating request object
        RequestSpecification request = RestAssured.given();

        //assigning header to the request
        request.header("Content-Type","application/json");

        //initializing new json object
        JSONObject json = new JSONObject();

        //defining the json values to be inserted in the request body
        json.put("id", "6");
        json.put("title", "Title Upd 6");
        json.put("author", "Author Upd Roshan6");



        //attaching the "json" object to the request body
        request.body(json.toJSONString());

        //capturing the response into a response object
        Response response = request.post("http://localhost:3000/posts");

        //capturing the response code and checking if it is success -201
        int statuscode=response.getStatusCode();

        Assert.assertEquals(statuscode,201);
    }
}
