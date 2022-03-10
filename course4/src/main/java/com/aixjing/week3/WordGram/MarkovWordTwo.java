package com.aixjing.week3.WordGram;
/**
 * Write a description of class MarkovWordOne here.
 * 
 * @author Jing Ai
 * @version 2022-03-10
 */

import com.aixjing.week3.MarkovWord.IMarkovModel;
import edu.duke.FileResource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class MarkovWordTwo implements IMarkovModel {
    private String[] myText;
    private Random myRandom;
  	private static final int myOrder = 2;

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

	public String getRandomText(int numWords){
		StringBuilder sb = new StringBuilder();
		int index = myRandom.nextInt(myText.length - myOrder);  // random word to start with
		String current = myText[index] + " " + myText[index + myOrder - 1];
		sb.append(current);
		sb.append(" ");
		HashMap<String, ArrayList<String>> keyMap = generateMap();
		for(int k=0; k < numWords-myOrder; k++){
      		if (keyMap.get(current) == null) break;
			index = myRandom.nextInt(keyMap.get(current).size());
			String next = keyMap.get(current).get(index);
			sb.append(next);
			sb.append(" ");
			current = current.substring(current.lastIndexOf(" ")) + next;
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
			if(start + myOrder > myText.length) break;
			pos = start + myOrder;
			follows.add(myText[pos]);
		}
		return follows;
	}

	private static int indexOf(String[] words, String target1, String target2, int startIndex) {
		for (int i = startIndex; i < words.length - myOrder; i++) {
      		if (words[i].equals(target1) && words[i+1].equals(target2)) {
			  return i;
		  	}
		}
		return -1;
	}

	//	// create a hashmap instead of ArrayList
	// this is not included in the course material
	public HashMap<String, ArrayList<String>> generateMap () {
		HashMap<String, ArrayList<String>> wordsMap = new HashMap<>();
		for (int i = 0; i < myText.length - myOrder; i++) {
			String key = myText[i] + " " + myText[i + 1];
			if(!wordsMap.containsKey(key)) {
				ArrayList<String> follows = new ArrayList<>();
				follows.add(myText[i+myOrder]);
				wordsMap.put(key, follows);
			}
			else {
				wordsMap.get(key).add(myText[i+myOrder]);
				wordsMap.put(key, wordsMap.get(key));
			}
		}
		return wordsMap;
	}
}
