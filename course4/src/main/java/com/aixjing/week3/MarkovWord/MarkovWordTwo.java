package com.aixjing.week3.MarkovWord;
/**
 * Write a description of class MarkovWordOne here.
 * 
 * @author Jing Ai
 * @version 2022-03-10
 */

import edu.duke.FileResource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class MarkovWordTwo implements IMarkovModel {
    private String[] myText;
    private Random myRandom;

	public MarkovWordTwo() {
		myRandom = new Random();
	}

	// this constructor is not included in the course material
    public MarkovWordTwo(String text, int seed) {
		myText = text.split("\\s++");
		myRandom = new Random(seed);
    }

	// this constructor is not included in the course material
	public MarkovWordTwo(FileResource fr, int seed) {
		String st = fr.asString();
		st = st.replace('\n', ' ');
		myText = st.split("\\s++");
		myRandom = new Random(seed);
	}
    
    public void setRandom(int seed) {
        myRandom = new Random(seed);
    }
    
    public void setTraining(String text){
		myText = text.split("\\s+");
	}
	
//	public String getRandomText(int numWords){
//		StringBuilder sb = new StringBuilder();
//		int index = myRandom.nextInt(myText.length-2);  // random word to start with
//		String[] keys = new String[]{myText[index], myText[index+1]};
//		sb.append(keys);
//		sb.append(" ");
//		// using hashmap method
//		HashMap<String[], ArrayList<String>> wordsMap = generateMap();
//		for(int k=0; k < numWords-1; k++){
//		    if (wordsMap.get(keys) == null) {
//		        break;
//		    }
//			index = myRandom.nextInt(wordsMap.get(keys).size());
//			String next = wordsMap.get(keys).get(index);
//			sb.append(next);
//			sb.append(" ");
//			keys = new String[]{sb.substring(k-1, k), next};
//		}
//
//		return sb.toString().trim();
//	}
//
//	// create a hashmap instead of ArrayList
//	// this is not included in the course material
//	public HashMap<String[], ArrayList<String>> generateMap () {
//		HashMap<String[], ArrayList<String>> wordsMap = new HashMap<>();
//		for (int i = 0; i < myText.length - 2; i++) {
//			String[] keys = new String[]{myText[i], myText[i + 1]};
//			if(!wordsMap.containsKey(keys)) {
//				ArrayList<String> follows = new ArrayList<>();
//				follows.add(myText[i+2]);
//				wordsMap.put(keys, follows);
//			}
//			else {
//				wordsMap.get(keys).add(myText[i+2]);
//				wordsMap.put(keys, wordsMap.get(keys));
//			}
//		}
//		return wordsMap;
//	}

	public String getRandomText(int numWords){
		StringBuilder sb = new StringBuilder();
		int index = myRandom.nextInt(myText.length-2);  // random word to start with
		String key1 = myText[index];
		String key2 = myText[index + 1];
		sb.append(key1);
		sb.append(" ");
		sb.append(key2);
		sb.append(" ");
		for(int k=0; k < numWords-1; k++){
			ArrayList<String> follows = getFollows(key1,key2);
      		if (follows.size() == 0) break;
			index = myRandom.nextInt(follows.size());
			String next = follows.get(index);
			sb.append(next);
			sb.append(" ");
			key1 = key2;
			key2 = next;
		}

		return sb.toString().trim();
	}

	private ArrayList<String> getFollows(String key1, String key2) {
		ArrayList<String> follows = new ArrayList<String>();
		int pos = 0;
		int start = 0;
		while (pos < myText.length - 1) {
			start = indexOf(myText, key1, key2, pos);
			if(start == -1) break;
			if(start + 2 > myText.length) break;
			pos = start + 2;
			follows.add(myText[pos]);
		}
		return follows;
	}

	private static int indexOf(String[] words, String target1, String target2, int startIndex) {
		for (int i = startIndex; i < words.length - 2; i++) {
      		if (words[i].equals(target1) && words[i+1].equals(target2)) {
			  return i;
		  	}
		}
		return -1;
	}
}
