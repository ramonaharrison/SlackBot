package nyc.c4q.ramonaharrison.cleverbot;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.net.ssl.HttpsURLConnection;

public class Cleverbot {
    private static final String CREATE_BOT_URL = "https://cleverbot.io/1.0/create";
    private static final String SEND_BOT_MSG_URL = "https://cleverbot.io/1.0/ask";
    private static final String USER_AGENT = "Mozilla/5.0";
    private static final String API_USER = "yGCgpzN6gssOX8EF";
    private static final String API_KEY = "szClqnca76wNIVofwyXF904iLTCsH7Mx";
    private static final String NICKNAME = "cookiebot";

    private static final String CREATE_BOT_URL_PARAM = "user=" + API_USER + "&key=" + API_KEY + "&nick=" + NICKNAME;
    private static final String SEND_BOT_MSG_URL_PARAM = "user=" + API_USER + "&key=" + API_KEY + "&nick=" + NICKNAME + "&text=";

    private static String messageResponse;

    public static String sendMessage(String messageText) {
        try {
            messageText = URLEncoder.encode(messageText, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }

        try {
            sendPost(SEND_BOT_MSG_URL, SEND_BOT_MSG_URL_PARAM + messageText);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return messageResponse;
    }

    public static void createInstance(){
        try {
            sendPost(CREATE_BOT_URL, CREATE_BOT_URL_PARAM);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // HTTP POST request
    private static void sendPost(String url, String param) throws Exception {

        url = "https://cleverbot.io/1.0/ask";
        URL obj = new URL(url);
        HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

        con.setRequestMethod("POST");
        con.setRequestProperty("User-Agent", USER_AGENT);
        con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

        String urlParameters = param;

        // Send post request
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(urlParameters);
        wr.flush();
        wr.close();

        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'POST' request to URL : " + url);
        System.out.println("Post parameters : " + urlParameters);
        System.out.println("Response Code : " + responseCode);

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        //print result
        System.out.println(response.toString());

        //if sendPost is sending a message then set the message response, otherwise don't
        if (url.equals(SEND_BOT_MSG_URL))
            messageResponse = parseResponse(response.toString());
    }

    //regex to get the response from cleverbot
    public static String parseResponse(String messageResponse) {
        String result = "";
        String regex = "((?<=\"status\":\"success\",\"response\":\").*(?=\"}))";
        Pattern p = Pattern.compile(regex);
        Matcher r = p.matcher(messageResponse);
          if(r.find())

        result = result + r.group(0);
        return result;
    }


}