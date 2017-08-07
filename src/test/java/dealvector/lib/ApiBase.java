package dealvector.lib;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;
import java.util.NoSuchElementException;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.responseSpecification;

/**
 * Created by UdayN on 28-07-2017.
 */
public class ApiBase {
    public enum MethodType{
        GET ("get"),
        POST    ("post"),
        DELETE  ("delete"),
        PUT     ("put");
        private String _label;

        MethodType(String label) {
            _label = label;
        }

        public String toString() {
            return _label;
        }
    }

    protected ValidatableResponse json;
    protected String endpoint;
    protected Response response;
    protected RequestSpecification request;

    public RequestSpecification getRequest(){
        return request;
    }

    public Response getResponse(){
        return response;
    }

    private void createRequestFromParams(HashMap<String,Object> params){
        request =  given().params(params);
    }

    public void makeCall(MethodType type, HashMap params,String url){
        createRequestFromParams(params);
        response = request.when().get(url);
    }

    public void isStatusCode(int code){
        json = response.then().statusCode(code);
    }

    /*public void verifyIntField(){
        json.body("totalItems",equals(0));
    }*/
}
