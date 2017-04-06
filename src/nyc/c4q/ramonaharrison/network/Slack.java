package nyc.c4q.ramonaharrison.network;

import nyc.c4q.ramonaharrison.Bot;
import nyc.c4q.ramonaharrison.model.Attachment;
import nyc.c4q.ramonaharrison.network.response.*;
import nyc.c4q.ramonaharrison.util.Token;
import org.json.simple.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;

/**
 * Created by Ramona Harrison
 * on 8/26/16
 *
 * A class for interacting with Slack's Web API.
 *
 */

public class Slack {

    private static final String USERNAME = "&username=beggarbot";
    private static final String API_KEY = Token.findApiToken();
    private static final String BASE_URL = "https://slack.com/api/";
    private static final String ENDPOINT_TEST = "api.test";
    private static final String ENDPOINT_LIST_CHANNELS = "groups.list";
    private static final String ENDPOINT_LIST_MESSAGES = "channels.history";
    private static final String ENDPOINT_POST_MESSAGE = "chat.postMessage";
    private static final String ENDPOINT_DELETE_MESSAGE = "chat.delete";
    private static final String ENDPOINT_URL_IMAGE = "&icon_url=http://orig02.deviantart.net/9689/f/2012/027/9/c/mr_bender______classy__by_sgtconker1r-d4nqpzu.png";

//    public static final String BOTS_CHANNEL_ID = "G2FBLTCGK";
    public static final String BOTS_CHANNEL_ID = "C2ABKERFT";

    /**
     * Static method to test the Slack API.
     *
     * @return the Response indicating ok/error or null if the connection failed.
     */
    public static Response testApi() {
        URL testUrl = HTTPS.stringToURL(BASE_URL + ENDPOINT_TEST  + "?token=" + API_KEY);

        JSONObject object = HTTPS.get(testUrl);

        return new Response(object);
    }

    /**
     * Static method to list all public channels on the Slack team.
     *
     * @return the ListChannelsResponse indicating ok/error or null if the connection failed.
     */
    public static ListChannelsResponse listChannels() {

        URL listChannelsUrl = HTTPS.stringToURL(BASE_URL + ENDPOINT_LIST_CHANNELS + "?token=" + API_KEY);

        return new ListChannelsResponse(HTTPS.get(listChannelsUrl));
    }

    /**
     * Static method to list the last 100 message on a given channel.
     *
     * @param  channelId the id of the channel from which to list messages.
     * @return the ListMessagesResponse indicating ok/error or null if the connection failed.
     */
    public static ListMessagesResponse listMessages(String channelId) {

        URL listMessagesUrl = HTTPS.stringToURL(BASE_URL + ENDPOINT_LIST_MESSAGES + "?token=" + API_KEY + "&channel=" + channelId);

        return new ListMessagesResponse(HTTPS.get(listMessagesUrl));
    }

    /**
     * Static method to send a message to the #bots channel.
     *
     * @param  messageText the message text.
     * @return the SendMessageResponse indicating ok/error or null if the connection failed.
     */
    public static SendMessageResponse sendMessage(String messageText) {

        try {
            messageText = URLEncoder.encode(messageText, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }


        URL sendMessageUrl = HTTPS.stringToURL(BASE_URL + ENDPOINT_POST_MESSAGE + "?token=" + API_KEY + "&channel=" + BOTS_CHANNEL_ID + ENDPOINT_URL_IMAGE + "&text=" + messageText + USERNAME);

        return new SendMessageResponse(HTTPS.get(sendMessageUrl));
    }

    public static SendMessageResponse sendMessageAsPolice(String messageText) {

        try {
            messageText = URLEncoder.encode(messageText, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }


        URL sendMessageUrl = HTTPS.stringToURL(BASE_URL + ENDPOINT_POST_MESSAGE + "?token=" + API_KEY + "&channel=" + BOTS_CHANNEL_ID + "&icon_url=http://images.clipartpanda.com/cop-clipart-POLICE-CARTOON-HOLDING-UP-ONE-HAND.jpg" + "&text=" + messageText + "&username=angrycop");

        return new SendMessageResponse(HTTPS.get(sendMessageUrl));
    }

    /**
     * Static method to send a message with one or more attachments to the #bots channel.
     *
     * @param  messageText the message text.
     * @param  attachments a list of one of more attachments to be parsed to a JSON-encoded URL string parameter.
     * @return the SendMessageResponse indicating ok/error or null if the connection failed.
     */


    public static SendMessageResponse sendMessageWithAttachments(String messageText, List<Attachment> attachments) {
        // first new feature
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (Attachment attachment: attachments) {
            if(attachment.equals(attachments.get(attachments.size()-1))){
                stringBuilder.append("{\"color\":%20\"%23" + attachment.getColor() + "\",%20\"pretext\":\"" + attachment.getPretext() + "\",\"author_name\":\"" + attachment.getAuthor_name() + "\",\"author_link\":\"" + attachment.getAuthor_link() + "\",\"author_icon\":\"" + attachment.getAuthor_icon() + "\",\"title\":\"" + attachment.getTitle() + "\",\"title_link\":\"" + attachment.getTitle_link() + "\",\"text\":\"" + attachment.getText() + "\",\"fields\":[{\"title\":\"Priority\",\"value\":\"High\",\"short\":false}],\"image_url\":\"" + attachment.getImageUrl() + "\",\"thumb_url\":\"" + attachment.getThumb_url() + "\",\"footer\":\"" + attachment.getFooter() + "\",\"footer_icon\":\"" + attachment.getFooter_icon() + "\",\"ts\":" + currentTs() + "}]");
            }else{

                stringBuilder.append("{\"color\":%20\"%23" + attachment.getColor() + "\",%20\"pretext\":\"" + attachment.getPretext() + "\",\"author_name\":\"" + attachment.getAuthor_name() + "\",\"author_link\":\"" + attachment.getAuthor_link() + "\",\"author_icon\":\"" + attachment.getAuthor_icon() + "\",\"title\":\"" + attachment.getTitle() + "\",\"title_link\":\"" + attachment.getTitle_link() + "\",\"text\":\"" + attachment.getText() + "\",\"fields\":[{\"title\":\"Priority\",\"value\":\"High\",\"short\":false}],\"image_url\":\"" + attachment.getImageUrl() + "\",\"thumb_url\":\"" + attachment.getThumb_url() + "\",\"footer\":\"" + attachment.getFooter() + "\",\"footer_icon\":\"" + attachment.getFooter_icon() + "\",\"ts\":" + currentTs() + "},");
            }
        }

        URL sendMessageUrl = HTTPS.stringToURL(BASE_URL + ENDPOINT_POST_MESSAGE + "?token=" + API_KEY + "&channel=" + BOTS_CHANNEL_ID + ENDPOINT_URL_IMAGE + "&text=" + messageText + "&attachments=" + stringBuilder.toString());
        return new SendMessageResponse(HTTPS.get(sendMessageUrl));

    }

    //Second new feature
    public static SendMessageResponse sendMessageWithButtons() {
        URL sendMessageUrl = HTTPS.stringToURL(BASE_URL + ENDPOINT_POST_MESSAGE + "?token=" + API_KEY + "&channel=" + BOTS_CHANNEL_ID + ENDPOINT_URL_IMAGE + "&text=sup%20homie?" + "&attachments=" + "[{\"text\":\"Choose%20a%20game%20to%20play\",\"fallback\":\"You%20are%20unable%20to%20choose%20a%20game\",\"callback_id\":\"wopr_game\",\"color\":\"%233AA3E3\",\"attachment_type\":\"default\",\"actions\":[{\"name\":\"chess\",\"text\":\"Chess\",\"type\":\"button\",\"value\":\"chess\"},{\"name\":\"maze\",\"text\":\"Falken's%20Maze\",\"type\":\"button\",\"value\":\"maze\"},{\"name\":\"war\",\"text\":\"Thermonuclear%20War\",\"style\":\"danger\",\"type\":\"button\",\"value\":\"war\",\"confirm\":{\"title\":\"Would%20you%20like%20to%20click%20a%20button?\",\"text\":\"Click%20one%20of%20a%20good%20game%20of%20chess?\",\"ok_text\":\"Yes\",\"dismiss_text\":\"No\"}}]}]");
        return new SendMessageResponse(HTTPS.get(sendMessageUrl));
    }


    /**
     * Static method to delete an existing message from the #bots channel.
     *
     * @param  messageTs the message timestamp.
     * @return the DeleteMessageResponse indicating ok/error or null if the connection failed.
     */
    public static DeleteMessageResponse deleteMessage(String messageTs) {
        URL deleteMessageUrl = HTTPS.stringToURL(BASE_URL + ENDPOINT_DELETE_MESSAGE + "?token=" + API_KEY + "&channel=" + BOTS_CHANNEL_ID + "&ts=" + messageTs);

        return new DeleteMessageResponse(HTTPS.get(deleteMessageUrl));
    }

    public static String currentTs() {
        Long timestamp = System.currentTimeMillis() / 1000L;
        return timestamp.toString();
    }
}
