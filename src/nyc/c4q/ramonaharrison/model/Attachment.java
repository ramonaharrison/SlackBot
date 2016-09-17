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
    public String fallback;
    // "color"
    private String color;
    // "pretext"
    private String pretext;
    // "author_name"
    private String author_name;
    // "author_link"
    private String author_link;
    // "author_icon"
    private String author_icon;
    // "title"
    private String title;
    // "title_link"
    private String title_link;
    // "text"
    private String text;
    // "fields"
    private List<Field> fields;
    // "image_url"
    private String image_url;
    // "thumb_url"
    private String thumb_url;
    // "footer"
    private String footer;
    // "footer_icon"
    private String footer_icon;
    // "ts"
    private long ts;

    public Attachment(JSONObject json) {
        // TODO: parse an attachment from the incoming json
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
            JSONArray jsonFields = (JSONArray) json.get("fields");        //1. Make JSONArray because fields is an array
            this.fields = new ArrayList<Field>();                         //2. Initialize private fields to an arrayList
            for (int i = 0; i < jsonFields.size(); i++) {                 //3. Loop through JSONArray
                Field field = new Field((JSONObject) jsonFields.get(i));  //4. Initialize a Field object with JSON
                this.fields.add(field);                                   //5. add the new Field object to the arrayList
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
            this.ts = (long) json.get("ts");
        }
    }

    // TODO add getters to access private fields
    //getters
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

    public String getImage_url() {
        return image_url;
    }

    public String getThumb_url() {
        return thumb_url;
    }

    public String getFooter() {
        return footer;
    }

    public String getFooter_icon() {
        return footer_icon;
    }

    public long getTs() {
        return ts;
    }

    //setters
    public void setFallback(String fallback) {
        this.fallback = fallback;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setPretext(String pretext) {
        this.pretext = pretext;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public void setAuthor_link(String author_link) {
        this.author_link = author_link;
    }

    public void setAuthor_icon(String author_icon) {
        this.author_icon = author_icon;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setTitle_link(String title_link) {
        this.title_link = title_link;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setFields(List<Field> fields) {
        this.fields = fields;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public void setThumb_url(String thumb_url) {
        this.thumb_url = thumb_url;
    }

    public void setFooter(String footer) {
        this.footer = footer;
    }

    public void setFooter_icon(String footer_icon) {
        this.footer_icon = footer_icon;
    }

    public void setTs(long ts) {
        this.ts = ts;
    }
}
