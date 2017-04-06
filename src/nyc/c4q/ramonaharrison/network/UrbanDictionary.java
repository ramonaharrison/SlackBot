package nyc.c4q.ramonaharrison.network;

import nyc.c4q.ramonaharrison.model.Message;
import nyc.c4q.ramonaharrison.network.response.ListMessagesResponse;

import java.net.URL;
import java.util.List;

public class UrbanDictionary {

    private static final String BASE_URL = "http://www.urbandictionary.com/";
    private static final String ENDPOINT_TEST = "define.php";
    private static final String UNFURL_LINK = "true";

    public static URL wordSearch() {
        ListMessagesResponse listMessagesResponse = Slack.listMessages("C2ERNHJ5D");
        List<Message> messages = listMessagesResponse.getMessages();

        for (Message message : messages) {
            String query = messages.get(0).getText();
            ;
            String substr = "+", regex = "\\s";
            query = query.replaceAll(regex, substr);

            StringBuilder builder = new StringBuilder();
            builder.append(query);

            query = query.substring(builder.indexOf("@U2ADRJVK9") + 15);

            return HTTPS.stringToURL(BASE_URL + ENDPOINT_TEST + "?term=" + query + "&unfurl_links=" + UNFURL_LINK);
        }
        return wordSearch();
    }
}
