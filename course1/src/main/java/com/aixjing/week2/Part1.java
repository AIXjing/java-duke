package com.aixjing.week2;

public class Part1 {

    // Create a method findSimpleGene that has one String parameter dna, representing a string of DNA.
    public String findSimpleGene(String dna) {
        // Find start codon index
        int startIndex = dna.indexOf("atg");
        if (startIndex == -1) {
            return "no start codon";
        }

        // Find stop codon index
        int stopIndex = dna.indexOf("taa", startIndex+3);
        if (stopIndex == -1) {
            return "no stop codon";
        }

        // Check whether the gene is valid
        if ((stopIndex - startIndex) % 3 == 0) {
            return dna.substring(startIndex, stopIndex+3);
        }
        else {
            return "not a valid dna";
        }
    }
}
