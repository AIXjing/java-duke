package com.aixjing.week1;

public class DepthFilter implements Filter {

    private final double minDepth;
    private final double maxDepth;

    public DepthFilter(double min, double max) {
        this.minDepth = min;
        this.maxDepth = max;
    }

    @Override
    public boolean satisfies(QuakeEntry qe) {
        return qe.getDepth() >= minDepth && qe.getDepth() <= maxDepth;
    }

    @Override
    public String getName() {
        return "Depth";
    }
}
