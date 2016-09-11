package nyc.c4q.ramonaharrison.model;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ramona Harrison
 * on 8/26/16
 *
 * A class representing a channel object, which contains information about a team channel.
 * See https://api.slack.com/types/channel
 *
 */

public class Channel {

    private String id;
    private String name;
    private String creator;
    private String lastRead;

    private Topic topic;
    private Purpose purpose;

    private List<String> members;
    private Message latest;

    private boolean isArchived;
    private boolean isGeneral;
    private boolean isChannel;
    private boolean isMember;

    private long created;
    private long unreadCount;
    private long unreadCountDisplay;

    public Channel(JSONObject json) {

        if (json.get("id") != null) {
            this.id = (String) json.get("id");
        }

        if (json.get("name") != null) {
            this.name = (String) json.get("name");
        }

        if (json.get("creator") != null) {
            this.creator = (String) json.get("creator");
        }

        if (json.get("last_read") != null) {
            this.lastRead = (String) json.get("last_read");
        }

        if (json.get("topic") != null) {
            this.topic = new Topic((JSONObject) json.get("topic"));
        }

        if (json.get("purpose") != null) {
            this.purpose = new Purpose((JSONObject) json.get("purpose"));
        }

        if (json.get("members") != null) {
            JSONArray membersArray = (JSONArray) json.get("members");
            this.members = new ArrayList<String>();
            for (int i = 0; i < membersArray.size(); i++) {
                this.members.add((String) membersArray.get(i));
            }
        }

        if (json.get("latest") != null) {
            this.latest = new Message((JSONObject) json.get("latest"));
        }

        if (json.get("is_archived") != null) {
            this.isArchived = (Boolean) json.get("is_archived");
        }

        if (json.get("is_general") != null) {
            this.isGeneral = (Boolean) json.get("is_general");
        }

        if (json.get("is_channel") != null) {
            this.isChannel = (Boolean) json.get("is_channel");
        }

        if (json.get("is_member") != null) {
            this.isMember = (Boolean) json.get("is_member");
        }

        if (json.get("created") != null) {
            this.created = (Long) json.get("created");
        }

        if (json.get("unread_count") != null) {
            this.unreadCount = (Long) json.get("unread_count");
        }

        if (json.get("unread_count_display") != null) {
            this.unreadCountDisplay = (Long) json.get("unread_count_display");
        }
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCreator() {
        return creator;
    }

    public String getLastRead() {
        return lastRead;
    }

    public Topic getTopic() {
        return topic;
    }

    public Purpose getPurpose() {
        return purpose;
    }

    public List<String> getMembers() {
        return members;
    }

    public Message getLatest() {
        return latest;
    }

    public boolean isArchived() {
        return isArchived;
    }

    public boolean isGeneral() {
        return isGeneral;
    }

    public boolean isChannel() {
        return isChannel;
    }

    public boolean isMember() {
        return isMember;
    }

    public long getCreated() {
        return created;
    }

    public long getUnreadCount() {
        return unreadCount;
    }

    public long getUnreadCountDisplay() {
        return unreadCountDisplay;
    }
}
