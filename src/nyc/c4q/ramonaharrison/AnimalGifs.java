package nyc.c4q.ramonaharrison;

import java.util.Random;

/**
 * Created by jordansmith on 9/16/16.
 */
public class AnimalGifs {


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

    public static String dogPics(){
        String [] dogPicsArray = new String [21];
        dogPicsArray[0] = "http://i.imgur.com/mJRa4GD.gif";
        dogPicsArray[1] = "http://i.imgur.com/cOoXLpI.gif";
        dogPicsArray[2] = "http://i.imgur.com/DI4bf50.gif";
        dogPicsArray[3] = "http://i.imgur.com/9nROuQm.gif";
        dogPicsArray[4] = "http://i.imgur.com/4mMMYPF.gif";
        dogPicsArray[5] = "http://i.imgur.com/zyk2jFL.gif";
        dogPicsArray[6] = "http://i.imgur.com/R9ovCJh.gif";
        dogPicsArray[7] = "http://i.imgur.com/ow2o1bM.gif";
        dogPicsArray[8] = "http://i.imgur.com/hRUJSRv.gif";
        dogPicsArray[9] = "http://i.imgur.com/m6mZY6K.gif";
        dogPicsArray[10] = "http://i.imgur.com/pCmV1uv.gif";
        dogPicsArray[11] = "http://i.imgur.com/QRixBl4.gif";
        dogPicsArray[12] = "http://i.imgur.com/cUYg2a8.gif";
        dogPicsArray[13] = "http://i.imgur.com/yFcHOv4.gif";
        dogPicsArray[14] = "http://i.imgur.com/DJvGKg9.gif";
        dogPicsArray[15] = "http://i.imgur.com/2FMwZuV.gif";
        dogPicsArray[16] = "http://i.imgur.com/jggkck1.gif";
        dogPicsArray[17] = "http://i.imgur.com/R3ZnXeR.gif";
        dogPicsArray[18] = "http://i.imgur.com/FcWJwYM.gif";
        dogPicsArray[19] = "http://i.imgur.com/pbHDghc.gif";
        dogPicsArray[20] = "http://i.imgur.com/RgxRyUu.gif";

        Random rand = new Random();
        int randomint = rand.nextInt(21);
        return dogPicsArray[randomint];



    }


}
