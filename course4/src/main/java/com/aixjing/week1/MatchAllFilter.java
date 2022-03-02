package com.aixjing.week1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MatchAllFilter implements Filter{
    private final ArrayList<Filter> filters;

    public MatchAllFilter() {
        this.filters = new ArrayList<Filter>();
    }

    public void addFilter(Filter filter) {
        filters.add(filter);
    }

    @Override
    public boolean satisfies(QuakeEntry qe) {
        for (Filter f : filters) {
            if (!f.satisfies(qe)) return false;
        }
        return true;
    }

    @Override
    public String getName() {
        List names = filters.stream()
                .map(Filter::getName)
                .collect(Collectors.toList());
        return names.toString();
    }
}
