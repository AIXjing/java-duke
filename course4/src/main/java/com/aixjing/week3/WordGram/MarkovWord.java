package com.aixjing.week3.WordGram;

import edu.duke.FileResource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class MarkovWord implements IMarkovModel{
    private String[] myText;
    private Random myRandom;
    private int myOrder;

    public MarkovWord(int order) {
        myOrder = order;
        myRandom = new Random();
    }

    // not required in the exercise
    public MarkovWord(String text, int order, int seed) {
        setTraining(text);
        myOrder = order;
        myRandom = new Random(seed);
    }

    // not required in the exercise
    public MarkovWord(FileResource fr, int order, int seed) {
        String text = fr.asString();
        setTraining(text);
        myOrder = order;
        myRandom = new Random(seed);
    }

    @Override
    public void setTraining(String text) {
        text = text.replace('\n', ' ');
        myText = text.split("\\s+");
    }

    @Override
    public void setRandom(int seed) {
        myRandom = new Random(seed);
    }

    @Override
    public String getRandomText(int numWords) {
        StringBuilder sb = new StringBuilder();
        int index = myRandom.nextInt(myText.length - myOrder); // random word to start with
        if (myOrder != 0) {
          WordGram currWg = new WordGram(myText, index, myOrder);
          sb.append(currWg.toString());
          sb.append(" ");
          HashMap<WordGram, ArrayList<String>> wordMap = buildMap();
          for (int k = 0; k < numWords - myOrder; k++) {
            if (wordMap.get(currWg) == null) {
              break;
            }
            index = myRandom.nextInt(wordMap.get(currWg).size());
            String nextWord = wordMap.get(currWg).get(index);
            sb.append(" ");
            sb.append(nextWord);
            currWg = currWg.shiftAdd(nextWord);
          }
        }
        else {
            for(int k=0; k < numWords - myOrder; k++){
                sb.append(" ");
                sb.append(myText[index]);
                index = myRandom.nextInt(myText.length);
            }
            return sb.toString().trim();
        }
        return sb.toString().trim();
    }

    public int indexOf (WordGram target, int start) {
        for (int i = start; i < myText.length - myOrder; i++) {
            WordGram wg = new WordGram(myText, i, myOrder);
            if(target.equals(wg)) return i;
        }
        return -1;
    }

    public ArrayList<String> getFollows(WordGram kGram) {
        ArrayList<String> follows = new ArrayList<>();
        for(int i = 0; i < myText.length - myOrder; i++) {
            WordGram currentWg = new WordGram(myText, i, myOrder);
            if(currentWg.equals(kGram)) follows.add(myText[i + myOrder]);
        }
        return follows;
    }

    private HashMap<WordGram, ArrayList<String>> buildMap() {
        HashMap<WordGram, ArrayList<String>> wordMap = new HashMap<>();
        WordGram currWg = new WordGram(myText, 0, myOrder);
        for (int i = 0; i < myText.length - myOrder; i++){
            if(!wordMap.containsKey(currWg)) {
                ArrayList<String> follows = new ArrayList<>();
                follows.add(myText[i + myOrder]);
                wordMap.put(currWg, follows);
            }
            else {
                wordMap.get(currWg).add(myText[i + myOrder]);
                wordMap.put(currWg, wordMap.get(currWg));
            }
            currWg = currWg.shiftAdd(myText[i + myOrder]);
        }
        WordGram lastWg = new WordGram(myText, myText.length-myOrder, myOrder);
        wordMap.put(lastWg, null);

        int max = 0;
        WordGram maxWG = new WordGram(myText, 0, myOrder);
        for (WordGram wg : wordMap.keySet()) {
            if ((wordMap.get(wg) != null) && wordMap.get(wg).size() > max) {
                max = wordMap.get(wg).size();
                maxWG = wg;
            }
        }
        System.out.println("The number of keys: " + wordMap.size());
        System.out.println("The key with the most follows: " + maxWG + " with the size of " + wordMap.get(maxWG).size());
        System.out.println("The key is " + maxWG.toString());
        System.out.println("The follows are " + wordMap.get(maxWG).toString());
        return wordMap;
    }
}
