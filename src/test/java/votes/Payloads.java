package votes;

import votes.pojos.Votes;

import java.util.HashMap;
import java.util.Map;

public class Payloads {

    public static Votes getCreateVotesPayloadFromPojo(Object imageId, Object subId, String value){
       return Votes
                .builder()
                .image_id(imageId)
                .sub_id(subId)
                .value(value)
                .build();
    }
}
