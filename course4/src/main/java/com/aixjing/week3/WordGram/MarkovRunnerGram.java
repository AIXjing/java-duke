package com.aixjing.week3.WordGram;
/**
 * Write a description of class MarkovRunner here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import com.aixjing.week3.WordGram.IMarkovModel;
import edu.duke.FileResource;

public class MarkovRunnerGram {

    // not included in the course material
    private final FileResource fr;
    private final int seed;
    private final int myOrder;
    private final int size;

    // self-defined constructor
    public MarkovRunnerGram(FileResource fr, int myOrder, int seed, int size) {
        this.fr = fr;
        this.seed = seed;
        this.size = size;
        this.myOrder = myOrder;
    }

    private void runModel(IMarkovModel markov){
//        markov.setTraining(text);
        System.out.println("running with " + markov); 
        for(int k=0; k < 3; k++){ 
            String st = markov.getRandomText(size); 
            printOut(st); 
        } 
    }

    public void runMarkov() {
        MarkovWord markovWord = new MarkovWord(fr, myOrder, seed);
//        runModel(markovWord, st,200);
        runModel(markovWord);
    }


    private void printOut(String s){
        String[] words = s.split("\\s+");
        int psize = 0;
        System.out.println("----------------------------------");
        for(int k=0; k < words.length; k++){
            System.out.print(words[k]+ " ");
            psize += words[k].length() + 1;
            if (psize > 60) {
                System.out.println(); 
                psize = 0;
            } 
        } 
        System.out.println("\n----------------------------------");
    } 

}
