package stepdefs;

import static io.restassured.RestAssured.given;
import static net.javacrumbs.jsonunit.JsonAssert.assertJsonEquals;
import static net.javacrumbs.jsonunit.core.util.ResourceUtils.resource;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import io.restassured.response.ResponseBody;
import org.apache.commons.lang3.StringUtils;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class LocationStepDefinitions {

    private Response response;
    private ValidatableResponse json;
    private RequestSpecification request;

    private String ENDPOINT_GET_BIKE_LOCATION = "http://api.citybik.es/v2/networks/visa-frankfurt";


    @Given("^city bike notwork available in Frankfurt$")
    public void city_bike_notwork_available_in_frankfurt() {
        request = given();
        System.out.println(" step 1 executed");
    }

    @When("^user requests location data using network api endpoint$")
    public void user_requests_location_data_using_network_api_endpoint()  {
        response = request.when().get(ENDPOINT_GET_BIKE_LOCATION);
        System.out.println("response: " + response.prettyPrint());
        System.out.println(" step 2 executed");
    }

    @Then("^the status code is (\\d+) returned$")
    public void verify_status_code(int statusCode){
        json = response.then().statusCode(statusCode);
        System.out.println(" step 3 executed");
    }
  /* @And("^response include the following$")*/
  /*  public void response_contains_in_any_order(Map<String,String> responseFields)*/
  /*  {*/
  /*      for (Map.Entry<String, String> field : responseFields.entrySet()) {*/
  /*          if(StringUtils.isNumeric(field.getValue())){*/
  /*              json.body(field.getKey(), containsInAnyOrder(Integer.parseInt(field.getValue())));*/
  /*          }*/
  /*          else{*/
  /*              json.body(field.getKey(), containsInAnyOrder(field.getValue()));*/
  /*          }*/
  /*      }*/
  /*  }*/
/**/
/**/


    @And("^response include the following$")
    public void response_contains_in_any_order(Map<String,String> responseFields)
    {
        json=response.then();
        System.out.println("JsonBody: "+json.extract().body().asString());

        for (Map.Entry<String, String> field : responseFields.entrySet()) {
            if(StringUtils.isNumeric(field.getValue())){
                json.body(field.getKey(), containsInAnyOrder(Integer.parseInt(field.getValue())));
            }
            else{
                json.body(field.getKey(), containsInAnyOrder(field.getValue()));
            }
        }
    }




}

