package com.aixjing.week2;

import edu.duke.FileResource;
import junit.framework.TestCase;
import org.junit.Test;

import java.io.File;
import java.util.HashMap;

public class CodonCountTest {
    FileResource fr = new FileResource("week2/QuizGladLibsData/dnaMystery2");
    String s = fr.asString();
    CodonCount codonCount = new CodonCount(s);

    @Test
    public void buildCodonTest () {
        System.out.println("Reading frame from 0: ");
        codonCount.buildCodonMap(0);
        System.out.println(codonCount.codonMap.size() + " unique codons");

        System.out.println("Reading frame from 1: ");
        codonCount.buildCodonMap(1);
        System.out.println(codonCount.codonMap.size() + " unique codons");

        System.out.println("Reading frame from 2: ");
        codonCount.buildCodonMap(2);
        System.out.println(codonCount.codonMap.size() + " unique codons");
    }

    @Test
    public void codonNumTest () {
        System.out.println("Reading frame from 0: ");
        codonCount.buildCodonMap(0);
        System.out.println(codonCount.codonMap.size() + " unique codons");
        codonCount.printOut(0);
        codonCount.printedWithin(7,7);
    }

}