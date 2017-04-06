package nyc.c4q.ramonaharrison.model;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ramona Harrison
 * on 8/26/16
 * <p>
 * A class representing a user.
 * See https://api.slack.com/types/user
 */

public class User {

    // implement private fields for each of the following user JSON keys:
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

    private String id;
    private String name;
    private String deleted;
    private String color;
    private List<Profile> userProfile;
    private boolean isAdmin;
    private boolean isOwner;
    private boolean isPrimaryOwner;
    private boolean isRestricted;
    private boolean isUltraRestricted;
    private boolean has2Fa;
    private String twoFactorType;
    private boolean hasFiles;

    public User(JSONObject json) {
        // parse a user from the incoming json

        if (json.containsKey("id"))
            this.id = (String) json.get("id");

        if (json.containsKey("name"))
            this.name = (String) json.get("name");

        if (json.containsKey("deleted"))
            this.deleted = (String) json.get("deleted");

        if (json.containsKey("color"))
            this.color = (String) json.get("color");

        if (json.containsKey("userProfile")) {
            JSONArray jsonUserProfile = (JSONArray) json.get("userProfile");
            this.userProfile = new ArrayList<Profile>();
            for (int i = 0; i < jsonUserProfile.size(); i++) {
                Profile profile = new Profile((JSONObject) jsonUserProfile.get(i));
                this.userProfile.add(profile);
            }
        }

        if (json.containsKey("isAdmin")) {
            this.isAdmin = (boolean) json.get("isAdmin");
        }

        if (json.containsKey("isOwner")) {
            this.isOwner = (boolean) json.get("isOwner");
        }

        if (json.containsKey("isPrimaryOwner")) {
            this.isPrimaryOwner = (boolean) json.get("isPrimaryOwner");
        }

        if (json.containsKey("isRestricted")) {
            this.isRestricted = (boolean) json.get("is_Restricted");
        }

        if (json.containsKey("isUltraRestricted")) {
            this.isUltraRestricted = (boolean) json.get("isUltraRestricted");
        }

        if (json.containsKey("has2Fa")) {
            this.has2Fa = (boolean) json.get("has2Fa");
        }

        if (json.containsKey("twoFactorType")) {
            this.twoFactorType = (String) json.get("twoFactorType");
        }

        if (json.containsKey("hasFiles")) {
            this.hasFiles = (boolean) json.get("hasFiles");
        }
    }

    // getters to access private fields

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

    public List<Profile> getUserProfile() {
        return userProfile;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public boolean isOwner() {
        return isOwner;
    }

    public boolean isPrimaryOwner() {
        return isPrimaryOwner;
    }

    public boolean isRestricted() {
        return isRestricted;
    }

    public boolean isUltraRestricted() {
        return isUltraRestricted;
    }

    public boolean isHas2Fa() {
        return has2Fa;
    }

    public String isTwoFactorType() {
        return twoFactorType;
    }

    public boolean isHasFiles() {
        return hasFiles;
    }

    public void get(String user) {
    }
}
