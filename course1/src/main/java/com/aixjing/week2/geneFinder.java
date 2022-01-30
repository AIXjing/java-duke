package com.aixjing.week2;

import edu.duke.StorageResource;

import java.text.DecimalFormat;

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
    public void findAll(String dna) {
        int startIndex = 0;
        int count = 0;
        while (true) {
            String currGene = geneFinder(dna, startIndex);
            if (currGene.isEmpty()) {
                break;
            }
//            System.out.println("Find: " + currGene);
//            System.out.println("cgRatio: " + cgRatio(currGene));
//            System.out.println("ctg counts: " + ctgCount(currGene));
            startIndex = dna.indexOf(currGene, startIndex) + currGene.length();
            count += 1;
        }
        System.out.println(count + " genes found");
    }

    // create a method to count all genes
    public int countAllGenes(String dna) {
        int startIndex = 0;
        int count = 0;
        while (true) {
            String currGene = geneFinder(dna, startIndex);
            if (currGene.isEmpty()) {
                break;
            }
            startIndex = dna.indexOf(currGene, startIndex) + currGene.length();
            count += 1;
        }
        return count;
    }

    // create a method to store all genes
    public StorageResource getAllGenes(String dna){
        int startIndex = 0;
        StorageResource genelist = new StorageResource();
        while (true) {
            String currGene = geneFinder(dna, startIndex);
            if (currGene.isEmpty()) { break; }
            genelist.add(currGene);
//            System.out.println("Find: " + currGene);
            startIndex = dna.indexOf(currGene, startIndex) + currGene.length();
        }
        return genelist;
    }

    // a method return the ratio of C and G in dna
    public double cgRatio(String dna){
        String dnaLower = dna.toLowerCase();
        int dnaLen = dna.length();
        int index = 0;
        double count = 0;
        while(index < dnaLen){
            if (dnaLower.charAt(index) == 'c' || dnaLower.charAt(index) == 'g') { count += 1; }
            index += 1;
        }
        return count/dna.length();
    }

    // a method count ctg codon
    public int ctgCount(String dna){
        String dnaLow = dna.toLowerCase();
        int count = 0;
        int startIndex = 0;
        while(true){
            startIndex = dnaLow.indexOf("ctg", startIndex + 1);
            if (startIndex == -1){ break; }
            if(startIndex % 3 == 0){ count += 1; }
        }
        return count;
    }

    // a method to process genes
    public void processGenes(StorageResource sr){
        int countLenOver9 = 0;
        int countLenOver60 = 0;
        int countcgRatio = 0;
        int countgene = 0;
        String longestGene = "";
        for (String s: sr.data()){
            // print all the Strings in sr that are longer than 9 characters
            // and count the number of the genes
            countgene = countgene + countAllGenes(s);

            if(s.length() > 9){
                //System.out.println("length > 9: " + s);
                countLenOver9 += 1;
            }

            if(s.length() > 60){
                //System.out.println("length > 60: " + s);
                countLenOver60 += 1;
            }
            // print the Strings in sr whose C-G-ratio is higher than 0.35
            if(cgRatio(s) > 0.35){
               // System.out.println("cg ratio > 0.35" + s);
                countcgRatio += 1;
            }

            // find the longest gene
            if(s.length() >= longestGene.length()){
                longestGene = s;
            }
        }
        System.out.println("longer than 9 characters: " + countLenOver9);
        System.out.println("longer than 60 characters: " + countLenOver60);
        System.out.println("C-G-ratio is higher than 0.35: " + countcgRatio);
        System.out.println("the length of the longest gene: " + longestGene.length());
        System.out.println("Total genes: " + countgene);

//        int countctg = ctgCount(longestGene);
//        System.out.println("ctg number: " + countctg);
    }
}
