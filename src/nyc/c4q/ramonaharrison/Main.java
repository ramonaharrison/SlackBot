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

            JSONObject jsonObject = (JSONObject) obj;

        Slack.sendMessageWithAttachments(jsonObject);



            //jsonObject.color
//            JSONObject object1 =new JSONObject();
//            JSONArray array = new JSONArray();
//        JSONObject object2 =new JSONObject();


//
//            ArrayList<Attachment> attachments = new ArrayList();
//            attachments.add(new Attachment(jsonObject));
//            System.out.println(jsonObject.toString());
////
//        object1.put("title","Priority");
//        object1.put("value","High");
//        object1.put("short",false);
//        array.add(object1);
//        object2.put("fields",array);
//        jsonObject.put("fallback","Required plain-text summary of the attachment.");
//        jsonObject.put("color","#36a64f");
//        jsonObject.put("pretext","Optional text that appears above the attachment block");
//        jsonObject.put("author_name","Bobby Tables");
//        jsonObject.put("author_link","http://flickr.com/bobby/");
//        jsonObject.put("author_icon","http://flickr.com/icons/bobby.jpg");
//        jsonObject.put("title","Slack API Documentation");
//        jsonObject.put("author_link","http://flickr.com/bobby/");
//        jsonObject.put("title_link","https://api.slack.com/");
//        jsonObject.put("text","Optional text that appears within the attachment");



            Bot myBot = new Bot();
        //myBot.listUsers(Slack.BOTSTEST_CHANNEL_ID);
            //myBot.listMessages(Slack.BOTSTEST_CHANNEL_ID);

            //Slack.sendMessageWithAttachments("This is my first atatchment", jsonObject);
        //}
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }


//        for(String map: words.getmWord().keySet())
//        System.out.println(words.getmWord().get(map));
//            //for(int i=0;i<3;i++){
//       Bot myBot = new Bot();
//     myBot.replaceWord(Slack.BOTSTEST_CHANNEL_ID);

            //}


            //myBot.testApi();

            //myBot.listChannels();


            // Post "Hello, world!" to the #bots channel
            //myBot.sendMessageToBotsChannel("Test2!");

            // Post a pineapple photo to the #bots channel
            //Slack.sendMessage("http://weknowyourdreams.com/images/pineapple/pineapple-07.jpg");

        }
    }