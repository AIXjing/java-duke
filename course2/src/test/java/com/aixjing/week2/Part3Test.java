package com.aixjing.week2;

import org.junit.Test;

import static org.junit.Assert.*;

public class Part3Test {
    Part3 test = new Part3();

    @Test
    public void testing(){
        String a = "zoo";
        System.out.println("a: " + a);
        String s = "forestz";
        System.out.println("s: " + s);
        System.out.println("result: " + test.twoOccurrences(a,s));
        System.out.println("resulting string:" + test.lastPart(a,s));
    }

}