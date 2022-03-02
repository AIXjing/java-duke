package com.aixjing.week1;

public class MagnitudeFilter implements Filter {

    private final double minMag;
    private final double maxMag;

    public MagnitudeFilter(double min, double max) {
        this.minMag = min;
        this.maxMag = max;
    }

    @Override
    public boolean satisfies(QuakeEntry qe) {
        return qe.getMagnitude() >= minMag && qe.getMagnitude() <= maxMag;
    }

    @Override
    public String getName() {
        return "Magnitudes";
    }
}
