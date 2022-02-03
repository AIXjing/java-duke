package com.aixjing.week4;

import org.junit.Test;

public class BabyNameRecordsTest {

//    static FileResource fr = new FileResource("src/main/resources/week4/babydata/example-small.csv");
    // String fname = "src/main/resources/week4/babydata/testing/yob" + year + "short.csv"; // test file
//    BabyBirths babybirth;

    @Test
    public void totalNamesTest() {
        // totalNames() is a static method, do not require an object
        BabyNameRecords.createFromYear(1905).totalNames();
    }

    @Test
    public void getRankTest() {
        // getRank() is a non-static method, which requires an object to call.
        BabyNameRecords records = BabyNameRecords.createFromYear(1990);

        int rank = records.getRank("Frank", "M");
        System.out.println("The rank of the name in the year is " + rank);

        String nameInYear = records.getName(rank, "M");
        System.out.println("Mason in 2013 is " + nameInYear);

        String name = records.getName(450, "M");
        System.out.println("Rank 450 Boy's name in 1982 is " + name);

        int totalBirthsHigherRank = records.getTotalBirthsRankedHigher("Drew", "M");
        System.out.println("Total births that the rank higher than the name: " + totalBirthsHigherRank );
    }

    @Test
    public void whatIsNameInYearTest() {
        BabyNameRecords.whatIsNameInYear("Owen", 1974, 2014, "M");
    }

    @Test
    public void rankInfoTest() {
        BabyNameRecords.getRankInfo("Mich", "M");
    }
}