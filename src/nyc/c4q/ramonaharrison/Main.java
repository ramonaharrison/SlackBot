package nyc.c4q.ramonaharrison;

import nyc.c4q.ramonaharrison.network.Slack;

public class Main {

    public static void main(String[] args) {

        Bot myBot = new Bot();

        myBot.testApi();

        myBot.listChannels();

        myBot.listMessages(Slack.BOTS_CHANNEL_ID);

        // Post "Hello, world!" to the #bots channel
        //myBot.sendMessage("Hello, world!");

        // Post a pineapple photo to the #bots channel
        // myBot.sendMessageToBotsChannel("http://www.troll.me/images/ancient-aliens-guy/testing-aliens-thumb.jpg");

    }
}