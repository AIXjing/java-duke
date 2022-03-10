package com.aixjing.week3.MarkovN;
/**
 * A created MarkovOne Class
 *
 * @author Jing Ai
 * @version 1.0
 */
import edu.duke.FileResource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class MarkovOne {
  private String myText; // training test
  private Random myRandom;

  // constructor with a filesource
  public MarkovOne(FileResource fr) {
    String st = fr.asString();
    st = st.replace('\n', ' ');
    this.myRandom = new Random();
    this.myText = st.trim();
  }

  public MarkovOne(String string) {
    String st = string.replace('\n', ' ');
    this.myRandom = new Random();
    this.myText = st.trim();
  }

  // another constructor method which can set seed in random
  public MarkovOne(FileResource fr, int seed) {
    String st = fr.asString();
    st = st.replace('\n', ' ');
    this.myRandom = new Random(seed);
    this.myText = st.trim();
  }

  public String getMyText() {
    return this.myText;
  }

  // generates and returns random text that is numChars long
  public String getRandomText(int numChars, int keyLen) {
    if (myText == null) {
      return "";
    }
    StringBuilder sb = new StringBuilder();
    HashMap<String, ArrayList<Character>> keyMap = generateMap(keyLen);
    // initialize to generate the random text
    int index = this.myRandom.nextInt(this.myText.length() - keyLen);
    String key = this.myText.substring(index, index + keyLen);
    sb.append(key);
    for (int k = keyLen - 1; k < numChars - keyLen; k++) {
      ArrayList<Character> follows = keyMap.get(key);
      if (follows == null) {
        break;
      }
      int indexOfNext = myRandom.nextInt(follows.size());
      Character next = follows.get(indexOfNext);
      sb.append(next);
      key = sb.substring(k-keyLen+2);
    }
    return sb.toString().trim();
  }

  // method provided in the course materials, only apply for MarkovOne
  public String getRandomTextOne(int numWords) {
    StringBuilder sb = new StringBuilder();
    int index = myRandom.nextInt(myText.length() - 1); // random word to start with
    String key = this.myText.substring(index, index + 1);
    sb.append(key);
//    sb.append(" ");
    for (int k = 0; k < numWords - 1; k++) {
      ArrayList<String> follows = getFollows(key);
      if (follows.size() == 0) {
        break;
      }
      index = myRandom.nextInt(follows.size());
      String next = follows.get(index);
      sb.append(next);
//      sb.append(" ");
      key = next;
    }
	return sb.toString().trim();
  }

  public HashMap<String, ArrayList<Character>> generateMap(int keyLen) {
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
    return keyMap;
  }

  public ArrayList<String> getFollows(String key) {
    ArrayList<String> followers = new ArrayList<>();
    //		for (int i = 0; i < this.myText.length() - 1; i++) {
    //			if (this.myText.charAt(i) == key) {
    //				followers.add(this.myText.substring(i + 1, i + 2));
    //			}
    //		}
    int keySize = key.length();
    for (int i = 0; i < this.myText.length() - keySize; i++) {
      if (key.equals(this.myText.substring(i, i + keySize))) {
        followers.add(this.myText.substring(i + keySize, i + keySize + 1));
      }
    }
    System.out.println("Follows size is " + followers.size());
    return followers;
  }
}
