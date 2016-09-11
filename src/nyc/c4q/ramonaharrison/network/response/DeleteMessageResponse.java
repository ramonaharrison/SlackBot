package nyc.c4q.ramonaharrison.network.response;

import org.json.simple.JSONObject;

/**
 * Created by Ramona Harrison
 * on 9/10/16
 *
 * A class representing the response from chat.delete
 * See https://api.slack.com/methods/chat.delete
 *
 */

public class DeleteMessageResponse extends Response {

    private String channel;
    private String ts;

    public DeleteMessageResponse(JSONObject json) {
        super(json);

        if (json.get("channel") != null) {
            this.channel = (String) json.get("channel");
        }

        if (json.get("ts") != null) {
            this.ts = (String) json.get("ts");
        }
    }

    public String getChannel() {
        return channel;
    }

    public String getTs() {
        return ts;
    }
}
