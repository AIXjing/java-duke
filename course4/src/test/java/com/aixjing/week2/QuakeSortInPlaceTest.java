package com.aixjing.week2;

import org.junit.Test;

import java.util.ArrayList;

public class QuakeSortInPlaceTest {
    String source = "/Users/jingai/workspace/JAVA-Duke/course4/src/main/resources/week2/earthQuakeDataDec6sample1.atom";
    QuakeSortInPlace quakeSortInPlace = new QuakeSortInPlace(source);

    @Test
    public void QuakeSortByMagTest () {
//        quakeSortInPlace.getQuakeEntriesCopy().forEach(System.out::println);

        System.out.println("this is quakeEntries sorted by magnitude");
        ArrayList<QuakeEntry> sortedQuakes = quakeSortInPlace.sortByMagnitude();
        sortedQuakes.forEach(System.out::println);

//        System.out.println("this is quakeEntries");
//        quakeSortInPlace.getQuakeEntries().forEach(System.out::println);
    }

    @Test
    public void QuakeSortByDepthTest () {
//        quakeSortInPlace.getQuakeEntriesCopy().forEach(System.out::println);

        System.out.println("this is quakeEntries sorted by Depth");
        ArrayList<QuakeEntry> sortedQuakes = quakeSortInPlace.sortByLargestDepth();
        sortedQuakes.forEach(System.out::println);
    }

    @Test
    public void BubbleSortTest () {
//        quakeSortInPlace.getQuakeEntries().forEach(System.out::println);

        System.out.println("this is quakeEntries sorted by magnitude using Bubble sort");
        ArrayList<QuakeEntry> sortedQuakes = quakeSortInPlace.sortByMagnitudeWithBubbleSort();
        sortedQuakes.forEach(System.out::println);
    }

}