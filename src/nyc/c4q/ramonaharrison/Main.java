package nyc.c4q.ramonaharrison;

import com.sun.tools.classfile.Opcode;
import com.sun.tools.javac.util.List;
import nyc.c4q.ramonaharrison.model.Attachment;
import nyc.c4q.ramonaharrison.network.Slack;
import nyc.c4q.ramonaharrison.util.Words;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Main {



    public static void main(String[] args) throws IOException, ParseException {


        //JSONObject obj = new JSONObject();
        JSONParser parser = new JSONParser();



            Object obj = parser.parse(new FileReader("/Users/Millochka/Desktop/accesscodeClass/SlackBot/src/nyc/c4q/ramonaharrison/model/Attachment.json"));

            JSONArray jsonObject = (JSONArray) obj;

        Slack.sendMessageWithAttachments(jsonObject);




            Bot myBot = new Bot();

     myBot.replaceWord(Slack.BOTS_CHANNEL_ID);

            //}


            //myBot.testApi();

            //myBot.listChannels();


            // Post "Hello, world!" to the #bots channel
            //myBot.sendMessageToBotsChannel("Test2!");

            // Post a pineapple photo to the #bots channel
            //Slack.sendMessage("http://weknowyourdreams.com/images/pineapple/pineapple-07.jpg");

        }
    }