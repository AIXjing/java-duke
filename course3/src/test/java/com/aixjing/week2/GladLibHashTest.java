package com.aixjing.week2;

import edu.duke.FileResource;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.HashMap;

public class GladLibHashTest {
  GladLibHash gladLibHash = new GladLibHash("week2/data");

  @Test
  public void makeStoryTest(){
    gladLibHash.makeStory();
    System.out.println();

    int totReplace = gladLibHash.totalWordsInMap();
    System.out.println("There are " + totReplace + " possible words to replace.");

    int totalWordsConsidered = gladLibHash.totalWordsConsidered();
    System.out.println("There are " + totalWordsConsidered + " total words considered");
  }
}
