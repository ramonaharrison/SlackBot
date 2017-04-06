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
    private String thumb_url;
    private String footer;
    private String footer_icon;
    private long ts;

    public Attachment() {
    }

    public Attachment(String fallback, String color, String pretext, String author_name, String author_link, String author_icon, String title, String title_link, String text, String imageUrl, String thumb_url, String footer, String footer_icon) {
        this.fallback = fallback;
        this.color = color;
        this.pretext = pretext;
        this.author_name = author_name;
        this.author_link = author_link;
        this.author_icon = author_icon;
        this.title = title;
        this.title_link = title_link;
        this.text = text;
        this.imageUrl = imageUrl;
        this.thumb_url = thumb_url;
        this.footer = footer;
        this.footer_icon = footer_icon;
    }

    public Attachment(JSONObject json) {

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
            this.author_link = (String) json.get("author_link");
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
            this.text = (String) json.get("text");
        }

        if (json.containsKey("fields")) {
            JSONArray jsonFields = (JSONArray) json.get("fields");
            this.fields = new ArrayList<Field>();
            for (int i = 0; i < jsonFields.size(); i++) {
                Field field = new Field((JSONObject) jsonFields.get(i));
                this.fields.add(field);
            }
        }

        if (json.containsKey("imageUrl")) {
                this.imageUrl = (String) json.get("imageUrl");
            }

        if (json.containsKey("thumb_url")) {
                this.thumb_url = (String) json.get("thumb_url");
            }

        if (json.containsKey("footer")) {
                this.footer = (String) json.get("footer");
            }

        if (json.containsKey("footer_icon")) {
                this.footer_icon = (String) json.get("footer_icon");
            }

        if(json.containsKey("ts")) {
            this.ts = (Long) json.get("ts");
        }
    }



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

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
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
