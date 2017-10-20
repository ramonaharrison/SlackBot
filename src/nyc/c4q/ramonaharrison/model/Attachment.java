package nyc.c4q.ramonaharrison.model;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.lang.reflect.Field;
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

    private ArrayList<Attachment> attachments;
        private String fallback;
        private String color;
        private String pretext;
        private String author_name;
        private String author_link;
        private String authorIcon;
        private String title;
        private String titleLink;
        private String text;

    private ArrayList<Field> fields;
//        private String title1;   these are the elements of array, shall i define them as properties?
//        private String value;
//        private boolean short1;

        private String imageUrl;
        private String thumbUrl;
        private String footer;
        private String footerIcon;
        private long ts;

        public class Fields {

        }

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

        if (json.get("authorName") != null) {
            this.authorName = (String) json.get("authorName");
        }

        if (json.get("authorLink") != null) {
            this.authorLink = (String) json.get("authorLink");
        }

        if (json.get("authorIcon") != null) {
            this.authorIcon = (String) json.get("authorIcon");
        }

        if (json.get("title") != null) {
            this.title = (String) json.get("title");
        }

        if (json.get("titleLink") != null) {
            this.titleLink = (String) json.get("titleLink");
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

        if (json.get("imageUrl") != null) {
            this.imageUrl = (String) json.get("imageUrl");
        }

        if (json.get("thumbUrl") != null) {
            this.thumbUrl = (String) json.get("thumbUrl");
        }

        if (json.get("footer") != null) {
            this.footer = (String) json.get("footer");
        }

        if (json.get("footerIcon") != null) {
            this.footerIcon = (String) json.get("footerIcon");
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
        return authorName;
    }

    public String getAuthorLink() {
        return authorLink;
    }
    public String getAuthorIcon() {
        return authorIcon;
    }

    public String getTitle() {
        return title;
    }

    public String getTitleLink() {
        return titleLink;
    }

    public String getText() {
        return text;
    }

    private ArrayList<Field> getFields() {
        return fields;
    }

//    private String getTitle1() {
//        return title1;
//    }
//
//    private String getValue() {
//        return value;
//    }
//
//    private boolean isShort1() {
//        return short1;
//    }

    private String getImageUrl() {
        return imageUrl;
    }

    private String getThumbUrl() {
        return thumbUrl;
    }

    private String getFooter() {
        return footer;
    }

    private String getFooterIcon() {
        return footerIcon;
    }

    private long getTs() {
        return ts;
    }
}
