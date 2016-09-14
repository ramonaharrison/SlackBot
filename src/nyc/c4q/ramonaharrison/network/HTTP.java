package nyc.c4q.ramonaharrison.network;

/**
 * Created by Rafael on 9/14/16.
 */

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Simplified API for HTTP.
 */
public class HTTP {
    /**
     * Reads from 'reader' by 'blockSize' until end-of-stream, and returns its complete contents.
     */
    private static String readAll(InputStreamReader reader, int blockSize) throws IOException {
        final char buffer[] = new char[blockSize];
        StringBuilder builder = new StringBuilder();
        while (true) {
            final int readSize = reader.read(buffer);
            if (readSize >= 0)
                builder.append(buffer, 0, readSize);
            else
                break;
        }
        return builder.toString();
    }

    /**
     * Returns from 'reader' until end-of-stream, and returns its complete contents.
     */
    private static String readAll(InputStreamReader reader) throws IOException {
        return readAll(reader, 1024 * 1024);
    }

    /**
     * Interprets a string as a URL.  If the string isn't a valid URL, prints an error message and returns null.
     */
    public static URL stringToURL(String string) {
        try {
            return new URL(string);
        } catch (MalformedURLException exception) {
            System.err.println("invalid URL: " + string + ": " + exception);
            return null;
        }
    }

    /**
     * Retrieves JSON from a URL.
     * <p>
     * Opens a connection to the URL, makes a request, and retrieves the response.  Returns the body as a JSONObject.
     * If the URL cannot be opened or the response cannot be read, prints an error message and returns null.
     */
    public static JSONObject get(URL url) {
        try {
            final HttpURLConnection connection = (HttpURLConnection)  url.openConnection();
            final InputStreamReader reader = new InputStreamReader(connection.getInputStream());
            try {
                return stringToJSON(readAll(reader));
            } finally {
                reader.close();
            }
        } catch (IOException exception) {
            System.err.println("can't open URL: " + url + ": " + exception);
            return null;
        }
    }

    /**
     * Interprets a string as JSON.  If the string isn't valid JSON, prints an error message and returns null.
     */
    private static JSONObject stringToJSON(String jsonString) {
        JSONParser parser = new JSONParser();
        try {
            return (JSONObject) parser.parse(jsonString);
        } catch (ParseException e) {
            System.err.println("invalid json: " + e);
            return null;
        }
    }

}