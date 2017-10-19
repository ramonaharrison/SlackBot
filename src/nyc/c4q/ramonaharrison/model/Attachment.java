package nyc.c4q.ramonaharrison.model;

import org.json.simple.JSONObject;

import java.util.ArrayList;

/**
 * Created by Ramona Harrison
 * on 8/26/16
 *
 * A class representing a message attachment.
 * See https://api.slack.com/docs/message-attachments
 *
 */

public class Attachment {

    // TODO: implement private fields for each of the following attachment JSON keys:
    // "fallback"
    // "color"
    // "pretext"
    // "author_name"
    // "author_link"
    // "author_icon"
    // "title"
    // "title_link"
    // "text"
    // "fields"
    // "image_url"
    // "thumb_url"
    // "footer"
    // "footer_icon"
    // "ts"
    String fallback;
    String color;
    String pretext;
    String author_name;

    public Attachment(JSONObject json) {
        // TODO: parse an attachment from the incoming json
        if (json.get("fallback") != null) {
            this.fallback = (String) json.get("fallback");
        }
        if (json.get("color") != null) {
            this.color = (String) json.get("fallback");
        }
        if (json.get("pretext") != null) {
            this.pretext = (String) json.get("fallback");
        }
        if (json.get("author_name") != null) {
            this.author_name = (String) json.get("fallback");
        }

        //private List<Field> fields = new ArrayList<>();
    }

    // TODO add getters to access private fields

}
