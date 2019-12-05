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
        if (cache.size() == 0){
            return "{}";
        }
        StringBuilder toRes = new StringBuilder();
        toRes.append("{");
        for (JsonPair pair : cache) {
            toRes.append("'").append(pair.key).append("': ").append(pair.value.toJson()).append(", ");
        }
        toRes.delete(toRes.length()-2, toRes.length());
        toRes.append("}");
        return String.valueOf(toRes);
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
