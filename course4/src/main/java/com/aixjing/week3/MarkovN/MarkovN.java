package com.aixjing.week3.MarkovN;
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
  private int myOrder;

  // constructor with a file source
  public MarkovN(FileResource fr, int order) {
    String st = fr.asString();
    st = st.replace('\n', ' ');
    this.myRandom = new Random();
    this.myText = st.trim();
    this.myOrder = order;
  }

  public MarkovN(String string, int order) {
    String st = string.replace('\n', ' ');
    this.myRandom = new Random();
    this.myText = st.trim();
    this.myOrder = order;
  }

  // another constructor method which can set seed in random
  public MarkovN(FileResource fr, int seed, int order) {
    String st = fr.asString();
    st = st.replace('\n', ' ');
    this.myRandom = new Random(seed);
    this.myText = st.trim();
    this.myOrder = order;
  }

  public String getMyText() {
    return this.myText;
  }

  public void setMyRandom(int seed) {myRandom = new Random(seed);}

  // generates and returns random text that is numChars long
  public String getRandomText(int numChars) {
    if (myText == null) {
      return "";
    }
    StringBuilder sb = new StringBuilder();
    if(myOrder == 0) {
      for(int k=0; k < numChars; k++){
        int index = myRandom.nextInt(myText.length());
        sb.append(myText.charAt(index));
      }
      return sb.toString();
    }
    HashMap<String, ArrayList<Character>> keyMap = generateMap(myOrder);
    // initialize to generate the random text
    int index = this.myRandom.nextInt(this.myText.length() - myOrder);
    String key = this.myText.substring(index, index + myOrder);
    sb.append(key);
    for (int k = myOrder - 1; k < numChars - myOrder; k++) {
      ArrayList<Character> follows = keyMap.get(key);
      if (follows.equals(null)) {
        break;
      }
      int indexOfNext = myRandom.nextInt(follows.size());
      Character next = follows.get(indexOfNext);
      sb.append(next);
      key = sb.substring(k-myOrder+2);
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

    int max = 0;
    String kMax = "";
    ArrayList<Character> maxOfList = null;
    for (String k : keyMap.keySet()) {
      if (keyMap.get(k).size() > max) {
        max = keyMap.get(k).size();
        kMax = k;
        maxOfList = keyMap.get(k);
      }
    }
//    System.out.println("The number of keys :" + keyMap.size() + " with " + max + " follows");
//    System.out.println("The key is " + kMax);
//    System.out.println("follows: " + maxOfList.toString());
    return keyMap;
  }

}
