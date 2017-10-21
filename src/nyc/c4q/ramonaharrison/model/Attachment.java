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
            // “fallback”
            private String fallback;
            // “color”
            private String color;
            // “pretext”
            private String pretext;
            // “author_name”
            private String author_name;
            // “author_link”
            private String author_link;
            // “author_icon”
            private String author_icon;
            // “title”
            private String title;
            // “title_link”
            private String title_link;
            // “text”
            private String text;
            // “fields”
            private String fields;
            // “image_url”
            private String image_url;
            // “thumb_url”
            private String thumb_url;
            // “footer”
            private String footer;
            // “footer_icon”
            private String footer_icon;
            // “ts”
            private String ts;

            public Attachment(JSONObject json) {
                // TODO: parse an attachment from the incoming json
                if (json.get("fallback") != null) {
                    this.fallback = (String) json.get("fallback");
                }
                if (json.get("color") !=null) {
                    this.color = (String) json.get("color");
                }
                if (json.get("pretext") != null) {
                    this.pretext = (String) json.get("pretext");
                }
                if (json.get("author name")!=null){
                    this.author_name = (String) json.get("author name");
                }
                if (json.get("author link")!=null){
                    this.author_link = (String) json.get("author link");
                }
                if (json.get("author icon")!=null){
                    this.author_icon =(String) json.get("author icon");
                }
                if (json.get("title")!=null){
                    this.title = (String) json.get ("title");
                }
                if (json.get("title link")!=null){
                    this.title_link = (String) json.get ("title link");
                }
                if (json.get("text")!=null){
                    this.text = (String) json.get ("text");
                }
                if (json.get("fields")!=null){
                    this.fields = (String) json.get ("fields");
                }
                if (json.get("image url")!=null){
                    this.image_url = (String) json.get ("image url");
                }
                if (json.get("thumb url")!=null){
                    this.thumb_url = (String) json.get ("thumb url");
                }
                if (json.get("footer")!=null){
                    this.footer= (String) json.get ("footer");
                }
                if (json.get("ts")!=null){
                    this.ts = (String) json.get ("ts");
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
            public String getFields() {
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




