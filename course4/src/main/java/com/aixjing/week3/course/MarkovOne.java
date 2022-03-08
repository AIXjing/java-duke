package com.aixjing.week3.course;
/**
 * MarkovOne
 *
 * @author Jing Ai
 * @version 2022-03-08
 */
import java.util.ArrayList;
import java.util.Random;

public class MarkovOne extends AbstractMarkovModel {
  private int keySize = 1;

  public MarkovOne() {
    myRandom = new Random();
  }

  public void setRandom(int seed) {
    myRandom = new Random(seed);
  }

  public void setTraining(String s) {
    myText = s.trim();
  }

  public int getKeySize() {return keySize;}

  public String getRandomText(int numWords) {
    if (myText == null) {
      return "";
    }
    StringBuilder sb = new StringBuilder();
    int index = myRandom.nextInt(myText.length() - 1); // random word to start with
    String key = myText.substring(index, index + 1);
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
}
