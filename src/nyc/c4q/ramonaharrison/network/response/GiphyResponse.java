package nyc.c4q.ramonaharrison.network.response;

import nyc.c4q.ramonaharrison.model.*;
import nyc.c4q.ramonaharrison.network.Slack;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CATWONG on 9/17/16.
 */

public class GiphyResponse{

    private String data;
    private String url;
    private String fixed_height_downsampled_url;


    public GiphyResponse(JSONObject json) {

        if (json.get("data") != null) {
            this.data = (String) json.get("data");
        }

        if (json.get("url") != null) {
            this.url = (String) json.get("url");
        }

        if (json.get("fixed_height_downsampled_url")  != null){
            this.fixed_height_downsampled_url = (String) json.get("url");
        }
    }

    public String getData() {
        return data;
    }
    public String getUrl() {
        return url;
    }
    public String getFixed_height_downsampled_url() {
        return fixed_height_downsampled_url;
    }
}


