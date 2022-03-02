package com.aixjing.week1;

public class DistanceFilter implements Filter {
    private final Location loc;
    private final double maxDis;

    public DistanceFilter(Location loc, double maxDis) {
        this.loc = loc;
        this.maxDis = maxDis;
    }

    @Override
    public boolean satisfies(QuakeEntry qe) {
        return qe.getLocation().distanceTo(loc) < maxDis;
    }

    @Override
    public String getName() {
        return "Distance";
    }
}
