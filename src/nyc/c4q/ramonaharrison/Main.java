package nyc.c4q.ramonaharrison;

import nyc.c4q.ramonaharrison.network.Slack;



public class Main {

    public static void main(String[] args) {

        Bot myBot = new Bot();

        myBot.testApi();
        myBot.listChannels();

//        myBot.respondGreeting("@C7M6UM4LA");
        myBot.respondGreeting("@C7M6UM4LA");
        myBot.randomTip();

        myBot.listMessages(Slack.BOTS_CHANNEL_ID);

<<<<<<< HEAD

//        myBot.sendMessageToBotsChannel(list);
//        myBot.sendMessageToBotsChannel(myBot.randomTip());
//        myBot.sendMessageToBotsChannel("Yum yum!");
//        myBot.sendMessageToBotsChannel("So does this one: <http://www.foo.com|www.foo.com>");
=======
        myBot.sendMessageToBotsChannel(myBot.randomQuote());
        myBot.sendMessageToBotsChannel("Yum yum!");
        myBot.sendMessageToBotsChannel("So does this one: <http://www.foo.com|www.foo.com>");
>>>>>>> cda13a2bd21a0090789c6efe97ba06dfc7e55298


        // Post "Hello, world!" to the #bots channel
//        myBot.sendMessageToBotsChannel("Testing, Testing");

        // Post a pineapple photo to the #bots channel
        //myBot.sendMessage("http://weknowyourdreams.com/images/pineapple/pineapple-07.jpg");

    }
}