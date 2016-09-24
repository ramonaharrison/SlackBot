package nyc.c4q.ramonaharrison.network;

import nyc.c4q.ramonaharrison.model.Attachment;
import nyc.c4q.ramonaharrison.model.Message;
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
 * <p>
 * A class for interacting with Slack's Web API.
 */

public class Slack {

    public static final String BOTS_CHANNEL_ID = "C2ERNHJ5D";
    private static final String API_KEY = Token.findApiToken();
    private static final String BASE_URL = "https://slack.com/api/";
    private static final String ENDPOINT_TEST = "api.test";
    private static final String ENDPOINT_LIST_CHANNELS = "channels.list";
    private static final String ENDPOINT_LIST_MESSAGES = "channels.history";
    private static final String ENDPOINT_POST_MESSAGE = "chat.postMessage";
    private static final String ENDPOINT_SEARCH_MESSAGE = "search.messages";
    private static final String ENDPOINT_DELETE_MESSAGE = "chat.delete";
    private static final String USERS_INFO = "users.info";
    private static final String UNFURL_LINK = "true";
    private static final String UNFURL_MEDIA = "true";
    private static final String USERNAME = "messybot";
    private static final String AS_USER = "false";
    private static final String IMAGE_URL = "https%3A%2F%2Fmedia.giphy.com%2Fmedia%2F3osxYpRxjzvPOtwfF6%2Fgiphy.gif";

    public static String getUSERNAME() {
        return USERNAME;
    }

    /**
     * Static method to test the Slack API.
     *
     * @return the Response indicating ok/error or null if the connection failed.
     */
    public static Response testApi() {
        URL testUrl = HTTPS.stringToURL(BASE_URL + ENDPOINT_TEST + "?token=" + API_KEY);

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
     * @param channelId the id of the channel from which to list messages.
     * @return the ListMessagesResponse indicating ok/error or null if the connection failed.
     */
    public static ListMessagesResponse listMessages(String channelId) {

        URL listMessagesUrl = HTTPS.stringToURL(BASE_URL + ENDPOINT_LIST_MESSAGES + "?token=" + API_KEY + "&channel=" + channelId);

        return new ListMessagesResponse(HTTPS.get(listMessagesUrl));
    }

    /**
     * Static method to send a message to the #bots channel.
     *
     * @param messageText the message text.
     * @return the SendMessageResponse indicating ok/error or null if the connection failed.
     */
    public static SendMessageResponse sendMessage(String messageText) {

        try {
            messageText = URLEncoder.encode(messageText, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }

        URL sendMessageUrl = HTTPS.stringToURL(BASE_URL + ENDPOINT_POST_MESSAGE + "?token=" + API_KEY + "&channel=" + BOTS_CHANNEL_ID + "&text=" + messageText + "&unfurl_links=" + UNFURL_LINK + "&unfurl_media=" + UNFURL_MEDIA + "&username=" + USERNAME + "&as_user=" + AS_USER + "&icon_url=" + IMAGE_URL + "&pretty=1");

        return new SendMessageResponse(HTTPS.get(sendMessageUrl));
    }

    /**
     * Static method to send a message with one or more attachments to the #bots channel.
     *
     * @param messageText the message text.
     * @param attachments a list of one of more attachments to be parsed to a JSON-encoded URL string parameter.
     * @return the SendMessageResponse indicating ok/error or null if the connection failed.
     */
    public static SendMessageResponse sendMessageWithAttachments(String messageText, List<Attachment> attachments) {

        // TODO (optional): implement this method! See https://api.slack.com/docs/message-attachments
        throw new RuntimeException("Method not implemented!");

//        https://slack.com/api/chat.postMessage?token=xoxp-71191384642-71441371842-79184766036-f9ac6a4d4f&channel=C2ADPS5MK&text=What%20would%20you%20like%20%40messybot%20to%20look%20up%3F&attachments=%5B%20%20%20%20%20%20%20%20%20%7B%20%09%09%09%22text%22%3A%20%22%3Apoop%3A%22%2C%20%20%20%20%20%20%20%20%20%20%20%20%20%22fallback%22%3A%20%22That%20is%20not%20a%20word%22%2C%20%20%20%20%20%20%20%20%20%20%20%20%20%22callback_id%22%3A%20%22messybot%22%2C%20%20%20%20%20%20%20%20%20%20%20%20%20%22color%22%3A%20%22%233AA3E3%22%2C%20%20%20%20%20%20%20%20%20%20%20%20%20%22attachment_type%22%3A%20%22default%22%2C%20%20%20%20%20%20%20%20%20%20%20%20%20%22actions%22%3A%20%5B%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%7B%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%22name%22%3A%20%22Urban%20Dictionary%22%2C%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%22text%22%3A%20%22Urban%20Dictionary%22%2C%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%22type%22%3A%20%22button%22%2C%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%22value%22%3A%20%22Urban%20Dictionary%22%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%7D%2C%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%7B%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%22name%22%3A%20%22Meme%22%2C%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%22text%22%3A%20%22Meme%22%2C%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%22type%22%3A%20%22button%22%2C%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%22value%22%3A%20%22Meme%22%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%7D%2C%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%7B%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%22name%22%3A%20%22Giphy%22%2C%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%22text%22%3A%20%22Giphy%22%2C%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%22type%22%3A%20%22button%22%2C%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%22value%22%3A%20%22Giphy%22%2C%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%22confirm%22%3A%20%7B%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%22title%22%3A%20%22Are%20you%20sure%3F%22%2C%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%22text%22%3A%20%22Let%27s%20find%20it!%22%2C%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%22ok_text%22%3A%20%22Yes%22%2C%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%22dismiss_text%22%3A%20%22No%22%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%7D%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%20%7D%20%20%20%20%20%20%20%20%20%20%20%20%20%5D%20%20%20%20%20%20%20%20%20%7D%20%20%20%20%20%5D%20%7D&unfurl_links=true&unfurl_media=true&username=messybot&as_user=false&icon_url=https%3A%2F%2Fmedia.giphy.com%2Fmedia%2F3osxYpRxjzvPOtwfF6%2Fgiphy.gif&pretty=1
    }

    /**
     * Static method to delete an existing message from the #bots channel.
     *
     * @param messageTs the message timestamp.
     * @return the DeleteMessageResponse indicating ok/error or null if the connection failed.
     */
    public static DeleteMessageResponse deleteMessage(String messageTs) {
        URL deleteMessageUrl = HTTPS.stringToURL(BASE_URL + ENDPOINT_DELETE_MESSAGE + "?token=" + API_KEY + "&channel=" + BOTS_CHANNEL_ID + "&ts=" + messageTs);

        return new DeleteMessageResponse(HTTPS.get(deleteMessageUrl));
    }

    public static Response addReaction() {
        String emojiName = "hankey";

        ListMessagesResponse listMessagesResponse = Slack.listMessages("C2ERNHJ5D");
        List<Message> messages = listMessagesResponse.getMessages();

        for (Message message : messages) {
            String timestamp = message.getTs();

            URL reaction = HTTPS.stringToURL(BASE_URL + "reactions.add" + "?token=" + API_KEY + "&name=" + emojiName + "&channel=" + BOTS_CHANNEL_ID + "&timestamp=" + timestamp + "&pretty=1");

            return new Response(HTTPS.get(reaction));
        }
        return addReaction();
    }

    public static String userInfo() {
        ListMessagesResponse listMessagesResponse = Slack.listMessages("C2ERNHJ5D");
        List<Message> messages = listMessagesResponse.getMessages();

        for (Message message : messages) {
            String name = message.getUser();

            URL username = HTTPS.stringToURL(BASE_URL + USERS_INFO + "?token=" + API_KEY + "&user=" + name + "&pretty=1");
            JSONObject json = HTTPS.get(username);

            if (json.containsKey("user")) {

                JSONObject myObj = (JSONObject) json.get("user");
                name = (String) myObj.get("name");
                    System.out.println(name);

                return name;
            }
        }
        return null;
    }
}


