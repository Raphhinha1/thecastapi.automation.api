package restUtils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;
import org.testng.Assert;
import reporting.ExtentReportManager;
import utils.ConfigReader;

public class RestUtils {
    static String xApiKey = ConfigReader.getApiKey();

    private static RequestSpecification getRequestSpecificationString(String endPoint, Object requestPayload) {
        return RestAssured.given().log().all()
                .baseUri(endPoint)
                .header("x-api-key", xApiKey)
                .contentType(ContentType.JSON)
                .body(requestPayload);
    }

    private static void printRequestLogInReport(RequestSpecification requestSpecification) {
        QueryableRequestSpecification queryableRequestSpecification = SpecificationQuerier.query(requestSpecification);
        ExtentReportManager.logInfoDetails("Endpoint is " + queryableRequestSpecification.getBaseUri());
        ExtentReportManager.logInfoDetails("Method is " + queryableRequestSpecification.getMethod());
        ExtentReportManager.logInfoDetails("Request body is");
        ExtentReportManager.logJson(queryableRequestSpecification.getBody());
    }

    private static void printResponseLogInReport(Response response) {
        ExtentReportManager.logInfoDetails("Response status is " + response.getStatusCode());
        ExtentReportManager.logInfoDetails("Response body is");
        ExtentReportManager.logJson(response.getBody().prettyPrint());
    }


    public static Response getVote(String endPoint, String voteId, String subId, Integer page, Integer limit, String order) {
        RequestSpecification requestSpecification = getRequestSpecificationString(endPoint, "");

        if (voteId != null) {
            requestSpecification = getRequestSpecificationString(endPoint + "/" + voteId, "");
        }

        if (subId != null) {
            requestSpecification.queryParam("sub_id", subId);
        }

        if (page != null) {
            requestSpecification.queryParam("page", page);
        }

        if (limit != null) {
            requestSpecification.queryParam("limit", limit);
        }

        if (order != null) {
            requestSpecification.queryParam("order", order);
        }

        Response response = requestSpecification.get();
        printRequestLogInReport(requestSpecification);
        printResponseLogInReport(response);
        return response;
    }



    public static Response votePost(String endPoint, Object requestPayloadAsPojo) {
        RequestSpecification requestSpecification = getRequestSpecificationString(endPoint, requestPayloadAsPojo);
        Response response = requestSpecification.post();
        printRequestLogInReport(requestSpecification);
        printResponseLogInReport(response);
        return response;
    }
}