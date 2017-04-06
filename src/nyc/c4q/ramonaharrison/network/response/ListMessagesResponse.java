package nyc.c4q.ramonaharrison.network.response;

import nyc.c4q.ramonaharrison.model.Message;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ramona Harrison
 * on 8/26/16
 *
 * A class representing the response from channels.history
 * See https://api.slack.com/methods/channels.history
 *
 */

public class ListMessagesResponse extends Response {

    private List<Message> messages;
    private String user;

    public ListMessagesResponse(JSONObject json) {
        super(json);

        if (json.containsKey("messages")) {
            JSONArray array = (JSONArray) json.get("messages");

            if(json.containsKey("user")){
                this.user= (String) json.get("user");
            }

            this.messages = new ArrayList<Message>();
            for (int i = 0; i < 1; i++) {
                this.messages.add(new Message((JSONObject) array.get(i)));
            }
        }
    }

    public List<Message> getMessages() {
        return messages;
    }

    public String getUser() {
        return user;
    }
}
