package dealvector.stepdef;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dealvector.lib.StepData;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;

import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsInAnyOrder;


/**
 * Created by UdayN on 28-07-2017.
 */
public class TestStepDef{

    @Given("^I say Hello$")
    public void sayHello(){
        System.out.println("Hello");
    }
    private String ENDPOINT_GET_BOOK_BY_ISBN = "https://www.googleapis.com/books/v1/volumes";
    private StepData stepData;

    public TestStepDef(StepData stepData) {
        this.stepData = stepData;
    }

    @Given("a book exists with an isbn of (.*)")
    public void a_book_exists_with_isbn(String isbn){
        stepData.request = given().param("q", "isbn:" + isbn);
    }

    @When("a user retrieves the book by isbn")
    public void a_user_retrieves_the_book_by_isbn(){
        stepData.response = stepData.request.when().get(ENDPOINT_GET_BOOK_BY_ISBN);
    }
    @And("response includes the following$")
    public void response_equals(Map<String,String> responseFields){
        for (Map.Entry<String, String> field : responseFields.entrySet()) {
            if(StringUtils.isNumeric(field.getValue())){
                stepData.json.body(field.getKey(), equalTo(Integer.parseInt(field.getValue())));
            }
            else{
                stepData.json.body(field.getKey(), equalTo(field.getValue()));
            }
        }
    }

    @Then("the status code is (\\d+)")
    public void verify_status_code(int statusCode){
        stepData.json = stepData.response.then().statusCode(statusCode);
    }

    @And("response includes the following in any order")
    public void response_contains_in_any_order(Map<String,String> responseFields){
        for (Map.Entry<String, String> field : responseFields.entrySet()) {
            if(StringUtils.isNumeric(field.getValue())){
                stepData.json.body(field.getKey(), containsInAnyOrder(Integer.parseInt(field.getValue())));
            }
            else{
                stepData.json.body(field.getKey(), containsInAnyOrder(field.getValue()));
            }
        }
    }
}

