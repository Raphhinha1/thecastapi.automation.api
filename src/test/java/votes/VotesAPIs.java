package votes;

import io.restassured.response.Response;
import restUtils.RestUtils;
import votes.pojos.Votes;

import java.util.HashMap;
import java.util.Map;

public class VotesAPIs {

    public Response createVote(Map<String, Object> createVotesPayLoad){
       String endPoint = (String) Base.dataFromJsonFile.get("voteEndpoint");
       return RestUtils.votePost(endPoint, createVotesPayLoad, new HashMap<>());
    }

    public Response createVote(Votes createVotesPayLoad){
        String endPoint = (String) Base.dataFromJsonFile.get("voteEndpoint");
        return RestUtils.votePost(endPoint, createVotesPayLoad, new HashMap<>());
    }


}
