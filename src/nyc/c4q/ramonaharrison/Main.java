package nyc.c4q.ramonaharrison;

import nyc.c4q.ramonaharrison.network.Slack;


public class Main {

    public static boolean loopBot = true;

    public static void main(String[] args) throws Exception{

        Bot myBot = new Bot();

        while (loopBot) {
            myBot.start();
        }

        //myBot.testApi();

        //myBot.listChannels();

        //myBot.listUsers(Slack.BOTS_CHANNEL_ID);
       // myBot.listMessages(Slack.PRIVATE_CHANNEL_ID);

        // Post "Hello, world!" to the #bots channel
        //myBot.sendMessageToBotsChannel("Hello World");

        // Post a pineapple photo to the #bots channel
        //myBot.sendMessage("http://weknowyourdreams.com/images/pineapple/pineapple-07.jpg");



    }
}