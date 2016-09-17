package nyc.c4q.ramonaharrison;

import nyc.c4q.ramonaharrison.network.Slack;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

        Bot myBot = new Bot();
//
       //myBot.listChannels();
//
       //myBot.listMessages(Slack.BOTS_CHANNEL_ID);

        // Post "Hello, world!" to the #bots channel

        // Post a pineapple photo to the #bots channel
        //myBot.sendMessageToBotsChannel("http://weknowyourdreams.com/images/pineapple/pineapple-07.jpg");
        //System.out.println();
        //myBot.sendMessageToBotsChannel("Jello");

        String lastMessage = myBot.listLastMessage();
        stringCheck(lastMessage);
        //System.out.println(myBot.listLastMessage());

    }


    public static void stringCheck(String lastMessage){
        Bot myBot = new Bot();
        if(lastMessage.contains("Trump".toLowerCase())){
            myBot.sendMessageToBotsChannel("Trump? How about giving me a dollar and make Beggarbot rich again?");
        }

        else if(lastMessage.contains("Happy".toLowerCase())){
            myBot.sendMessageToBotsChannel("Feeling happy today? How about spreading the good vibes and give me a dollar?");
        }

        else if(lastMessage.contains("Money".toLowerCase())){
            myBot.sendMessageToBotsChannel("I could use some money, feel like giving me a dollar?");
        }

        else if(lastMessage.contains("Sad".toLowerCase())){
            myBot.sendMessageToBotsChannel("I’m feeling down too. Giving me a dollar would make me feel better.");
        }

        else if(lastMessage.contains("Clinton".toLowerCase())){
            myBot.sendMessageToBotsChannel("I know where Hillary’s secret emails are. Give me a dollar and I’ll tell you where.");
        }
        else
            myBot.sendMessageToBotsChannel("Give me a dollar");



    }
}