package com.aixjing.week1;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
public class ClosestQuakesTest {
    EarthQuakeParser parser = new EarthQuakeParser();
    String source = "/Users/jingai/workspace/JAVA-Duke/course4/src/main/resources/week1/nov20quakedatasmall.atom";
    ClosestQuakes closestQuakes = new ClosestQuakes(source);

    @Test
    public void findClosestQuakes() {
        Location loc = new Location(-6.211, 106.845);
        closestQuakes.findClosestQuakes(loc, 3);
    }

}