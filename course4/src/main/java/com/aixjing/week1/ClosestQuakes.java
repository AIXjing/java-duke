package com.aixjing.week1;
/**
 * Find N-closest quakes
 * 
 * @author Duke Software/Learn to Program
 * @version 1.0, November 2015
 */

import java.util.*;

public class ClosestQuakes {

    private ArrayList<QuakeEntry> quakeEntries;

    public ClosestQuakes(String source) {
        EarthQuakeParser parser = new EarthQuakeParser();
        this.quakeEntries = parser.read(source);
        System.out.println("read data for " + quakeEntries.size() + " quakes.");
    }
    ;

    public ArrayList<QuakeEntry> getQuakeEntries() {
        return quakeEntries;
    }

    public void findClosestQuakes(Location loc, int howMany){
//        Location jakarta  = new Location(-6.211, 106.845);
//
        ArrayList<QuakeEntry> closestQuakes = getClosest(loc, howMany);
//        for(int k=0; k < closestQuakes.size(); k++){
//            QuakeEntry entry = closestQuakes.get(k);
//            double distanceInMeters = loc.distanceTo(entry.getLocation());
//            System.out.printf("%4.2f\t %s\n", distanceInMeters/1000, entry);
//        }

    closestQuakes.forEach(
        qe -> System.out.printf(
            "%4.2f\t %s\n", loc.distanceTo(qe.getLocation()) / 1000, qe)
    );

    System.out.println("number found: " + closestQuakes.size());
    }

   private ArrayList<QuakeEntry> getClosest(Location current, int howMany){
        ArrayList<QuakeEntry> copy = new ArrayList<>(quakeEntries);
        ArrayList<QuakeEntry> ret = new ArrayList<>();
        for(int j=0; j < howMany; j++) {
            QuakeEntry closest = getClosest(copy, current);
            ret.add(closest);
            copy.remove(copy.indexOf(closest));
        }
        return ret;
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
