package nyc.c4q.ramonaharrison.util;

import nyc.c4q.ramonaharrison.model.Message;
import nyc.c4q.ramonaharrison.network.Slack;
import nyc.c4q.ramonaharrison.network.response.ListMessagesResponse;

import java.util.List;

/**
 * Created by shannonalexander-navarro on 9/24/16.
 */
public class SecondQuestion {

    public static void secondQuestion()  {
        boolean playing = true;

        while (playing) {

            boolean isAnswerOk = true;

            while (isAnswerOk) {
                ListMessagesResponse listMessagesResponse1 = Slack.listMessages(Slack.BOTS_CHANNEL_ID);
          List<Message> messages = listMessagesResponse1.getMessages();
               String thirdResponse = messages.get(0).getText();

                if (thirdResponse.equalsIgnoreCase("b") || thirdResponse.equalsIgnoreCase("c")) {
                    Slack.sendMessage("Aight you got it.");
                    Slack.sendMessage(Images.makeImages(3));
                    playing = false;
                  isAnswerOk = false;
                } else if (thirdResponse.equalsIgnoreCase("a") ) {
                    Slack.sendMessage("Nah son b or c.");
                    Slack.sendMessage(Images.makeImages(3));
                  playing = false;
                    isAnswerOk = false;
                }
            }
        }
    }
}
