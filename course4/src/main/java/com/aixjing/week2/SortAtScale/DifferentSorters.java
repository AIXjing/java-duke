package com.aixjing.week2.SortAtScale;
/**
 * Write a description of class DifferentSorters here.
 * 
 * @author Jing
 * @version 06-03-2022
 */

import java.util.*;
import java.util.stream.Collectors;

public class DifferentSorters {

    ArrayList<QuakeEntry> quakeEntries;
    ArrayList<QuakeEntry> quakeEntriesCopy;

    public DifferentSorters(String source) {
        EarthQuakeParser parser = new EarthQuakeParser();
        this.quakeEntries = parser.read(source);
        quakeEntriesCopy = quakeEntries.stream().collect(Collectors.toCollection(ArrayList::new));
    }

    public void sortWithCompareTo() {
        Collections.sort(quakeEntriesCopy);
//        quakeEntriesCopy.forEach(System.out::println);
        int quakeNumber = 600;
        System.out.println("Print quake entry in position " + quakeNumber);
        System.out.println(quakeEntriesCopy.get(quakeNumber));
    }    

    public void sortByMagnitude() {
        Collections.sort(quakeEntriesCopy, new MagnitudeComparator());
//        quakeEntriesCopy.forEach(System.out::println);
//        for (int i = 0; i < 10; i++) System.out.println(quakeEntriesCopy.get(i).toString());
    }

    public void sortByDistance() {
        // Location is Durham, NC
        Location where = new Location(35.9886, -78.9072);
        Collections.sort(quakeEntriesCopy, new DistanceComparator(where));
        quakeEntriesCopy.forEach(System.out::println);
    }

    public void sortByTitleAndDepth() {
        Collections.sort(quakeEntriesCopy, new TitleAndDepthComparator());
//        quakeEntriesCopy.forEach(System.out::println);
        int quakeNumber = 500;
        System.out.println("Print quake entry in position " + quakeNumber);
        System.out.println(quakeEntriesCopy.get(quakeNumber));
    }

    public void TitleLastAndMagnitudeComparator() {
        Collections.sort(quakeEntriesCopy, new TitleLastAndMagnitudeComparator());
//        quakeEntriesCopy.forEach(System.out::println);
        int quakeNumber = 500;
        System.out.println("Print quake entry in position " + quakeNumber);
        System.out.println(quakeEntriesCopy.get(quakeNumber));
    }
}
