package com.aixjing.week3.Markov;

import com.aixjing.week3.MarkovN.MarkovN;
import com.aixjing.week3.MarkovN.MarkovRunner;
import edu.duke.FileResource;
import org.junit.Test;

public class MarkovRunnerTest {

    @Test
    public void runMarkovTest (){
        FileResource fr = new FileResource("src/main/resources/week3/romeo.txt");
        MarkovRunner markovRunner = new MarkovRunner();
//        markovRunner.runMarkovN(fr,715, 4);
        markovRunner.runMarkovN(fr,953, 7);
    }

    @Test
    public void runMarkovZeroTest (){
        FileResource fr = new FileResource("src/main/resources/week3/confucius.txt");
        MarkovRunner markovRunner = new MarkovRunner();
//        markovRunner.runMarkovN(fr,365, 1);
        markovRunner.runMarkovZero(fr,1024);
    }

    @Test
    public void hashMapTest (){
        FileResource fr = new FileResource("src/main/resources/week3/confucius.txt");
        MarkovRunner markovRunner = new MarkovRunner();
//        markovRunner.runMarkovN(fr,365, 1);
        markovRunner.runMarkovN(fr,531, 5);
    }

}