package votes;

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
    public static Map<String, Object> getDeleteVotesPayloadFromMap(Integer id) {
        Map<String, Object> payload = new HashMap<>();
        payload.put("id", id);
        return payload;
    }
}
