package nyc.c4q.ramonaharrison;

import nyc.c4q.ramonaharrison.model.Channel;
import nyc.c4q.ramonaharrison.model.GiphyData;
import nyc.c4q.ramonaharrison.model.Message;

import nyc.c4q.ramonaharrison.model.User;
import nyc.c4q.ramonaharrison.network.*;
import nyc.c4q.ramonaharrison.network.response.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;

public class Bot {

    Slack myBot;
    public Bot() {

    }

    public void addReaction() {
        Response reaction = Slack.addReaction();
        System.out.println(reaction);
    }

//   public void userInfo() {
//        UserInfoResponse user = Slack.userInfo("U23CZAXQS");
//        System.out.println(user);
//    }

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
                System.out.println("User: " + message.getUser());
            }
        } else {
            System.err.print("Error listing messages: " + listMessagesResponse.getError());
        }
    }

    public void respondGreeting(String channelId) {
        ListMessagesResponse listMessagesResponse = Slack.listMessages(channelId);

        if (listMessagesResponse.isOk()) {

                List<Message> messages = listMessagesResponse.getMessages();

                myBot = new Slack();

                for (Message message : messages) {

                    String whatDidYouSay = "";
                        whatDidYouSay = message.getText();
                        if (whatDidYouSay.contains("@U2ADRJVK9") || whatDidYouSay.contains("messybot")) {
                                if (message.getUser() != null) {

                                    myBot.sendMessage("Hello " + message.getUser().toString());
                                }
                                myBot.sendMessage("I am messybot");
                                myBot.sendMessage(":poop::poop::poop:");
                                myBot.sendMessage("You asked for " + whatDidYouSay);
                            }
                        }
            }else {
            System.err.print("Error listing messages: " + listMessagesResponse.getError());
        }
    }

    public void respondAll(String channelId) {
        ListMessagesResponse listMessagesResponse = Slack.listMessages(channelId);

        if (listMessagesResponse.isOk()) {
            List<Message> messages = listMessagesResponse.getMessages();

            Slack myBot = new Slack();
            UrbanDictionary urbanDictionary = new UrbanDictionary();
            Memes memes = new Memes();
            Giphy giphy = new Giphy();

            for (Message message : messages) {

                String word = message.getText();

//                while (word != null) {

                    URL slangSearch = urbanDictionary.wordSearch();
                    slangSearch.toString();

                    URL memeSearch = memes.memeSearch();
                    memeSearch.toString();

                    String giphySearch = giphy.giphySearch();

                    myBot.sendMessage(slangSearch.toString());
                    Slack.addReaction();
                    myBot.sendMessage(memeSearch.toString());
                    Slack.addReaction();
                    myBot.sendMessage(giphySearch);
                    Slack.addReaction();
//                    }

            }
        } else {
            System.err.print("Error listing messages: " + listMessagesResponse.getError());
        }
    }

    public void respondDictionary(String channelId) {
        ListMessagesResponse listMessagesResponse = Slack.listMessages(channelId);

        if (listMessagesResponse.isOk()) {
            List<Message> messages = listMessagesResponse.getMessages();

            Slack myBot = new Slack();
            UrbanDictionary urbanDictionary = new UrbanDictionary();

            for (Message message : messages) {
                String user = message.getUser();
                String word = messages.get(0).getText();

                String[] parts =  word.split(" ");
                    String part1 = parts[0]; // @messybot
                    String part2 = parts[1]; // query word
                System.out.println(part2);

                StringBuilder builder = new StringBuilder();
                builder.append(part2);

                if (builder.indexOf("Give me a word") == -1) {
                    URL slangSearch = urbanDictionary.wordSearch();
                    slangSearch.toString();

                    myBot.sendMessage(slangSearch.toString());
                }
            }
        } else {
            System.err.print("Error listing messages: " + listMessagesResponse.getError());
        }
    }

    public void respondMeme(String channelId) {
        ListMessagesResponse listMessagesResponse = Slack.listMessages(channelId);

        if (listMessagesResponse.isOk()) {
            List<Message> messages = listMessagesResponse.getMessages();

            Slack myBot = new Slack();
            Memes memes = new Memes();

            for (Message message : messages) {

                String aMeme = message.getText();
                if (aMeme == aMeme) {
                    URL memeSearch = memes.memeSearch();
                    memeSearch.toString();
                    myBot.sendMessage(memeSearch.toString());
                }
            }
        } else {
            System.err.print("Error listing messages: " + listMessagesResponse.getError());
        }
    }

    public void respondGiphy(String channelId) {
        ListMessagesResponse listMessagesResponse = Slack.listMessages(channelId);

        if (listMessagesResponse.isOk()) {
            List<Message> messages = listMessagesResponse.getMessages();

            Slack myBot = new Slack();
            Giphy giphy = new Giphy();

            for (Message message : messages) {
                String aGiphy = message.getText();

                if (aGiphy == aGiphy) {
                    String giphySearch = giphy.giphySearch();
                    myBot.sendMessage(giphySearch.toString());
                }
            }

        } else {
            System.err.print("Error listing messages: " + listMessagesResponse.getError());
        }
    }
            /**
             * Sample method: tests the Slack API. Prints a message indicating success or failure.
             */
        public void testApi () {
            Response apiTest = Slack.testApi();
            System.out.println("API OK: " + apiTest.isOk() + "\n");
        }

        /**
         * Sample method: prints all public AccessCode3-3 channel names and ids. Prints an error message on failure.
         */
        public void listChannels () {
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
         * Sample method: sends a plain text message to the #bots channel. Prints a message indicating success or failure.
         *
         * @param text message text.
         */
        public void sendMessageToBotsChannel (String text){
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
        public void deleteMessageInBotsChannel (String messageTs){
            DeleteMessageResponse deleteMessageResponse = Slack.deleteMessage(messageTs);

            if (deleteMessageResponse.isOk()) {
                System.out.println("Message deleted successfully!");
            } else {
                System.err.print("Error sending message: " + deleteMessageResponse.getError());
            }
        }

        public void searchMessages (String channelId, String query){
            SearchMessagesResponse querySearch = Slack.searchMessages(channelId, query);

            if (querySearch.isOk()) {
                List<Message> messages = querySearch.getMessages();
                System.out.println("You searched for: " + querySearch);

                for (Message queryWord : messages) {
                    System.out.println();
                    System.out.println("Timestamp: " + queryWord.getTs());
                    System.out.println("Message: " + queryWord.getText());
                    System.out.println("User: " + queryWord.getUser());
                }
            } else {
                System.err.print("Error listing messages: " + querySearch.getError());
            }
        }
    }
