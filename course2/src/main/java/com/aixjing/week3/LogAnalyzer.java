package com.aixjing.week3;
/**
 * Write a description of class LogAnalyzer here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;

import edu.duke.*;

public class LogAnalyzer {
  private ArrayList<LogEntry> records;

  public LogAnalyzer(String filename) { // original was not parameter
    // complete constructor
    this.records = new ArrayList<LogEntry>();
    readFile(filename);
  }

  public void readFile(String filename) {
    // complete method
    String path = "week3/";
    FileResource fr = new FileResource(path + filename);
    for (String line : fr.lines()) {
      LogEntry record = WebLogParser.parseEntry(line);
      records.add(record);
    }
  }

  public int countUniqueIPs() {
    HashMap<String, Integer> countVisits = countVisitsPerIP();
    return countVisits.size();
  }

  public int mostVisitsByIP(HashMap<String, Integer> countVisits) {
    int max = 0;
    for (String ip : countVisits.keySet()) {
      if (countVisits.get(ip) > max) {
        max = countVisits.get(ip);
      }
    }
    return max;
  }

  public ArrayList<String> iPsMostVisits (HashMap<String, Integer> countVisits) {
    int mostVisits = mostVisitsByIP(countVisits);
    ArrayList<String> mostVisitsIPs = new ArrayList<>();
    for (String ip:countVisits.keySet()) {
      if ( countVisits.get(ip).equals(mostVisits)) {
        mostVisitsIPs.add(ip);
      }
    }
    return mostVisitsIPs;
  }

  public HashMap<String, ArrayList<String>> iPsForDays() {
    HashMap<String, ArrayList<String>> ipDayMap= new HashMap<>();
    for (LogEntry le : records) {
      String date = le.getAccessTime().toString().substring(4,10);
      String ip = le.getIpAddress();
      if (!ipDayMap.containsKey(date)) {
        ArrayList<String> ipList = new ArrayList<>();
        ipList.add(ip);
        ipDayMap.put(date,ipList);
      }
      else {
        ArrayList<String> ipList = ipDayMap.get(date);
        ipList.add(ip);
        ipDayMap.put(date, ipList);
      }
    }
    return ipDayMap;
  }

  public String dayWithMostVisits (HashMap<String, ArrayList<String>> ipsForDays) {
    int mostVisits = 0;
    String mostVisitsDate = "";
    for (String date : ipsForDays.keySet()) {
      int visitsPerDay = ipsForDays.get(date).size();
      if (mostVisits < visitsPerDay) {
        mostVisits = visitsPerDay;
        mostVisitsDate = date;
      }
    }
    return mostVisitsDate;
  }

  public ArrayList<String> iPsWithMostVisitsOnDay(HashMap<String, ArrayList<String>> ipDayMap, String date) {
    HashMap<String, Integer> visitsOnDay = new HashMap<String, Integer>();
    for (String dd : ipDayMap.keySet()) {
      if (dd.equals(date)) {
        for (String ip: ipDayMap.get(dd)) {
          if(!visitsOnDay.containsKey(ip)) {
            visitsOnDay.put(ip, 1);
          }
          else {
            visitsOnDay.put(ip, visitsOnDay.get(ip) + 1);
          }
        }
      }
    }
    ArrayList<String> ipsMostVisits = iPsMostVisits(visitsOnDay);
    return ipsMostVisits;
  }

  public void printAllHigherThanNum(int num) {
    System.out.println("Here are log records with the status code higher than " + num);
    int count = 0;
    for (LogEntry record : records) {
      int code = record.getStatusCode();
      if (code > num) {
        System.out.println(record);
        count ++;
      }
    }
    System.out.println("There are " + count + " logs in total.");
  }

  public int countUniqueCodeHigherThan(int num) {
    ArrayList<Integer> uniqueCodes = new ArrayList<>();
    for (LogEntry record : records) {
      int code = record.getStatusCode();
      if (code > num && !uniqueCodes.contains(code)) {
        uniqueCodes.add(code);
        System.out.println(code);
      }
    }
    return uniqueCodes.size();
  }

  // n the format “MMM DD” where MMM is the first three characters of the month name
  // with the first letter capitalized and the others in lowercase,
  // and DD is the day in two digits (examples are “Dec 05” and “Apr 22”).
  public void uniqueIPVisitsOnDay(String someday) {
    ArrayList<String> uniqueIPs = new ArrayList<String>();
    for (LogEntry record : records) {
      String tmpDate = record.getAccessTime().toString().substring(4, 10);
      // System.out.println(tmpDate);
      String ipAddr = record.getIpAddress();
      if (tmpDate.equals(someday)) {
        if (!uniqueIPs.contains(ipAddr)) {
          uniqueIPs.add(ipAddr);
        }
      }
    }
    System.out.println("There are " + uniqueIPs.size() + " unique IP address on " + someday);
    ;
  }

  public int countUniqueIPsInRange(int low, int high) {
    ArrayList<String> uniqueIPs = new ArrayList<>();
    for (LogEntry record : records) {
      int code = record.getStatusCode();
      String ipAddr = record.getIpAddress();
      if (code >= low && code <= high && !uniqueIPs.contains(ipAddr)) {
        uniqueIPs.add(ipAddr);
      }
    }
    return uniqueIPs.size();
  }

  public HashMap<String, Integer> countVisitsPerIP () {
    HashMap<String, Integer> visitCounts = new HashMap<>();
    for (LogEntry le : records) {
      String ipAddr = le.getIpAddress();
      if (!visitCounts.containsKey(ipAddr)) {
        visitCounts.put(ipAddr,1);
      }
      else {
        visitCounts.put(ipAddr, visitCounts.get(ipAddr) + 1);
      }
    }
    return visitCounts;
  }

  public void printAll() {
    for (LogEntry le : records) {
      System.out.println(le);
    }
  }
}
