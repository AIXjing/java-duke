package com.aixjing.week3.course;
/**
 * Abstract class AbstractMarkovModel - write a description of the class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */

import java.util.*;

public abstract class AbstractMarkovModel implements IMarkovModel {
    protected String myText;
    protected Random myRandom;
    
    public AbstractMarkovModel() {
        myRandom = new Random();
    }
    
    public void setTraining(String s) {
        myText = s.trim();
    }

    public void setRandom(int seed) {
        this.myRandom = new Random(seed);
    }

    abstract public String getRandomText(int numChars);

    protected ArrayList<String> getFollows(String key) {
        ArrayList<String> followers = new ArrayList<>();
        //		for (int i = 0; i < this.myText.length() - 1; i++) {
        //			if (this.myText.charAt(i) == key) {
        //				followers.add(this.myText.substring(i + 1, i + 2));
        //			}
        //		}
        int keySize = key.length();
        for (int i = 0; i < myText.length() - keySize - 1; i++) {
            if (key.equals(myText.substring(i, i + keySize))) {
                followers.add(myText.substring(i + keySize, i + keySize + 1));
            }
        }
        return followers;
    }

    protected HashMap<String, ArrayList<Character>> generateMap(int keyLen) {
        HashMap<String, ArrayList<Character>> keyMap = new HashMap<>();
        int textLen = this.myText.length();
        for (int i = 0; i < textLen - keyLen; i++) {
            String key = this.myText.substring(i, i + keyLen);
            if (!keyMap.containsKey(key)) {
                Character ch = this.myText.charAt(i + keyLen);
                ArrayList<Character> keyFollowers = new ArrayList<>();
                keyFollowers.add(ch);
                keyMap.put(key, keyFollowers);
            } else {
                Character ch = this.myText.charAt(i + keyLen);
                keyMap.get(key).add(ch);
            }
        }
        keyMap.put(this.myText.substring(textLen - keyLen, textLen), new ArrayList<Character>() );
        return keyMap;
    }

}
