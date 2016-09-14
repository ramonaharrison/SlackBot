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
    // "id"
    private String id;
    // "name"
    private String name;
    // "deleted"
    private boolean deleted;
    // "color"
    private String color;
    // "profile"
    private Profile profile;
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

        if (json.get("name") != name) {
            this.name = (String) json.get("name");
        }

        if (json.get("deleted") != null) {
            this.deleted = (boolean) json.get("deleted");
        }

        if (json.get("color") != null) {
            this.color = (String) json.get("color");
        }

        if (json.get("profile") != null) {
            this.profile = new Profile((JSONObject) json.get("profile"));
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

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public boolean is_admin() {
        return is_admin;
    }

    public void setIs_admin(boolean is_admin) {
        this.is_admin = is_admin;
    }

    public boolean is_owner() {
        return is_owner;
    }

    public void setIs_owner(boolean is_owner) {
        this.is_owner = is_owner;
    }

    public boolean is_primary_owner() {
        return is_primary_owner;
    }

    public void setIs_primary_owner(boolean is_primary_owner) {
        this.is_primary_owner = is_primary_owner;
    }

    public boolean is_restricted() {
        return is_restricted;
    }

    public void setIs_restricted(boolean is_restricted) {
        this.is_restricted = is_restricted;
    }

    public boolean is_ultra_restricted() {
        return is_ultra_restricted;
    }

    public void setIs_ultra_restricted(boolean is_ultra_restricted) {
        this.is_ultra_restricted = is_ultra_restricted;
    }

    public boolean isHas_2fa() {
        return has_2fa;
    }

    public void setHas_2fa(boolean has_2fa) {
        this.has_2fa = has_2fa;
    }

    public String getTwo_factor_type() {
        return two_factor_type;
    }

    public void setTwo_factor_type(String two_factor_type) {
        this.two_factor_type = two_factor_type;
    }

    public boolean isHas_files() {
        return has_files;
    }

    public void setHas_files(boolean has_files) {
        this.has_files = has_files;
    }
}
