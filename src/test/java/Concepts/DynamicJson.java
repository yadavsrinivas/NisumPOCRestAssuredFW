package Concepts;

import Files.ReUsableMethods;
import Files.payLoad;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class DynamicJson {

/*    @Test(dataProvider = "BooksData")
    public void addBook(String isbn, String aisle){
        RestAssured.baseURI="http://216.10.245.166";
       String response =  given().header("Content-Type", "application/json")
                .body(payLoad.Addbook(isbn, aisle))
                .when()
                .post("/Library/Addbook.php")
                .then().log().all().assertThat().statusCode(200)
                .extract().response().asString();
        JsonPath js = ReUsableMethods.rawToJson(response);
        String id = js.get("ID");
        System.out.println(id);
    }*/


    @Test(dataProvider = "BooksData")
    public void deleteBook(String isbn, String aisle){
        RestAssured.baseURI="http://216.10.245.166";
        String response =  given().header("Content-Type", "application/json")
                .body(payLoad.Addbook(isbn, aisle))
                .when()
                .delete("/Library/Addbook.php")
                .then().log().all().assertThat().statusCode(200)
                .extract().response().asString();
        JsonPath js = ReUsableMethods.rawToJson(response);
      //  String msg = js.getString();
      //  System.out.println(id);
    }

    @DataProvider(name ="BooksData")
    public Object[][] getData(){
        //array = collection of elements
        //multidimesional array collection of arrays
        return new Object[][] {{"test2","1112"}, {"test3","1113"}, {"test4","1114"}};
    }

  }
