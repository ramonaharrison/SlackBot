package nyc.c4q.ramonaharrison.model;

import org.json.simple.JSONObject;

/**
 * Created by Ramona Harrison
 * on 8/26/16
 *
 * A class representing a user.
 * See https://api.slack.com/types/user
 *
 */

public class User {

    // TODO: implement private fields for each of the following user JSON keys:
    private String id;
    private String name;
    private String deleted;
    private String color;
    private String is_admin;
    private String is_owner;
    private String is_primary_owner;
    private String is_restricted;
    private String is_ultra_restricted;
    private String has_2fa;
    private String two_factor_type;
    private String has_files;

    // "id"
    // "name"
    // "deleted"
    // "color"
    // "profile"
    // "is_admin"
    // "is_owner"
    // "is_primary_owner"
    // "is_restricted"
    // "is_ultra_restricted"
    // "has_2fa"
    // "two_factor_type"
    // "has_files"

    public User(JSONObject json) {
        // TODO: parse a user from the incoming json

        if(json.containsKey("id")){
            this.id = (String) json.get("id");
        }
    }

    // TODO add getters to access private fields

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDeleted() {
        return deleted;
    }

    public String getColor() {
        return color;
    }

    public String getIs_admin() {
        return is_admin;
    }

    public String getIs_owner() {
        return is_owner;
    }

    public String getIs_primary_owner() {
        return is_primary_owner;
    }

    public String getIs_restricted() {
        return is_restricted;
    }

    public String getIs_ultra_restricted() {
        return is_ultra_restricted;
    }

    public String getHas_2fa() {
        return has_2fa;
    }

    public String getTwo_factor_type() {
        return two_factor_type;
    }

    public String getHas_files() {
        return has_files;
    }
}
