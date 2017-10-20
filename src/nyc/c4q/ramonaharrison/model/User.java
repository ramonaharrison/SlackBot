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

    private String id;
    private String name;
    private boolean deleted;
    private String color;
    private String profile;
    private boolean isAdmin;
    private boolean isOwner;
    private boolean isPrimaryOwner;
    private boolean isRestricted;
    private boolean has2fa;
    private boolean twoFactorType;
    private boolean hasFiles;


    public User(JSONObject json) {

    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean deleted() {
        return deleted;
    }

    public String getcolor() {
        return color;
    }

    public String getProfile() {
        return profile;
    }

    public boolean IsAdmin() {
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

    public boolean has2fa() {
        return has2fa;
    }

    public boolean twoFactorType() {
        return twoFactorType;
    }

    public boolean hasFiles() {
        return hasFiles;
    }
}
