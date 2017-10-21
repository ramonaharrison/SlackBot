package nyc.c4q.ramonaharrison.model;

import org.json.simple.JSONObject;

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

        if(json.get("id") != null) {
            this.id = (String) json.get("id");
        }

        if(json.get("name") != null) {
            this.name = (String) json.get("name");
        }

        if(json.get("deleted") != null) {
            this.deleted = (Boolean) json.get("deleted");
        }

        if(json.get("color") != null) {
            this.color = (String) json.get("color");
        }

        if(json.get("profile") != null) {
            this.profile = (String) json.get("profile");
        }

        if(json.get("isAdmin") != null) {
            this.isAdmin = (Boolean) json.get("isAdmin");
        }

        if(json.get("isOwner") != null) {
            this.isOwner = (Boolean) json.get("isOwner");
        }

        if(json.get("isPrimaryOwner") != null) {
            this.isPrimaryOwner = (Boolean) json.get("isPrimaryOwner");
        }

        if(json.get("isRestricted") != null) {
            this.isRestricted = (Boolean) json.get("isRestricted");
        }

        if(json.get("has2fa") != null) {
            this.has2fa = (Boolean) json.get("has2fa");
        }

        if(json.get("twoFactorType") != null) {
            this.twoFactorType = (Boolean) json.get("twoFactorType");
        }

        if(json.get("hasFile") != null) {
            this.hasFiles = (Boolean) json.get("hasFiles");
        }

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
