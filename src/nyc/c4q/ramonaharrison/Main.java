package nyc.c4q.ramonaharrison;

import nyc.c4q.ramonaharrison.model.Message;
import nyc.c4q.ramonaharrison.network.Slack;
import nyc.c4q.ramonaharrison.network.response.ListMessagesResponse.*;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Bot myBot = new Bot();

        myBot.testApi();

        myBot.listChannels();

        //myBot.listMessages(Slack.BOTS_CHANNEL_ID);

        ArrayList<String> myMessages = myBot.listMessages(Slack.BOTS_CHANNEL_ID);

        String lastmessage =  myBot.getLastMessage();

        String link = myBot.getLmgtfyLink();

        myBot.sendMessageToBotsChannel(link);


    }




    }
