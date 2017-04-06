package nyc.c4q.ramonaharrison.network.response;

import nyc.c4q.ramonaharrison.model.Message;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;

// CANNOT SEARCH MESSAGES AS BOT. COULD NOT USE PUBLIC GENERATOR KEY
public class SearchMessagesResponse extends Response {

    private List<Message> messages;
    private String user;

    public SearchMessagesResponse(JSONObject json) {
        super(json);

        if (json.containsKey("messages")) {
            JSONArray array = (JSONArray) json.get("messages");

            if (json.containsKey("user")) {
                this.user = (String) json.get("user");
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


