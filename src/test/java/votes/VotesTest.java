package votes;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import votes.pojos.Votes;

import java.util.Map;


public class VotesTest extends VotesAPIs {
    double number = (int) Math.floor(Math.random() * 1000);
    String image = "e7t";

    @Test
    public void createUpVote() {

        Votes payload = Payloads.getCreateVotesPayloadFromPojo(image, "raphhinha1", "1");
        Response response = createVote(payload);
        Assert.assertEquals(response.statusCode(), 201);
        Assert.assertEquals(response.jsonPath().getString("message"), "Failure");
    }

//    @Test
//    public void createDownVote() {
//
//        Map<String, Object> payload = Payloads.getCreateVotesPayloadFromMap(image, "raphhinha2", "-1");
//        Response response = createVote(payload);
//        Assert.assertEquals(201, response.statusCode());
//
//    }
//
//    @Test
//    public void createWithoutImageIdVote() {
//
//        Map<String, Object> payload = Payloads.getCreateVotesPayloadFromMap("", "raphhinha1", "1");
//        Response response = createVote(payload);
//        Assert.assertEquals(400, response.statusCode());
//    }
//
//    @Test
//    public void createWithoutSubIdVote() {
//
//        Map<String, Object> payload = Payloads.getCreateVotesPayloadFromMap(image, "", "1");
//        Response response = createVote(payload);
//        Assert.assertEquals(400, response.statusCode());
//    }

//    @Test
//    public void createWithoutValueVote() {
//
//        Votes payload = Payloads.getCreateVotesPayloadFromPojo(image, "raphhinha1", "");
//        Response response = createVote(payload);
//        Assert.assertEquals(400, response.statusCode());
//    }

//    @Test
//    public void createDifferentValueVote() {
//
//        Map<String, Object> payload = Payloads.getCreateVotesPayloadFromMap(image, "raphhinha1", "2");
//        Response response = createVote(payload);
//        Assert.assertEquals(400, response.statusCode());
//    }

//    @Test
//    public void getAllVotes() {
//        RestAssured.given().log().all()
//                .baseUri("https://api.thecatapi.com/v1/votes")
//                .header("x-api-key", "live_OPZZQUS7wlcd4ztnHXoAmvJzaEyzRIM1lhkJCgASGuGS0sc9z6vIA2IYBo1GOiIq")
//                .when()
//                .get()
//                .then()
//                .log().all().extract().response();
//    }
}
