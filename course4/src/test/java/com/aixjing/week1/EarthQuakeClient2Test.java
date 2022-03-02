package com.aixjing.week1;


import org.junit.Test;

import java.util.ArrayList;

public class EarthQuakeClient2Test {
    String source = "/Users/jingai/workspace/JAVA-Duke/course4/src/main/resources/week1/nov20quakedata.atom";
    // String source = "https://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
    EarthQuakeClient2 earthQuakeClient2 = new EarthQuakeClient2(source);

    @Test
    public void quakesWithFilter() {
//        earthQuakeClient2.quakesWithMinMagFilter(5.0);
//        earthQuakeClient2.quakesByPhrase("any", "California");
//        ArrayList<QuakeEntry> quakes = earthQuakeClient2.quakesByFilters(4.0,5.0,-35000.0,-12000.0);
//        quakes.forEach(System.out::println);
//        System.out.println("found " + quakes.size() + " quakes.");
        earthQuakeClient2.testMatchAllFilter();

    }

}