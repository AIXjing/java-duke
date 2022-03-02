package com.aixjing.week1;
/**
 * Find N-closest quakes
 * 
 * @author Duke Software/Learn to Program
 * @version 1.0, November 2015
 */

import java.util.ArrayList;

public class LargestQuakes {

    private ArrayList<QuakeEntry> quakeEntries;

    public LargestQuakes(String source) {
        EarthQuakeParser parser = new EarthQuakeParser();
        this.quakeEntries = parser.read(source);
        System.out.println("read data for " + quakeEntries.size() + " quakes.");
    }

    public ArrayList<QuakeEntry> getQuakeEntries() {
        return quakeEntries;
    }

    public ArrayList<QuakeEntry> getLargest(int howMany){
        ArrayList<QuakeEntry> ret = new ArrayList<>();
        if (howMany > quakeEntries.size()) ret = quakeEntries;
        else {
            ArrayList<QuakeEntry> copy = new ArrayList<>(quakeEntries);
            for(int j=0; j < howMany; j++) {
                int largestOfIndex = getIndexOfLargest(copy);
                ret.add(copy.get(largestOfIndex));
                copy.remove(largestOfIndex);
            }
        }
        return ret;
    }

//    private static QuakeEntry findLargestQuakes(ArrayList<QuakeEntry> quakeData){
//        return quakeData.get(getIndexOfLargest(quakeData));
//        System.out.println("The Largest quakes is at location " + getIndexOfLargest(quakeData) + " with mag. " + largestQuake.getMagnitude());
//    }

    private static int getIndexOfLargest(ArrayList<QuakeEntry> quakeData) {
        int indexOfLargest = 0;
        for (int k = 1; k < quakeData.size(); k++) {
            if (quakeData.get(k).getMagnitude() >
                    quakeData.get(indexOfLargest).getMagnitude()) {
                indexOfLargest = k;
            }
        }
        return indexOfLargest;
    }

   // a method to find the closest quakeEntry
    private QuakeEntry getClosest(ArrayList<QuakeEntry> quakeData, Location current) {
        int minIndex = 0;
        for(int k=1; k < quakeData.size(); k++){
            QuakeEntry quake = quakeData.get(k);
            Location loc = quake.getLocation();
            if (loc.distanceTo(current) <
                    quakeData.get(minIndex).getLocation().distanceTo(current)){
                minIndex = k;
            }
        }
        return quakeData.get(minIndex);
    }
}
