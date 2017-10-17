package nyc.c4q.ramonaharrison.model;

import com.sun.tools.javac.jvm.Profile;
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
    private boolean isAdmin;

    // "is_owner"
    private boolean isOwner;

    // "is_primary_owner"
    private boolean isPrimaryOwner;

    // "is_restricted"
    private boolean isRestricted;

    // "is_ultra_restricted"
    private boolean isUltraRestricted;

    // "has_2fa"
    private boolean has2fa;

    // "two_factor_type"
    private boolean twoFactorType;

    // "has_files"
    private boolean hasFiles;

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
        if (json.get("color") != null) {
            this.color = (String) json.get("color");
        }
        if (json.get("profile") != null) {
            this.profile = (Profile) json.get("profile");
        }
        if (json.get("is_admin") != null) {
            this.isAdmin = (boolean) json.get("is_admin");
        }
        if (json.get("is_owner") != null) {
            this.isOwner = (boolean) json.get("is_owner");
        }
        if (json.get("is_primary_owner") != null) {
            this.isPrimaryOwner = (boolean) json.get("is_primary_owner");
        }
        if (json.get("is_restricted") != null) {
            this.isRestricted = (boolean) json.get("is_restricted");
        }
        if (json.get("is_ultra_restricted") != null) {
            this.isUltraRestricted = (boolean) json.get("is_ultra_restricted");
        }
        if (json.get("has_2fa") != null) {
            this.has2fa = (boolean) json.get("has_2fa");
        }
        if (json.get("two_factor_type") != null) {
            this.twoFactorType = (boolean) json.get("two_factor_type");
        }
        if (json.get("has_files") != null) {
            this.hasFiles = (boolean) json.get("has_files");
        }
    }

    // TODO add getters to access private fields


    public String getName() {
        return name;
    }

    public Profile getProfile() {
        return profile;
    }

    public String getColor() {
        return color;
    }

    public String getId() {
        return id;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public boolean isHas2fa() {
        return has2fa;
    }

    public boolean isHasFiles() {
        return hasFiles;
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

    public boolean isTwoFactorType() {
        return twoFactorType;
    }

    public boolean isUltraRestricted() {
        return isUltraRestricted;
    }
}