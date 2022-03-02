package com.aixjing.week2;

import org.junit.Test;

import static org.junit.Assert.*;

public class occurenceTest {
    occurence occurence = new occurence();

    @Test
    public void howManyTest(){
        String a1 = "GAA";
        String s1 = "ATGAACGAATTGAATC";
        int times1 = occurence.howMany(a1,s1);
        System.out.println("How many occurences: " + times1);

        String a2 = "AA";
        String s2 = "ATAAAA";
        int times2 = occurence.howMany(a2,s2);
        System.out.println("How many occurences: " + times2);

    }

}