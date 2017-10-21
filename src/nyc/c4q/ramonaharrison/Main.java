package nyc.c4q.ramonaharrison;

import nyc.c4q.ramonaharrison.network.Slack;

import java.util.Random;

public class Main {

    public static void main(String[] args) {

        Bot myBot = new Bot();

        myBot.testApi();

        myBot.listChannels();

        myBot.listMessages(Slack.BOTS_CHANNEL_ID);

        // Post "Hello, world!" to the #bots channel
        //myBot.sendMessage("Hello, world!");

        // Post a pineapple photo to the #bots channel
        //myBot.sendMessage("http://weknowyourdreams.com/images/pineapple/pineapple-07.jpg");

    }
}