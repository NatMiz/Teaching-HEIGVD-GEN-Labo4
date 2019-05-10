package ch.heigvd.gen;

import java.util.LinkedList;

public class JsonArray implements Serializable{
    LinkedList<String> values = new LinkedList<>();

    public void add(Serializable value){
        values.add(value.serialize());
    }

    public String serialize(){
        return "[" + String.join(", ", values) + "]";
    }
}
