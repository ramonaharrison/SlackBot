package nyc.c4q.ramonaharrison.network.response;

import nyc.c4q.ramonaharrison.model.Channel;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ramona Harrison
 * on 8/26/16
 *
 * A class representing the response from channels.list
 * See https://api.slack.com/methods/channels.list
 *
 */

public class ListChannelsResponse extends Response {

    private List<Channel> channels;

    public ListChannelsResponse(JSONObject json) {
        super(json);

        if (json.containsKey("channels")) {
            JSONArray array = (JSONArray) json.get("channels");

            this.channels = new ArrayList<Channel>();
            for (int i = 0; i < array.size(); i++) {
                channels.add(new Channel((JSONObject) array.get(i)));
            }
        }
    }

    public List<Channel> getChannels() {
        return channels;
    }
}
