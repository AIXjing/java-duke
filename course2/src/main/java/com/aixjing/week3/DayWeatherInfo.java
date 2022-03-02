package com.aixjing.week3;

import edu.duke.DirectoryResource;
import edu.duke.FileResource;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

public class DayWeatherInfo {
    // Declare a field for this class
    private List<CSVRecord> csvRecords;

    // Construct the field to the class
    public DayWeatherInfo(CSVParser parser) {
        this.csvRecords = parser.stream().collect(Collectors.toList());
    }

    // a method to find the average T in a day
    public double avgTempInDay(){
        double tempSum = 0;
        int count = 0;
        for (CSVRecord row : this.csvRecords){
            double currTemp = Double.parseDouble(row.get("TemperatureF"));
            tempSum = currTemp + tempSum;
            count += 1;
        }
        return tempSum/(double) count;
    }

    // a static method (do not require an object) to find the highest T between two Ts
    public static CSVRecord largestOfTwoTemp (CSVRecord curr, CSVRecord highest){
        if(highest == null){
            highest = curr;
        }
        else {
            double currTemp = Double.parseDouble(curr.get("TemperatureF"));
            double hottestTemp = Double.parseDouble(highest.get("TemperatureF"));
            if(currTemp > hottestTemp){
                highest = curr;
            }
        }
        return highest;
    }

    // a method need a specific DayTemperature object for finding the highest T in a day.
    public CSVRecord hottestInDay (){
        CSVRecord maxTempSofar = null;
        for(CSVRecord currRow : this.csvRecords){
            maxTempSofar = largestOfTwoTemp(currRow, maxTempSofar);
        }
        return maxTempSofar;
    }

    // a static method to find the highest T among different files.
    public static CSVRecord hottestInMany(){
        DirectoryResource Dr = new DirectoryResource();
        CSVRecord hottestSoFar = null;
        for (File file : Dr.selectedFiles()){
            FileResource fr = new FileResource(file);
            DayWeatherInfo dayWeatherInfo = new DayWeatherInfo(fr.getCSVParser());
            CSVRecord curr = dayWeatherInfo.hottestInDay();
            hottestSoFar = largestOfTwoTemp(curr,hottestSoFar);
        }
        return hottestSoFar;
    }

    // a static method to return the coldest T between two Ts record
    public static CSVRecord coldestOfTwoTemp (CSVRecord curr, CSVRecord coldest){
        if (coldest == null){
            coldest = curr;
        }
        else{
            double currTemp = Double.parseDouble(curr.get("TemperatureF"));
            double coldestTemp = Double.parseDouble(coldest.get("TemperatureF"));
            if(currTemp < coldestTemp && (currTemp != -9999 && coldestTemp != -9999)){ coldest = curr; }
        }
        return coldest;
    }

    // a method to return the lowest T in a day
    public CSVRecord coldestInDay(){
        CSVRecord coldestRecord = null;
        for(CSVRecord curr : this.csvRecords){
            coldestRecord = coldestOfTwoTemp(curr, coldestRecord);
        }
        return coldestRecord;
    }

    // a method to return the lowest T among different days
    public static CSVRecord coldestInMany(){
        DirectoryResource Dr = new DirectoryResource();
        CSVRecord coldestRecord = null;
        String coldestDayFileName = null;
        for(File file : Dr.selectedFiles()){
            FileResource fr = new FileResource(file);
            DayWeatherInfo dayRecord = new DayWeatherInfo(fr.getCSVParser());
            CSVRecord curr = dayRecord.coldestInDay();
            coldestRecord = coldestOfTwoTemp(curr, coldestRecord);
            if(coldestRecord.equals(curr)){ coldestDayFileName = file.getName(); }

        }
        System.out.println("Coldest day was in file " + coldestDayFileName);
        return coldestRecord;
    }

    // a method to compare the lowest humidity between two Days
    public static CSVRecord lowestOfTwoHumidity (CSVRecord currRecord, CSVRecord lowestHumidityRecord){
        if(lowestHumidityRecord == null){
            lowestHumidityRecord = currRecord;
        }
        else {
            if(!currRecord.get("Humidity").equals("N/A")){
                double currHumidity = Double.parseDouble(currRecord.get("Humidity"));
                double lowestHumidity = Double.parseDouble(lowestHumidityRecord.get("Humidity"));
                if(currHumidity < lowestHumidity){ lowestHumidityRecord = currRecord; }
            }
        }
        return lowestHumidityRecord;
    }

    // a method to find the lowest Humidity in a file
    public CSVRecord lowestHumidityInDay(){
        CSVRecord lowestHumidityRecord = null;
        for(CSVRecord currRecord : this.csvRecords){
            lowestHumidityRecord = lowestOfTwoHumidity(currRecord, lowestHumidityRecord);
        }
        return lowestHumidityRecord;
    }

    // a method to find the lowest Humidity in many files
    public static CSVRecord lowestHumidityInMany(){
        DirectoryResource Dr = new DirectoryResource();
        CSVRecord lowestHumadityRecord = null;
        for(File file : Dr.selectedFiles()){
            FileResource fr = new FileResource(file);
            DayWeatherInfo dayweatherinfo = new DayWeatherInfo(fr.getCSVParser());
            CSVRecord currRecord = dayweatherinfo.lowestHumidityInDay();
            lowestHumadityRecord = lowestOfTwoHumidity(currRecord, lowestHumadityRecord);
        }
        return lowestHumadityRecord;
    }

    // a method to return average T of Ts when the humidity was >= certain value
    public double avgTempHumidity(int value){
        double tempSum = 0;
        int count = 0;
        for(CSVRecord row : this.csvRecords){
            int humidity = Integer.parseInt(row.get("Humidity"));
            double currTemp = Double.parseDouble(row.get("TemperatureF"));
            if(humidity >= value){
                tempSum = currTemp + tempSum;
                count += 1;
            }
        }
        if (count == 0) {
            return 0;
        }
        else { return tempSum/(double) count; }
    }
}
