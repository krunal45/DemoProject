package steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import gherkin.deps.com.google.gson.JsonObject;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.apache.http.util.Asserts;
import org.testng.Assert;
import utils.CommonUtil;
import utils.FileUtil;

import java.util.ArrayList;
import java.util.List;

public class APISteps {
    List<String> val = new ArrayList<>();
    static String var1 = "";

    @And("^Make Post call from \"([^\"]*)\" with \"([^\"]*)\" and save response as variable and check if status is \"([^\"]*)\"$")
    public void makeCallAndSaveResponseAsVariable(String filePath, String endPoint, String statusCode) {
        ValidatableResponse response = RestAssured.given().contentType(ContentType.JSON).body(filePath).when().post(endPoint).then().statusCode(Integer.parseInt(statusCode));
        var1 = response.toString();
        CommonUtil.setVar(var1);
    }

    @Then("^Validate response body json with \"([^\"]*)\"$")
    public void validateBodyJsonWith(String filePath) {
        String var2;
        JsonPath jsonPath = new JsonPath(filePath);
        var2 = jsonPath.toString();
        Assert.assertEquals(var1, var2, "FAIL: Reponse mismatch");
    }
}
