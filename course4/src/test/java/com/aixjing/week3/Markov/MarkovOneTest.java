package com.aixjing.week3.Markov;

import com.aixjing.week3.MarkovN.MarkovOne;
import edu.duke.FileResource;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

public class MarkovOneTest {
  String source = "this is a test yes this is a test.";
  MarkovOne markovOneStr = new MarkovOne(source);

  FileResource fr = new FileResource("src/main/resources/week3/romeo.txt");
  MarkovOne markovOneFr = new MarkovOne(fr);
  MarkovOne markovOneFrSeed = new MarkovOne(fr, 365);

  @Test
  public void getRandomTextTest() {
//      markovOneFrSeed.getRandomText(100,1);
  }

  @Test
  public void generatedMapTest() {
    //          System.out.println(markovOneStr.generateMap(2).toString());
    HashMap<String, ArrayList<Character>> keyMap = markovOneFrSeed.generateMap(1);
    // to check whether getFlowers and generateMap will give the same result.
    System.out.println(keyMap.get(" ").size());
    System.out.println(markovOneFrSeed.getFollows(" ").size());
  }

  @Test
  public void getFollowsTest() {
    FileResource fr = new FileResource("src/main/resources/week3/confucius.txt");
    MarkovOne markovOneFr = new MarkovOne(fr);
    System.out.println(markovOneFr.getFollows("he").size());
  }
}
