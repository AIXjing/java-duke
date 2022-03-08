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

}
