package com.aixjing.week4; /**
 * Print out the names for which 100 or fewer babies were born in a chosen CSV file of baby name data.
 *
 * @author Duke Software Team
 */

import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

public class BabyNameRecords {

    // create fields
    // private means that other users cannot see these fields
    private final List<CSVRecord> csvRecords;
    private int year;

    // build a constractor
    private BabyNameRecords(CSVParser parser, int year) {
        this.csvRecords = parser.stream().collect(Collectors.toList());
        this.year = year;
    }

    // builder, static factory method - build an object from fr and year
    // static method is the method do not need an instance/object
    public static BabyNameRecords createFromFile(FileResource fr, int year) {
        CSVParser parser = fr.getCSVParser(false);
        return new BabyNameRecords(parser, year);
    }

    // builder - build an object from year
    public static BabyNameRecords createFromYear(int year) {
        String fName = "src/main/resources/week4/babydata/yob" + year + ".csv"; // test file
        FileResource fr = new FileResource(fName);
        return BabyNameRecords.createFromFile(fr, year);
    }

    // to get year in the object
    public int getYear() {
        return year;
    }

    public void totalNames() {
        int BoyName = 0;
        int GirlName = 0;
        for (CSVRecord rec : this.csvRecords) {
            String gender = rec.get(1);
            if (gender.equals("F")) {
                GirlName += 1;
            } else {
                BoyName += 1;
            }
        }
        System.out.println("Year: " + this.getYear());
        System.out.println("Total number of names: " + this.csvRecords.size());
        System.out.println("Total Boy's name: " + BoyName);
        System.out.println("Total Girl's name: " + GirlName);
    }

    public int getRank(String name, String gender) {
        int rank = 0;
        for (CSVRecord rec : this.csvRecords) {
            String currGender = rec.get(1);
            if (currGender.equals(gender)) {
                rank += 1;
                String currName = rec.get(0);
                if (currName.equals(name)) {
                    return rank;
                }
            }
        }
        return Integer.MAX_VALUE;
    }

    public int getTotalBirthsRankedHigher(String name, String gender) {
        int rank = this.getRank(name,gender);
        int currRank = 0;
        int totalBirths = 0;
        for (CSVRecord rec : this.csvRecords){
            if(gender.equals(rec.get(1))) {
                currRank += 1;
                if(currRank < rank) {
                    int currBirths = Integer.parseInt(rec.get(2));
                    totalBirths += currBirths;
                }
            }
        }
        return totalBirths;
    }

    public String getName(int rank, String gender) {
        int currRank = 0;
        for (CSVRecord rec : this.csvRecords) {
            if (rec.get(1).equals(gender)) {
                currRank += 1;
                if (currRank == rank) {
                    return rec.get(0);
                }
            }
        }
        return "NO NAME";
    }

    public static void whatIsNameInYear(String name, Integer year, Integer newYear, String gender) {
        int rank = BabyNameRecords.createFromYear(year).getRank(name, gender);
        String nameInNewYear = BabyNameRecords.createFromYear(newYear).getName(rank, gender);
        System.out.println(name + " born in " + year + " would be " + nameInNewYear + " if he/she was born in " + newYear);
    }

    public static void getRankInfo(String name, String gender) {
        // set parameters to find the highest rank
        Integer highestRank = 0;
        Integer highestRankYear = 0;
        // set parameters to find the average rank
        Integer totalRank = 0;
        Integer count = 0;

        DirectoryResource Dr = new DirectoryResource();
        for (File file : Dr.selectedFiles()) {
            // extract year from file name
            String currFileName = file.getName();
            int currFileNameLen = currFileName.length();
            String yearStr = currFileName.substring(currFileNameLen-1-7, currFileNameLen-1-3);
            // String yearString = currFileName.replaceAll("[^0-9]", ""); // this method can be improved.
            int currYear = Integer.parseInt(yearStr);

            FileResource fr = new FileResource(file);
            BabyNameRecords currBabyBirths = BabyNameRecords.createFromFile(fr,currYear);
            // update total Rank and count
            int currRank = currBabyBirths.getRank(name, gender);
            System.out.println(currYear + ": " + currRank);
            if(currRank != Integer.MAX_VALUE){
                totalRank += currRank;
                count += 1;
            }

            // update the highest rank
            if (highestRank.equals(0)) {
                highestRank = currRank;
                highestRankYear = currYear;
            } else {
                if (highestRank > currRank) {
                    highestRank = currRank;
                    highestRankYear = currYear;
                }
            }
        }
        if (highestRankYear.equals(0)) {
            System.out.println("Name not Found.");
        }
        System.out.println(name + " has the highest rank in " + highestRankYear);
        System.out.println("Average rank of name " + name + " is " + (double) totalRank / (double) count);
    }

}
