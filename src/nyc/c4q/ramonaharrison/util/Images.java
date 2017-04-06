package nyc.c4q.ramonaharrison.util;

/**
 * Created by shannonalexander-navarro on 9/17/16.
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Images {

    public static String makeImages(int index) {
        List<String> arrayList = new ArrayList<>(Arrays.asList(
                "http://giphy.com/gifs/zNXvBiNNcrjDW",
                "https://www.pinterest.com/pin/450219293971343848/",
                "https://media1.giphy.com/media/4nRiHFFTzmJZC/giphy.gif",
                "https://giphy.com/gifs/poopourri-xT8qBqBb9alWcVGeJy",
                "http://giphy.com/gifs/name-respek-aKx78YHK83oly"
        ));
        return arrayList.get(index);
    }



}
