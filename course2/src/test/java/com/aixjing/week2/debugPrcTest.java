package com.aixjing.week2;

import org.junit.Test;

import static org.junit.Assert.*;

public class debugPrcTest {
    debugPrc prac = new debugPrc();

    @Test
    public void test(){
//        prac.findAbc("abcd");
        prac.findAbc("abcabcabcabca");
    }

}