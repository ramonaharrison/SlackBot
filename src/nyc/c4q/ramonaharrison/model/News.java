package nyc.c4q.ramonaharrison.model;

import nyc.c4q.ramonaharrison.Bot;
import nyc.c4q.ramonaharrison.network.HTTPS;
import nyc.c4q.ramonaharrison.network.Slack;
import nyc.c4q.ramonaharrison.network.response.ListMessagesResponse;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by jordansmith on 9/19/16.
 */
public class News {

    List<Articles> articles;

   List<String> author = new ArrayList<>();
   List<String> title = new ArrayList<>();
   List<String> description = new ArrayList<>();
   List<String> url = new ArrayList<>();
   List<String> urlToImage = new ArrayList<>();
   List<String> publishedAt = new ArrayList<>();

    public static String vergeUrl = "https://newsapi.org/v1/articles?source=the-verge&sortBy=top&apiKey=589ffd42ff994295802a4ccef02aa18e";
    public static String espnURl = "https://newsapi.org/v1/articles?source=espn&sortBy=top&apiKey=589ffd42ff994295802a4ccef02aa18e";
    public static String polygonURL = "https://newsapi.org/v1/articles?source=polygon&sortBy=top&apiKey=589ffd42ff994295802a4ccef02aa18e";

//    public News(JSONObject json){
//        if(json.containsKey("articles")){
//            JSONArray jsonArticles = (JSONArray) json.get("articles");
//            this.articles = new ArrayList<Articles>();
//            for (int i = 0; i < jsonArticles.size() ; i++) {
//                JSONObject mjsonObject = (JSONObject) jsonArticles.get(i);
//                Articles mArticles = new Articles(mjsonObject);
//                author.add(mArticles.getAuthor());
//                title.add(mArticles.getTitle());
//                description.add(mArticles.getDescription());
//                url.add(mArticles.getUrl());
//                urlToImage.add(mArticles.getUrlToImage());
//                publishedAt.add(mArticles.getPublishedAt());
//            }
//            System.out.println(author.get(0));
//            System.out.println(title.get(0));
//            System.out.println(author.get(0));
//            System.out.println(description.get(0));
//        }
//    }

    public void newsReaderBot(String apiURL){
        JSONObject json = HTTPS.get(HTTPS.stringToURL(apiURL));
        if(json.containsKey("articles")){
            JSONArray jsonArticles = (JSONArray) json.get("articles");
            for (int i = 0; i < jsonArticles.size() ; i++) {
                JSONObject mjsonObject = (JSONObject) jsonArticles.get(i);
                Articles mArticles = new Articles(mjsonObject);
                author.add(mArticles.getAuthor());
                title.add(mArticles.getTitle());
                description.add(mArticles.getDescription());
                url.add(mArticles.getUrl());
                urlToImage.add(mArticles.getUrlToImage());
                publishedAt.add(mArticles.getPublishedAt());
            }

        }

    }

    public void sendNews(){
        while (true){
            ListMessagesResponse listMessagesResponse = Slack.listMessages(Slack.BOTS_CHANNEL_ID);
            if (listMessagesResponse.isOk()) {
                Bot bot = new Bot();
                List<Message> messages = listMessagesResponse.getMessages();
                String originalMessage = messages.get(0).getText();
                Message senderMessage = messages.get(0);
                if(originalMessage.contains("<@U2ADC0PLL> give me tech news")){
                    newsReaderBot(vergeUrl);
                    bot.sendMessageToBotsChannel("Alright sure " + "<@" + senderMessage.getUser() + ">"
                            + ". Check out this random story from the Verge:");
                    Random rand = new Random();
                    int value = rand.nextInt(title.size()-1);
                    bot.sendMessageToBotsChannel("*" + title.get(value) +"*");
                    bot.sendMessageToBotsChannel("_" + description.get(value) + "_");
                    bot.sendMessageToBotsChannel(urlToImage.get(value));
                }
                if(originalMessage.contains("<@U2ADC0PLL> give me sports news")){
                    newsReaderBot(espnURl);
                    bot.sendMessageToBotsChannel("Alright sure " + "<@" + senderMessage.getUser() + ">"
                            + ". Check out this random story from the ESPN:");
                    Random rand = new Random();
                    int value = rand.nextInt(title.size()-1);
                    bot.sendMessageToBotsChannel("*" + title.get(value) +"*");
                    bot.sendMessageToBotsChannel("_" + description.get(value) + "_");
                    bot.sendMessageToBotsChannel(urlToImage.get(value));
                }
                if(originalMessage.contains("<@U2ADC0PLL> give me gaming news")){
                    newsReaderBot(polygonURL);
                    bot.sendMessageToBotsChannel("Alright sure " + "<@" + senderMessage.getUser() + ">"
                            + ". Check out this random story from the Polygon:");
                    Random rand = new Random();
                    int value = rand.nextInt(title.size()-1);
                    bot.sendMessageToBotsChannel("*" + title.get(value) +"*");
                    bot.sendMessageToBotsChannel("_" + description.get(value) + "_");
                    bot.sendMessageToBotsChannel(urlToImage.get(value));
                }



            }
            else{  System.err.print("Error listing messages: " + listMessagesResponse.getError());
                break;

            }


        }

    }





}
