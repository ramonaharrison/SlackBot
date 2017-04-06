package nyc.c4q.ramonaharrison.model;

import org.json.simple.JSONObject;

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

        if (json.containsKey("isShort")) {
            this.isShort = (boolean) json.get("short");
        }
    }
}
