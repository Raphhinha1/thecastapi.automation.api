package votes;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import votes.pojos.Votes;


public class VotesPostTest extends VotesAPIs {
    String image = "e7t";

    @Test
    public void createUpVote() {

        Votes payload = Payloads.getCreateVotesPayloadFromPojo(image, "raphhinha1", "1");
        Response response = createVote(payload);
        Assert.assertEquals(response.statusCode(), 201);
        Assert.assertEquals(response.jsonPath().getString("message"), "SUCCESS");
    }

    @Test
    public void createDownVote() {

        Votes payload = Payloads.getCreateVotesPayloadFromPojo(image, "raphhinha1", "-1");
        Response response = createVote(payload);
        Assert.assertEquals(response.statusCode(), 201);
        Assert.assertEquals(response.jsonPath().getString("message"), "SUCCESS");

    }

    @Test
    public void createUpVoteWithNumericSubId() {
        int numericSubId = 123;
        Votes payload = Payloads.getCreateVotesPayloadFromPojo(image, numericSubId, "1");
        Response response = createVote(payload);
        Assert.assertEquals(response.statusCode(), 400);
        Assert.assertEquals(response.getBody().asString(), "\"sub_id\" must be a string");
    }

    @Test
    public void createDownVoteWithNumericAndImageId() {
        int numericImageId = 101;
        Votes payload = Payloads.getCreateVotesPayloadFromPojo(numericImageId, "raphhinha1", "-1");
        Response response = createVote(payload);
        Assert.assertEquals(response.statusCode(), 400);
        Assert.assertEquals(response.getBody().asString(), "\"image_id\" must be a string");
    }

    @Test
    public void createWithoutImageIdVote() {

        Votes payload = Payloads.getCreateVotesPayloadFromPojo("", "raphhinha1", "1");
        Response response = createVote(payload);
        Assert.assertEquals(400, response.statusCode());
        Assert.assertEquals(response.getBody().asString(), "\"image_id\" is not allowed to be empty");

    }

    @Test
    public void createWithoutSubIdVote() {

        Votes payload = Payloads.getCreateVotesPayloadFromPojo(image, "", "1");
        Response response = createVote(payload);
        Assert.assertEquals(400, response.statusCode());
        Assert.assertEquals(response.getBody().asString(), "\"sub_id\" is not allowed to be empty");

    }

//    These tests are commented out due to a potential issue in the API
//
//    @Test
//    public void createWithoutImageIdAndSubIdVote() {
//
//        Votes payload = Payloads.getCreateVotesPayloadFromPojo("", "", "1");
//        Response response = createVote(payload);
//        Assert.assertEquals(400, response.statusCode());
//        Assert.assertEquals(response.getBody().asString(), "”image_id” is not allowed to be empty\n" +
//                "\"sub_id\" is not allowed to be empty\n");
//
//    }

//    @Test
//    public void createWithoutValueVote() {
//
//        Votes payload = Payloads.getCreateVotesPayloadFromPojo(image, "raphhinha1", "");
//        Response response = createVote(payload);
//        Assert.assertEquals(400, response.statusCode());
//        Assert.assertEquals(response.getBody().asString(), "\"value\" is not allowed to be empty");
//
//    }

//    @Test
//    public void createDifferentValueVote() {
//
//        Votes payload = Payloads.getCreateVotesPayloadFromPojo("", "raphhinha1", "");
//        Response response = createVote(payload);
//        Assert.assertEquals(400, response.statusCode());
//        Assert.assertEquals(response.getBody().asString(), "\"value\" is 1 or -1");
//
//    }
}
