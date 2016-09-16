package nyc.c4q.ramonaharrison.model;

import org.json.simple.JSONObject;

/**
 * Created by Millochka on 9/11/16.
 */
public class Profile {

    private String first_name ="Bobby";
    private String last_name = "Tables";
    private String real_name ="Bobby Tables";
    private String email= "bobby@slack.com";
    private String skype = "my-skype-name";
    private String phone = "+1 (123) 456 7890";
    private String image_24= "https:\\/\\/...";
    private String image_32= "https:\\/\\/...";
    private String image_48= "https:\\/\\/...";
    private String image_72= "https:\\/\\/...";
    private String image_192= "https:\\/\\/...";
    private String image_512= "https:\\/\\/...";

    public Profile(JSONObject json){

        if(json.containsKey("first_name")){
         this.first_name=(String) json.get("first_name");
        }
        if(json.containsKey("last_name")){
            this.last_name=(String) json.get("last_name");
        }
        if(json.containsKey("real_name")){
            this.real_name=(String) json.get("real_name");
        }
        if(json.containsKey("email")){
            this.email=(String) json.get("email");
        }
        if(json.containsKey("skype")){
            this.skype=(String) json.get("skype");
        }
        if(json.containsKey("phone")){
            this.phone=(String) json.get("phone");
        }
        if(json.containsKey("image_24")){
            this.image_24=(String) json.get("image_24");
        }
        if(json.containsKey("image_32")){
            this.image_32=(String) json.get("image_32");
        }
        if(json.containsKey("image_48")){
            this.image_48=(String) json.get("image_48");
        }
        if(json.containsKey("image_72")){
            this.image_72=(String) json.get("image_72");
        }
        if(json.containsKey("image_192")){
            this.image_192=(String) json.get("image_192");
        }
        if(json.containsKey("image_512")){
            this.image_512=(String) json.get("image_512");
        }

    }


    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getReal_name() {
        return real_name;
    }

    public String getEmail() {
        return email;
    }

    public String getSkype() {
        return skype;
    }

    public String getPhone() {
        return phone;
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
}
