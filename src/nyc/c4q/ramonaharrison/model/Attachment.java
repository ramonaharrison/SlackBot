package nyc.c4q.ramonaharrison.model;

import org.json.simple.JSONObject;

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
    // "fallback"

    private String color;
    // "color"

    private String pretext;
    // "pretext"

    private String authorName;
    // "author_name"

    private String authorLink;
    // "author_link"

    private String authorIcon;
    // "author_icon"

    private String title;
    // "title"

    private String titleLink;
    // "title_link"

    private String text;
    // "text"

    private String fields;
    // "fields"

    private String imageUrl;
    // "image_url"

    private String thumbUrl;
    // "thumb_url"

    private String footer;
    // "footer"

    private String footerIcon;
    // "footer_icon"

    private String ts;
    // "ts"

    public Attachment(JSONObject json) {
        // TODO: parse an attachment from the incoming json

        if (json.get("fallback") != null) {
            this.fallback = (String) json.get("fallback");
        }
        if (json.get("color") != null) {
            color = (String) json.get("color");
        }
        if (json.get("pretext") != null) {
            pretext = (String) json.get("pretext");
        }
        if (json.get("author_icon") != null) {
            authorIcon = (String) json.get("author_icon");
        }
        if (json.get("author_link") != null) {
            authorLink = (String) json.get("author_link");
        }
        if (json.get("author_name") != null) {
            authorName = (String) json.get("author_name");
        }
        if (json.get("title") != null) {
            title = (String) json.get("title");
        }
        if (json.get("title_link") != null) {
            titleLink = (String) json.get("title_link");
        }
        if (json.get("text") != null) {
            text = (String) json.get("text");
        }
        if (json.get("fields") != null) {
            fields = (String) json.get("fields");
        }
        if (json.get("image_url") != null) {
            imageUrl = (String) json.get("image_url");
        }
        if (json.get("thumb_url") != null) {
            thumbUrl = (String) json.get("thumb_url");
        }
        if (json.get("footer") != null) {
            footer = (String) json.get("footer");
        }
        if (json.get("footer_icon") != null) {
            footerIcon = (String) json.get("footer_icon");
        }
        if (json.get("ts") != null) {
            ts = (String) json.get("ts");
        }
    }

    // TODO add getters to access private fields
    public String getFallback() {
        return fallback;
    }
    public String getColor(){
        return color;
    }
    public String getPretext(){
        return pretext;
    }

    public String getAuthorIcon() {
        return authorIcon;
    }

    public String getAuthorLink() {
        return authorLink;
    }

    public String getAuthorName() {
        return authorName;
    }

    public String getTitle(){
        return title;
    }

    public String getTitleLink() {
        return titleLink;
    }

    public String getFields() {
        return fields;
    }

    public String getFooter() {
        return footer;
    }

    public String getFooterIcon() {
        return footerIcon;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getText() {
        return text;
    }

    public String getThumbUrl() {
        return thumbUrl;
    }

    public String getTs() {
        return ts;
    }
}