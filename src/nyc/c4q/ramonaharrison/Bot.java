package nyc.c4q.ramonaharrison;

import nyc.c4q.ramonaharrison.model.Channel;
import nyc.c4q.ramonaharrison.model.Message;
import nyc.c4q.ramonaharrison.model.User;
import nyc.c4q.ramonaharrison.network.*;
import nyc.c4q.ramonaharrison.network.response.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by Ramona Harrison
 * on 8/26/16
 *
 */

public class Bot {
    // TODO: implement your bot logic!

    public Bot() {
    }
    public void sendPigLatinResponse(){
        ListMessagesResponse allResponses = Slack.listMessages("C7KE0KTM4");
        List<Message> allMessages = allResponses.getMessages();
        Message lastMessage = allMessages.get(0);
        String text = lastMessage.getText();
        PigLatin pigMessage= new PigLatin(text);
        text=pigMessage.getPigMessage();
        while(Slack.listMessages("C7KE0KTM4").isOk()) {
            sendMessageToBotsChannel(text);
        }//TODO make an if statement to trigger response so bot doesn't spam replies to every message.
    }
    public void sendHomeworkLink() {
        ListMessagesResponse allResponses = Slack.listMessages("C7KE0KTM4");
        List<Message> allMessages = allResponses.getMessages();
        Message lastMessage = allMessages.get(allMessages.size() - 1);
        String text = lastMessage.getText();
        HashMap<String, String> listOfHomeworks = new HashMap<>();
        listOfHomeworks.put("homework1", "https://canvas.instructure.com/courses/1218009/quizzes/2367962");
        listOfHomeworks.put("homework2", "https://github.com/C4Q/AC-Android/blob/master/homework/unit-1/week-2.md");
        listOfHomeworks.put("homework3", "https://github.com/C4Q/AC-Android/blob/master/homework/unit-1/Hw3");


        if (text.contains("homework1")) {
            String link = listOfHomeworks.get("homework1");
            Slack.sendMessage(link);
        }
        else if (text.contains("homework2")) {
            String link = listOfHomeworks.get("homework2");
            Slack.sendMessage(link);
        }
        else if (text.contains("homework3")) {
            String link = listOfHomeworks.get("homework3");
            Slack.sendMessage(link);
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
    public static class PigLatin{
        String pigMessage;
        public PigLatin(String pigMessage){
            this.pigMessage = messageToPigLatin(messageToStringArray(pigMessage));
        }
        public StringBuilder pigLatin(String s){
            StringBuilder pigLatin=new StringBuilder(s);
            String igLatin=pigLatin.substring(1);
            pigLatin.delete(1,pigLatin.length());
            pigLatin.insert(0, igLatin);
            pigLatin.append("ay");
            return pigLatin;
        }
        public ArrayList<String> messageToStringArray(String s){
            ArrayList<String> stringArray= new ArrayList<>();
            StringTokenizer pLT = new StringTokenizer(s, " ");
            while (pLT.hasMoreTokens()){
                stringArray.add(pLT.nextToken());
            }
            return stringArray;
        }
        public  String messageToPigLatin(ArrayList<String> message){
            String messageToPigLatin="";
            for (String s:message){
                messageToPigLatin+= (pigLatin(s) + " ");
            }
            return messageToPigLatin;
        }

        public String getPigMessage() {
            return pigMessage;
        }
    }
}
