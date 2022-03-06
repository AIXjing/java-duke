package com.aixjing.week1;

import java.util.*;
import java.util.stream.Collectors;

public class EarthQuakeClient2 {

    private ArrayList<QuakeEntry> quakeEntries;

    public EarthQuakeClient2(String source) {
        // TODO Auto-generated constructor stub
        EarthQuakeParser parser = new EarthQuakeParser();
        this.quakeEntries = parser.read(source);
        System.out.println("read data for " + quakeEntries.size() + " quakes.");
    }

    public void testMatchAllFilter () {
        MatchAllFilter allFilters = new MatchAllFilter();
        allFilters.addFilter(new MagnitudeFilter(0.0, 5.0));
//        allFilters.addFilter(new DepthFilter(-180000.0, -30000.0));
        allFilters.addFilter(new PhraseFilter("any", "e"));
        allFilters.addFilter(new DistanceFilter(new Location(55.7308, 9.1153), 3000000));
        ArrayList<QuakeEntry> quakes = quakeEntries.stream()
                .filter(allFilters::satisfies)
                .collect(Collectors.toCollection(ArrayList::new));
        quakes.forEach(System.out::println);
        System.out.println("Found " + quakes.size() + " quakes.");
        System.out.println("Filters are used : " + allFilters.getName() );
    }

    public ArrayList<QuakeEntry> quakesByFilters (double minMag, double maxMag, double minDepth, double maxDepth) {
        Filter filterByMag = new MagnitudeFilter(minMag,maxMag);
        ArrayList<QuakeEntry> quakesFilteredByMag =
                quakeEntries.stream()
                            .filter(filterByMag::satisfies)
                         .collect(Collectors.toCollection(ArrayList::new));
        Filter filterByDepth = new DepthFilter(minDepth,maxDepth);
        return quakesFilteredByMag.stream()
                                    .filter(filterByDepth::satisfies)
                                    .collect(Collectors.toCollection(ArrayList::new));

    }

//    Not really needed
    public ArrayList<QuakeEntry> filterQuakesByFilter(Filter f) {
        ArrayList<QuakeEntry> answer =
                quakeEntries.stream()
                        .filter(f::satisfies)
                        .collect(Collectors.toCollection(ArrayList::new));
//        for(QuakeEntry qe : quakeEntries) {
//            if (f.satisfies(qe)) {
//                answer.add(qe);
//            }
        return answer;
    } 

    public ArrayList<QuakeEntry> quakesWithMinMagFilter(double mag) {
        Filter minMagFilter = new MinMagFilter(mag);
        return this.quakeEntries.stream()
                .filter(minMagFilter::satisfies)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<QuakeEntry> quakesWithMagRangeFilter(double min, double max) {
        Filter filterBetweenMag = new MagnitudeFilter(min, max);
        return quakeEntries.stream()
                        .filter(filterBetweenMag::satisfies)
                        .collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<QuakeEntry> quakesWithMDepthFilter(double min, double max) {
        Filter filterBetweenMagDepth = new DepthFilter(min, max);
        return quakeEntries.stream()
                        .filter(filterBetweenMagDepth::satisfies)
                        .collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<QuakeEntry> quakesWithMaxDistance(Location loc, double maxDistance) {
        Filter filterByDistance = new DistanceFilter(loc, maxDistance);
        return quakeEntries.stream()
                        .filter(filterByDistance::satisfies)
                        .collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<QuakeEntry> quakesByPhrase(String where, String phrase) {
        Filter filterByPhrase = new PhraseFilter(where, phrase);
        return quakeEntries.stream()
                        .filter(filterByPhrase::satisfies)
                        .collect(Collectors.toCollection(ArrayList::new));
    }


    public void createCSV() {
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "../data/nov20quakedata.atom";
        String source = "data/nov20quakedatasmall.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        dumpCSV(list);
        System.out.println("# quakes read: "+list.size());
    }

    public void dumpCSV(ArrayList<QuakeEntry> list) {
        System.out.println("Latitude,Longitude,Magnitude,Info");
        for(QuakeEntry qe : list){
            System.out.printf("%4.2f,%4.2f,%4.2f,%s\n",
                qe.getLocation().getLatitude(),
                qe.getLocation().getLongitude(),
                qe.getMagnitude(),
                qe.getInfo());
        }
    }
}
