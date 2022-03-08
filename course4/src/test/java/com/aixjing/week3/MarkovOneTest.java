package com.aixjing.week3;

import edu.duke.FileResource;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

public class MarkovOneTest {
  String source = "this is a test yes this is a test.";
  MarkovOne markovOneStr = new MarkovOne(source);

  FileResource fr = new FileResource("src/main/resources/week3/confucius.txt");
  MarkovOne markovOneFr = new MarkovOne(fr);

  MarkovOne markovOneFrSeed = new MarkovOne(fr, 42);

  @Test
  public void getFollowersTest() {
    //        System.out.println(markovOneStr.getFollows(".").toString());
    //        System.out.println(markovOneFr.getFollows("t").size());
    //    HashMap<String, ArrayList<Character>> keyMap = markovOneStr.generateMap(1);
    //    System.out.println(keyMap.toString());

    //      String generated = markovOneStr.getRandomText(source.length(), 1);
    //    System.out.println(markovOneStr.generateMap(1).toString());
    //      System.out.println(generated);

    String generated1 = markovOneFrSeed.getRandomText(500, 1);
    //    System.out.println(markovOneFrSeed.generateMap(1).toString());
//          String generated2 = markovOneFrSeed.getRandomTextOne(500);
    System.out.println(generated1);
//          System.out.println(generated2);
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
    FileResource fr = new FileResource("src/main/resources/week3/melville.txt");
    MarkovOne markovOneFr = new MarkovOne(fr);
    System.out.println(markovOneFr.getFollows("th").size());
  }
}
