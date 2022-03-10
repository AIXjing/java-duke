package com.aixjing.week3.InterfaceAndAbstract;
/**
 * Abstract class AbstractMarkovModel - write a description of the class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
import java.util.Random;

public abstract class AbstractMarkovModelRaw implements IMarkovModel {
  protected String myText;
  protected Random myRandom;

  public AbstractMarkovModelRaw() {
    myRandom = new Random();
  }

  public void setTraining(String s) {
    myText = s.trim();
  }

  public abstract String getRandomText(int numChars);
}
