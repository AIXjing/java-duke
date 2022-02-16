package com.aixjing.week2;

import junit.framework.TestCase;
import org.junit.Test;

public class GladLibTest {
    GladLib gladLib = new GladLib("week2/data");

    @Test
    public void makeStoryTest(){
        gladLib.makeStory();
    }


}