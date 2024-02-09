package votes;

import votes.pojos.Votes;

import java.util.HashMap;
import java.util.Map;

public class Payloads {
    public static Map<String, Object> getCreateVotesPayloadFromMap(String imageId, String subId, String value) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("image_id", imageId);
        payload.put("sub_id", subId);
        payload.put("value", value);
        return payload;
    }
    public static Map<String, Object> getVotesParamsFromMap(Integer id) {
        Map<String, Object> params = new HashMap<>();
        params.put("vote_id", id);
        return params;
    }

    public static Votes getCreateVotesPayloadFromPojo(String imageId, String subId, String value){
       return Votes
                .builder()
                .image_id(imageId)
                .sub_id(subId)
                .value(value)
                .build();
    }
}
