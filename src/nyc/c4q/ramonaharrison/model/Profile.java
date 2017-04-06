package nyc.c4q.ramonaharrison.model;

import org.json.simple.JSONObject;

public class Profile {

    private String firstName;
    private String lastName;
    private String realName;
    private String email;
    private String skype;
    private String phone;
    private String image24;
    private String image32;
    private String image48;
    private String image72;
    private String image192;
    private String image512;

    public Profile(JSONObject json) {
        if (json.containsKey("firstName")) {
            this.firstName = (String) json.get("firstName");
        }

        if (json.containsKey("lastName")) {
            this.lastName = (String) json.get("lastName");
        }

        if (json.containsKey("realName")) {
            this.realName = (String) json.get("realName");
        }

        if (json.containsKey("email")) {
            this.email = (String) json.get("email");
        }

        if (json.containsKey("skype")) {
            this.skype = (String) json.get("skype");
        }

        if (json.containsKey("phone"))
            this.phone = (String) json.get("phone");

        if (json.containsKey("image24")) {
            this.image24 = (String) json.get("image_24");
        }

        if (json.containsKey("image32")) {
            this.image32 = (String) json.get("image32");
        }

        if (json.containsKey("image48")) {
            this.image48 = (String) json.get("image48");
        }

        if (json.containsKey("image72")) {
            this.image72 = (String) json.get("image72");
        }

        if (json.containsKey("image192")) {
            this.image192 = (String) json.get("image192");
        }

        if (json.containsKey("image512")) {
            this.image512 = (String) json.get("image512");
        }
    }
}
