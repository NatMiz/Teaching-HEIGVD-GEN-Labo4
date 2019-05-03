package ch.heigvd.gen;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Locale;

public class JsonObject {

    LinkedList<String> attributes = new LinkedList<>();


    public void add(String key, String value){
        attributes.add(String.format("\"%s\": \"%s\"", key, value));
    }

    public void add(String key, int value){
        attributes.add(String.format("\"%s\": %d", key, value));
    }

    public void add(String key, double value){
        attributes.add(String.format(Locale.US,"\"%s\": %s", key, value));
    }

    public String serialize(){
        return "{" + String.join(", ", attributes) + "}";
    }
}
