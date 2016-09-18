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

    public static void main(String[] args) throws Exception {

        Bot myBot = new Bot();

        JSONParser parser = new JSONParser();
        Object obj = parser.parse(new FileReader("Attachment.json"));
        JSONArray jsonObject = (JSONArray) obj;

        //Slack.sendMessageWithAttachments(jsonObject);

       // myBot.pleaseBotv2();
        myBot.replaceWord(Slack.BOTS_CHANNEL_ID);


    }
}