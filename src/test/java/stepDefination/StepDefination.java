package stepDefination;

import io.cucumber.java.en.*;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.Assert;
import pojo.AddPlace;
import pojo.Location;
import resources.APIResources;
import resources.TestDataBuild;
import resources.Utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class StepDefination extends Utils {
    ResponseSpecification resBuilder;
    RequestSpecification res;
    Response    response;
    JsonPath jp;
    RequestSpecification reqBuilder;
   static String placeId;
    TestDataBuild data = new TestDataBuild();

//    @Given("Add place payload")
//    public void add_place_payload() throws IOException {
//        res = given().spec(requestSpecification())
//                .body(data.addPlacePayLoad());
//    }

    @Given("Add place payload with {string} {string} {string}")
    public void add_place_payload_with(String name, String language, String address) throws IOException {
        res = given().spec(requestSpecification())
                .body(data.addPlacePayLoad(name, language, address));
    }


    @When("user calls {string} with {string} http request")
    public void user_calls_with_http_request(String resource, String method) {
        resBuilder = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
        APIResources resourcesAPI = APIResources.valueOf(resource);
        System.out.println(resourcesAPI.getResource());
        if (method.equalsIgnoreCase("POST")) {
            response = res.when().post(resourcesAPI.getResource());
        } else if (method.equalsIgnoreCase("GET")) {
            response = res.when().get(resourcesAPI.getResource());
        }
    }

    @Then("verify place_id created maps to {string} using {string}")
    public void verify_place_id_created_maps_to_using(String expectedName, String resource) throws IOException {
        placeId=getJsonPath(response,"place_id");
        res = given().spec(requestSpecification()).queryParam("place_id",placeId);
        user_calls_with_http_request(resource,"GET");
        String actualName=getJsonPath(response,"name");
        Assert.assertEquals(actualName,expectedName);


    }

    @Then("the a api call got success with status code {int}")
    public void the_a_api_call_got_success_with_status_code(Integer int1) {
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Then("{string} in responce body is {string}")
    public void in_responce_body_is(String keyValue, String expectedValue) {
        Assert.assertEquals(getJsonPath(response,keyValue),expectedValue);
    }

    @Given("DeleteAdd place payload")
    public void delete_add_place_payload() throws IOException {
        res=given().spec(requestSpecification()).body(data.deletePlacePayload(placeId));
    }
}
