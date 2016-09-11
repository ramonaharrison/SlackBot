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
    private List<Profile> profiles;
    private boolean isAdmin;
    private boolean isOwner;
    private boolean isPrimaryOwner;
    private boolean isRestricted;
    private boolean isUltraRestricted;
    private boolean has2FA;
    private String twoFactorType;
    private boolean hasFiles;


    public User(JSONObject json) {
        if (json.containsKey("id")) {
            this.id = (String) json.get("id");
        }
        if (json.containsKey("name")) {
            this.name = (String) json.get("name");
        }
        if (json.containsKey("deleted")) {
            this.deleted = (boolean) json.get("deleted");
        }
        if (json.containsKey("deleted")) {
            this.deleted = (boolean) json.get("deleted");
        }
        if (json.containsKey("color")) {
            this.color = (String) json.get("color");
        }
        if (json.containsKey("profiles")) {
            JSONArray jsonProfiles = (JSONArray) json.get("profiles");
            this.profiles = new ArrayList<Profile>();
            for (int i = 0; i < jsonProfiles.size(); i++) {
                Profile profile = new Profile((JSONObject) jsonProfiles.get(i));
            }
        }
        if (json.containsKey("is_admin")) {
            this.isAdmin = (boolean) json.get("is_admin");
        }
        if (json.containsKey("is_owner")) {
            this.isOwner = (boolean) json.get("is_owner");
        }
        if (json.containsKey("is_primary_owner")) {
            this.isPrimaryOwner = (boolean) json.get("is_primary_owner");
        }
        if (json.containsKey("is_restricted")) {
            this.isRestricted = (boolean) json.get("is_restricted");
        }
        if (json.containsKey("is_ultra_restricted")) {
            this.isUltraRestricted = (boolean) json.get("is_ultra_restricted");
        }
        if (json.containsKey("has_2fa")) {
            this.has2FA = (boolean) json.get("has_2fa");
        }
        if (json.containsKey("two_factor_type")) {
            this.twoFactorType = (String) json.get("two_factor_type");
        }
        if (json.containsKey("has_files")) {
            this.hasFiles = (boolean) json.get("has_files");
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

    public List<Profile> getProfiles() {
        return profiles;
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

    public boolean isHas2FA() {
        return has2FA;
    }

    public String getTwoFactorType() {
        return twoFactorType;
    }

    public boolean isHasFiles() {
        return hasFiles;
    }
}
