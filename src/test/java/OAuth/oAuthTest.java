package OAuth;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class oAuthTest {

    public static void main (String[] args){

       String Response = given()
                .formParams("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
                .formParams("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
                .formParams("grant_type","client_credentials")
                .formParams("scope", "scope")
                .when().log().all()
                .post("https://rahulshettyacademy.com/oauthapi/oauth2/resourceOwner/token")
                .asString();
       System.out.println(Response);

        JsonPath jsonpath = new JsonPath(Response);
      String accessToken =  jsonpath.getString("access_token");


   String response2 =   given()
              .queryParam("access_token", accessToken)
              .when().log().all()
              .get("https://rahulshettyacademy.com/oauthapi/getCourseDetails").asString();

     System.out.println(response2);
    }

}
