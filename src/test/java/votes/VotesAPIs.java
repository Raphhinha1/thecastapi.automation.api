package votes;

import io.restassured.response.Response;
import restUtils.RestUtils;
import votes.pojos.Votes;


public class VotesAPIs {

    public Response getVote(String voteId, String subId, Integer page, Integer limit, String order) {
        String endPoint = (String) Base.dataFromJsonFile.get("voteEndpoint");
        return RestUtils.getVote(endPoint, voteId, subId, page, limit, order);
    }


    public Response createVote(Votes createVotesPayLoad){
        String endPoint = (String) Base.dataFromJsonFile.get("voteEndpoint");
        return RestUtils.votePost(endPoint, createVotesPayLoad);
    }


}
