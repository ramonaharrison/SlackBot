package nyc.c4q.ramonaharrison.network.response;

import org.json.simple.JSONObject;
import nyc.c4q.ramonaharrison.model.User;


public class UserInfoResponse extends Response {

    private User user;
    private User name;

    public UserInfoResponse(JSONObject json) {
        super(json);

        if (json.containsKey("user")) {
            this.user = new User((JSONObject) json.get("user"));
        }

        if (json.containsKey("name")) {
            this.name = new User((JSONObject) json.get("name"));
        }
    }

    public User getUser() {
        return user;
    }

    public User getName() {
        return name;
    }
}







