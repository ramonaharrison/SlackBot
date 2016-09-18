package nyc.c4q.ramonaharrison.util;

import nyc.c4q.ramonaharrison.model.Message;
import nyc.c4q.ramonaharrison.network.Slack;
import nyc.c4q.ramonaharrison.network.response.ListMessagesResponse;

import java.util.List;

/**
 * Created by shannonalexander-navarro on 9/17/16.
 */
public class Quiz {
    public static void quiz() {
        Slack.sendMessage("Yo bot channel 'bout to be lit g! You goody?");

        boolean playing = true;

        while (playing) {
            ListMessagesResponse listMessagesResponse = Slack.listMessages(Slack.BOTS_CHANNEL_ID);
            List<Message> messages = listMessagesResponse.getMessages();
            String firstResponse = messages.get(0).getText();
            String secondResponse;

            if (firstResponse.equalsIgnoreCase("y") || firstResponse.equalsIgnoreCase("yes")) {
                Slack.sendMessage("Aight fam, it's gonna go like this- I give you a word, you tell me what it means. You feel me? "
                        + "Pick a, b, or c, aight? "
                        + "\n1st question: The word is Situationship. As in \"Sounds like you in a situationship\"."
                        + "\na)A situation   b)Playing at being in a relationship without actually being in one  c)A committed relationship");
              ListMessagesResponse listMessagesResponse1 = Slack.listMessages(Slack.BOTS_CHANNEL_ID);
                messages = listMessagesResponse.getMessages();
                secondResponse = messages.get(0).getText();
                if (secondResponse.equalsIgnoreCase("b")) {
                    Slack.sendMessage("I see you " + "this.getName()" + ". You obviously out in these streets, I'ma make sure I put some respek on your name.");
                    Slack.sendMessage(Images.makeImages(4));
                    playing = false;
                } else if (secondResponse.equalsIgnoreCase("a") || secondResponse.equalsIgnoreCase("c")) {
                    Slack.sendMessage("Good for you, obviously you ain't neva been in one-the answer was b.");
                    Slack.sendMessage(Images.makeImages(1));
                } else {
                    Slack.sendMessage("Yo, a, b or c only homie.");
                    Slack.sendMessage(Images.makeImages(0));
                    playing = false;
                }

            } else if (firstResponse.equalsIgnoreCase("n") || firstResponse.equalsIgnoreCase("no")) {
                Slack.sendMessage("Nah son, you 'bout to play so get ready.");
                Slack.sendMessage("Aight fam, it's gonna go like this- I give you a word, you tell me what it means. You feel me? "
                        + "Pick a, b, or c, aight? "
                        + "\n1st question: The word is Situationship. As in \"Sounds like you in a situationship\"."
                        + "\na)A situation   b)Playing at being in a relationship without actually being in one  c)A committed relationship");
                ListMessagesResponse listMessagesResponse1 = Slack.listMessages(Slack.BOTS_CHANNEL_ID);
                messages = listMessagesResponse.getMessages();
                secondResponse = messages.get(0).getText();
                if (secondResponse.equalsIgnoreCase("b")) {
                    Slack.sendMessage("I see you " + "this.getName()" + ". You obviously out in these streets, I'ma make sure I put some respek on your name.");
                    Slack.sendMessage(Images.makeImages(4));
                    playing = false;
                } else if (secondResponse.equalsIgnoreCase("a") || secondResponse.equalsIgnoreCase("c")) {
                    Slack.sendMessage("Good for you, obviously you ain't neva been in one-the answer was b.");
                    Slack.sendMessage(Images.makeImages(1));
                } else {
                    Slack.sendMessage("Yo, a, b or c only homie.");
                    Slack.sendMessage(Images.makeImages(0));
                    playing = false;
                }
            }

        }
    }
}
