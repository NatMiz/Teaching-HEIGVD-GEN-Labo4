package ch.heigvd.gen;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Locale;

public class JsonObject implements Serializable {

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

    public void add(String key, Serializable value){
        attributes.add(String.format("\"%s\": %s", key, value.serialize()));
    }

    public String serialize(){
        return "{" + String.join(", ", attributes) + "}";
    }
}
