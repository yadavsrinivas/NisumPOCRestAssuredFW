package Concepts;

import Files.Utilities;
import Files.payLoad;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Basics {

    //given - all input details
    //when - submit the API - resource, http method
    //Then - validate the response

    public static void main (String[] args){

        RestAssured.baseURI = "https://rahulshettyacademy.com";
       String response = given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
                .body(payLoad.AddPlace())
                .when().post("maps/api/place/add/json")
                .then().assertThat().statusCode(200).body("scope", equalTo("APP"))
                .header("Server", "Apache/2.4.52 (Ubuntu)").extract().response().asString();
                 System.out.println(response);

        //Jsonpath is the one which takes the string as input and it will help to convert Json
        JsonPath js = new JsonPath(response);
        String placeId= js.getString("place_id");
        System.out.println(placeId);



        // content of the file to String-->content of fhe file convert into Byte-> Byte data to String
/*        public static void main (String[] args) throws IOException {

            RestAssured.baseURI = "https://rahulshettyacademy.com";
            String response = given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
                    .body(new String(Files.readAllBytes(Paths.get("D:\\Technical\\addPlace.json"))))
                    .when().post("maps/api/place/add/json")
                    .then().assertThat().statusCode(200).body("scope", equalTo("APP"))
                    .header("Server", "Apache/2.4.52 (Ubuntu)").extract().response().asString();
            System.out.println(response);

            //Jsonpath is the one which takes the string as input and it will help to convert Json
            JsonPath js = new JsonPath(response);
            String placeId= js.getString("place_id");
            System.out.println(placeId);*/

            //update place
        String newAddress = "Nisum Kondapur";
        given().log().all().queryParam("key", "qaClick123").header("Content-Type", "application/json")
                .body("{\n" +
                        "\"place_id\":\""+placeId+"\",\n" +
                        "\"address\":\""+newAddress+"\",\n" +
                        "\"key\" :\"qaclick123\"\n" +
                        "}\n")
                .when().put("maps/api/place/update/json").then().assertThat().statusCode(200).
                body("msg", equalTo("Address successfully updated"));

        // Get place and verfiy the address is successfuly updated or not

        String getAddressResponse = given().log().all().queryParam("key", "qaclick123").queryParam("place_id", placeId)
                .when().get("maps/api/place/get/json").then().assertThat().log().all().statusCode(200)
                .extract().response().asString();
      JsonPath js1 =  Utilities.rawtoJson(getAddressResponse);
       String actualAddress  =  js1.getString("address");
       System.out.println(actualAddress);
       Assert.assertEquals(actualAddress, newAddress);

    }
}
