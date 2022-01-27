package com.aixjing.week2;

import org.junit.Test;

public class Part1Test {
    Part1 test1 = new Part1();

    @Test
    public void testSimpleGene() {
        // not a valid dna
        String testGene1 = "cccatggggtttaaataataataggagagagagagagagttt";
        System.out.println("test gene 1: " + testGene1);
        String gene1 = test1.findSimpleGene(testGene1);
        System.out.println("DNA1: " + gene1);
//        assertEquals("", a_gene);

        // gene no atg
        String testGene2 = "gggtttaaataat";
        System.out.println("test gene 2: " + testGene2);
        String gene2 = test1.findSimpleGene(testGene2);
        System.out.println("DNA2: " + gene2);

        // gene no taa
        String testGene3 = "cccatgaaagagagttt";
        System.out.println("test gene 3: " + testGene3);
        String gene3 = test1.findSimpleGene(testGene3);
        System.out.println("DNA3: " + gene3);

        // valid dna
        String testGene4 = "atgaaagagagttaa";
        System.out.println("test gene 4: " + testGene4);
        String gene4 = test1.findSimpleGene(testGene4);
        System.out.println("DNA4: " + gene4);
        //String ap = "atggggtttaaataataatag";
        //String a = "atgcctag";
        //String ap = "";
        //String a = "ATGCCCTAG";
        //String ap = "ATGCCCTAG";
    }
}