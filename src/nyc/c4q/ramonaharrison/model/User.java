package nyc.c4q.ramonaharrison.model;

import com.sun.org.apache.xpath.internal.operations.Bool;
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
    private boolean deleted;
    private String color;
    private Profile profile;
    private boolean isAdmin;
    private boolean isOwner;
    private boolean isPrimaryOwner;
    private boolean isRestricted;
    private boolean isUltraRestricted;
    private boolean has2fa;
    private String twoFactorType;
    private boolean hasFiles;

    public User(JSONObject json) {
        // TODO: parse a user from the incoming json
        if (json.containsKey("id")) {
            this.id = (String) json.get("id"); //casting this object to a string
        }
        if (json.containsKey("name")) {
            this.name = (String) json.get("name"); //casting this object to a string
        }
        if (json.containsKey("deleted")) {
            this.deleted = (boolean) json.get("deleted");
        }
        if (json.containsKey("color")) {
            this.color = (String) json.get("deleted");
        }
        if (json.containsKey("isAdmin")) {
            this.isAdmin = (boolean) json.get("isAdmin");
        }
        if (json.containsKey("isOwner")) {
            this.isOwner = (boolean) json.get("isOwner");
        }
        if (json.containsKey("isPrimaryOwner")) {
            this.isPrimaryOwner = (Boolean) json.get("isPrimaryOwner");
        }
        if (json.containsKey("isRestricted")) {
            this.isRestricted = (boolean) json.get("isRestricted");
        }
        if (json.containsKey("isUltraRestricted")) {
            this.isUltraRestricted = (boolean) json.get("isUltraRestricted");
        }
        if (json.containsKey("has2fa")) {
            this.has2fa = (boolean) json.get("has2fa");
        }
        if (json.containsKey("twoFactorType")) {
            this.twoFactorType = (String) json.get("twoFactorType");
        }
        if (json.containsKey("hasFiles")) {
            this.hasFiles = (boolean) json.get("hasFiles");
        }
    }

    // TODO add getters to access private fields

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean getDeleted() {
        return deleted;
    }

    public String getColor() {
        return color;
    }

    public boolean getAdmin() {
        return isAdmin;
    }

    public boolean getOwner() {
        return isOwner;
    }

    public boolean getPrimaryOwner() {
        return isPrimaryOwner;
    }

    public boolean getRestricted() {
        return isRestricted;
    }

    public boolean getUltraRestricted() {
        return isUltraRestricted;
    }

    public boolean getHas2fa() {
        return has2fa;
    }

    public String getTwoFactorType() {
        return twoFactorType;
    }

    public boolean getHasFiles() {
        return hasFiles;
    }

    public Profile getProfile() {
        return profile;
    }
}
