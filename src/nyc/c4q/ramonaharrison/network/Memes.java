package nyc.c4q.ramonaharrison.network;

import java.net.URL;
import java.util.Scanner;
import java.util.Random;


/**
 http://www.memes.com/img/13
 http://www.memes.com/img/1190510
 */
public class Memes {
    private static final String BASE_URL = "http://www.memes.com/";
    private static final String ENDPOINT_TEST = "img/";
    private static final String UNFURL_LINK = "true";
    private static final String UNFURL_MEDIA = "true";

    public static URL memeSearch()  {
        Random number = new Random();
        int query = number.nextInt(1190510) + 13;

            return HTTPS.stringToURL(BASE_URL + ENDPOINT_TEST + query);
    }
}
