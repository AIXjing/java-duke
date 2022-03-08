package com.aixjing.week3.course;

/**
 * Write a description of class MarkovRunner here.
 * 
 * @author Duke Software
 * @version 1.0
 */

import edu.duke.*;

import java.util.Random;

public class MarkovRunnerWithInterface {
	private String text;
	private int textSize;
	private int seed;


	public MarkovRunnerWithInterface(FileResource fr, int textSize) {
		String st = fr.asString();
		st = st.replace('\n', ' ');
		this.text = st.trim();
		this.textSize = textSize;
	}

	public MarkovRunnerWithInterface(FileResource fr, int textSize, int seed) {
		String st = fr.asString();
		st = st.replace('\n', ' ');
		this.text = st.trim();
		this.seed = seed;
		this.textSize = textSize;
	}


    public void runModel(IMarkovModel markov) {
		markov.setTraining(text);
        System.out.println("running with MarkovModel of order " + markov.getKeySize());
        for(int k=0; k < 3; k++){
			String st= markov.getRandomText(this.textSize);
			printOut(st);
		}
    }
    
    public void runMarkov() {
        MarkovZero mz = new MarkovZero();
		mz.setRandom(this.seed);
        runModel(mz);
    
        MarkovOne mOne = new MarkovOne();
		mz.setRandom(this.seed);
        runModel(mOne);
        
        MarkovModel mThree = new MarkovModel(3);
		mz.setRandom(this.seed);
        runModel(mThree);
        
//        MarkovFour mFour = new MarkovFour();
//        runModel(mFour, st, size);

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
