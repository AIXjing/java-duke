package com.aixjing.week1;
/**
 * Find N-closest quakes
 * 
 * @author Duke Software/Learn to Program
 * @version 1.0, November 2015
 */

import java.util.*;

public class ClosestQuakes
{
   public static ArrayList<QuakeEntry> getClosest(ArrayList<QuakeEntry> quakeData, Location current, int howMany){
        ArrayList<QuakeEntry> copy = new ArrayList<>(quakeData);
        ArrayList<QuakeEntry> ret = new ArrayList<>();
        for(int j=0; j < howMany; j++) {
            QuakeEntry closest = getClosest(copy, current);
            ret.add(closest);
            copy.remove(copy.indexOf(closest));
        }
        return ret;
   }

   // a method to find the closest quakeEntry
    private static QuakeEntry getClosest(ArrayList<QuakeEntry> quakeData, Location current) {
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

   public void findClosestQuakes(){
       EarthQuakeParser parser = new EarthQuakeParser();
		//String source = "data/nov20quakedata.atom";
		String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
		ArrayList<QuakeEntry> list  = parser.read(source);
		System.out.println("read data for " + list.size());

		Location jakarta  = new Location(-6.211, 106.845);

		ArrayList<QuakeEntry> close = getClosest(list, jakarta, 10);
		for(int k=0; k < close.size(); k++){
			QuakeEntry entry = close.get(k);
			double distanceInMeters = jakarta.distanceTo(entry.getLocation());
			System.out.printf("%4.2f\t %s\n", distanceInMeters/1000, entry);
		}
		System.out.println("number found: " + close.size());
   }
}
