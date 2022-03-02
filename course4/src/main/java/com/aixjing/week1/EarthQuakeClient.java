package com.aixjing.week1;

import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class EarthQuakeClient {

  private ArrayList<QuakeEntry> quakeEntries;

  public EarthQuakeClient(String source) {
    EarthQuakeParser parser = new EarthQuakeParser();
    this.quakeEntries = parser.read(source);
    System.out.println("read data for " + quakeEntries.size() + " quakes.");
  }

  public ArrayList<QuakeEntry> getQuakeEntries() {
    return quakeEntries;
  }

  public void bigQuakes(double mag) {
    ArrayList<QuakeEntry> magHigherLists =
        quakeEntries.stream()
            .filter(qe -> qe.getMagnitude() > mag)
            .collect(Collectors.toCollection(ArrayList::new));

    magHigherLists.forEach(System.out::println);
    System.out.println(
        "Found " + magHigherLists.size() + " quakes with a magnitude higher than " + mag);
  }

  public void closeToMe(double distMax, Location loc) {
    //    for (int k = 0; k < close.size(); k++) {
    //      QuakeEntry entry = close.get(k);
    //      double distanceInMeters = loc.distanceTo(entry.getLocation());
    //      System.out.println(distanceInMeters / 1000 + " " + entry.getInfo());
    ArrayList<QuakeEntry> closestQuakeLists =
        quakeEntries.stream()
            .filter(qe -> qe.getLocation().distanceTo(loc) < distMax)
            .collect(Collectors.toCollection(ArrayList::new));

    closestQuakeLists.forEach(
        qe -> System.out.println((loc.distanceTo(qe.getLocation()) / 1000) + " " + qe.getInfo()));
    System.out.println("Found " + closestQuakeLists.size() + " quakes");
  }

  public void quakesOfDepth(double minDepth, double maxDepth) {
    ArrayList<QuakeEntry> quakesOfDepth =
        quakeEntries.stream()
            .filter(qe -> qe.getDepth() > minDepth && qe.getDepth() < maxDepth)
            .collect(Collectors.toCollection(ArrayList::new));
    System.out.println("Find quakes with depth between " + minDepth + " and " + maxDepth);

    quakesOfDepth.forEach(System.out::println);
    System.out.println("Found " + quakesOfDepth.size() + " quakes for certain depth.");
  }

  public void quakesByPhrase(String where, String phrase) {
    ArrayList<QuakeEntry> quakesByPhrases = filterByPhrase(where, phrase);
    quakesByPhrases.forEach(System.out::println);
    System.out.println("Found " + quakesByPhrases.size() + " quakes by Phrase.");
  }

  private ArrayList<QuakeEntry> filterByPhrase(
      String where, String phrase) { // where = start, end, or any
    // quake.getInfo to get title of the quake
    Predicate<QuakeEntry> filterByWhereAndPhrase;
    switch (where) {
      case "start": filterByWhereAndPhrase = entry -> entry.getInfo().startsWith(phrase); break;
      case "end": filterByWhereAndPhrase = entry -> entry.getInfo().endsWith(phrase); break;
      default: filterByWhereAndPhrase = entry -> entry.getInfo().contains(phrase);
    }
    return quakeEntries.stream().filter(filterByWhereAndPhrase).collect(Collectors.toCollection(ArrayList::new));

    //    ArrayList<QuakeEntry> quakesWithPhrase = new ArrayList<>();
    //    // find the matched entry
    //    if (where.equals("start")) {
    //      for (int k = 0; k < quakeEntries.size(); k++) {
    //        if (quakeEntries.get(k).getInfo().startsWith(phrase))
    //          quakesWithPhrase.add(quakeEntries.get(k));
    //      }
    //    } else if (where.equals("end")) {
    //      for (int k = 0; k < quakeEntries.size(); k++) {
    //        if (quakeEntries.get(k).getInfo().endsWith(phrase))
    //          quakesWithPhrase.add(quakeEntries.get(k));
    //      }
    //    } else {
    //      for (int k = 0; k < quakeEntries.size(); k++) {
    //        if (quakeEntries.get(k).getInfo().contains(phrase))
    //          quakesWithPhrase.add(quakeEntries.get(k));
    //      }
    //    }
    //    return quakesWithPhrase;
  }

  public void dumpCSV(ArrayList<QuakeEntry> list) {
    System.out.println("Latitude,Longitude,Magnitude,Info");
    for (QuakeEntry qe : list) {
      System.out.printf(
          "%4.2f,%4.2f,%4.2f,%s\n",
          qe.getLocation().getLatitude(),
          qe.getLocation().getLongitude(),
          qe.getMagnitude(),
          qe.getInfo());
    }
  }

  public void createCSV() {
    EarthQuakeParser parser = new EarthQuakeParser();
    String source = "data/nov20quakedata.atom";
    // String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
    ArrayList<QuakeEntry> list = parser.read(source);
    dumpCSV(list);
    System.out.println("# quakes read: " + list.size());
  }

  private ArrayList<QuakeEntry> filterByMagnitude(double magMin) {
    //    ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
    //    // TODO
    //    for (QuakeEntry qe : quakeData) {
    //      if (qe.getMagnitude() > magMin) {
    //        answer.add(qe);
    //      }
    //    }
    //    return answer;
    //

    // Try to use stream to perform achieve the same result
    ArrayList<QuakeEntry> answer =
        quakeEntries.stream()
            .filter(qe -> qe.getMagnitude() > magMin)
            .collect(Collectors.toCollection(ArrayList::new));
    return answer;
  }

  private ArrayList<QuakeEntry> filterByDistanceFrom(double distMax, Location from) {
    // TODO

    //    ArrayList<QuakeEntry> answer = new ArrayList<>();
    //    for (QuakeEntry qe : quakeData) {
    //      if (qe.getLocation().distanceTo(from) < distMax) {
    //        answer.add(qe);
    //      }
    //    }

    // Use stream to achieve the same result
    ArrayList<QuakeEntry> answer =
        quakeEntries.stream()
            .filter(qe -> qe.getLocation().distanceTo(from) < distMax)
            .collect(Collectors.toCollection(ArrayList::new));
    return answer;
  }
}
