package nyc.c4q.ramonaharrison;

import jdk.nashorn.internal.parser.JSONParser;
import nyc.c4q.ramonaharrison.network.Slack;



public class Main {

    public static void main(String[] args) {

        Bot myBot = new Bot();

        myBot.testApi();
        myBot.listChannels();



       myBot.listMessages(Slack.BOTS_CHANNEL_ID);

       myBot.listMessages(Slack.BOTS_CHANNEL_ID);


        myBot.sendMessageToBotsChannel(myBot.randomTip());
        myBot.sendMessageToBotsChannel("Yum yum!");
        myBot.sendMessageToBotsChannel("So does this one: <http://www.foo.com|www.foo.com>");

        // Post "Hello, world!" to the #bots channel
        myBot.sendMessageToBotsChannel("Testing, Testing");

        // Post a pineapple photo to the #bots channel
        //myBot.sendMessage("http://weknowyourdreams.com/images/pineapple/pineapple-07.jpg");

    }
}