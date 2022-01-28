package com.aixjing.week2;

import org.junit.Test;

import static org.junit.Assert.*;

public class geneFinderTest {
    geneFinder genefinder = new geneFinder();
    String strand = "cccatggttaacccatagatgttataaatgagatgagtttaaataa";
                   //0123456789012345678901234567890123456789
                   //0         1         2         3
    // String strand = "cccatggtttaacccatggtttaaagagagagtttaaataa";

    @Test
    public void findStopCodonTest(){
        int startIndex = strand.indexOf("atg");
        if(startIndex == -1){System.out.println("not found");}
        int tgaIndex = genefinder.findStopCodon(strand, 0, "tga");
        System.out.println("stop codon tga index: " + tgaIndex);
        int taaIndex = genefinder.findStopCodon(strand, 0, "taa");
        System.out.println("stop codon taa index: " + taaIndex);
        int tagIndex = genefinder.findStopCodon(strand, 0, "tag");
        System.out.println("stop codon tag index: " + tagIndex);
        System.out.println(("stand length: " + strand.length()));
    }

    @Test
    public void geneFinderTest(){
        String gene = genefinder.geneFinder(strand, 0);
        System.out.println("DNA strand: " + gene);
        System.out.println("Gene: " + gene);
    }

    @Test
    public void findAllTest(){
        genefinder.findAll(strand);
    }

}