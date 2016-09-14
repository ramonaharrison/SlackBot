package nyc.c4q.ramonaharrison;

import nyc.c4q.ramonaharrison.network.Slack;

public class Main {

    public static void main(String[] args) {

        Bot myBot = new Bot();
/*
        boolean loop = true;
        while (loop) {
            myBot.greetings();
            loop = myBot.exitUntil("kill bot");
        }
*/
        //myBot.testApi();

        //myBot.listChannels();

        //myBot.listUsers(Slack.BOTS_CHANNEL_ID);
        myBot.listMessages(Slack.BOTS_CHANNEL_ID);

        // Post "Hello, world!" to the #bots channel
        //myBot.sendMessage("Hello, world!");

        // Post a pineapple photo to the #bots channel
        //myBot.sendMessage("http://weknowyourdreams.com/images/pineapple/pineapple-07.jpg");



    }
}