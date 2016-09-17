package nyc.c4q.ramonaharrison;

import nyc.c4q.ramonaharrison.model.Channel;
import nyc.c4q.ramonaharrison.model.Message;
import nyc.c4q.ramonaharrison.model.User;
import nyc.c4q.ramonaharrison.network.*;
import nyc.c4q.ramonaharrison.network.response.*;
import nyc.c4q.ramonaharrison.cleverbot.*;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Ramona Harrison
 * on 8/26/16
 *
 */

public class Bot {
    // TODO: implement your bot logic!
    public double startTimeStamp;
    /*public List<String> greetingslog = new ArrayList<String>();
    public List<String> commandsLog = new ArrayList<String>();
    public List<String> cleverbotLog = new ArrayList<>();
    public List<String> recipesLog = new ArrayList<>();
    public List<String> foodItemLog = new ArrayList<>();*/

    public List<String> log = new ArrayList<>();

    public Bot() {
        getLatestTimeStamp();
       // sendMessageToBotsChannel("Hi <!everyone>, don't eat me please!\nYou can talk to me by typing cookiebot -your text-");
        //1.CREATE INSTANCE OF CLEVERBOT
        //Cleverbot.createInstance(); //instance already created
    }

    public void getLatestTimeStamp() {
        ListMessagesResponse listMessagesResponse = Slack.listMessages(Slack.PRIVATE_CHANNEL_ID);
        List<Message> messages = listMessagesResponse.getMessages();
        startTimeStamp = Double.parseDouble(messages.get(0).getTs());
    }

    public void start() {
        ListMessagesResponse listMessagesResponse = Slack.listMessages(Slack.PRIVATE_CHANNEL_ID); //get list of Message object
        List<Message> messages = listMessagesResponse.getMessages();                              //return list to messages

        goThroughTheseStatements(messages);
    }

    public void goThroughTheseStatements(List<Message> messages) {
        for (Message message : messages) {
            //if the text matches and timestamp is > the latest timestamp and the message isn't from a bot
            if (doesMessageContain("cookiebot", message)
                    && Double.parseDouble(message.getTs()) >  startTimeStamp
                    && message.getUser() != null) {

                String savedLog = message.getTs() + message.getUser() + message.getText();

                if (!log.contains(savedLog)) {

                    if (doesMessageContain("cookiebot die", message)) {
                        checkStopMessage(message);
                        break;
                    } else if (doesMessageContain("cookiebot hi", message) || doesMessageContain("cookiebot hello", message)) {
                        checkGreetings(message, savedLog);
                    } else if (doesMessageContain("cookiebot recipes", message)) {
                        checkRecipes(message, savedLog);
                    } else if (doesMessageContain("cookiebot commands", message)) {
                        checkCommands(message, savedLog);
                    } else if (doesMessageContain("cookiebot pic", message)) {
                            checkPics(message, savedLog);
                    } else {
                        convoWithCleverbot(message, savedLog);
                    }
                }
            }
        }
    }

    //TERMINATE BOT
    public void checkStopMessage(Message message) {
        sendMessageToBotsChannel("cookiebot eating itself away...");
        Main.loopBot = false;
    }

    //CHECK GREETINGS
    public void checkGreetings(Message message, String savedLog) {
        sendMessageToBotsChannel("Hello <@" + message.getUser() + ">. Take a :cookie:.");
        log.add(savedLog);

    }

    //LIST OF COMMANDS
    public void checkCommands(Message message, String savedLog) {                                                            //if log doesn't contain message then
        sendMessageToBotsChannel("cookie commands:\ncookiebot recipes\ncookiebot pic\n...");
        log.add(savedLog);

    }

    //CONVERSE WITH CLEVERBOT
    public void convoWithCleverbot(Message message, String savedLog) {
        //get text after cookiebot "____", then send that text over to Cleverbot class to get a response from Cleverbot
        sendMessageToBotsChannel(Cleverbot.sendMessage(getTextAfterCookiebot(message)));
        log.add(savedLog);

    }

    //RECIPES
    public void checkRecipes(Message message, String savedLog) {
        boolean waitingForRequest = true;
        sendMessageToBotsChannel("What do you want to make?");
        log.add(savedLog);
        while (waitingForRequest) {
            waitingForRequest = requestingRecipe(message);
        }
    }

    public boolean requestingRecipe(Message messageFromRequestingUser) {
        ListMessagesResponse listMessagesResponse = Slack.listMessages(Slack.PRIVATE_CHANNEL_ID);
        List<Message> messages = listMessagesResponse.getMessages();

        for (Message message : messages) {
            if (doesMessageContain("cookiebot", message)
                    && message.getUser() != null
                    && message.getUser().equals(messageFromRequestingUser.getUser()) //if message is from this user
                    && Double.parseDouble(message.getTs()) > Double.parseDouble(messageFromRequestingUser.getTs())) { //if message timestamp is > this users timestamp when he called cookiebot recipes

                String savedLog = message.getTs() + message.getUser() + message.getText();

                if (!log.contains(savedLog)) {

                    String messageText = getTextAfterCookiebot(message);
                    try {
                        messageText = URLEncoder.encode(messageText, "UTF-8");
                    } catch (UnsupportedEncodingException e) {
                        throw new RuntimeException(e);
                    }

                    sendMessageToBotsChannel("<@" + message.getUser() + "> http://www.google.com/search?q=recipes+" + messageText + "&btnI&unfurl_links=true");
                    log.add(savedLog);
                    return false;
                }
            }
            else if (doesMessageContain("cookiebot", message)
                    && message.getUser() != null
                    && !message.getUser().equals(messageFromRequestingUser.getUser()) //if message is not from this user
                    && Double.parseDouble(message.getTs()) > Double.parseDouble(messageFromRequestingUser.getTs())) {

                String savedLog = message.getTs() + message.getUser() + message.getText();
                if (!log.contains(savedLog)) {
                    sendMessageToBotsChannel("<@" + message.getUser() + ">. SHUT UP HUMAN, wait... until I take care of this other human's request first <@" + messageFromRequestingUser.getUser() + ">.");
                    log.add(savedLog);
                }
            }
        }
        return true;
    }

    public void checkPics(Message message, String savedLog) {
        sendMessageToBotsChannel("Picture of the most delicious food in the world.");
        log.add(savedLog);
    }
    //GUESS WHAT I'M GIPHYING

    //-------------- HELPER METHODS BELOW ---------------
    //USING REGEX TO MATCH TEXT AFTER cookiebot "____"
    public String getTextAfterCookiebot(Message message) {
        String result = "";
        String regex = "((?<=cookiebot ).*)";
        Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher r = p.matcher(message.getText());
        if(r.find())
            result = result + r.group(0);
        return result;
    }

    //USING REGEX TO MATCH TEXT
    public boolean doesMessageContain(String str, Message message) {

        boolean found = false;
        String regex = "(" + str +")";
        Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher r = p.matcher(message.getText());

        if(r.find())
            found = true;

        return found;
    }

    //get user name from message
    public String getUserNameFromMessage(String userId) {
        String result = null;
        ListUsersResponse listUsersResponse = Slack.listUsers(Slack.PRIVATE_CHANNEL_ID);
        List<User> users = listUsersResponse.getUsers();

        for (User user : users) {
            if (userId.equals(user.getId())) {
                result = user.getName();
            }
        }
        return result;
    }

    public void listUsers(String channelId) {
        ListUsersResponse listUsersResponse = Slack.listUsers(channelId);

        if (listUsersResponse.isOk()) {
            List<User> users = listUsersResponse.getUsers();

            System.out.println("\nUsers: ");
            for (User user : users) {
                System.out.println();
                System.out.println("ID: " + user.getId());
                System.out.println("Name: " + user.getName());
            }
        } else {
            System.err.print("Error listing users: " + listUsersResponse.getError());
        }
    }

    /**
     * Sample method: tests the Slack API. Prints a message indicating success or failure.
     */
    public void testApi() {
        Response apiTest = Slack.testApi();
        System.out.println("API OK: " +apiTest.isOk() + "\n");
    }

    /**
     * Sample method: prints all public AccessCode3-3 channel names and ids. Prints an error message on failure.
     */
    public void listChannels() {
        ListChannelsResponse listChannelsResponse = Slack.listChannels();

        if (listChannelsResponse.isOk()) {
            List<Channel> channels = listChannelsResponse.getChannels();

            System.out.println("\nChannels: ");
            for (Channel channel : channels) {
                System.out.println("name: " + channel.getName() + ", id:" + channel.getId());
            }
        } else {
            System.err.print("Error listing channels: " + listChannelsResponse.getError());
        }
    }

    /**
     * Sample method: prints up to the last 100 messages from a given channel. Prints an error message on failure.
     * or failure.
     *
     * @param channelId id of the given channel.
     */
    public void listMessages(String channelId) {
        ListMessagesResponse listMessagesResponse = Slack.listMessages(channelId);

        if (listMessagesResponse.isOk()) {
            List<Message> messages = listMessagesResponse.getMessages();

            System.out.println("\nMessages: ");
            for (Message message : messages) {
                System.out.println();
                System.out.println("Timestamp: " + message.getTs());
                System.out.println("Message: " + message.getText());
            }
        } else {
            System.err.print("Error listing messages: " + listMessagesResponse.getError());
        }
    }

    /**
     * Sample method: sends a plain text message to the #bots channel. Prints a message indicating success or failure.
     *
     * @param text message text.
     */
    public void sendMessageToBotsChannel(String text) {
        SendMessageResponse sendMessageResponse = Slack.sendMessage(text);

        if (sendMessageResponse.isOk()) {
            System.out.println("Message sent successfully!");
        } else {
            System.err.print("Error sending message: " + sendMessageResponse.getError());
        }
    }

    /**
     * Sample method: deletes a message from the #bots channel. Prints a message indicating success or failure.
     *
     * @param messageTs unique timestamp of the message to be deleted.
     */
    public void deleteMessageInBotsChannel(String messageTs) {
        DeleteMessageResponse deleteMessageResponse = Slack.deleteMessage(messageTs);

        if (deleteMessageResponse.isOk()) {
            System.out.println("Message deleted successfully!");
        } else {
            System.err.print("Error sending message: " + deleteMessageResponse.getError());
        }
    }
}
