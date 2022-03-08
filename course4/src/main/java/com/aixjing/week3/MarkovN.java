package com.aixjing.week3;
/**
 * A created MarkovFour Class, but it is a general way not limited to key with length four
 *
 * @author Jing Ai
 * @version 1.0
 */
import edu.duke.FileResource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class MarkovN {
  private String myText; // training test
  private Random myRandom;

  // constructor with a filesource
  public MarkovN(FileResource fr) {
    String st = fr.asString();
    st = st.replace('\n', ' ');
    this.myRandom = new Random();
    this.myText = st.trim();
  }

  public MarkovN(String string) {
    String st = string.replace('\n', ' ');
    this.myRandom = new Random();
    this.myText = st.trim();
  }

  // another constructor method which can set seed in random
  public MarkovN(FileResource fr, int seed) {
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
    if(keyLen == 0) {
      for(int k=0; k < numChars; k++){
        int index = myRandom.nextInt(myText.length());
        sb.append(myText.charAt(index));
      }
      return sb.toString();
    }
    HashMap<String, ArrayList<Character>> keyMap = generateMap(keyLen);
    // initialize to generate the random text
    int index = this.myRandom.nextInt(this.myText.length() - keyLen);
    String key = this.myText.substring(index, index + keyLen);
    sb.append(key);
    for (int k = keyLen - 1; k < numChars - keyLen; k++) {
      ArrayList<Character> follows = keyMap.get(key);
      if (follows.equals(null)) {
        break;
      }
      int indexOfNext = myRandom.nextInt(follows.size());
      Character next = follows.get(indexOfNext);
      sb.append(next);
      key = sb.substring(k-keyLen+2);
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

}
