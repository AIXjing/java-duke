package com.aixjing.week2;

import org.junit.Test;

import static org.junit.Assert.*;

public class Part2Test {
    Part2 test2 = new Part2();

    @Test
    public void testSimpleGene() {
        // not a valid dna
        String testGene1 = "AAATGCCCTAACTAGATTAAGAAACC";
        System.out.println("test gene 1: " + testGene1);
        String gene1 = test2.findSimpleGene(testGene1, "atg", "taa");
        System.out.println("DNA1: " + gene1);
//        assertEquals("", a_gene);

        // gene no atg
        String testGene2 = "gggtttaaataat";
        System.out.println("test gene 2: " + testGene2);
        String gene2 = test2.findSimpleGene(testGene2, "atg", "taa");
        System.out.println("DNA2: " + gene2);

        // gene no taa
        String testGene3 = "cccatgaaagagagttt";
        System.out.println("test gene 3: " + testGene3);
        String gene3 = test2.findSimpleGene(testGene3, "atg", "taa");
        System.out.println("DNA3: " + gene3);

        // valid dna - lowercase
        String testGene4 = "atgaaagagagttaa";
        System.out.println("test gene 4: " + testGene4);
        String gene4 = test2.findSimpleGene(testGene4, "atg", "taa");
        System.out.println("DNA4: " + gene4);

        // valid dna - uppercase
        String testGene5 = "ATGAAAGAGAGTTAA";
        System.out.println("test gene 5: " + testGene5);
        String gene5 = test2.findSimpleGene(testGene5, "atg", "taa");
        System.out.println("DNA5: " + gene5);
    }

}