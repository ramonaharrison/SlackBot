package nyc.c4q.ramonaharrison.network.response;

import nyc.c4q.ramonaharrison.model.Message;
import nyc.c4q.ramonaharrison.model.User;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Millochka on 9/15/16.
 */
public class ListUsers extends Response {


    private List<User> user;

    public ListUsers(JSONObject json) {
        super(json);

        if (json.containsKey("user")) {
            JSONArray array = (JSONArray) json.get("user");

            this.user = new ArrayList<User>();
            for (int i = 0; i < array.size(); i++) {
                this.user.add(new User((JSONObject) array.get(i)));
            }
        }
    }

    public List<User> getUser() {
        return user;
    }
}
