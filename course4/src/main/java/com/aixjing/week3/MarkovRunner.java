package com.aixjing.week3;

import edu.duke.FileResource;

/**
 * Write a description of class MarkovRunner here.
 * 
 * @author Duke Software
 * @version 1.0
 */

public class MarkovRunner {
	private final MarkovN markovN;
	private final int keyLen;

	public MarkovRunner(FileResource fr, int n) {
		this.markovN = new MarkovN(fr);
		this.keyLen = n;
	}

	public MarkovRunner(FileResource fr, int seed, int n) {
		this.markovN = new MarkovN(fr, seed);
		this.keyLen = n;
	}

	public void runMarkovN() {
		for(int k=0; k < 3; k++){
			String text = markovN.getRandomText(500,keyLen);
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
