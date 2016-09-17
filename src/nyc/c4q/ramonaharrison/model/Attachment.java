package nyc.c4q.ramonaharrison.model;

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
    private String fallback;
    private String color;
    private String pretext;
    private String author_name;
    private String author_link;
    private String author_icon;
    private String title;
    private String title_link;
    private String text;
    List<Field> fields = new ArrayList<Field>();
    private String image_url;
    private String thumb_url;
    private String footer;
    private String footer_icon;
    private String ts;

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

    public Attachment(JSONObject json) {
        // TODO: parse an attachment from the incoming json
        if(json.containsKey("fallback")){
            this.fallback = (String) json.get("fallback");
        }
        if(json.containsKey("color")){
            this.color = (String) json.get("color");
        }
        if(json.containsKey("pretext")){
            this.pretext = (String) json.get("pretext");
        }
        if(json.containsKey("author_name")){
            this.author_name = (String) json.get("author_name");
        }
        if(json.containsKey("author_link")){
            this.author_link = (String) json.get("author_link");
        }
        if(json.containsKey("author_icon")){
            this.author_icon = (String) json.get("author_icon");
        }
        if(json.containsKey("title")){
            this.title = (String) json.get("title");
        }
        if(json.containsKey("title_link")){
            this.title_link = (String) json.get("title_link");
        }
        if(json.containsKey("title")){
            this.title_link = (String) json.get("title");
        }
        if(json.containsKey("image_url")){
            this.image_url = (String) json.get("image_url");
        }
        if(json.containsKey("thumb_url")){
            this.thumb_url = (String) json.get("thumb_url");
        }
        if(json.containsKey("footer")){
            this.footer = (String) json.get("footer");
        }
        if(json.containsKey("footer_icon")){
            this.footer_icon = (String) json.get("footer_icon");
        }
        if(json.containsKey("ts")){
            this.ts =(String) json.get("ts");
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

    public String getTs() {
        return ts;
    }
}
