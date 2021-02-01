package api;


import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class RestAssured {
    public static void main(String args[])
    {
        makeAPICallRestAssured();
    }

    private static void makeAPICallRestAssured() {
        Response response = given().get("https://jsonplaceholder.typicode.com/posts");
        System.out.println(response.statusCode());
        System.out.println(response.asString());
        System.out.println(response.getBody().asString());
        System.out.println(response.statusLine());
    }
}


