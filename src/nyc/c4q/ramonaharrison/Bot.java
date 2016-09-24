package nyc.c4q.ramonaharrison;

import nyc.c4q.ramonaharrison.model.Channel;
import nyc.c4q.ramonaharrison.model.Message;
import nyc.c4q.ramonaharrison.network.Giphy;
import nyc.c4q.ramonaharrison.network.Memes;
import nyc.c4q.ramonaharrison.network.Slack;
import nyc.c4q.ramonaharrison.network.UrbanDictionary;
import nyc.c4q.ramonaharrison.network.response.*;
import java.net.URL;
import java.util.List;

public class Bot {

    Slack myBot;

    public Bot() {

    }

    public void addReaction() {
        Response reaction = Slack.addReaction();
        System.out.println(reaction);
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

                String whatDidYouSay = messages.get(0).getText();
                Message userMessage = messages.get(0);

                if (whatDidYouSay.contains("@U2ADRJVK9") || whatDidYouSay.contains("messybot")) {
                    if (userMessage.getUser() != null) {
                        myBot.sendMessage("Hello " + myBot.userInfo());
                    }
                    myBot.sendMessage("I am " + myBot.getUSERNAME());
                    myBot.sendMessage(":poop::poop::poop:");
                    myBot.sendMessage("You asked for " + whatDidYouSay);
                }
            } else {
                System.err.print("Error listing messages: " + listMessagesResponse.getError());
            }
    }

    public void respondAll(String channelId) {
        ListMessagesResponse listMessagesResponse = Slack.listMessages(channelId);

        if (listMessagesResponse.isOk()) {
            List<Message> messages = listMessagesResponse.getMessages();

            myBot = new Slack();
            UrbanDictionary urbanDictionary = new UrbanDictionary();
            Memes memes = new Memes();
            Giphy giphy = new Giphy();

            for (Message message : messages) {
                String word = message.getText();

                if (word.contains("give me")) {

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
                }
            }
        } else {
            System.err.print("Error listing messages: " + listMessagesResponse.getError());
        }
    }

    public void respondDictionary(String channelId) {
        ListMessagesResponse listMessagesResponse = Slack.listMessages(channelId);

        if (listMessagesResponse.isOk()) {
            List<Message> messages = listMessagesResponse.getMessages();

            myBot = new Slack();
            UrbanDictionary urbanDictionary = new UrbanDictionary();

            for (Message message : messages) {
                String word = message.getText();

                if (word.contains("ud")) {
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

            myBot = new Slack();
            Memes memes = new Memes();

            for (Message message : messages) {

                String aMeme = message.getText();
                if (aMeme.contains("meme")) {
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

            myBot = new Slack();
            Giphy giphy = new Giphy();

            for (Message message : messages) {
                String aGiphy = message.getText();

                if (aGiphy.contains("giphy")) {
                    String giphySearch = giphy.giphySearch();
                        myBot.sendMessage(giphySearch);
                }
            }
        } else {
            System.err.print("Error listing messages: " + listMessagesResponse.getError());
        }
    }

    /**
     * Sample method: tests the Slack API. Prints a message indicating success or failure.
     */
    public void testApi() {
        Response apiTest = Slack.testApi();
        System.out.println("API OK: " + apiTest.isOk() + "\n");
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
