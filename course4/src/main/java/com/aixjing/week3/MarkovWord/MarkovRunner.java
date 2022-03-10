package com.aixjing.week3.MarkovWord;
/**
 * Write a description of class MarkovRunner here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;

public class MarkovRunner {

    // not included in the course material
    private FileResource fr;
    private int seed;
    private int size;

    // self-defined constructor
    public MarkovRunner(FileResource fr, int seed, int size) {
        this.fr = fr;
        this.seed = seed;
        this.size = size;
    }

    public void runModel(IMarkovModel markov, String text){
        markov.setTraining(text); 
        System.out.println("running with " + markov); 
        for(int k=0; k < 3; k++){ 
            String st = markov.getRandomText(size); 
            printOut(st); 
        } 
    } 

    public void runModel(IMarkovModel markov, String text, int setSeed){
        markov.setTraining(text); 
        markov.setRandom(setSeed);
        System.out.println("running with " + markov); 
        for(int k=0; k < 3; k++){ 
            String st = markov.getRandomText(size); 
            printOut(st); 
        } 
    }

    // not included in the course
    private void runModel(IMarkovModel markov, int size){
        System.out.println("running with " + markov);
        for(int k=0; k < 3; k++){
            String st = markov.getRandomText(size);
            printOut(st);
        }
    }

    public void runMarkovOne() {
//        String st = fr.asString();
//        st = st.replace('\n', ' ');
        MarkovWordOne markovWord = new MarkovWordOne(fr, seed);
//        runModel(markovWord, st,200);
        runModel(markovWord,size);
    }

    public void runMarkovTwo() {
//        String st = fr.asString();
//        st = st.replace('\n', ' ');
        MarkovWordTwo markovWord = new MarkovWordTwo(fr, seed);
//        runModel(markovWord, st,200);
        runModel(markovWord,size);
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
