package nyc.c4q.ramonaharrison.model;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ramona Harrison
 * on 8/26/16
 *
 * A class representing a message.
 * See https://api.slack.com/docs/message-formatting
 *
 * Example JSON:
 *
 *  {
 *    "text": "I am a test message http://slack.com",
 *    "ts": "1358546515.000008",
 *    "user": "U2147483896",
 *    "attachments": [
 *       {
 *         "text": "And here's an attachment!"
 *       }
 *    ]
 *  }
 *
 */

public class Message {

    private String text;
    private String ts;
    private String user;
    List<Attachment> attachments;

    public Message(JSONObject json) {
        if (json.get("text") != null) {
            this.text = (String) json.get("text");
        }

        if (json.get("ts") != null) {
            this.ts = (String) json.get("ts");
        }

        if (json.get("user") != null) {
            this.user = (String) json.get("user");
        }

        if (json.get("attachments") != null) {
            JSONArray attachmentsArray = (JSONArray) json.get("attachments");
            this.attachments = new ArrayList<Attachment>();
            for (int i = 0; i < attachmentsArray.size(); i++) {
                this.attachments.add(new Attachment((JSONObject) attachmentsArray.get(i)));
            }
        }

    }

    public String getText() {
        return text;
    }

    public String getTs() {
        return ts;
    }

    public String getUser() {
        return user;
    }

    public List<Attachment> getAttachments() {
        return attachments;
    }
}
