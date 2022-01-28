package com.aixjing.week2;

import java.util.Currency;
import java.util.Locale;

public class geneFinder {

    // create a method find stop codon
    public int findStopCodon (String dna,
                               int startIndex,
                               String stopCodon){
        int currIndex = dna.indexOf(stopCodon,  startIndex + 3);
        while (currIndex != -1){
            int diff = currIndex - startIndex;
            if (diff % 3 == 0){
                return currIndex;
            }
            currIndex = dna.indexOf(stopCodon, currIndex + 1);
            //System.out.println("currIndex: " + currIndex);
        }
        return dna.length();
    }

    // create a find gene method
    public String geneFinder(String dna, int whereIndex){
        String dnaLower = dna.toLowerCase();
        // find start codon index
        int startIndex = dnaLower.indexOf("atg", whereIndex);
        if (startIndex == -1){ return "";}
        // find stop codon index
        int taaIndex = findStopCodon(dnaLower, startIndex, "taa");
        int tagIndex = findStopCodon(dnaLower, startIndex, "tag");
        int tgaIndex = findStopCodon(dnaLower, startIndex, "tga");
        // find the stop index with the smallest index
        int stopIndex = Math.min(taaIndex, Math.min(tagIndex, tgaIndex));
        if (stopIndex != dna.length()) {
            String gene = dna.substring(startIndex, stopIndex + 3);
            return gene;
        }
        return "";
    }

    // create a method to print all genes
    public void findAll(String dna){
        int startIndex = 0;
        while(true) {
            String currGene = geneFinder(dna, startIndex);
            if (currGene.isEmpty()) { break; }
            System.out.println(currGene);
            startIndex = dna.indexOf(currGene, startIndex) + currGene.length();
        }

    }


}
