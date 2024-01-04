package Concepts;

import Files.payLoad;
import io.restassured.path.json.JsonPath;

import java.net.StandardSocketOptions;

public class ComplexJsonParse {

    public static void main(String[] args) {

        JsonPath js = new JsonPath(payLoad.CoursePrice());
        //print No. of courses returned in API
        int count = js.getInt("courses.size()");
        System.out.println(count);

        System.out.println("Print purchase Amount");
        int totalAMount = js.getInt("dashboard.purchaseAmount");
        System.out.println(totalAMount);

        System.out.println("print title of first course");

        String title = js.getString("courses[0].title");
        System.out.println(title);

        System.out.println("print all course title and respective prices");


        for(int i=0; i<count; i++)
        {
           String courseTitles= js.get("courses["+i+"].title");
            System.out.println(js.get("courses["+i+"].price").toString());
           System.out.println(courseTitles);
        }

        System.out.println("print No. of copies sold by RPA");

        for(int i=0; i<count; i++) {
            String courseTitles = js.get("courses[" + i + "].title");
            if(courseTitles.equalsIgnoreCase("RPA"))
            {
               int copies = js.get("courses["+i+"].copies");
               System.out.println(copies);
               break;
            }

        }

        }
}
