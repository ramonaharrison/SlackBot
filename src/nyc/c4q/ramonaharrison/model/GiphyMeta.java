package nyc.c4q.ramonaharrison.model;

import org.json.simple.JSONObject;

/**
 * "meta": {
 * "status": 200,
 * "msg": "OK"
 * }
 */

public class GiphyMeta {

    private int status;
    private String msg;

    // parse data from the incoming json

    public GiphyMeta(JSONObject json) {

        if (json.containsKey("status")) {
            this.status = (Integer) json.get("status");
        }

        if (json.containsKey("msg")) {
            this.msg = (String) json.get("msg");
        }
    }

    // getters to access private fields

    public int getStatus() {
        return status;
    }

    public String getMsg() {
        return msg;
    }
}
