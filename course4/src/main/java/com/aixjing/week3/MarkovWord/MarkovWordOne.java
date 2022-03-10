package com.aixjing.week3.MarkovWord;
/**
 * Write a description of class MarkovWordOne here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.FileResource;

import java.util.*;

public class MarkovWordOne implements IMarkovModel {
    private String[] myText;
    private Random myRandom;

	public MarkovWordOne() {
		myRandom = new Random();
	}

	// this constructor is not included in the course material
    public MarkovWordOne(String text, int seed) {
		myText = text.split("\\s+");
		myRandom = new Random(seed);
    }

	// this constructor is not included in the course material
	public MarkovWordOne(FileResource fr, int seed) {
		String st = fr.asString();
		st = st.replace('\n', ' ');
		myText = st.split("\\s+");
		myRandom = new Random(seed);
	}
    
    public void setRandom(int seed) {
        myRandom = new Random(seed);
    }
    
    public void setTraining(String text){
		myText = text.split("\\s+");
	}
	
	public String getRandomText(int numWords){
		StringBuilder sb = new StringBuilder();
		int index = myRandom.nextInt(myText.length-1);  // random word to start with
		String key = myText[index];
		sb.append(key);
		sb.append(" ");
		// using hashmap method
		HashMap<String, ArrayList<String>> wordsMap = generateMap();
		for(int k=0; k < numWords-1; k++){

		    if (wordsMap.get(key).size() == 0) {
		        break;
		    }
			index = myRandom.nextInt(wordsMap.get(key).size());
			String next = wordsMap.get(key).get(index);
			sb.append(next);
			sb.append(" ");
			key = next;
		}
		return sb.toString().trim();
	}
	
	public ArrayList<String> getFollows(String key) {
	    ArrayList<String> follows = new ArrayList<String>();
		int pos = 0;
		int start;
    	while (pos < myText.length) {
			start = indexOf(myText, key, pos);
			if(start == -1) break;
			if(start + 1 > myText.length) break;
			pos = start + 1;
			follows.add(myText[pos]);
		}
		System.out.println("The number of follows: " + follows.size());
		return follows;
    }

	// create a hashmap instead of ArrayList
	// this is not included in the course material
	private HashMap<String, ArrayList<String>> generateMap () {
		HashMap<String, ArrayList<String>> wordsMap = new HashMap<>();
		for (int i = 0; i < myText.length - 1; i++) {
			if(!wordsMap.containsKey(myText[i])) {
				ArrayList<String> follows = new ArrayList<>();
				follows.add(myText[i+1]);
				wordsMap.put(myText[i], follows);
			}
			else {
				wordsMap.get(myText[i]).add(myText[i+1]);
				wordsMap.put((myText[i]), wordsMap.get(myText[i]));
			}
		}
		return wordsMap;
	}


	private static int indexOf(String[] words, String target, int startIndex) {
		for (int i = startIndex; i < words.length - 1; i++) {
      		if (words[i].equals(target)) {
			  return i;
		  	}
		}
		return -1;
	}
}
