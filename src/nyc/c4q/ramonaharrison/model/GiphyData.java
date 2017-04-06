package nyc.c4q.ramonaharrison.model;

import org.json.simple.JSONObject;

/**
 * {
 * "data": {
 * type: "gif",
 * id: "Ggjwvmqktuvf2",
 * url: "http://giphy.com/gifs/american-psycho-christian-bale-Ggjwvmqktuvf2",
 * image_original_url: "http://s3.amazonaws.com/giphygifs/media/Ggjwvmqktuvf2/giphy.gif",
 * image_url: "http://s3.amazonaws.com/giphygifs/media/Ggjwvmqktuvf2/giphy.gif",
 * image_mp4_url: "http://s3.amazonaws.com/giphygifs/media/Ggjwvmqktuvf2/giphy.mp4",
 * image_frames: "11",
 * image_width: "500",
 * image_height: "256",
 * fixed_height_downsampled_url: "http://s3.amazonaws.com/giphygifs/media/Ggjwvmqktuvf2/200_d.gif",
 * fixed_height_downsampled_width: "391",
 * fixed_height_downsampled_height: "200",
 * fixed_width_downsampled_url: "http://s3.amazonaws.com/giphygifs/media/Ggjwvmqktuvf2/200w_d.gif",
 * fixed_width_downsampled_width: "200",
 * fixed_width_downsampled_height: "102",
 * fixed_height_small_url: "http://s3.amazonaws.com/giphygifs/media/Ggjwvmqktuvf2/100.gif",
 * fixed_height_small_still_url: "http://s3.amazonaws.com/giphygifs/media/Ggjwvmqktuvf2/100_s.gif",
 * fixed_height_small_width: "195",
 * fixed_height_small_height: "100",
 * fixed_width_small_url: "http://s3.amazonaws.com/giphygifs/media/Ggjwvmqktuvf2/100w.gif",
 * fixed_width_small_still_url: "http://s3.amazonaws.com/giphygifs/media/Ggjwvmqktuvf2/100w_s.gif",
 * fixed_width_small_width: "100",
 * fixed_width_small_height: "51"
 * },
 * "meta": {
 * "status": 200,
 * "msg": "OK"
 * }
 * }
 */
public class GiphyData {

    private String type;
    private String id;
    private String url;
    private String image_url;
    private String image_mp4_url;
    private String image_frames;
    private String image_width;
    private String image_height;
    private String fixed_height_downsampled_url;
    private String fixed_height_downsampled_width;
    private String fixed_height_downsampled_height;
    private String fixed_width_downsampled_url;
    private String fixed_width_downsampled_width;
    private String fixed_width_downsampled_height;
    private String fixed_height_small_url;
    private String fixed_height_small_still_url;
    private String fixed_height_small_width;
    private String fixed_height_small_height;
    private String fixed_width_small_url;
    private String fixed_width_small_still_url;
    private String fixed_width_small_width;
    private String fixed_width_small_height;

    public GiphyData(JSONObject json) {
        // parse data from the incoming json

        if (json.containsKey("type")) {
            this.type = (String) json.get("type");
        }

        if (json.containsKey("id")) {
            this.id = (String) json.get("id");
        }

        if (json.containsKey("url")) {
            this.url = (String) json.get("url");
        }

        if (json.containsKey("image_url")) {
            this.image_mp4_url = (String) json.get("image_url");
        }

        if (json.containsKey("image_mp4_url")) {
            this.image_url = (String) json.get("image_mp4_url");
        }

        if (json.containsKey("image_frames")) {
            this.image_frames = (String) json.get("image_frames");
        }

        if (json.containsKey("image_width")) {
            this.image_width = (String) json.get("image_width");
        }

        if (json.containsKey("image_height")) {
            this.image_height = (String) json.get("image_height");
        }

        if (json.containsKey("fixed_height_downsampled_url")) {
            this.fixed_height_downsampled_url = (String) json.get("fixed_height_downsampled_url");
        }

        if (json.containsKey("fixed_height_downsampled_width")) {
            this.fixed_height_downsampled_width = (String) json.get("fixed_height_downsampled_width");
        }

        if (json.containsKey("fixed_height_downsampled_height")) {
            this.fixed_height_downsampled_height = (String) json.get("fixed_height_downsampled_height");
        }

        if (json.containsKey("fixed_width_downsampled_url")) {
            this.fixed_width_downsampled_url = (String) json.get("fixed_width_downsampled_url");
        }

        if (json.containsKey("fixed_width_downsampled_width")) {
            this.fixed_width_downsampled_width = (String) json.get("fixed_width_downsampled_width");
        }

        if (json.containsKey("fixed_width_downsampled_height")) {
            this.fixed_width_downsampled_height = (String) json.get("fixed_width_downsampled_height");
        }

        if (json.containsKey("fixed_height_small_url")) {
            this.fixed_height_small_url = (String) json.get("fixed_height_small_url");
        }

        if (json.containsKey("fixed_height_small_still_url")) {
            this.fixed_height_small_still_url = (String) json.get("fixed_height_small_still_url");
        }

        if (json.containsKey("fixed_height_small_width")) {
            this.fixed_height_small_width = (String) json.get("fixed_height_small_width");
        }

        if (json.containsKey("fixed_height_small_height")) {
            this.fixed_height_small_height = (String) json.get("fixed_height_small_height");
        }

        if (json.containsKey("fixed_width_small_url")) {
            this.fixed_width_small_url = (String) json.get("fixed_width_small_url");
        }

        if (json.containsKey("fixed_width_small_still_url")) {
            this.fixed_width_small_still_url = (String) json.get("fixed_width_small_still_url");
        }

        if (json.containsKey("fixed_width_small_width")) {
            this.fixed_width_small_width = (String) json.get("fixed_width_small_width");
        }

        if (json.containsKey("fixed_width_small_height")) {
            this.fixed_width_small_height = (String) json.get("fixed_width_small_height");
        }
    }


    // getters to access private fields

    public String getType() {
        return type;
    }

    public String getId() {
        return id;
    }

    public String getUrl() {
        return this.url;
    }

    public String getImage_url() {
        return image_url;
    }

    public String getImage_mp4_url() {
        return image_mp4_url;
    }

    public String getImage_frames() {
        return image_frames;
    }

    public String getImage_width() {
        return image_width;
    }

    public String getImage_height() {
        return image_height;
    }

    public String getFixed_height_downsampled_url() {
        return fixed_height_downsampled_url;
    }

    public String getFixed_height_downsampled_width() {
        return fixed_height_downsampled_width;
    }

    public String getFixed_height_downsampled_height() {
        return fixed_height_downsampled_height;
    }

    public String getFixed_width_downsampled_url() {
        return fixed_width_downsampled_url;
    }

    public String getFixed_width_downsampled_width() {
        return fixed_width_downsampled_width;
    }

    public String getFixed_width_downsampled_height() {
        return fixed_width_downsampled_height;
    }

    public String getFixed_height_small_url() {
        return fixed_height_small_url;
    }

    public String getFixed_height_small_still_url() {
        return fixed_height_small_still_url;
    }

    public String getFixed_height_small_width() {
        return fixed_height_small_width;
    }

    public String getFixed_height_small_height() {
        return fixed_height_small_height;
    }

    public String getFixed_width_small_url() {
        return fixed_width_small_url;
    }

    public String getFixed_width_small_still_url() {
        return fixed_width_small_still_url;
    }

    public String getFixed_width_small_width() {
        return fixed_width_small_width;
    }

    public String getFixed_width_small_height() {
        return fixed_width_small_height;
    }
}
