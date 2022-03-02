package com.aixjing.week1;

import com.aixjing.week1.QuakeEntry;

/**
 * Write a description of interface Filter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public interface Filter {
    public boolean satisfies(QuakeEntry qe);
    public String getName();
}
