package nyc.c4q.ramonaharrison.model;

import org.json.simple.JSONObject;

/**
 * Created by jordansmith on 9/19/16.
 */
public class Articles {

    String author;
    String title;
    String description;
    String url;
    String urlToImage;
    String publishedAt;

    public Articles(JSONObject json){
        if(json.containsKey("author")){
            this.author=(String)json.get("author");
        }
        if(json.containsKey("title")){
            this.title=(String)json.get("title");
        }
        if(json.containsKey("description")){
            this.description=(String)json.get("description");
        }
        if(json.containsKey("url")){
            this.url=(String)json.get("url");
        }
        if(json.containsKey("urlToImage")){
            this.urlToImage=(String)json.get("urlToImage");
        }
        if(json.containsKey("publishedAt")){
            this.publishedAt=(String)json.get("publishedAt");
        }

    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getUrl() {
        return url;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public String getPublishedAt() {
        return publishedAt;
    }
}
