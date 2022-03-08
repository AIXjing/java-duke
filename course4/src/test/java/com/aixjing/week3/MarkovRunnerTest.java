package com.aixjing.week3;

import edu.duke.FileResource;
import org.junit.Test;

public class MarkovRunnerTest {
    FileResource fr = new FileResource("src/main/resources/week3/confucius.txt");
    MarkovRunner markovRunner = new MarkovRunner(fr, 365,8);

    @Test
    public void runMarkovTest (){
//        markovRunner.runMarkovZero();
//        markovRunner.runMarkovOne();
        markovRunner.runMarkovN();
    }

}