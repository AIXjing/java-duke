package com.aixjing.week3.InterfaceAndAbstract;


import edu.duke.FileResource;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

public class MarkovRunnerWithInterfaceTest {
    FileResource fr = new FileResource("src/main/resources/week3/confucius.txt");
    MarkovRunnerWithInterface mRunInterface = new MarkovRunnerWithInterface(fr, 200, 365);

    String text = "yes-this-is-a-thin-pretty-pink-thistle";

    @Test
    public void runMarkovTest() {
//        mRunInterface.runMarkov();
        HashMap<String, ArrayList<Character>> keyMap = mRunInterface.testHashMap(text, 365);
    System.out.println(keyMap.size());
        for (String key: keyMap.keySet()) {
            System.out.println(key + ": " + keyMap.get(key));
        }
    }

    @Test
    public void hashMapText() {
        FileResource fr = new FileResource("src/main/resources/week3/romeo.txt");
        MarkovRunnerWithInterface mRunInterface = new MarkovRunnerWithInterface(fr, 200, 615);
        HashMap<String, ArrayList<Character>> keyMap = mRunInterface.testHashMapModel(5);
        int max = 0;
        for (String key : keyMap.keySet()) {
            if(keyMap.get(key).size() > max ) max = keyMap.get(key).size();
        }
        System.out.println(max);
    }

}