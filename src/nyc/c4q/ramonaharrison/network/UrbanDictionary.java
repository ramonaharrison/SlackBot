package nyc.c4q.ramonaharrison.network;

import com.sun.org.apache.regexp.internal.RE;
import nyc.c4q.ramonaharrison.model.Attachment;
import nyc.c4q.ramonaharrison.model.Message;
import nyc.c4q.ramonaharrison.network.response.*;
import nyc.c4q.ramonaharrison.util.Token;
import org.json.simple.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;
import java.util.Scanner;


public class UrbanDictionary {

    private static final String BASE_URL = "http://www.urbandictionary.com/";
    private static final String ENDPOINT_TEST = "define.php";
    private static final String TERM = "?term=";
    private static final String UNFURL_LINK = "true";
    private static final String UNFURL_MEDIA = "true";

    public static URL wordSearch() {
        ListMessagesResponse listMessagesResponse = Slack.listMessages("C2ADPS5MK");
        List<Message> messages = listMessagesResponse.getMessages();

        for (Message message : messages) {
            String query = message.getText();
            String substr = "+", regex = "\\s";
            query = query.replaceAll(regex,substr);
            return HTTPS.stringToURL(BASE_URL + ENDPOINT_TEST + "?term=" + query + "&unfurl_links=" + UNFURL_LINK);
        }
        return wordSearch();
    }
}

//       Scanner input = new Scanner(System.in);
//       System.out.println("enter a word: ");
//       query = input.next();