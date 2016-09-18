package nyc.c4q.ramonaharrison;

import nyc.c4q.ramonaharrison.network.Giphy;
import nyc.c4q.ramonaharrison.network.UrbanDictionary;
import nyc.c4q.ramonaharrison.network.Slack;


public class Main {

    public static void main(String[] args){

    Bot myBot = new Bot();

//    myBot.testApi();
//    myBot.deleteMessageInBotsChannel("1474042536.000733");

    myBot.listChannels();
    myBot.listMessages(Slack.BOTS_CHANNEL_ID);

    myBot.addReaction();

    myBot.respondGreeting("C2ABKERFT");

    myBot.addReaction();

    myBot.listMessages(Slack.BOTS_CHANNEL_ID);

//    myBot.respondAll("C2ABKERFT");
        myBot.respondDictionary("C2ABKERFT");
        myBot.addReaction();

        myBot.respondMeme("C2ABKERFT");
        myBot.addReaction();

        myBot.respondGiphy("C2ABKERFT");
        myBot.addReaction();

        myBot.listMessages(Slack.BOTS_CHANNEL_ID);

//
//    myBot.listMessages(Slack.BOTS_CHANNEL_ID);

//        myBot.respondDictionary("C2ADPS5MK");
//        myBot.respondMeme("C2ADPS5MK");
//        myBot.respondGiphy("C2ADPS5MK");

//        myBot.sendMessageToBotsChannel(":poop: messybot will be under maintenance.");

        // non working method-calls. NEED TO REVISIT OR DELETE
//        myBot.respondMeme("C2ADPS5MK");
//        myBot.searchMessages(Slack.BOTS_CHANNEL_ID, "messybot");

    }
}