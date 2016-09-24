package nyc.c4q.ramonaharrison.network;

import nyc.c4q.ramonaharrison.model.Message;
import nyc.c4q.ramonaharrison.network.response.ListMessagesResponse;
import org.json.simple.JSONObject;

import java.net.URL;
import java.util.List;


public class Giphy {

    // RANDOM GIPHY PULLED FROM QUERY TAG
    // http://api.giphy.com/v1/gifs/random?api_key=dc6zaTOxFJmzC&tag=american+psycho

    private static final String BASE_URL = "https://api.giphy.com/";
    private static final String ENDPOINT_TEST = "v1/gifs/";
    private static final String API = "dc6zaTOxFJmzC";

    public static String giphySearch() {

        ListMessagesResponse listMessagesResponse = Slack.listMessages("C2ERNHJ5D");
        List<Message> messages = listMessagesResponse.getMessages();

        for (Message message : messages) {
            String query = message.getText();
            String substr = "+", regex = "\\s";
            query = query.replaceAll(regex, substr);

            StringBuilder builder = new StringBuilder();
            builder.append(query);

            query = query.substring(builder.indexOf("@U2ADRJVK9") + 18);

            URL giphyURL = HTTPS.stringToURL(BASE_URL + ENDPOINT_TEST + "random?" + "api_key=" + API + "&tag=" + query);
            System.out.println(giphyURL);

            JSONObject giphyJson = HTTPS.get(giphyURL);

            if (giphyJson.containsKey("data")) {

                JSONObject myObj = (JSONObject) giphyJson.get("data");
                String giphyString = myObj.get("url").toString();
                System.out.println(giphyString);
                return giphyString;
            } else
                return null;
        }
        return " ";
    }
}
