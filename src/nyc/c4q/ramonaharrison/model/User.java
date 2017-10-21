package nyc.c4q.ramonaharrison.model;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import java.util.ArrayList;
import java.util.List;

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
    // "id"
    private String id;
    // "name"
    private String name;
    // "deleted"
    private boolean deleted;
    // "color"
    private String color;
    // "profile"
    private List<String> profile;
    // "is_admin"
    private boolean is_admin;
    // "is_owner"
    private boolean is_owner;
    // "is_primary_owner"
    private boolean is_primary_owner;
    // "is_restricted"
    private boolean is_restricted;
    // "is_ultra_restricted"
    private boolean is_ultra_restricted;
    // "has_2fa"
    private boolean has_2fa;
    // "two_factor_type"
    private String two_factor_type;
    // "has_files"
    private boolean has_files;

    public User(JSONObject json) {
        // TODO: parse a user from the incoming json
        if (json.get("id") != null) {
            this.id = (String) json.get("id");
        }

        if (json.get("name") != null) {
            this.name = (String) json.get("name");
        }

        if (json.get("deleted") != null) {
            this.deleted = (boolean) json.get("deleted");
        }

        if(json.get("color") != null) {
            this.color = (String) json.get("color");
        }

        if (json.get("profile") != null) {
            JSONArray profileArray = (JSONArray) json.get("profile");
            this.profile = new ArrayList<String>();
            for (int i = 0; i < profileArray.size(); i++) {
                this.profile.add((String) profileArray.get(i));
            }
        }

        if (json.get("is_admin") != null) {
            this.is_admin = (boolean) json.get("is_admin");
        }

        if (json.get("is_owner") != null) {
            this.is_owner = (boolean) json.get("is_owner");
        }

        if (json.get("is_primary_owner") != null) {
            this.is_primary_owner = (boolean) json.get("is_primary_owner");
        }

        if (json.get("is_restricted") != null) {
            this.is_restricted = (boolean) json.get("is_restricted");
        }

        if (json.get("is_ultra_restricted") != null) {
            this.is_ultra_restricted = (boolean) json.get("is_ultra_restricted");
        }

        if (json.get("has_2fa") != null) {
            this.has_2fa = (boolean) json.get("has_2fa");
        }

        if (json.get("two_factor_type") != null) {
            this.two_factor_type = (String) json.get("two_factor_type");
        }

        if (json.get("has_files") != null) {
            this.has_files = (boolean) json.get("has_files");
        }
    }

    // TODO add getters to access private fields

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public String getColor() {
        return color;
    }

    public List<String> getProfile() {
        return profile;
    }

    public boolean isIs_admin() {
        return is_admin;
    }

    public boolean isIs_owner() {
        return is_owner;
    }

    public boolean isIs_primary_owner() {
        return is_primary_owner;
    }

    public boolean isIs_restricted() {
        return is_restricted;
    }

    public boolean isIs_ultra_restricted() {
        return is_ultra_restricted;
    }

    public boolean isHas_2fa() {
        return has_2fa;
    }

    public String getTwo_factor_type() {
        return two_factor_type;
    }

    public boolean isHas_files() {
        return has_files;
    }
}
