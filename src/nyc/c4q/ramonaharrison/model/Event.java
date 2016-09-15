package nyc.c4q.ramonaharrison.model;

import com.sun.xml.internal.bind.v2.TODO;
import org.json.simple.JSONObject;

import java.util.Random;

/**
 * Created by Rafael on 9/14/16.
 */
public class Event {

    private String year;
    private String text;


    public Event(JSONObject json) {

        if (json.containsKey("year")) {
            this.year = (String) json.get("year");
        }
        if (json.containsKey("text")) {
            this.text = (String) json.get("text");
        }
    }

    public String getYear() {
        return year;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {

        String year = getYear();
        String text = getText();
        String complete = "On this day in " + year + ": \n" + text + "\n";

        return complete;
    }
}
