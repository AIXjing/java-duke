package com.aixjing.week3.MarkovN;

import com.aixjing.week3.MarkovWord.IMarkovModel;
import com.aixjing.week3.MarkovWord.MarkovWordOne;
import edu.duke.FileResource;

/**
 * Write a description of class MarkovRunner here.
 * 
 * @author Duke Software
 * @version 1.0
 */

public class MarkovRunner {
//	private final MarkovN markovN;
//	private final int keyLen;
//
//	public MarkovRunner(FileResource fr, int n) {
//		this.markovN = new MarkovN(fr);
//		this.keyLen = n;
//	}

	public void runMarkovN(FileResource fr, int seed, int order) {
		MarkovN MarkovN = new MarkovN(fr, order);
//        runModel(markovWord, st,200);
		runModel(MarkovN, seed);
	}

	public void runModel(MarkovN markovN, int seed) {
		for(int k=0; k < 3; k++){
			markovN.setMyRandom(seed);
			String text = markovN.getRandomText(200);
			printOut(text);
		}
	}

	// for MarkovZero
	public void runMarkovZero(FileResource fr, int seed) {
		MarkovZero markovZero = new MarkovZero(fr, seed);
		runModel(markovZero, seed);
	}

	public void runModel(MarkovZero markovZero, int seed) {
		for(int k=0; k < 3; k++){
			markovZero.setMyRandom(seed);
			String text = markovZero.getRandomText(200);
			printOut(text);
		}
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
