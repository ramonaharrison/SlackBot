package nyc.c4q.ramonaharrison.model;

import org.json.simple.JSONObject;

/**
 * Created by Ramona Harrison
 * on 8/26/16
 *
 * A class representing a channel purpose.
 * See https://api.slack.com/types/channel
 *
 * Example JSON:
 *
 *  {
 *    "value": "This channel is for fun",
 *    "creator": "U024BE7LV",
 *    "last_set": 1369677212
 *  }
 *
 */

public class Purpose {

    private String value;
    private String creator;
    private long lastSet;

    public Purpose(JSONObject json) {

        if (json.get("value") != null) {
            this.value = (String) json.get("value");
        }

        if (json.get("creator") != null) {
            this.creator = (String) json.get("creator");
        }

        if (json.get("last_set") != null) {
            this.lastSet = (Long) json.get("last_set");
        }
    }

    public String getValue() {
        return value;
    }

    public String getCreator() {
        return creator;
    }

    public long getLastSet() {
        return lastSet;
    }
}