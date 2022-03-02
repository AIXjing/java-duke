package com.aixjing.week1;

import org.junit.Test;

import java.util.ArrayList;

public class EarthQuakeClientTest {
    String source = "/Users/jingai/workspace/JAVA-Duke/course4/src/main/resources/week1/nov20quakedata.atom";
    // String source = "https://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
    EarthQuakeClient earthQuakeClient = new EarthQuakeClient(source);

    @Test
    public void bigQuakesTest() {
        earthQuakeClient.bigQuakes(5.0);
    }

    @Test
    public void closeToMeTest() {
        // Durham, NC
//         Location loc = new Location(35.988, -78.907);
        // Bridgeport, CA
         Location loc = new Location(38.17, -118.82);
        // ArrayList<QuakeEntry> close = filterByDistanceFrom(distMax, loc);
        earthQuakeClient.closeToMe(1000*1000, loc);
    }

    @Test
    public void quakesOfDepthTest() {
        earthQuakeClient.quakesOfDepth(-4000.0, -2000.0);
    }

    @Test
    public void quakesByPhraseTest() {
        earthQuakeClient.quakesByPhrase("any", "Can");
    }
}