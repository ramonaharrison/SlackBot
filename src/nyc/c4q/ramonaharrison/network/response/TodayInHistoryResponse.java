package nyc.c4q.ramonaharrison.network.response;

/**
 * Created by Rafael on 9/14/16.
 */
import nyc.c4q.ramonaharrison.model.Event;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


import java.util.ArrayList;
import java.util.List;

public class TodayInHistoryResponse {

    private List<Event> events;

    public TodayInHistoryResponse(JSONObject json) {

        if (json.containsKey("event")) {
            JSONArray array = (JSONArray) json.get("event");

            this.events = new ArrayList<Event>();
            for (int i = 0; i < array.size(); i++) {
                this.events.add(new Event((JSONObject) array.get(i)));
            }
        }
    }

    public List<Event> getEvents() {
        return events;
    }
}