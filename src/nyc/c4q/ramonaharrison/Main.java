package nyc.c4q.ramonaharrison;

import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import nyc.c4q.ramonaharrison.model.Message;
import nyc.c4q.ramonaharrison.network.Slack;

public class Main {

    public static void main(String[] args) {

        Bot myBot = new Bot();

        myBot.testApi();

        myBot.listChannels();

        myBot.listMessages(Slack.BOTS_CHANNEL_ID);

//        myBot.sendMessageToBotsChannel(" testing " );



        // Post "Hello, world!" to the #bots channel
        //myBot.sendMessage("Hello, world!");

        // Post a pineapple photo to the #bots channel
        //myBot.sendMessage("http://weknowyourdreams.com/images/pineapple/pineapple-07.jpg");

    }
}