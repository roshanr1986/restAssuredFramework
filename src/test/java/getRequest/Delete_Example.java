package getRequest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class Delete_Example {

    @Test
    public void test2(){

        //creating request object
        RequestSpecification request = RestAssured.given();

        //capturing the response into a response object
        Response response = request.delete("http://localhost:3000/posts/3");

        //capturing the response code and checking if it is success -201
        int statuscode=response.getStatusCode();

        Assert.assertEquals(statuscode,200);
    }

    @Test
    public void test_multiple_delete(){

        //creating request object
        RequestSpecification request = RestAssured.given();

       String recordsToDelete[]={"4","5"};
        List<String> deleteList=new LinkedList<String>();
        Collections.addAll(deleteList, recordsToDelete);

       // System.out.println(deleteQue);
       for(int i=0;i< deleteList.size();i++) {

           //capturing the response into a response object
           Response response = request.delete("http://localhost:3000/posts/"+deleteList.get(i).toString());

           //capturing the response code and checking if it is success -201
           int statuscode=response.getStatusCode();

           Assert.assertEquals(statuscode,200);

       }
       // System.out.println(deleteQue.element());

    }
}
