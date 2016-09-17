package nyc.c4q.ramonaharrison.model;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;

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

    private String fallback;
    private String color;
    private String pretext;
    private String author_name;
    private String author_link;
    private String author_icon;
    private String title;
    private String title_link;
    private String text;
    private List<Field> fields;
    private String imageUrl;
    private String thumbUrl;
    private String footer;
    private String footer_icon;
    private String ts;

    public Attachment(JSONObject json) {


        // parse a user from the incoming json

        if (json.containsKey("fallback")) {
            this.fallback = (String) json.get("fallback");
        }

        if (json.containsKey("color")) {
            this.color = (String) json.get("color");
        }

        if (json.containsKey("pretext")) {
            this.pretext = (String) json.get("pretext");
        }

        if (json.containsKey("author_name")) {
            this.author_name = (String) json.get("author_name");
        }

        if (json.containsKey("author_link")) {
            this.author_link = (String) json.get("author_name");
        }

        if (json.containsKey("author_icon")) {
            this.author_icon = (String) json.get("author_icon");
        }

        if (json.containsKey("title")) {
            this.title = (String) json.get("title");
        }

        if (json.containsKey("title_link")) {
            this.title_link = (String) json.get("title_link");
        }

        if (json.containsKey("text")) {
            this.text = (String) json.get("title");
        }

        if (json.containsKey("imageUrl")) {
            this.imageUrl = (String) json.get("imageUrl");
        }

        if (json.containsKey("thumbUrl")) {
            this.thumbUrl = (String) json.get("thumbUrl");
        }

        if (json.containsKey("footer")) {
            this.footer = (String) json.get("footer");
        }

        if (json.containsKey("footer_icon")) {
            this.footer_icon = (String) json.get("footer_icon");
        }

        if (json.containsKey("fields")) {
            JSONArray jsonFields = (JSONArray) json.get("fields");
            this.fields = new ArrayList<Field>();
            for (int i = 0; i < jsonFields.size(); i++) {
                Field field = new Field ((JSONObject) jsonFields.get(i));
                this.fields.add(field);
            }
        }

        if (json.containsKey("ts")) {
            this.ts = (String) json.get("ts");
        }
    }
    // getters to access private fields

    public String getFallback() {
        return fallback;
    }

    public String getColor() {
        return color;
    }

    public String getPretext() {
        return pretext;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public String getAuthor_link() {
        return author_link;
    }

    public String getAuthor_icon() {
        return author_icon;
    }

    public String getTitle() {
        return title;
    }

    public String getTitle_link() {
        return title_link;
    }

    public String getText() {
        return text;
    }

    public List<Field> getFields() {
        return fields;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getThumbUrl() {
        return thumbUrl;
    }

    public String getFooter() {
        return footer;
    }

    public String getFooterIcon() {
        return footer_icon;
    }

    public String getTs() {
        return ts;
    }

}
