package json;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by Andrii_Rodionov on 1/3/2017.
 */
public class JsonObject extends Json {
    private ArrayList<Object> keys = new ArrayList<>();
    private ArrayList<JsonPair> cache = new ArrayList<>();

    public JsonObject(JsonPair... jsonPairs) {
//        for (JsonPair pair : jsonPairs) {
//            if (keys.contains(pair.key)){
//
//            }
//        }
        cache.addAll(Arrays.asList(jsonPairs));
    }
    
//    private void checkRepetitions(){
//        ArrayList<Object> tempKeys = new ArrayList<>();
//        ArrayList<JsonPair> temp = new ArrayList<>();
//        for (JsonPair pair : cache) {
//            if (tempKeys.contains(pair.key)){
//                cache.set(cache.indexOf(temp.get(tempKeys.indexOf(pair.key))), pair
//            }
//            else{
//                tempKeys.add(pair.key);
//                temp.add(pair);
//            }
//        }
//    }

    @Override
    public String toJson() {
        if (cache.size() == 0) {
            return "{}";
        }
        StringBuilder toRes = new StringBuilder();
        toRes.append("{");
        for (JsonPair pair : cache) {
            toRes.append("'").append(pair.key).append("': ").append(pair.value.toJson()).append(", ");
        }
        toRes.delete(toRes.length() - 2, toRes.length());
        toRes.append("}");
        return String.valueOf(toRes);
    }

    public void add(JsonPair jsonPair) {
        cache.add(jsonPair);
    }

    public Json find(String name) {
        for (JsonPair pair : cache) {
            if (pair.key.equals(name)){
                return pair.value;
            }
        }
        return null;
    }

    public JsonObject projection(String... names) {
        JsonObject toRes = new JsonObject();
        for (JsonPair pair : cache) {
            for (String name: names) {
                if (pair.key.equals(name)){
                    toRes.add(pair);
                }
            }
        }
        return toRes;
    }
}
