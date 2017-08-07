package dealvector.apiObject;

import dealvector.lib.ApiBase;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

/**
 * Created by UdayN on 28-07-2017.
 */
public class FirstApi extends ApiBase {

    String query;
    String volumeId;
    String download;
    String filter;
    String langRestrict;
    String libraryRestrict;
    String maxResult;
    String orderBy;
    String partner;
    String printType;
    String projection;
    String showPreorders;
    String source;
    String startIndex;

    private String ENDPOINT_GET_BOOK_BY_ISBN = "https://www.googleapis.com/books/v1/volumes";

    public void getListOfVolumesBySearchQuery(String query){
        HashMap<String,Object> hm = new HashMap<String, Object>();
        hm.put("q",query);
        makeCall(MethodType.GET,hm,ENDPOINT_GET_BOOK_BY_ISBN);
    }

    public void getTotalItem(){
    }

    public void serachUsingQuery(){
//        given().param("q", "isbn:" + isbn);
    }
}
