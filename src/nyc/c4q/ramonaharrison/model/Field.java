package nyc.c4q.ramonaharrison.model;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Field {
    private String title;
    private String value;
    private boolean isShort;

    public Field(JSONObject json) {
        if (json.get("title") != null) {
            this.title = (String) json.get("title");
        }

        if (json.get("value") != null) {
            this.value = (String) json.get("value");
        }

        if (json.get("short") != null) {
            this.isShort = (Boolean) json.get("short");
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

    public void setTitle(String title) {
        this.title = title;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setShort(boolean aShort) {
        isShort = aShort;
    }
}
