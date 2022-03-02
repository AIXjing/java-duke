package com.aixjing.week3;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class LogAnalyzerTest {
    @Test
/**
 * Write a description of class Tester here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
    public void testLogEntry() {
        LogEntry le = new LogEntry("1.2.3.4", new Date(), "example request", 200, 500);
        System.out.println(le);
        LogEntry le2 = new LogEntry("1.2.100.4", new Date(), "example request 2", 300, 400);
        System.out.println(le2);
    }

    @Test
    public void testLogAnalyzer() {
        // complete method
        LogAnalyzer logAnalyzer = new LogAnalyzer("weblog2_log");
        //logAnalyzer.printAll();
        //System.out.println("There are " + logAnalyzer.countUniqueIPs() + " unique IP address.");

//        int uniqueIPsCount = logAnalyzer.countUniqueIPs();
//        System.out.println("There are " + uniqueIPsCount + " unique IDs.");
//        logAnalyzer.printAllHigherThanNum(400);
//        int countUniqueCode= logAnalyzer.countUniqueCodeHigherThan(400);
//        System.out.println("There are " + countUniqueCode + " status codes higher than 400");
//        logAnalyzer.uniqueIPVisitsOnDay("Sep 27");
//        int countInRange = logAnalyzer.countUniqueIPsInRange(200, 299);
//        System.out.println("There are " + countInRange + " unique IP address with status code between 300 and 399.");

        HashMap<String, Integer> countVisits = logAnalyzer.countVisitsPerIP();
//        for (String ip : countVisits.keySet()) {
//            System.out.println(ip + ": " + countVisits.get(ip));
//        }
        System.out.println("The most visits are " + logAnalyzer.mostVisitsByIP(countVisits));
        System.out.println("They are " + logAnalyzer.iPsMostVisits(countVisits));
//        System.out.println(countVisits);
        HashMap<String, ArrayList<String>> ipDayMap = logAnalyzer.iPsForDays();
        System.out.println(ipDayMap);
//        for (String d:ipDayMap.keySet()) {
//            System.out.println(d + ": " + ipDayMap.get(d));
//        }
        System.out.println(logAnalyzer.dayWithMostVisits(ipDayMap));
        ArrayList<String> ips = logAnalyzer.iPsWithMostVisitsOnDay(ipDayMap, "Sep 30");
        System.out.println(ips);
    }



}