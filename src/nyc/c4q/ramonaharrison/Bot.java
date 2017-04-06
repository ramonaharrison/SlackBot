package nyc.c4q.ramonaharrison;

import nyc.c4q.ramonaharrison.model.Attachment;
import nyc.c4q.ramonaharrison.model.Channel;
import nyc.c4q.ramonaharrison.model.Message;
import nyc.c4q.ramonaharrison.network.*;
import nyc.c4q.ramonaharrison.network.response.*;

import java.util.List;

/**
 * Created by Ramona Harrison
 * on 8/26/16
 *
 */

public class Bot {

    public static int money = 0;
    public void checkMessagesAndRespond(String channelId) {
        ListMessagesResponse listMessagesResponse = Slack.listMessages(channelId);

        if (listMessagesResponse.isOk()) {
            List<Message> messages = listMessagesResponse.getMessages();
            for (Message message : messages) {
                if (message.getText().contains("hamburger")) {
                    Slack.sendMessage("I love hamburgers");
                    Slack.sendMessage("https://media.giphy.com/media/yYc5L3vhTWeBi/giphy.gif");
                    break;
                }else if(message.getText().contains("cat")){
                    Slack.sendMessage("Cats are meh");
                    Slack.sendMessage("https://media.giphy.com/media/MVQLSJt38RKJG/giphy.gif");
                    break;
                }else if (message.getText().contains("alien")){
                    Slack.sendMessage("Aliens are scary");
                    Slack.sendMessage("https://media.giphy.com/media/l3V0ma60jQqGCoJyM/giphy.gif");
                    break;
                }else if (message.getText().contains("ufo")){
                    Slack.sendMessage("OMG UFOS");
                    Slack.sendMessage("https://media.giphy.com/media/dKVvUk2oH8x2g/giphy.gif");
                    break;
                }else {
                    Slack.sendMessage("life is hard could you lend me some money?");
                    break;
                }


            }

        }
    }

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

    public String lastMessageText() {
        ListMessagesResponse listMessagesResponse = Slack.listMessages(Slack.BOTS_CHANNEL_ID);

        if (listMessagesResponse.isOk()) {
            List<Message> messages = listMessagesResponse.getMessages();

            Message message = messages.get(0);

            return message.getText();
        } else {
            System.err.print("Error listing messages: " + listMessagesResponse.getError());
        }
        return "";
    }

    public Message lastMessage() {
        ListMessagesResponse lmr = Slack.listMessages(Slack.BOTS_CHANNEL_ID);
        if (lmr.isOk()) {
            List<Message> messages = lmr.getMessages();
            return messages.get(0);
        } else {
            System.err.print("Error listing messages: " + lmr.getError());
        }
        return null;
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


    public void sendMessageToBotsChannelAsPolice(String text) {
        SendMessageResponse sendMessageResponse = Slack.sendMessageAsPolice(text);

        if (sendMessageResponse.isOk()) {
            System.out.println("Message sent successfully!");
        } else {
            System.err.print("Error sending message: " + sendMessageResponse.getError());
        }
    }

    public void sendMessageWithAttachmentsToBotsChannel(String text, List<Attachment> attachments) {
        SendMessageResponse sendMessageResponse = Slack.sendMessageWithAttachments(text,attachments);

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
