package com.aixjing.week3.MarkovWord;

import edu.duke.FileResource;
import org.junit.Test;


public class MarkovWordOneTest {
    String text = "this is just a test yes this is a simple test";
    MarkovWordOne markovWordOne = new MarkovWordOne(text, 42);
    FileResource fr = new FileResource("src/main/resources/week3/confucius.txt");
    MarkovWordOne markovWordOneFr = new MarkovWordOne(fr, 175);

    MarkovRunner markovRunner = new MarkovRunner(fr, 139, 200);

    @Test
    public void getFollowsTest () {
        // the following works only if getFollows turns to public.
//    System.out.println(markovWordOne.getFollows("is").toString());
//        System.out.println(markovWordOne.generateMap().toString());

        markovRunner.runMarkovOne();
    }

}