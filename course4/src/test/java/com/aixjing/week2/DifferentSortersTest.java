package com.aixjing.week2;

import com.aixjing.week2.SortAtScale.DifferentSorters;
import junit.framework.TestCase;
import org.junit.Test;

public class DifferentSortersTest {

    String source = "/Users/jingai/workspace/JAVA-Duke/course4/src/main/resources/week2/earthQuakeDataWeekDec6sample2.atom";
    DifferentSorters differentSorters = new DifferentSorters(source);

    @Test
    public void sortWithCompareToTest() {
        differentSorters.sortWithCompareTo();
    }

    @Test
    public void sortByTitleAndDepthTest () {
        differentSorters.sortByTitleAndDepth();
//        System.out.println(differentSorters.quakeEntries.get(0).getInfo());
    }

    @Test
    public void TitleLastAndMagnitudeComparatorTest () {
        differentSorters.TitleLastAndMagnitudeComparator();
    }

}