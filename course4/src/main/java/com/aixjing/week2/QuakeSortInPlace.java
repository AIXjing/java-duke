package com.aixjing.week2;
/**
 * Write a description of class QuakeSortInPlace here.
 *
 * @author Jing
 * @version 2021-03-04
 */
import java.util.ArrayList;

public class QuakeSortInPlace {

  private ArrayList<QuakeEntry> quakeEntries;
  private ArrayList<QuakeEntry> quakeEntriesCopy;

  public QuakeSortInPlace(String source) {
    EarthQuakeParser parser = new EarthQuakeParser();
    this.quakeEntries = parser.read(source);
    System.out.println("# quakes read: " + quakeEntries.size());
    quakeEntriesCopy = new ArrayList<>(quakeEntries.size());
    this.quakeEntriesCopy.addAll(quakeEntries);
//    this.quakeEntriesCopy = quakeEntries;
  }

  public QuakeSortInPlace() {
    // TODO Auto-generated constructor stub
  }

  public ArrayList<QuakeEntry> getQuakeEntries(){
    return quakeEntries;
  }

  public ArrayList<QuakeEntry> getQuakeEntriesCopy(){
    return quakeEntriesCopy;
  }

  // sort quakeEntriesCopy and do not modify the original data
  public ArrayList<QuakeEntry> sortByMagnitude() {
    int pass = 0;
    for (int i = 0; i < quakeEntriesCopy.size(); i++) {
      int minIdx = getSmallestMagnitude(i);
      QuakeEntry qi = quakeEntriesCopy.get(i);
      QuakeEntry qmin = quakeEntriesCopy.get(minIdx);
      quakeEntriesCopy.set(i, qmin);
      quakeEntriesCopy.set(minIdx, qi);
      pass++;
      if (isSortedFromSmallest(quakeEntriesCopy)) break;
    }
    System.out.println(pass + " passes");
    return quakeEntriesCopy;
  }

  public ArrayList<QuakeEntry> sortByLargestDepth() {
    int pass = 0;
    for (int i = 0; i < quakeEntriesCopy.size(); i++) {
      int maxIdx = getLargestDepth(i);
      QuakeEntry qi = quakeEntriesCopy.get(i);
      QuakeEntry qMax = quakeEntriesCopy.get(maxIdx);
      quakeEntriesCopy.set(i, qMax);
      quakeEntriesCopy.set(maxIdx, qi);
      pass++;
//      System.out.println(pass + " pass: ");
//      quakeEntriesCopy.forEach(System.out::println);
      if (pass == 50) break;
      if (isSortedFromLargest(quakeEntriesCopy)) break;
    }
    System.out.println(pass + " passes");
    return quakeEntriesCopy;
  }

  public ArrayList<QuakeEntry> sortByMagnitudeWithBubbleSort() {
    int size = quakeEntriesCopy.size();
    int numSorted = 0;
    for (int i = 0; i < size; i++) {
      numSorted++;
      quakeEntriesCopy = onePassBubbleSort(quakeEntriesCopy, numSorted);
      // check if it is already sorted.
      if (isSortedFromSmallest(quakeEntriesCopy)) break;
    }
    System.out.println(numSorted + " passes are needed to sort.");
    return quakeEntriesCopy;
  }

  private static ArrayList<QuakeEntry> onePassBubbleSort(ArrayList<QuakeEntry> quakes, int numSorted) {
    for (int i = 0; i < quakes.size() - numSorted; i++) {
      if (quakes.get(i).getMagnitude() > quakes.get(i+1).getMagnitude()) {
        QuakeEntry q1 = quakes.get(i);
        QuakeEntry q2 = quakes.get(i+1);
        quakes.set(i, q2);
        quakes.set(i+1,q1);
      }
    }
    return quakes;
  }

  private int getSmallestMagnitude(int from) {
    int minIdx = from;
    for (int i = from + 1; i < quakeEntries.size(); i++) {
      if (quakeEntriesCopy.get(i).getMagnitude() < quakeEntriesCopy.get(minIdx).getMagnitude()) {
        minIdx = i;
      }
    }
    return minIdx;
  }

  private int getLargestDepth(int from) {
    int maxIdx = from;
    for (int i = from + 1; i < quakeEntriesCopy.size(); i++) {
      if (quakeEntriesCopy.get(i).getDepth() < quakeEntriesCopy.get(maxIdx).getDepth()) {
        maxIdx = i;
      }
    }
    return maxIdx;
  }

  private boolean isSortedFromSmallest(ArrayList<QuakeEntry> quakes) {
    int size = quakes.size();
    for (int i = 0; i < size - 1; i++) {
      if (quakes.get(i).getMagnitude() > quakes.get(i+1).getMagnitude()) return false;
    }
    return true;
  }

  private boolean isSortedFromLargest(ArrayList<QuakeEntry> quakes) {
    int size = quakes.size();
    for (int i = 0; i < size - 1; i++) {
      if (quakes.get(i).getDepth() > quakes.get(i+1).getDepth()) return false;
    }
    return true;
  }

  public void createCSV() {
    EarthQuakeParser parser = new EarthQuakeParser();
    // String source = "data/nov20quakedata.atom";
    String source = "data/nov20quakedatasmall.atom";
    // String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
    ArrayList<QuakeEntry> list = parser.read(source);
    dumpCSV(list);
    System.out.println("# quakes read: " + list.size());
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
}
