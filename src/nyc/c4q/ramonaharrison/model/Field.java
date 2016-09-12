package nyc.c4q.ramonaharrison.model;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * Created by jonathancolon on 9/11/16.
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
            this.title = (String) json.get("value");
        }
        if (json.containsKey("short")) {
            this.isShort = (Boolean) json.get("short");
        }
    }
}
