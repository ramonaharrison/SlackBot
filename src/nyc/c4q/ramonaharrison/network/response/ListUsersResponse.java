package nyc.c4q.ramonaharrison.network.response;

import nyc.c4q.ramonaharrison.model.User;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ListUsersResponse extends Response{
    private List<User> users;

    public ListUsersResponse(JSONObject json) {
        super(json);

        if (json.containsKey("members")) {
            JSONArray array = (JSONArray) json.get("members");

            this.users = new ArrayList<User>();
            for (int i = 0; i < array.size(); i++) {
                this.users.add(new User((JSONObject) array.get(i)));
            }
        }
    }

    public List<User> getUsers() {
        return users;
    }
}
