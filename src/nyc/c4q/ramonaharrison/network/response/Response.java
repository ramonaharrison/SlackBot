package nyc.c4q.ramonaharrison.network.response;

import org.json.simple.JSONObject;

/**
 * Created by Ramona Harrison
 * on 8/26/16
 *
 * A class representing a response from Slack's Web API.
 * See https://api.slack.com/methods/api.test
 *
 */

public class Response {

    private boolean ok;
    private String error;

    public Response(JSONObject json) {
        if (json.get("ok") != null) {
            this.ok = (Boolean) json.get("ok");
        }

        if (json.get("error") != null) {
            this.error = (String) json.get("error");
        }
    }

    public boolean isOk() {
        return ok;
    }

    public String getError() {
        return error;
    }
}
