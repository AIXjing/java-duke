package com.aixjing.week1;

import org.junit.Test;

import java.util.ArrayList;

public class LargestQuakesTest {
    String source = "/Users/jingai/workspace/JAVA-Duke/course4/src/main/resources/week1/nov20quakedata.atom";
    LargestQuakes largestQuakes = new LargestQuakes(source);

    @Test
    public void findLargestQuakeTest() {
        ArrayList<QuakeEntry> quakes = largestQuakes.getLargest(50);
        quakes.forEach(System.out::println);
    }
}