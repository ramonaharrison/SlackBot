package nyc.c4q.ramonaharrison;

import nyc.c4q.ramonaharrison.model.Channel;
import nyc.c4q.ramonaharrison.model.Message;
import nyc.c4q.ramonaharrison.model.User;
import nyc.c4q.ramonaharrison.network.*;
import nyc.c4q.ramonaharrison.network.response.*;
import nyc.c4q.ramonaharrison.util.Words;

import java.util.*;

/**
 * Created by Ramona Harrison
 * on 8/26/16
 *
 */

public class Bot {
    // TODO: implement your bot logic!


    Words words = new Words();
    public Bot() {}




    public void pleaseBotv2(){
        while (true){
            ListMessagesResponse listMessagesResponse = Slack.listMessages(Slack.BOTS_CHANNEL_ID);
            if (listMessagesResponse.isOk()) {
                Bot bot = new Bot();
                List<Message> messages = listMessagesResponse.getMessages();
                String originalMessage = messages.get(0).getText();
                if(originalMessage.toLowerCase().contains("please")){
                    bot.sendMessageToBotsChannel("Someone said please. Here's a cat gif");
                    bot.sendMessageToBotsChannel(AnimalGifs.catPics());
                }


            }
            else{  System.err.print("Error listing messages: " + listMessagesResponse.getError());
                break;

            }


        }

    }




    public void pleaseBotv4(){
        int count = 0;
        while (true){
            ListMessagesResponse listMessagesResponse = Slack.listMessages(Slack.BOTSTEST_CHANNEL_ID);
            if (listMessagesResponse.isOk()) {
                Bot bot = new Bot();
                List<Message> messages = listMessagesResponse.getMessages();
                String originalMessage = messages.get(0).getText();
                if(count <= 3 && originalMessage.toLowerCase().contains("please")){
                    bot.sendMessageToBotsChannel("Someone said please. Here's a cat gif");
                    bot.sendMessageToBotsChannel(AnimalGifs.catPics());
                    count++;
                }
                if(count >= 4 && count <= 6 && originalMessage.toLowerCase().contains("please")){
                    bot.sendMessageToBotsChannel("That's enough cats. Here's a dog gif");
                    bot.sendMessageToBotsChannel(AnimalGifs.dogPics());
                    count++;
                }
                if(count > 6){
                    count = 0;
                }




            }
            else{  System.err.print("Error listing messages: " + listMessagesResponse.getError());
                break;

            }


        }

    }



    public void pleaseBotv3() {
        int count = 0;
        while (true) {
            ListMessagesResponse listMessagesResponse = Slack.listMessages(Slack.BOTSTEST_CHANNEL_ID);
            if (listMessagesResponse.isOk()) {
                Bot bot = new Bot();
                List<Message> messages = listMessagesResponse.getMessages();
                String originalMessage = messages.get(0).getText();
                while (count <= 5) {
                    if (originalMessage.toLowerCase().contains("please")) {
                        bot.sendMessageToBotsChannel("Someone said the magic word. Here's a cat gif");
                        bot.sendMessageToBotsChannel(AnimalGifs.catPics());
                        count++;
                        break;
                    }
                    else{
                        break;
                    }
                }
                while (count == 6) {
                    if (originalMessage.toLowerCase().contains("please")) {
                        bot.sendMessageToBotsChannel("That's enough Cats. Here's a dog gif instead");
                        bot.sendMessageToBotsChannel(AnimalGifs.dogPics());
                        count++;
                        break;
                    }
                    else{
                        break;
                    }
                }
                while (count >= 7 && count <= 10) {
                    if (originalMessage.toLowerCase().contains("please")) {
                        bot.sendMessageToBotsChannel("Someone said the magic word. Here's a dog gif");
                        bot.sendMessageToBotsChannel(AnimalGifs.dogPics());
                        count++;
                        break;
                    }
                    else{
                        break;
                    }

                }
                while (count == 11) {
                    if (originalMessage.toLowerCase().contains("please")) {
                        bot.sendMessageToBotsChannel("That's enough dogs. Here's a cat gif instead");
                        bot.sendMessageToBotsChannel(AnimalGifs.catPics());
                        count = 1;
                        break;
                    }
                    else{
                        break;
                    }

                }

            }


            else{
                    System.err.print("Error listing messages: " + listMessagesResponse.getError());
                    break;

                }


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

    public void listUsers(String channelId) {
        ListUsers listUsers = Slack.listUsers(channelId);

        if (listUsers.isOk()) {
            List<User> users = listUsers.getUser();

            System.out.println("\nUsers: ");
            for (User user : users) {
                System.out.println();

                System.out.println("User: " + user.getName());
            }
        } else {
            System.err.print("Error listing messages: " + listUsers.getError());
        }
    }
}
