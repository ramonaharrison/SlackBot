package nyc.c4q.ramonaharrison.model;

import org.json.simple.JSONObject;

/**
 * Created by jonathancolon on 9/11/16.
 */
public class Profile {
    private String firstName;
    private String lastName;
    private String realName;
    private String email;
    private String skype;
    private String phone;
    private String image_24;
    private String image_32;
    private String image_48;
    private String image_72;
    private String image_192;
    private String image_512;

    public Profile(JSONObject json) {
        if (json.containsKey("first_name")) {
            this.firstName = (String) json.get("first_name");
        }
        if (json.containsKey("last_name")) {
            this.lastName = (String) json.get("last_name");
        }
        if (json.containsKey("real_name")) {
            this.realName = (String) json.get("real_name");
        }
        if (json.containsKey("email")) {
            this.email = (String) json.get("email");
        }
        if (json.containsKey("skype")) {
            this.skype = (String) json.get("skype");
        }
        if (json.containsKey("phone")) {
            this.phone = (String) json.get("phone");
        }
        if (json.containsKey("image_24")) {
            this.image_24 = (String) json.get("image_24");
        }
        if (json.containsKey("image_32")) {
            this.image_32 = (String) json.get("image_32");
        }
        if (json.containsKey("image_48")) {
            this.image_48 = (String) json.get("image_48");
        }
        if (json.containsKey("image_72")) {
            this.image_72 = (String) json.get("image_72");
        }
        if (json.containsKey("image_192")) {
            this.image_192 = (String) json.get("image_192");
        }
        if (json.containsKey("image_512")) {
            this.image_512 = (String) json.get("image_512");
        }






    }
}