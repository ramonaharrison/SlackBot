package nyc.c4q.ramonaharrison;

import nyc.c4q.ramonaharrison.network.Slack;

public class Main {

    // 9/23 - retrieved username from last message. did some refactoring (deleted unused methods). changed Giphy url to read
    // actual url instead of small height fixed url. continue working on respondAll() and started working
    // on Yelp API integration. 

    public static void main(String[] args) {

        Bot myBot = new Bot();

//    myBot.testApi();
//    myBot.deleteMessageInBotsChannel("1474042536.000733");

        myBot.listChannels();
        myBot.listMessages(Slack.BOTS_CHANNEL_ID);

//      myBot.addReaction();
        myBot.respondGreeting("C2ERNHJ5D");
        myBot.respondDictionary("C2ERNHJ5D");
        myBot.respondMeme("C2ERNHJ5D");
        myBot.respondGiphy("C2ERNHJ5D");

//    myBot.listMessages(Slack.BOTS_CHANNEL_ID);
//    myBot.sendMessageToBotsChannel(":poop: messybot will be under maintenance.");

//      I am working on code below.
//      myBot.respondAll("C2ERNHJ5D");

    }
}