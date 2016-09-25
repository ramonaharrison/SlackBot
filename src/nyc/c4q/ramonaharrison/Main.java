package nyc.c4q.ramonaharrison;

import nyc.c4q.ramonaharrison.network.Slack;
import nyc.c4q.ramonaharrison.util.Quiz;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Bot myBot = new Bot();

        myBot.testApi();

        myBot.listChannels();

        myBot.listMessages(Slack.BOTS_CHANNEL_ID);

       // myBot.testMethod(Slack.BOTS_CHANNEL_ID);

      Quiz.quiz();

        myBot.listMessages(Slack.BOTS_CHANNEL_ID);

        // Post "Hello, world!" to the #bots channel
       // myBot.sendMessageToBotsChannel(quiz());
        // Post a pineapple photo to the #bots channel
        //myBot.sendMessage("http://weknowyourdreams.com/images/pineapple/pineapple-07.jpg");
//myBot.deleteMessageInBotsChannel("1474086468.000821");
//        myBot.deleteMessageInBotsChannel("1474222673.002704");
//        myBot.deleteMessageInBotsChannel("1474222733.002711");
//        myBot.deleteMessageInBotsChannel("1474223222.002729");
//        myBot.deleteMessageInBotsChannel("1474223316.002735");
//        myBot.deleteMessageInBotsChannel("1474223811.002831");
//        myBot.deleteMessageInBotsChannel("1474223970.002865");





    }
}