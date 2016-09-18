package nyc.c4q.ramonaharrison.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Millochka on 9/14/16.
 */
public class Words {

    public Words(){

        this.initOfReplaceable(this.getReplaceable());
        this.initOfReplacement(this.getReplacemnet());

        this.prepareReplacement(mReplaceable, mReplacement);

    }

    private Map<String, String> mWord= new HashMap<>();
    private List<String> mReplaceable= new ArrayList<>();

    String[] s={};

    private List<String> mReplacement=new ArrayList<>();

    public List<String> getmReplaceable(){

        return mReplaceable;
    }

    public List<String> getmReplacement(){

        return mReplacement;
    }

    public Map<String, String> getmWord(){

        return mWord;
    }



    public String[] getReplaceable(){
        return replaceable;
    }

    public String[] getReplacemnet(){
        return replacemnet;
    }


    public void initOfReplacement(String[] replacement){
        for(int i=0;i<replacement.length;i++)
            mReplacement.add(replacement[i]);


    }


    public void initOfReplaceable(String[] replaceable){
        for(int i=0;i<replaceable.length;i++)
            mReplaceable.add(replaceable[i]);


    }


    public void prepareReplacement(List<String> mReplaceable, List<String> mReplacement){
        //if(mReplaceable.size()==mReplacement.size()){
        for(int i=0; i< mReplaceable.size();i++)
        mWord.put(mReplaceable.get(i),mReplacement.get(i));//}

//        else{
//            System.out.println("Please make sure your Array of replaceable items is the same size with Array of replacemnets");
//        }

    }



    private String[] replaceable = {"really",
            "crap" ,
            "father" ,
            "dad",
            "mom",
            "mother",
            "come",
            "buck",
            "minute",
    "gun",
            "sure",
            "pregnant",
    "big",
            "hard",
    "tight",
            "wet",
    "head" ,
            "balls",
    "ball ",
            "shaft" ,
    "justin bieber" ,
            "jj" ,
            "6 ",
            "women" ,
    "thing" ,
            "weed" ,
    "punch" ,
            "sex ",
        "while" ,
    "dirty "};


    private String[] replacemnet = {
            "mad",
            "shiiiii",
             "Baby Daddy",
            "Baby Daddy",
           "Baby Momma",
            "Baby Momma",
            "skeet",
            "$100 Dollars",
            "long time",
    "chopper",
            "Fo Shizzle",
            "Prego",
    "pause",
             "pause",
    "pause",
            "pause",
    "pause",
           "pause",
    "pause",
             "pause",
     "She Rocks",
             "Hey!!!",
             "Drake",
             "Chick",
    "joint",
             "joint",
    "knock",
            "smash",
"A minute",
     "grimey"

    };
}
