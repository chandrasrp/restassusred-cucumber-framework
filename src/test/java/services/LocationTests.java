package services;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import static net.javacrumbs.jsonunit.JsonAssert.assertJsonEquals;
import static net.javacrumbs.jsonunit.core.Option.IGNORING_ARRAY_ORDER;
import static net.javacrumbs.jsonunit.core.Option.IGNORING_EXTRA_FIELDS;
import static net.javacrumbs.jsonunit.core.util.ResourceUtils.resource;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import net.javacrumbs.jsonunit.JsonAssert;
import org.apache.http.HttpStatus;
import org.junit.Test;


public class LocationTests {
    //private static String ENDPOINT_GET_LOCATION = "http://api.citybik.es/v2/networks/visa-frankfurt";

    @Test
    public void testGetByLocation() {
        /*RestAssured.baseURI = "http://api.citybik.es";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("/v2/networks/visa-frankfurt");
        ResponseBody body = response.getBody();
        String bodyStringValue = body.asString();
        assertJsonEquals(resource("src/test/responseData/response.json"), bodyStringValue);*/

        Response response = when().get("http://api.citybik.es/v2/networks/visa-frankfurt");
        response
                .then()
                .statusCode(200);
        JsonAssert.setOptions(IGNORING_ARRAY_ORDER, IGNORING_EXTRA_FIELDS);
        // compares two JSON documents
       assertJsonEquals(resource("response.json"), response.asString());

    }

}