package domain;

import json.*;

import java.util.ArrayList;

/**
 * Created by Andrii_Rodionov on 1/3/2017.
 */
public class Student extends BasicStudent {
    private Tuple<String, Integer>[] exams;

    public Student(String name, String surname, Integer year, Tuple<String, Integer>... exams) {
        super(name, surname, year);
        this.exams = exams;
    }

    public JsonObject toJsonObject() {
        JsonObject toRet = new JsonObject();
        toRet.add(new JsonPair("name", new JsonString(name)));
        toRet.add(new JsonPair("surname", new JsonString(surname)));
        toRet.add(new JsonPair("year", new JsonNumber(year)));
        ArrayList<JsonPair> jPairs = new ArrayList<>();
        for (Tuple<String, Integer> pair : exams) {
            toRet.add(new JsonPair(pair.key, new JsonNumber(pair.value)));
        }
//        System.out.println(toRet.toJson());
        return toRet;
    }
}
