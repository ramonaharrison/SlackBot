package nyc.c4q.ramonaharrison.model;

import org.json.simple.JSONObject;

public class Field {


        private String title;
        private String value;
        private boolean short1;

    public Field(JSONObject json) {

        if (json.get("value") != null) {
            this.value = (String) json.get("value");
        }

        if (json.get("title") != null) {
            this.title = (String) json.get("title");
        }

        if (json.get("short1") != null) {
            this.short1 = (boolean) json.get("short1");
        }

    }

    private String getTitle() {
        return title;
    }

    private String getValue() {
        return value;
    }

    private boolean isShort1() {
        return short1;
    }
}
