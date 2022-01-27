package com.aixjing.week2;

import java.util.Locale;

public class Part2 {
    // Create a method findSimpleGene that has one String parameter dna, representing a string of DNA.
    public String findSimpleGene(String dna, String startCondo, String stopCondo) {
        // Check whether dna is uppercase or lowercase
        if (dna == dna.toLowerCase()) {
            startCondo = startCondo.toLowerCase();
            stopCondo = stopCondo.toLowerCase();
        }
        else {
            startCondo = startCondo.toUpperCase();
            stopCondo = stopCondo.toUpperCase();
        }

        // Find start codon index
        int startIndex = dna.indexOf(startCondo);
        if (startIndex == -1) {
            return "no start codon";
        }

        // Find stop codon index
        int stopIndex = dna.indexOf(stopCondo, startIndex+3);
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
