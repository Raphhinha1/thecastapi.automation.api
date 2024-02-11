package votes;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VotesGetTest extends VotesAPIs {

    @Test
    public void getVoteBySubId() {
        String subId = "raphhinha2";
        Response response = getVote(null, subId, null, null, null);
        Assert.assertEquals(200, response.statusCode());
        Assert.assertEquals(response.jsonPath().getString("sub_id[0]"), subId);
    }

    @Test
    public void getVoteByVoteId() {
        String voteId = "1157523";
        Response response = getVote(voteId, null, null,null,null);
        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertEquals(response.jsonPath().getString("id"), voteId);

    }

    @Test
    public void getVoteWithSubIdOrderAndLimit() {
        String subId = "raphhinha1";
        String order = "desc";
        int limit = 5;
        Response response = getVote(null, subId, null, limit, order);
        Assert.assertEquals(200, response.statusCode());

        Assert.assertEquals(response.jsonPath().getString("sub_id[0]"), subId);

        int actualItemCount = response.jsonPath().getList("$").size();
        Assert.assertEquals(actualItemCount, limit);
    }

    @Test
    public void getVoteWithPageAndLimit() {
        int page = 3;
        int limit = 8;
        Response response = getVote(null, null, page, limit, null);
        Assert.assertEquals(200, response.statusCode());
    }

    @Test
    public void getVoteWithOrder() {
        String order = "desc";
        Response response = getVote(null, null, null, null, order);
        Assert.assertEquals(200, response.statusCode());
    }

//    Feature
//    @Test
//    public void getVoteWithInvalidSubId() {
//        String subId = "invalidSubId";
//        Response response = getVote(null, subId, null, null, null);
//        Assert.assertEquals(200, response.statusCode());
//        Assert.assertEquals(response.jsonPath().getString("message"), "sub_id is not exist");
//    }
}
