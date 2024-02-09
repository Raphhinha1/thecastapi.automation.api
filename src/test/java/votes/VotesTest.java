package votes;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import restUtils.RestUtils;
import utils.JsonUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class VotesTest extends VotesAPIs{
    double number = (int) Math.floor(Math.random() * 1000);

    @Test
    public void createUpVote() throws IOException {

        Map<String, Object> payload = Payloads.getCreateVotesPayloadFromMap("image" + number,"raphhinha1", "1");
        Response response = createVote(payload);
        Assert.assertEquals(201, response.statusCode());
    }

    @Test
    public void createDownVote() throws IOException {

        Map<String, Object> payload = Payloads.getCreateVotesPayloadFromMap("image" + number + 1,"raphhinha1", "-1");
        Response response = createVote(payload);
        Assert.assertEquals(201, response.statusCode());
    }

    @Test
    public void createWithoutImageIdVote() throws IOException {

        Map<String, Object> payload = Payloads.getCreateVotesPayloadFromMap("","raphhinha1", "1");
        Response response = createVote(payload);
        Assert.assertEquals(201, response.statusCode());
    }

    @Test
    public void getAllVotes(){
        RestAssured.given().log().all()
                .baseUri("https://api.thecatapi.com/v1/votes")
                .header("x-api-key", "live_OPZZQUS7wlcd4ztnHXoAmvJzaEyzRIM1lhkJCgASGuGS0sc9z6vIA2IYBo1GOiIq")
                .when()
                .get()
                .then()
                .log().all().extract().response();
    }
}
