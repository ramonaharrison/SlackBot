package nyc.c4q.ramonaharrison;

import nyc.c4q.ramonaharrison.model.Channel;
import nyc.c4q.ramonaharrison.model.Message;
import nyc.c4q.ramonaharrison.network.*;
import nyc.c4q.ramonaharrison.network.response.*;
import nyc.c4q.ramonaharrison.util.Images;

import java.util.List;
import java.util.Scanner;

/**
 * Created by Ramona Harrison
 * on 8/26/16
 *
 */

public class Bot {
    // TODO: implement your bot logic!
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
    public void listMessages(String channelId) {
        ListMessagesResponse listMessagesResponse = Slack.listMessages(channelId);

        if (listMessagesResponse.isOk()) {
            List<Message> messages = listMessagesResponse.getMessages();

            System.out.println("\nMessages: ");
            for (Message message : messages) {
                System.out.println();
                System.out.println("Timestamp: " + message.getTs());
                System.out.println("Message: " + message.getText());
                System.out.println("User: " +message.getUser());
            }
        } else {
            System.err.print("Error listing messages: " + listMessagesResponse.getError());
        }
    }

    public void sendMessageToBotsChannel(String text) {
        SendMessageResponse sendMessageResponse = Slack.sendMessage(text);

        if (sendMessageResponse.isOk()) {
            System.out.println("Message sent successfully!");
        } else {
            System.err.print("Error sending message: " + sendMessageResponse.getError());
        }
    }
//    public void quiz() {
//        Slack.sendMessage("Yo bot channel 'bout to be lit g! You goody?");
//
//        while (true) {
//
//
//            ListMessagesResponse listMessagesResponse = Slack.listMessages(Slack.BOTS_CHANNEL_ID);
//            List<Message> messages = listMessagesResponse.getMessages();
//            String firstResponse = messages.get(0).getText();
//            String secondResponse = null;
//            String thirdResponse = null;
//            String fourthResponse = null;
//
//            if (firstResponse.toLowerCase().contains("yes") || firstResponse.toLowerCase().contains("y")) {
//                sendMessageToBotsChannel("Aight fam, it's gonna go like this- I give you a word, you tell me what it means. You feel me? "
//                        + "Pick a, b, or c, aight? "
//                        + "\n1st question: The word is Situationship. As in \"Sounds like you in a situationship\"."
//                        + "\na)A situation   b)Playing at being in a relationship without actually being in one  c)A committed relationship");
//                ListMessagesResponse listMessagesResponse1 = Slack.listMessages(Slack.BOTS_CHANNEL_ID);
//                messages = listMessagesResponse.getMessages();
//                secondResponse = messages.get(0).getText();
//            }
//
//            else {
//                break;
//            }
//
//            if (secondResponse.equalsIgnoreCase("b")) {
//                sendMessageToBotsChannel("You got it. Next word, gucci- as in \"What's gucci?\"" +
//                        "\na)Good   b)Bad   c)A designer");
//                ListMessagesResponse listMessagesResponse2 = Slack.listMessages(Slack.BOTS_CHANNEL_ID);
//                messages = listMessagesResponse.getMessages();
//                thirdResponse = messages.get(0).getText();
//            } else {
//                break;
//            }
//            if (thirdResponse.equalsIgnoreCase("a")) {
//                sendMessageToBotsChannel("Another right answer, that's a good look. Aight how 'bout deuces?"
//                                        + "\n a)A fancy way to say the number 2   b)Another way to say peace   c)Another way to let someone know IDFWY");
//                                //answer for deuces
//                                ListMessagesResponse listMessagesResponse3 = Slack.listMessages(Slack.BOTS_CHANNEL_ID);
//                                messages = listMessagesResponse.getMessages();
//                                String fourthResponse = messages.get(0).getText();
//                                if (fourthResponse.equalsIgnoreCase("b") || fourthResponse.equalsIgnoreCase("c")) {
//                                    sendMessageToBotsChannel("I see you " + "this.getName()" + ". You obviously out in these streets, I'ma make sure I put some respek on your name.");
//                                    sendMessageToBotsChannel(Images.makeImages(4));
//                                    break;
//                                } else if (fourthResponse.equalsIgnoreCase("a")) {
//                                    sendMessageToBotsChannel("b or c son, it's up to you.");
//                                    sendMessageToBotsChannel(Images.makeImages(3));
//                                    break;
//                                }
//                            } else if (thirdResponse.equalsIgnoreCase("b") || thirdResponse.equalsIgnoreCase("c")) {
//                                sendMessageToBotsChannel("Wrong answer, that's not a good look. It was a.");
//                                sendMessageToBotsChannel(Images.makeImages(2));
//                                break;
//                            } else {
//                                sendMessageToBotsChannel("Yo, a, b or c only homie.");
//                                //played yourself gif
//                                sendMessageToBotsChannel(Images.makeImages(0));
//                                break;
//
//                            }
//                        } else if (secondResponse.equalsIgnoreCase("a") || secondResponse.equalsIgnoreCase("c")) {
//                            sendMessageToBotsChannel("Good for you, obviously you ain't neva been in one-the answer was b.");
//                            sendMessageToBotsChannel(Images.makeImages(1));
//                            break;
//                            //2nd question
//                        } else {
//                            sendMessageToBotsChannel("Yo, a, b or c only homie.");
//                            sendMessageToBotsChannel(Images.makeImages(0));
//                            break;
//                            //post this image: http://giphy.com/gifs/zNXvBiNNcrjDW
//                        }
//
//                } else {
//                    sendMessageToBotsChannel("Nah son, you 'bout to play so get ready.");
//                }
//            }
//        }








//    public Bot() {
//
//
//    }

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
//    public void listChannels() {
//        ListChannelsResponse listChannelsResponse = Slack.listChannels();
//
//        if (listChannelsResponse.isOk()) {
//            List<Channel> channels = listChannelsResponse.getChannels();
//
//            System.out.println("\nChannels: ");
//            for (Channel channel : channels) {
//                System.out.println("name: " + channel.getName() + ", id:" + channel.getId());
//            }
//        } else {
//            System.err.print("Error listing channels: " + listChannelsResponse.getError());
//        }
//    }

    /**
     * Sample method: prints up to the last 100 messages from a given channel. Prints an error message on failure.
     * or failure.
     *
     * @param channelId id of the given channel.
     */
//    public void listMessages(String channelId) {
//        ListMessagesResponse listMessagesResponse = Slack.listMessages(channelId);
//
//        if (listMessagesResponse.isOk()) {
//            List<Message> messages = listMessagesResponse.getMessages();
//
//            System.out.println("\nMessages: ");
//            for (Message message : messages) {
//                System.out.println();
//                System.out.println("Timestamp: " + message.getTs());
//                System.out.println("Message: " + message.getText());
//            }
//        } else {
//            System.err.print("Error listing messages: " + listMessagesResponse.getError());
//        }
//    }

    /**
     * Sample method: sends a plain text message to the #bots channel. Prints a message indicating success or failure.
     *
     * @param text message text.
     */
//    public void sendMessageToBotsChannel(String text) {
//        SendMessageResponse sendMessageResponse = Slack.sendMessage(text);
//
//        if (sendMessageResponse.isOk()) {
//            System.out.println("Message sent successfully!");
//        } else {
//            System.err.print("Error sending message: " + sendMessageResponse.getError());
//        }
//    }

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
