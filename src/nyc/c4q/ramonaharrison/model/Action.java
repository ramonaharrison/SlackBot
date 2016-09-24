package nyc.c4q.ramonaharrison.model;

import org.json.simple.JSONObject;

public class Action {

    private String name;
    private String text;
    private String style;
    private String type;
    private String value;

    public Action(JSONObject json) {

        if (json.containsKey("name")) {
            this.name = (String) json.get("name");
        }

        if (json.containsKey("text")) {
            this.text = (String) json.get("text");
        }

        if (json.containsKey("style")) {
            this.style = (String) json.get("style");
        }

        if (json.containsKey("type")) {
            this.type = (String) json.get("type");
        }

        if (json.containsKey("value")) {
            this.value = (String) json.get("value");
        }
    }
}
