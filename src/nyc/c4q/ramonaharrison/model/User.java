package nyc.c4q.ramonaharrison.model;

import org.json.simple.JSONObject;


public class User {
    private String userInput;


    // TODO: implement private fields for each of the following user JSON keys:
    private String id;   // "id"
    private String pigLatin;   // "name"
    // "deleted"
    // "color"
    // "profile"
    // "is_admin"
    // "is_owner"
    // "is_primary_owner"
    // "is_restricted"
    // "is_ultra_restricted"
    // "has_2fa"
    // "two_factor_type"
    // "has_files"

    public User(JSONObject json) {


        // TODO: parse a user from the incoming json
    }

    public String getUserInput() {
        return userInput;
    }

    public String getPigLAtin() {
        return pigLatin;
    }

    public String getId() {
        return id;
    }

    public void setUserInput(String userInput) {
        this.userInput = userInput;

    }

    public void setPigLAtin(String pigLAtin) {

        this.pigLatin = pigLatin;
    }

    public void translate(JSONObject json) {
        if (json.get("userInput") != null) {
            this.userInput = (String) json.get("userInput");

        }
        if (json.get("pigLatin") != null) {
            this.pigLatin = pigLatin;
        }
    }

    public String wordToPigLatin(String word) {
        String wordSubstring = word.substring(1);
        char firstChar = word.charAt(0);
        String ay = "ay";
        String nonLowerCaseResult = wordSubstring + firstChar + ay;
        return nonLowerCaseResult.toLowerCase();
    }

    public String sentenceToPigLatin(String sentence) {
        String[] wordArray = sentence.split(" ");
        for (int i = 0; i < wordArray.length; i++) {
            // v3
            String word = wordArray[i];
            String pigLatin = wordToPigLatin(word);
            wordArray[i] = pigLatin;
        }

        String pigLatinSentence = "";
        for (int i = 0; i < wordArray.length; i++) {
            String space = " ";
            pigLatinSentence += wordArray[i];

            int lastIndex = wordArray.length - 1;
            if (i != lastIndex) {
                pigLatinSentence += space;
            }
        }
        return capitlize(pigLatinSentence);

    }

    public String capitlize(String sentence) {
        String firstLetter= sentence.substring(0,1);
        String capFirstLetter=firstLetter.toUpperCase();
        String restOfSentence= sentence.substring(1);
        return capFirstLetter+restOfSentence;
    }


    // TODO add getters to access private fields
}


