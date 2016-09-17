package nyc.c4q.ramonaharrison;

import java.util.Random;

/**
 * Created by jordansmith on 9/16/16.
 */
public class CatGifs {


    public static String catPics(){
        String [] catPicsArray = new String [28];
        catPicsArray [0] = "http://i.imgur.com/zcP8RYL.gif";
        catPicsArray [1] = "http://i.imgur.com/4dSv0jH.gif";
        catPicsArray [2] = "http://i.imgur.com/vmExtY7.gif";
        catPicsArray [3] = "http://i.imgur.com/NIeyIQP.gif";
        catPicsArray [4] = "http://i.imgur.com/sHQQJG5.gif";
        catPicsArray [5] = "http://i.imgur.com/JKH5xBZ.gif";
        catPicsArray [6] = "http://i.imgur.com/U0aCPSv.gif";
        catPicsArray [7] = "http://i.imgur.com/FH8J8R3.gif";
        catPicsArray [8] = "http://i.imgur.com/7AtUnqc.gif";
        catPicsArray [9] = "http://i.imgur.com/OOVmdwa.gif";
        catPicsArray [10] = "http://i.imgur.com/nfKM2dN.gif";
        catPicsArray [11] = "http://i.imgur.com/nfKM2dN.gif";
        catPicsArray [12] = "http://i.imgur.com/svQyujn.gif";
        catPicsArray [13] = "http://i.imgur.com/fDiFnbO.gif";
        catPicsArray [14] = "http://i.imgur.com/bPd4Kgh.gif";
        catPicsArray [15] = "http://i.imgur.com/AOSdhQe.gif";
        catPicsArray [16] = "http://i.imgur.com/nflEpRJ.gif";
        catPicsArray [17] = "http://i.imgur.com/AOSdhQe.gif";
        catPicsArray [18] = "http://i.imgur.com/JvyQd.gif";
        catPicsArray [19] = "http://i.imgur.com/mMrUT.gif";
        catPicsArray [20] = "http://i.imgur.com/2aJRS.gif";
        catPicsArray [21] = "http://i.imgur.com/5xfNq82.gif";
        catPicsArray [22] = "http://i.imgur.com/nLwiod0.gif";
        catPicsArray [23] = "http://i.imgur.com/4nmgRLR.gif";
        catPicsArray [24] = "http://i.imgur.com/KqgdiBH.gif";
        catPicsArray [25] = "http://i.imgur.com/j3PYjtJ.gif";
        catPicsArray [26] = "http://i.imgur.com/kNIBvRs.gif";
        catPicsArray [27] = "http://i.imgur.com/EH7PhPo.gif";


        Random rand = new Random();
        int randomint = rand.nextInt(28);
        return catPicsArray[randomint];

    }


}
