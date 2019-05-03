package ch.heigvd.gen;

import java.util.LinkedList;
import java.util.Locale;

public class JsonArray implements Serializable{
    LinkedList<String> values = new LinkedList<>();

    public void add(String value){
        values.add(String.format("\"%s\"", value));
    }

    public void add(int value){
        values.add(String.format("%d", value));
    }

    public void add(double value){
        values.add(String.format(Locale.US,"%s", value));
    }

    public void add(Serializable value){
        values.add(String.format(Locale.US,"%s", value.serialize()));
    }


    public String serialize(){
        return "[" + String.join(", ", values) + "]";
    }
}
