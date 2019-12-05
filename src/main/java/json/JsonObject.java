package json;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Andrii_Rodionov on 1/3/2017.
 */
public class JsonObject extends Json {
    private ArrayList<JsonPair> cache = new ArrayList<>();

    public JsonObject(JsonPair... jsonPairs) {
        cache.addAll(Arrays.asList(jsonPairs));
    }

    @Override
    public String toJson() {
        String toRes;
        for (JsonPair pair : cache) {

        }
        return null;
    }

    public void add(JsonPair jsonPair) {
        // ToDo
    }

    public Json find(String name) {
        // ToDo
        return null;
    }

    public JsonObject projection(String... names) {
        // ToDo
        return null;
    }
}
