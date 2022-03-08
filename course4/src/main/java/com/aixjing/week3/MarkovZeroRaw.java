package com.aixjing.week3;
/**
 * Write a description of class MarkovZero here.
 * 
 * @author Duke Software
 * @version 1.0
 */

import java.util.Random;

public class MarkovZeroRaw {
    private String myText;  // training test
	private Random myRandom;

	// constructor
	public MarkovZeroRaw() {
		myRandom = new Random();
	}

	// for testing
	public void setRandom(int seed){
		myRandom = new Random(seed);
	}
	
	public void setTraining(String s){
		myText = s.trim();
	}

	// generates and returns random text that is numChars long
	public String getRandomText(int numChars){
		if (myText == null){
			return "";
		}
		StringBuilder sb = new StringBuilder();
		for(int k=0; k < numChars; k++){
			int index = myRandom.nextInt(myText.length());
			sb.append(myText.charAt(index));
		}
		return sb.toString();
	}
}

