package com.aixjing.week4; /**
 * Print out the names for which 100 or fewer babies were born in a chosen CSV file of baby name data.
 * 
 * @author Duke Software Team 
 */
import edu.duke.*;
import org.apache.commons.csv.*;

import java.io.File;

public class BabyBirths {

	public void numBirths () {
		FileResource fr = new FileResource("src/main/resources/week4/babydata/example-small.csv");
		int numBorn = 0;
		int numBoy = 0;
		int numGirl = 0;
		for (CSVRecord rec : fr.getCSVParser(false)) {
			String gender = rec.get(1);
			numBorn = Integer.parseInt(rec.get(2));
			if (gender.equals("F")) {
				numGirl += 1;
			}
			else { numBoy += 1; }
			numBorn += 1;
		}
		System.out.println("Total baby: " + numBorn);
		System.out.println("Total Boy: " + numBoy);
		System.out.println("Total Girl: " + numGirl);
	}

	public int getRank(Integer year, String name, String gender){
		String fname = "src/main/resources/week4/babydata/testing/yob" + year + "short.csv"; // test file
		FileResource fr = new FileResource(fname);
		CSVParser birthRecords = fr.getCSVParser();
		Integer rank = 0;
		for(CSVRecord rec : birthRecords){
			String currGender = rec.get(1);
			if(currGender.equals(gender)){
				rank += 1;
				String currName = rec.get(0);
				if (currName.equals(name)){
					return rank;
				}
			}

		}
		return -1;
	}

	public String getName(Integer year, Integer rank, String gender){
		String fname = "src/main/resources/week4/babydata/testing/yob" + year + "short.csv";
		FileResource fr = new FileResource(fname);
		CSVParser birthRecords = fr.getCSVParser();
		Integer currRank = 0;
		for (CSVRecord rec : birthRecords){
			if(rec.get(1).equals(gender)){
				currRank += 1;
				if(currRank.equals(rank)){
					return rec.get(0);
				}
			}
		}
		return "NO NAME";
	}

	public void whatIsNameInYear(String name, Integer year, Integer newYear, String gender){
		Integer rank = getRank(year, name, gender);
		String nameInNewYear = getName(newYear, rank, gender);
		System.out.println(name + " born in " + year + " would be " + nameInNewYear + "if he/she was born in " + newYear);
	}

	public Integer yearOfHighestRank(String name, String gender){
		Integer highestRank = 0;
		Integer highestRankYear = 0;
		DirectoryResource Dr = new DirectoryResource();
		for (File file : Dr.selectedFiles()){
			String currFileName = file.getName();
			String yearString = currFileName.replaceAll("[^0-9]", "");
			Integer currYear = Integer.parseInt(yearString);
			Integer currRank = getRank(currYear, name, gender);
			if(highestRank.equals(0)){
				highestRank = currRank;
				highestRankYear = currYear;
			}
			else {
				if(highestRank > currRank) {
					highestRank = currRank;
					highestRankYear = currYear;
				}
			}
		}
		if(highestRankYear.equals(0)){ return -1; }
		return highestRankYear;
	}
}
