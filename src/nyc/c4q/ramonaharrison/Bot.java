package nyc.c4q.ramonaharrison;

import nyc.c4q.ramonaharrison.model.Channel;
import nyc.c4q.ramonaharrison.model.Message;
import nyc.c4q.ramonaharrison.model.User;
import nyc.c4q.ramonaharrison.network.*;
import nyc.c4q.ramonaharrison.network.response.*;

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
    public List<String> greetingslog = new ArrayList<String>();
    public List<String> commandsLog = new ArrayList<String>();

    public Bot() {
        getLatestTimeStamp();
    }

    //Test methods
    public void getLatestTimeStamp() {
        ListMessagesResponse listMessagesResponse = Slack.listMessages(Slack.BOTS_CHANNEL_ID);
        List<Message> messages = listMessagesResponse.getMessages();
        startTimeStamp = Double.parseDouble(messages.get(0).getTs());
    }

    public void start() {
        ListMessagesResponse listMessagesResponse = Slack.listMessages(Slack.BOTS_CHANNEL_ID); //get list of messages object
        List<Message> messages = listMessagesResponse.getMessages();

        checkCommandList(messages);
        checkGreetings(messages);
        checkStopMessage(messages);

    }

    public void checkStopMessage(List<Message> messages) {
        for (Message message : messages){
            if (message.getText().equals("kill bot")) {

                if (Double.parseDouble(message.getTs()) >  startTimeStamp) {
                    sendMessageToBotsChannel("Bot terminating...");
                    Main.loopBot = false;
                    break;
                }
            }
        }
    }

    //LIST OF COMMANDS
    public void checkCommandList(List<Message> messages) {
        for (Message message : messages){
            if (doesMessageContain("\\/nomnombot commands", message)) {
                String savedLog = message.getTs() + message.getUser() + message.getText();

                if (!commandsLog.contains(savedLog) && Double.parseDouble(message.getTs()) >  startTimeStamp) {                                                                //if log doesn't contain message then
                    sendMessageToBotsChannel("I can do these following commands:\n/Command 1...\nCommand 2...\nCommand 3...");
                    commandsLog.add(savedLog);
                }
            }
        }
    }

    //CHECK GREETINGS
    public void checkGreetings(List<Message> messages) {
        for (Message message : messages){                                                                   //loop through each message
            if (doesMessageContain("hi bot", message)) {                                                       //if a message says "Hello Bot"
                String savedLog = message.getTs() + message.getUser() + message.getText();                    //create a string to store the timestamp + user + message

                if (!greetingslog.contains(savedLog) && Double.parseDouble(message.getTs()) >  startTimeStamp) {                                                                //if log doesn't contain message then
                    sendMessageToBotsChannel("Hello " + getUserNameFromMessage(message.getUser()) + ".");   //print message
                    greetingslog.add(savedLog);                                                                        //add message to log
                }
            }
        }
    }
    //FOOD RIDDLES

    //RECIPES

    //GUESS WHAT I'M GIPHYING

    public boolean doesMessageContain(String str, Message message) {

        boolean found = false;
        String regex = "(" + str +")";
        Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher r = p.matcher(message.getText());

        if(r.find())
            found = true;

        return found;
    }

    public String getUserNameFromMessage(String userId) {
        String result = null;
        ListUsersResponse listUsersResponse = Slack.listUsers(Slack.BOTS_CHANNEL_ID);
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
