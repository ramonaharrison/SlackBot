package nyc.c4q.ramonaharrison.model;

import org.json.simple.JSONObject;

/**
 * Created by Millochka on 9/11/16.
 */
public class Field {


    private    String title= "Priority";
    private    String value =  "High";
    private boolean isShort=false;


    public Field(JSONObject json) {
        if(json.containsKey("title")){
            this.title=(String)json.get("title");
        }
        if(json.containsKey("value")){
            this.value=(String)json.get("value");
        }
        if(json.containsKey("Short")){
            this.isShort=(Boolean) json.get("Short");
        }


    }


    public String getTitle() {
        return title;
    }

    public String getValue() {
        return value;
    }

    public boolean isShort() {
        return isShort;
    }
}

