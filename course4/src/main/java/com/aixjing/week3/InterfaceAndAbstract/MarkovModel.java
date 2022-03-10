package com.aixjing.week3.InterfaceAndAbstract;
/**
 * MarkovModel
 *
 * @author Jing Ai
 * @version 2022-03-08
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class MarkovModel extends AbstractMarkovModel {
  private int keySize;

  public MarkovModel(int keySize) {
    myRandom = new Random();
    this.keySize = keySize;
  }

  public void setRandom(int seed) {
    myRandom = new Random(seed);
  }

  public int getKeySize() {
    return keySize;
  }

  public void setTraining(String s) {
    myText = s.trim();
  }

  public String getRandomText(int numChars) {
    if (myText == null) {
      return "";
    }
    StringBuilder sb = new StringBuilder();
    if(keySize == 0) {
      for(int k=0; k < numChars; k++){
        int index = myRandom.nextInt(myText.length());
        sb.append(myText.charAt(index));
      }
      return sb.toString();
    }
    HashMap<String, ArrayList<Character>> keyMap = generateMap(keySize);
    // initialize to generate the random text
    int index = this.myRandom.nextInt(this.myText.length() - keySize);
    String key = this.myText.substring(index, index + keySize);
    sb.append(key);
    for (int k = keySize - 1; k < numChars - keySize; k++) {
      ArrayList<Character> follows = keyMap.get(key);
      int indexOfNext = myRandom.nextInt(follows.size());
      Character next = follows.get(indexOfNext);
      sb.append(next);
      key = sb.substring(k-keySize+2);
    }
    return sb.toString().trim();
  }
}
