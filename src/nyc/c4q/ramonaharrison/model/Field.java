package nyc.c4q.ramonaharrison.model;

import org.json.simple.JSONObject;

/**
 * Created by Rafael on 9/15/16.
 */

public class Field {

    private String title;
    private String value;
    private boolean isShort;


    public Field(JSONObject json) {

        if (json.containsKey("title")) {
            this.title = (String) json.get("title");
        }

        if (json.containsKey("value")) {
            this.value = (String) json.get("value");
        }

        if (json.containsKey("short")) {
            this.isShort = (boolean) json.get("short");
        }

    }

    public String getTitle() {
        return title;
    }

    public String getValue() {
        return value;
    }

    public boolean isShort() {
        return isShort;
    }
}