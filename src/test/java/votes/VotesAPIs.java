package votes;

import freemarker.core.ReturnInstruction;
import io.restassured.response.Response;
import restUtils.RestUtils;

import java.util.HashMap;
import java.util.Map;

public class VotesAPIs {

    public Response createVote(Map<String, Object> createVotesPayLoad){
       String endPoint = (String) Base.dataFromJsonFile.get("createVoteEndpoint");
       return RestUtils.votePost(endPoint, createVotesPayLoad, new HashMap<>());
    };
}
