package nyc.c4q.ramonaharrison.network.response;

/**
 * Created by Rafael on 9/14/16.
 */
import nyc.c4q.ramonaharrison.model.Event;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TodayInHistoryResponse {

    private List<Event> events;

    public TodayInHistoryResponse(JSONObject json) {

        if (json.containsKey("data")) {
            json = (JSONObject) json.get("data");

            if (json.containsKey("Events")) {
                JSONArray array = (JSONArray) json.get("Events");

                this.events = new ArrayList<Event>();
                for (int i = 0; i < array.size(); i++) {
                    this.events.add(new Event((JSONObject) array.get(i)));
                }
            }

        }
    }

    public List<Event> getEvents() {
        return events;
    }

    public Event getRandomEvent() {
        Random random = new Random();

        return events.get(random.nextInt(events.size()));
    }
}