package nyc.c4q.ramonaharrison.network;

/**
 * Created by Rafael on 9/14/16.
 */
import nyc.c4q.ramonaharrison.network.response.TodayInHistoryResponse;

import java.net.URL;

public class TodayInHistory {

    public static TodayInHistoryResponse getTodayInHistory() {
        URL testUrl = HTTP.stringToURL("http://history.muffinlabs.com/date");

        return new TodayInHistoryResponse(HTTP.get(testUrl));
    }
}