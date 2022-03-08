package com.aixjing.week3.course;
/**
 * MarkovModel
 *
 * @author Jing Ai
 * @version 2022-03-08
 */
import java.util.ArrayList;
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

  public int getKeySize() {return keySize;}


  public void setTraining(String s) {
    myText = s.trim();
  }

  public String getRandomText(int numWords) {
    if (myText == null) {
      return "";
    }
    StringBuilder sb = new StringBuilder();
    int index = myRandom.nextInt(myText.length() - keySize); // random word to start with
    String key = this.myText.substring(index, index + keySize);
    sb.append(key);
    //    sb.append(" ");
    for (int k = keySize - 1; k < numWords - keySize; k++) {
      ArrayList<String> follows = getFollows(key);
      if (follows.size() == 0) {
        break;
      }
      int indexOfNext = myRandom.nextInt(follows.size());
      String next = follows.get(indexOfNext);
      sb.append(next);
      key = sb.substring(k - keySize + 2);
    }
    return sb.toString().trim();
  }

}
