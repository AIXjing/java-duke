package com.aixjing.week4;

import org.junit.Test;

import static org.junit.Assert.*;

public class BabyBirthsTest {

    BabyBirths babybirth = new BabyBirths();

    @Test
    public void numBirthsTest() {
        babybirth.numBirths();
    }

    @Test
    public void getRankTest() {
        Integer rank = babybirth.getRank(2012, "Mason", "M");
        System.out.println("The rank of the name in the year is " + rank);

        String nameInYear = babybirth.getName(2013, rank, "M");
        System.out.println("Mason in 2013 is " + nameInYear);
    }

    @Test
    public void whatIsNameInYearTest() {
        babybirth.whatIsNameInYear("Isabella", 2012, 2014, "F");
    }

    @Test
    public void yearOfHighestRankTest(){
        Integer yearofhighestrank = babybirth.yearOfHighestRank("Mason", "M");
        System.out.println(yearofhighestrank);
    }
}