package votes;

import utils.JsonUtils;

import java.io.IOException;
import java.util.Map;

public class Base {

    public static Map<String, Object> dataFromJsonFile;

    static {
        System.out.println(System.getProperty("env") + "Env value");
        String env = System.getProperty("env") == null ? "qa" : System.getProperty("env");
        try {
            dataFromJsonFile = JsonUtils.getJsonDataAsMap("votes/"+env+"/votesApiData.json");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
