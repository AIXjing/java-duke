package com.aixjing.week3;

import edu.duke.FileResource;
import org.apache.commons.csv.CSVRecord;
import org.junit.Before;
import org.junit.Test;


public class DayWeatherInfoTest {

    static FileResource fr = new FileResource("src/main/resources/week3/nc_weather/2013/weather-2013-09-02.csv");
    DayWeatherInfo dayweatherinfo;

    @Before
    public void setup() {
        dayweatherinfo = new DayWeatherInfo(fr.getCSVParser());
    }

    @Test
    public void avgTempInDayTest(){
        double avgTemp = dayweatherinfo.avgTempInDay();
        System.out.println("Average Temperature in file is " + avgTemp);

        double avgTempHum = dayweatherinfo.avgTempHumidity(80);
        if(avgTempHum == 0) { System.out.println("No temperature above that humidity was found.");}
        else { System.out.println("Average Temperature obove that humidity is " + avgTempHum); }
    }


    @Test
    public void hottestInDayTest(){
        CSVRecord hottestDay = dayweatherinfo.hottestInDay();
        System.out.println("The hottest T was " + hottestDay.get("TemperatureF") + "F at "+ hottestDay.get("TimeEST"));
    }

    @Test
    public void hottestInManyTest(){
        CSVRecord hottest = DayWeatherInfo.hottestInMany();
        System.out.println("The hottest T was " + hottest.get("TemperatureF") + " at " + hottest.get("DateUTC"));
    }

    @Test
    public void coldestInDayTest() {
        CSVRecord coldestDay = dayweatherinfo.coldestInDay();
        System.out.println("The coldest T was " + coldestDay.get("TemperatureF") + "F at "+ coldestDay.get("TimeEDT"));
    }

    @Test
    public void coldestInManyTest(){
        CSVRecord coldest = DayWeatherInfo.coldestInMany();
        System.out.println("The coldest T on that day was " + coldest.get("TemperatureF") + " at " + coldest.get("DateUTC"));
    }

    @Test
    public void lowestHumidityInDayTest(){
        CSVRecord lowestHumidity = dayweatherinfo.lowestHumidityInDay();
        System.out.println("The lowest Humidity was " + lowestHumidity.get("Humidity") +" at " + lowestHumidity.get("DateUTC"));
    }

    @Test
    public void lowestHumidityInManyTest(){
        CSVRecord lowestHumidityRecord = DayWeatherInfo.lowestHumidityInMany();
        System.out.println("The lowest Humidity was " + lowestHumidityRecord.get("Humidity") +" at " + lowestHumidityRecord.get("DateUTC"));
    }
}