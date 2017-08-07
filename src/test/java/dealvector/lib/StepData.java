package dealvector.lib;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

/**
 * Created by UdayN on 02-08-2017.
 */
public class StepData {

    public Response response;
    public ValidatableResponse json;
    public RequestSpecification request;
    public String sessionId;
    private String login = "https://sharad.dealvector.com/auth/login";

    public Response getResponse(){
        return response;
    }

    public ValidatableResponse getJson(){
        return json;
    }

    public RequestSpecification getRequest(){
        return request;
    }

    public void setResponse(Response response){
        this.response = response;
    }

    public void setJson(ValidatableResponse json){
        this.json = json;
    }

    public void setRequest(RequestSpecification request){
        this.request = request;
    }
}
