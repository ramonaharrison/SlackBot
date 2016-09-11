package nyc.c4q.ramonaharrison.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Ramona Harrison
 * on 8/24/16
 *
 * A utility class for retrieving the API token.
 */

public class Token {

    public static String findApiToken() {

        String apiKey = "";

        File file = new File("api_token.txt");
        System.out.println(file.getAbsolutePath());

        try {

            Scanner scanner = new Scanner(file);

            apiKey = scanner.next();

            scanner.close();

        } catch (FileNotFoundException e) {

            e.printStackTrace();

        }

        return apiKey;
    }
}
