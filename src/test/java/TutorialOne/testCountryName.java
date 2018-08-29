package TutorialOne;


import io.restassured.http.ContentType;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.ReadExcelData;

import java.lang.reflect.Method;
import static org.hamcrest.Matchers.equalTo;
import static io.restassured.RestAssured.given;

public class testCountryName {

    @DataProvider(name = "countryData")
    public Object[][] getTestData(Method method) throws Exception {
        String testName=method.getName().toString().trim();
        ReadExcelData excelData = new ReadExcelData();
        return excelData.getData(testName,"Sheet1");
    }

    @Test(dataProvider ="countryData")
    public void testCountryName(String iso2code, String name){

        String baseURL="http://services.groupkt.com/country/get/iso2code/";
        //Response response=get(baseURL+iso2code);

        given().
                get(baseURL+iso2code).
                then().
                contentType(ContentType.JSON). // check that the content type return from the API is JSON
                body("RestResponse.result.name",equalTo(name));
    }
}
