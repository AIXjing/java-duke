package com.aixjing.week1;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
public class ClosestQuakesTest {


    @Test
    public void getClosestTest() {
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "https://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> quakeData  = parser.read(source);

        Location loc = new Location(-6.211, 106.845);
        ArrayList<QuakeEntry> closestList = ClosestQuakes.getClosest(quakeData, loc, 10);
        closestList.stream().forEach(System.out::println);

    }
}