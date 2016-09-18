package nyc.c4q.ramonaharrison.network;

import java.net.URL;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import nyc.c4q.ramonaharrison.model.GiphyData;
import nyc.c4q.ramonaharrison.model.GiphyMeta;
import nyc.c4q.ramonaharrison.model.Message;
import nyc.c4q.ramonaharrison.network.response.GiphyResponse;
import nyc.c4q.ramonaharrison.network.response.ListMessagesResponse;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


public class Giphy {

    // RANDOM GIPHY PULLED FROM QUERY TAG
    // http://api.giphy.com/v1/gifs/random?api_key=dc6zaTOxFJmzC&tag=american+psycho

    private static final String BASE_URL = "https://api.giphy.com/";
    private static final String ENDPOINT_TEST = "v1/gifs/";
    private static final String API = "dc6zaTOxFJmzC";
    private static final String UNFURL_MEDIA = "true";

    public static String giphySearch() {

        ListMessagesResponse listMessagesResponse = Slack.listMessages("C2ADPS5MK");
        List<Message> messages = listMessagesResponse.getMessages();

        for (Message message : messages) {
            String query = message.getText();
            String substr = "+", regex = "\\s";
            query = query.replaceAll(regex, substr);

            URL giphyURL = HTTPS.stringToURL(BASE_URL + ENDPOINT_TEST + "random?" + "api_key=" + API + "&tag=" + query);
                System.out.println(giphyURL);

            JSONObject giphyJson = HTTPS.get(giphyURL);

            if (giphyJson.containsKey("data")) {

                JSONObject myObj = (JSONObject) giphyJson.get("data");
                String giphyString = myObj.get("fixed_height_downsampled_url").toString();
                    System.out.println(giphyString);
                return giphyString;
            } else
                return null;
        }
        return " ";
    }
}

//        Scanner input = new Scanner(System.in);
//            System.out.println("enter a word: ");
//        String query = input.next();