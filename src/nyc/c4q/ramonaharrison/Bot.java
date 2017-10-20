package nyc.c4q.ramonaharrison;

import nyc.c4q.ramonaharrison.model.Channel;
import nyc.c4q.ramonaharrison.model.Message;
import nyc.c4q.ramonaharrison.network.*;
import nyc.c4q.ramonaharrison.network.response.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Ramona Harrison
 * on 8/26/16
 *
 */

public class Bot {
    // TODO: implement your bot logic!

    ArrayList<String> inspirationQuotes = new ArrayList<>();

    public Bot() {

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

        Bot myBot = new Bot();

        if (listMessagesResponse.isOk()) {
            List<Message> messages = listMessagesResponse.getMessages();

            System.out.println("\nMessages: ");
            for (Message message : messages) {
                System.out.println();
                System.out.println("Timestamp: " + message.getTs());
                System.out.println("Message: " + message.getText());

                String saySomething = message.getText();

                if(saySomething.contains("candy")) {
                    myBot.sendMessageToBotsChannel(randomTip());

                }


            }
        } else {
            System.err.print("Error listing messages: " + listMessagesResponse.getError());
        }
    }

    public void respondGreeting(String channelId) {
        ListMessagesResponse listMessagesResponse = Slack.listMessages(channelId);

        if (listMessagesResponse.isOk()) {
            List<Message> messages = listMessagesResponse.getMessages();

            Bot myBot = new Bot();

            for (Message message : messages) {

                String saySomething = message.getText();

                if (saySomething.contains("@U7JJ7B7K4") || saySomething.contains("candy")) {
//                    myBot.sendMessageToBotsChannel("Hello");
                    System.out.println(randomTip());

                }
            }
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

<<<<<<< HEAD
    public String randomTip () {

        inspirationQuotes.add("cvbncn");
        inspirationQuotes.add("pwertiowert");
        inspirationQuotes.add("09645094609");
=======
    public String randomQuote() {
        inspirationQuotes.add("If you have the opportunity to play this game of life \n " +
                                "you need to appreciate every moment. \n" +
                                "A lot of people don't appreciate the moment until it's passed.\n" +
                                        "-Kanye West");
        inspirationQuotes.add("Do not dwell in the past, do not dream of the future.\n" +
                                "Concentrate the mind on the present moment\n" +
                                    "-Buddha");
        inspirationQuotes.add("Try to be a rainbow in someone's cloud\n -Maya Angelou");
        inspirationQuotes.add("Sometimes when you innovate, you make mistakes.\n" +
                                "It is best to admit them quickly, and get on with improving your other innovations\n" +
                                    "-Steve Jobs");
        inspirationQuotes.add("People say nothing is impossible, but I do nothing everyday.\n" +
                                    "-A.A. Milne");
        inspirationQuotes.add("A diamond is merely a lump of coal that did well under pressure\n" +
                                "-Unknown");
        inspirationQuotes.add("No one can make you feel inferior without your consent\n" +
                                "-Eleanor Roosevelt");
        inspirationQuotes.add("Believe you can and you're halfway there\n" +
                                "-T. Roosevelt");
        inspirationQuotes.add("Don't sweat the petty things and don't pet the sweaty things.\n" +
                                "-George Carlin");
        inspirationQuotes.add("There isn't a way things should be. There's just what happens and what we do.\n" +
                                "-Terry Pratchett");
        inspirationQuotes.add("More fuck yeah, less fuck that.\n" +
                                "-Unknown");
        inspirationQuotes.add("Turn your wounds into wisdom\n" +
                                "-Oprah");
        inspirationQuotes.add("Hope is a waking dream\n" +
                                "-Aristotle");
        inspirationQuotes.add("Life is trying things to see if they work\n" +
                                "-Ray Bradbury");
        inspirationQuotes.add("The obstacle is the path\n" +
                                "-Unknown");
        inspirationQuotes.add("We become what we think about\n" +
                                "-Earl Nightingale");
        inspirationQuotes.add("It does not matter how slowly you go as long as you do not stop\n" +
                                "-Confucius");
        inspirationQuotes.add("A jug fills drop by drop\n" +
                                "-Buddha");
        inspirationQuotes.add("Don't regret the past, just learn from it\n" +
                                "-Ben Ipock");
        inspirationQuotes.add("Action is the foundational key to all success\n" +
                                "-Pablo Picasso");
        inspirationQuotes.add("Whatever you are, be a good one\n" +
                                "-Abraham Lincoln");

>>>>>>> cda13a2bd21a0090789c6efe97ba06dfc7e55298

        Random r= new Random();


        String quote= inspirationQuotes.get(r.nextInt(inspirationQuotes.size()));
        return quote;
    }


}
