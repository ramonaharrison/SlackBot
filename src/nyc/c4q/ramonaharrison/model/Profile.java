package nyc.c4q.ramonaharrison.model;

public class Profile {

    private String avatar_hash;
    private String status_text;
    private String status_emoji;
    private String real_name;
    private String display_name;
    private String real_name_normalized;
    private String display_name_normalized;
    private String email;
    private String image_24;
    private String image_32;
    private String image_48;
    private String image_72;
    private String image_192;
    private String image_512;
    private String team;

    public Profile(String avatar_hash, String status_text, String status_emoji, String real_name, String display_name, String real_name_normalized, String display_name_normalized, String email, String image_24, String image_32, String image_48, String image_72, String image_192, String image_512, String team) {
        this.avatar_hash = avatar_hash;
        this.status_text = status_text;
        this.status_emoji = status_emoji;
        this.real_name = real_name;
        this.display_name = display_name;
        this.real_name_normalized = real_name_normalized;
        this.display_name_normalized = display_name_normalized;
        this.email = email;
        this.image_24 = image_24;
        this.image_32 = image_32;
        this.image_48 = image_48;
        this.image_72 = image_72;
        this.image_192 = image_192;
        this.image_512 = image_512;
        this.team = team;
    }

    public String getAvatar_hash() {
        return avatar_hash;
    }

    public String getStatus_text() {
        return status_text;
    }

    public String getStatus_emoji() {
        return status_emoji;
    }

    public String getReal_name() {
        return real_name;
    }

    public String getDisplay_name() {
        return display_name;
    }

    public String getReal_name_normalized() {
        return real_name_normalized;
    }

    public String getDisplay_name_normalized() {
        return display_name_normalized;
    }

    public String getEmail() {
        return email;
    }

    public String getImage_24() {
        return image_24;
    }

    public String getImage_32() {
        return image_32;
    }

    public String getImage_48() {
        return image_48;
    }

    public String getImage_72() {
        return image_72;
    }

    public String getImage_192() {
        return image_192;
    }

    public String getImage_512() {
        return image_512;
    }

    public String getTeam() {
        return team;
    }
}
