package com.aixjing.week2;

import edu.duke.URLResource;
import org.junit.Test;

public class Part4Test {
    URLResource urlres = new URLResource("https://www.dukelearntoprogram.com//course2/data/manylinks.html");
    Part4 part4 = new Part4();

    @Test
    public void testing(){
        part4.findYT(urlres);
    }
}