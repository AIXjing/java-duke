package com.aixjing.week2.SortAtScale;

import java.util.Comparator;

public class TitleLastAndMagnitudeComparator implements Comparator<QuakeEntry> {
    @Override
    public int compare(QuakeEntry q1, QuakeEntry q2) {
        String lastWord1 = q1.getInfo().substring(q1.getInfo().lastIndexOf(" "));
        String lastWord2 = q2.getInfo().substring(q2.getInfo().lastIndexOf(" "));
        int comp = lastWord1.compareTo(lastWord2);
        if (comp == 0) return Double.compare(q1.getMagnitude(),q2.getMagnitude());
        return comp;
    }
}
