package com.aixjing.week3.MarkovWord;

import edu.duke.FileResource;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;


public class MarkovWordTwoTest {

    String text = "this is just a test yes this is a simple test";
    MarkovWordTwo markovWordTwo = new MarkovWordTwo(text,42);
    FileResource fr = new FileResource("src/main/resources/week3/confucius.txt");
    MarkovRunner markovRunner = new MarkovRunner(fr, 832, 200);

    @Test
    public void markovRunnerTest () {
        markovRunner.runMarkovTwo();
    }
}