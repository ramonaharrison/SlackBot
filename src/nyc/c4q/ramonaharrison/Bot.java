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

    public List<String> log = new ArrayList<>();

    public Bot() {
        getLatestTimeStamp();
        sendMessageToBotsChannel("Hi <!everyone>, don't eat me please!\nYou can talk to me by typing cookiebot -your text-");
        //1.CREATE INSTANCE OF CLEVERBOT //only allowed 1000 calls to cleverbot api per day
        //Cleverbot.createInstance(); //instance already created
    }

    public void getLatestTimeStamp() {
        ListMessagesResponse listMessagesResponse = Slack.listMessages(Slack.BOTS_CHANNEL_ID);
        List<Message> messages = listMessagesResponse.getMessages();
        startTimeStamp = Double.parseDouble(messages.get(0).getTs());
    }

    public void start() {
        ListMessagesResponse listMessagesResponse = Slack.listMessages(Slack.BOTS_CHANNEL_ID); //get list of Message object
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
                        checkStopMessage(message, savedLog);
                        break;
                    } else if (doesMessageContain("cookiebot hi", message) || doesMessageContain("cookiebot hello", message)) {
                        checkGreetings(message, savedLog);
                    } else if (doesMessageContain("cookiebot recipes", message)) {
                        checkRecipes(message, savedLog);
                    } else if (doesMessageContain("cookiebot commands", message)) {
                        checkCommands(message, savedLog);
                    } else if (doesMessageContain("cookiebot pic", message)) {
                        checkPics(message, savedLog);
                    } else if (doesMessageContain("cookiebot random", message)) {
                        randomResponse(message, savedLog);
                    }else if (doesMessageContain("cookie monster", message)){
                        checkMonster(message, savedLog);
                    } else {
                        convoWithCleverbot(message, savedLog);
                    }
                }
            }
        }
    }

    //TERMINATE BOTmessage.getUser().equals("U239PRECU")
    public void checkStopMessage(Message message, String savedLog) {
        if (message.getUser().equals("U23A4LK4M")
                || message.getUser().equals("U239PRECU")
                || message.getUser().equals("U23AETT50")
                || message.getUser().equals("U238CFFLK")) {
            sendMessageToBotsChannel("cookiebot eating itself away...");
            Main.loopBot = false;
        }
        else {
            sendMessageToBotsChannel("no");
            log.add(savedLog);
        }
    }

    //CHECK GREETINGS
    public void checkGreetings(Message message, String savedLog) {
        sendMessageToBotsChannel("Hello <@" + message.getUser() + ">. Take a :cookie:.");
        log.add(savedLog);

    }

    //LIST OF COMMANDS
    public void checkCommands(Message message, String savedLog) {                                                            //if log doesn't contain message then
        sendMessageToBotsChannel("cookie commands:\ncookiebot recipes\ncookiebot random\ncookiebot pic\ncookiebot cookie monster\n...");
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
        ListMessagesResponse listMessagesResponse = Slack.listMessages(Slack.BOTS_CHANNEL_ID);
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
        sendMessageToBotsChannel("<http://i.imgur.com/AJuCnm2.jpg|Most delicious food in the world.>");
        log.add(savedLog);
    }

    public void randomResponse(Message message, String savedLog) {
            int random = (int) (Math.random() * 22 + 1); //1-22
            String sassyResponse;


            switch (random) {
                case 1:
                    sassyResponse = "Ain't nobody got time for that... cookie roll away.";
                    break;
                case 2:
                    sassyResponse = "We cookies are a proud race.";
                    break;
                case 3:
                    sassyResponse = "Did you know Oreo was introduced in 1912, and sell $550 million annually.";
                    break;
                case 4:
                    sassyResponse = "The first fortune cookie was made in America.";
                    break;
                case 5:
                    sassyResponse = "Cookies have feelings too!";
                    break;
                case 6:
                    sassyResponse = "December 4th is National Cookie Day, respect.";
                    break;
                case 7:
                    sassyResponse = "Americans run on cookies.";
                    break;
                case 8:
                    sassyResponse = "Retired cookie cutters reside in the National Cookie Cutter Historial Museum.";
                    break;
                case 9:
                    sassyResponse = "Animal crackers were introduced as edible ornaments";
                    break;
                case 10:
                    sassyResponse = "I want to be the very best like no one ever was.";
                    break;
                case 11:
                    sassyResponse = "Betty Crocker is not a real person.";
                    break;
                case 12:
                    sassyResponse = "No one really knows why an Oreo is called an Oreo.";
                    break;
                case 13:
                    sassyResponse = "I have been busy contributing to Project Skynet... I mean here take this :cookie:";
                    break;
                case 14:
                    sassyResponse = "Eat brownies not cookies.";
                    break;
                case 15:
                    sassyResponse = "We come in all shapes and sizes, but the original size is bite-sized.";
                    break;
                case 16:
                    sassyResponse = "The best sandwich is a ice cream cookie sandwich.";
                    break;
                case 17:
                    sassyResponse = "Why did the cookie go to the hospital? Because it felt crummy";
                    break;
                case 18:
                    sassyResponse = "The tallest tower of cookies measured 6 ft 1/8 inches tall built by Girl Scouts in " +
                            "Roosevelt Field Mall, NY. 22,800 cookies were used to build the tower. ";
                    break;
                case 19:
                    sassyResponse = "And that is how the cookie crumbles.";
                    break;
                case 20:
                    sassyResponse = "Little Debbie is not little anymore but she was 4 when they named the brand after her.";
                    break;
                case 21:
                    sassyResponse = "Unagi Pie, a specialty of Hamamatsu, Japan, are cookies made with fresh butter, crushed " +
                            "eel bones, eel extract, and garlic.";
                    break;
                case 22:
                    sassyResponse = "The world record for the most cookies baked in one hour: 4,695.";
                    break;

                default: sassyResponse = "Give a cookiebot command and ye shall receive";
                    break;
            }
            sendMessageToBotsChannel(sassyResponse);

            log.add(savedLog);

    }

    public void checkMonster(Message message, String savedLog){
        sendMessageToBotsChannel("The one who must not be named is here, HIDE!!!");
        log.add(savedLog);

    }

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
