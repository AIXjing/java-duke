package com.aixjing.week3.MarkovN;
/**
 * A modified MarkovZero class
 * 
 * @author Jing Ai
 * @version 1.0
 */

import edu.duke.FileResource;

import java.util.Random;

public class MarkovZero {
    private String myText;  // training test
	private Random myRandom;

	// constructor
	public MarkovZero(FileResource fr) {
		String st = fr.asString();
		st = st.replace('\n', ' ');
		this.myRandom = new Random();
		this.myText = st.trim();
	}

	// another constructor method which can set seed in random
	public MarkovZero(FileResource fr, int seed) {
		String st = fr.asString();
		st = st.replace('\n', ' ');
		this.myRandom = new Random(seed);
		this.myText = st.trim();
	}

	public String getMyText() {
		return this.myText;
	}
	public void setMyRandom(int seed) {myRandom = new Random(seed);}

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
