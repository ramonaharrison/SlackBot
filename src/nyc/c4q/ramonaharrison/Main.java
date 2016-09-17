package nyc.c4q.ramonaharrison;

import nyc.c4q.ramonaharrison.model.Attachment;
import nyc.c4q.ramonaharrison.model.Message;
import nyc.c4q.ramonaharrison.network.Slack;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Bot myBot = new Bot();



        while(true) {
            Message message = myBot.lastMessage();
            String user = message.getUser();
            String lastMessage = myBot.lastMessageText().toLowerCase();
            if(lastMessage.contains("poor")){
                myBot.sendMessageToBotsChannel("*POOR??*");
                myBot.sendMessageToBotsChannel("...");
                myBot.sendMessageToBotsChannel("...");
                myBot.sendMessageToBotsChannel("Ugh Here's a dollar, Bye");
                Bot.money--;
                myBot.sendMessageToBotsChannel("_beggarbot escapes with " + Bot.money + " dollars!_");
                Thread.sleep(6000);
                myBot.sendMessageToBotsChannelAsPolice("WHERE DID HE GO! :police_car:");
                break;
            }
            if(!user.equals("beggarbot"))
                stringCheck(lastMessage);
        }
    }


    public static void stringCheck(String lastMessage){
        Bot myBot = new Bot();
        if(lastMessage.contains("Trump".toLowerCase())){
            myBot.sendMessageToBotsChannel("Trump? How about giving me a dollar and make Beggarbot rich again!");
            Bot.money++;
        }

        else if(lastMessage.contains("Happy".toLowerCase())){
            myBot.sendMessageToBotsChannel("Feeling happy today? How about spreading the good vibes and give me a dollar?");
            Bot.money++;
        }

        else if(lastMessage.contains("Money".toLowerCase())){
            myBot.sendMessageToBotsChannel("I could use some money, give me a dollar!");
            Bot.money++;
        }

        else if(lastMessage.contains("Sad".toLowerCase())){
            myBot.sendMessageToBotsChannel("I’m feeling down too. Giving me a dollar would make me feel better.");
            Bot.money++;
        }

        else if(lastMessage.contains("Clinton".toLowerCase())){
            myBot.sendMessageToBotsChannel("I know where Hillary’s secret emails are. Give me a dollar and I’ll tell you where.");
            Bot.money++;
        }
        else if(lastMessage.equalsIgnoreCase("sure")||lastMessage.equalsIgnoreCase("fine")||lastMessage.equalsIgnoreCase("okay")){
            myBot.sendMessageToBotsChannel("SURE?? You agree to give me a dollar!");
            Bot.money++;
        }
        else
            myBot.sendMessageToBotsChannel("Give me a dollar, cmon");



    }
}