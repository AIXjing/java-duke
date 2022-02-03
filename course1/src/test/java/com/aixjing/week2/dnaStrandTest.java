package com.aixjing.week2;

import edu.duke.FileResource;
import edu.duke.StorageResource;
import org.junit.Test;

public class dnaStrandTest {
    dnaStrand dnaStrand = new dnaStrand();
    String strand = "AATGCTAACTAGCTGACTAAT";
                   //0123456789012345678901234567890123456789
                   //0         1         2         3
    // String strand = "cccatggtttaacccatggtttaaagagagagtttaaataa";

    @Test
    public void findStopCodonTest(){
        int startIndex = strand.indexOf("atg");
        if(startIndex == -1){System.out.println("not found");}
        int tgaIndex = dnaStrand.findStopCodon(strand, 0, "tga");
        System.out.println("stop codon tga index: " + tgaIndex);
        int taaIndex = dnaStrand.findStopCodon(strand, 0, "taa");
        System.out.println("stop codon taa index: " + taaIndex);
        int tagIndex = dnaStrand.findStopCodon(strand, 0, "tag");
        System.out.println("stop codon tag index: " + tagIndex);
        System.out.println(("stand length: " + strand.length()));
    }

    @Test
    public void geneFinderTest(){
        String gene = dnaStrand.geneFinder(strand, 0);
        System.out.println("DNA strand: " + gene);
        System.out.println("Gene: " + gene);
    }

    @Test
    public void findAllTest(){
        dnaStrand.findAllGenes(strand);
        String strand2 = "ATGCTGCTGTAAGATGCCCTAGT";
        dnaStrand.findAllGenes(strand2);

        //check ctgCount method
        String strand3 = "ATGACAATCCTAAACATATGTGAACCTAACACTGGAGCTCCCAAATTTATAAAACAATTACTAGTAGACATAAGAAATAAGATAGACAGCAACACAATAATAGTGGGGGACTTCAATACTCCACTGACAGCACTAGACAGGTCATCAAGACAGAAAGTCAACAAAGAAACAATGGATTTAAACTATACTTTGGAACAAATGGACTTAACAGATATATATAGAACATTTCATCCAACAACCACAGAATACACATTCTATTCAACAGCACATGGAATTTTCTCCAAGATAGACCATATGATAGGCCATAAAATGAGTCTCAATAAATTTAAGAAAATTGAAATTGTATCACGCACTCTCTCACATCACAATGGAATAAAACTGAAAATCAACTCCAAAAGGAATCTTCGAAACCATGCAAATACATGGAAATTAAATAACCTGCTCCTGAATGAGCATTGGGTGAAAAACGAAATCAAGATGGAAATGTAA";
        int ctgCount = dnaStrand.ctgCount(strand3);
        System.out.println("Count ctg: " + ctgCount);
    }

    @Test
    public void getAllGenesTest(){
        StorageResource genelist = dnaStrand.getAllGenes(strand);
        for(String g: genelist.data()){
            System.out.println(g);
        }
    }

    @Test
    public void processGenesTest() {
        FileResource fr = new FileResource("src/main/resources/week2/GRch38dnapart.fa");
        String textFile = fr.asString();
//        System.out.println(textFile);

        StorageResource geneList = dnaStrand.getAllGenes(textFile);
//        for(String g: genelist.data()){
//            System.out.println(g);
//        }
        dnaStrand.processGenes(geneList);

        // take the whole txt as a long strand and count CTG codon
        int ctgCount = dnaStrand.ctgCount(textFile);
        System.out.println("Count ctg: " + ctgCount);

    }


}