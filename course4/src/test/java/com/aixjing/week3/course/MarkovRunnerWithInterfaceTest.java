package com.aixjing.week3.course;


import edu.duke.FileResource;
import org.junit.Test;

public class MarkovRunnerWithInterfaceTest {
    FileResource fr = new FileResource("src/main/resources/week3/confucius.txt");
    MarkovRunnerWithInterface mRunInterface = new MarkovRunnerWithInterface(fr, 200, 42);


    @Test
    public void runMarkovTest() {
        mRunInterface.runMarkov();
    }

}