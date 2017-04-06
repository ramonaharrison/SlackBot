package nyc.c4q.ramonaharrison.model;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

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


    private String id;
    private String name;
    private boolean deleted;
    private String color;
    private List<Profile> profile;
    private boolean is_admin;
    private boolean is_owner;
    private boolean is_primary_owner;
    private boolean is_restricted;
    private boolean is_ultra_restricted;
    private boolean has_2fa;
    private String two_factor_type;
    private boolean has_files;

    public User(JSONObject json) {

        if (json.containsKey("id")) {
            this.id = (String) json.get("id");
        }
        if (json.containsKey("name")) {
            this.name = (String) json.get("name");
        }
        if (json.containsKey("color")) {
            this.color = (String) json.get("color");
        }
        if (json.containsKey("two_factor_type")) {
            this.two_factor_type = (String) json.get("two_factor_type");
        }
        if (json.containsKey("deleted")) {
            this.deleted = (boolean) json.get("deleted");
        }
        if (json.containsKey("is_admin")) {
            this.is_admin = (boolean) json.get("is_admin");
        }
        if (json.containsKey("is_owner")) {
            this.is_owner = (boolean) json.get("is_owner");
        }
        if (json.containsKey("is_primary_owner")) {
            this.is_primary_owner = (boolean) json.get("is_primary_owner");
        }
        if (json.containsKey("is_restricted")) {
            this.is_restricted = (boolean) json.get("is_restricted");
        }
        if (json.containsKey("is_ultra_restricted")) {
            this.is_ultra_restricted = (boolean) json.get("is_ultra_restricted");
        }
        if (json.containsKey("has_2fa")) {
            this.has_2fa = (boolean) json.get("has_2fa");
        }
        if (json.containsKey("has_files")) {
            this.has_files = (boolean) json.get("has_files");
        }

        if (json.containsKey("profile")) {

            JSONArray jasonFields = (JSONArray) json.get("profile");
            this.profile = new ArrayList<Profile>();
            for (int i = 0; i < jasonFields.size(); i++) {

                Profile profile = new Profile((JSONObject) jasonFields.get(i));
                this.profile.add(profile);

            }


        }
    }



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

    public List<Profile> getProfile() {
        return profile;
    }

    public boolean is_admin() {
        return is_admin;
    }

    public boolean is_owner() {
        return is_owner;
    }

    public boolean is_primary_owner() {
        return is_primary_owner;
    }

    public boolean is_restricted() {
        return is_restricted;
    }

    public boolean is_ultra_restricted() {
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
