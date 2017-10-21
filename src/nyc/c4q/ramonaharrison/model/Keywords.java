package nyc.c4q.ramonaharrison.model;
import java.util.*;
import java.net.*;

public class Keywords  {

    public Keywords(){
        addWord("sad");
        addWord("happy");
        addWord("anxious");
        addWord("content");
        addWord("hurt");
        addWord("insulted");
        addWord("lyrical");
    }

    private HashMap<Character, ArrayList<String>>words = new HashMap<>();

    private char getFirstLetter(String string){
        char[] word = string.toCharArray();
        return word[1];
    }

    private void addWord(String string){
        if(words.containsKey(getFirstLetter(string))) {
            words.get(getFirstLetter(string)).add(string);
        } else {
            ArrayList<String> thisLetter = new ArrayList();
            thisLetter.add(string);
            words.put(getFirstLetter(string),thisLetter);
        }
    }

    private boolean searchFor(String string){
        return words.get(getFirstLetter(string)).contains(string);
    }
}



