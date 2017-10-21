package nyc.c4q.ramonaharrison.model;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


import java.lang.reflect.Field;
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

    private String fallback;
    private String color;
    private String pretext;
    private String author_name;
    private String author_link;
    private String author_icon;
    private String title;
    private String title_link;
    private String text;
    private ArrayList<Field> fields;
    private String image_url;
    private String thumb_url;
    private String footer;
    private String footer_icon;
    private long ts;

    public Attachment(JSONObject json) {

        if (json.get("fallback") != null) {
            this.fallback = (String) json.get("fallback");
        }

        if (json.get("color") != null) {
            this.color = (String) json.get("color");
        }

        if (json.get("pretext") != null) {
            this.pretext = (String) json.get("pretext");
        }

        if (json.get("author_name") != null) {
            this.author_name = (String) json.get("author_name");
        }

        if (json.get("author_link") != null) {
            this.author_link = (String) json.get("author_link");
        }

        if (json.get("author_icon") != null) {
            this.author_icon = (String) json.get("author_icon");
        }

        if (json.get("title") != null) {
            this.title = (String) json.get("title");
        }

        if (json.get("title_link") != null) {
            this.title_link = (String) json.get("title_link");
        }

        if (json.get("text") != null) {
            this.text = (String) json.get("text");
        }

        if (json.get("fields") != null) {
            JSONArray fieldsArray = (JSONArray) json.get("fields"); // need more explanation here
            this.fields = new ArrayList<Field>();
            for (int i = 0; i < fieldsArray.size(); i++) {
                this.fields.add((Field) fieldsArray.get(i));
            }
        }

        if (json.get("image_url") != null) {
            this.image_url = (String) json.get("image_url");
        }

        if (json.get("thumb_url") != null) {
            this.thumb_url = (String) json.get("thumb_url");
        }

        if (json.get("footer") != null) {
            this.footer = (String) json.get("footer");
        }

        if (json.get("footer_icon") != null) {
            this.footer_icon = (String) json.get("footer_icon");
        }

        if (json.get("ts") != null) {
            this.ts = (Long) json.get("ts");
        }

    }


    // TODO add getters to access private fields


    public String getFallback() {
        return fallback;
    }

    public String getColor() {
        return color;
    }

    public String getPretext() {
        return pretext;
    }

    public String getAuthorName() {
        return author_name;
    }

    public String getAuthorLink() {
        return author_link;
    }
    public String getAuthorIcon() {
        return author_icon;
    }

    public String getTitle() {
        return title;
    }

    public String getTitleLink() {
        return title_link;
    }

    public String getText() {
        return text;
    }

    private ArrayList<Field> getFields() {
        return fields;
    }


    private String getImageUrl() {
        return image_url;
    }

    private String getThumbUrl() {
        return thumb_url;
    }

    private String getFooter() {
        return footer;
    }

    private String getFooterIcon() {
        return footer_icon;
    }

    private long getTs() {
        return ts;
    }
}
