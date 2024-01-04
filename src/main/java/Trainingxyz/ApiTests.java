package Trainingxyz;



import io.restassured.RestAssured;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class ApiTests {

    @Test
    public void getCategories(){
        String endpoint = "http://localhost:8888/api_testing/category/read.php";
    given().when().get(endpoint).then();

    }

}

