package nyc.c4q.ramonaharrison.network;

import nyc.c4q.ramonaharrison.network.response.*;
import nyc.c4q.ramonaharrison.util.Token;
import org.json.simple.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by Ramona Harrison
 * on 8/26/16
 *
 * A class for interacting with Slack's Web API.
 *
 */

public class Slack {

    private static final String API_KEY = Token.findApiToken();
    private static final String BASE_URL = "https://slack.com/api/";
    private static final String ENDPOINT_TEST = "api.test";
    private static final String ENDPOINT_LIST_CHANNELS = "channels.list";
    private static final String ENDPOINT_LIST_MESSAGES = "channels.history";
    private static final String ENDPOINT_POST_MESSAGE = "chat.postMessage";
    private static final String ENDPOINT_DELETE_MESSAGE = "chat.delete";

    public static final String BOTS_CHANNEL_ID = "C2ABKERFT";
    
    public static Response testApi() {
        URL testUrl = HTTPS.stringToURL(BASE_URL + ENDPOINT_TEST  + "?token=" + API_KEY);

        JSONObject object = HTTPS.get(testUrl);

        return new Response(object);
    }

    public static ListChannelsResponse listChannels() {

        URL listChannelsUrl = HTTPS.stringToURL(BASE_URL + ENDPOINT_LIST_CHANNELS + "?token=" + API_KEY);

        return new ListChannelsResponse(HTTPS.get(listChannelsUrl));
    }

    public static ListMessagesResponse listMessages(String channelId) {

        URL listMessagesUrl = HTTPS.stringToURL(BASE_URL + ENDPOINT_LIST_MESSAGES + "?token=" + API_KEY + "&channel=" + channelId);

        return new ListMessagesResponse(HTTPS.get(listMessagesUrl));
    }

    public static SendMessageResponse sendMessageToBotsChannel(String messageText) {

        try {
            messageText = URLEncoder.encode(messageText, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }

        URL sendMessageUrl = HTTPS.stringToURL(BASE_URL + ENDPOINT_POST_MESSAGE + "?token=" + API_KEY + "&channel=" + BOTS_CHANNEL_ID + "&text=" + messageText);

        return new SendMessageResponse(HTTPS.get(sendMessageUrl));
    }

    public static DeleteMessageResponse deleteMessageFromBotsChannel(String messageTs) {
        URL deleteMessageUrl = HTTPS.stringToURL(BASE_URL + ENDPOINT_DELETE_MESSAGE + "?token=" + API_KEY + "&channel=" + BOTS_CHANNEL_ID + "&ts=" + messageTs);

        return new DeleteMessageResponse(HTTPS.get(deleteMessageUrl));
    }
}
