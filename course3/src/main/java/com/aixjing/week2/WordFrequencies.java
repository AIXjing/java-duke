package com.aixjing.week2;

import edu.duke.FileResource;
import java.util.ArrayList;

public class WordFrequencies {
  private ArrayList<String> myWords;
  private ArrayList<Integer> myFreqs;
  private FileResource fr;

  public WordFrequencies(FileResource fr) {
    this.myWords = new ArrayList<String>();
    this.myFreqs = new ArrayList<Integer>();
    this.fr = fr;
  }

  public ArrayList<String> getMyWords() {
    return myWords;
  }

  public ArrayList<Integer> getMyFreqs() {
    return myFreqs;
  }

  public int getSize() {
    return myWords.size();
  }

  // a method to find unique words and count the frequencies
  public void findUnique() {
    // clear both myWords and myFreqs
    this.myWords.clear();
    this.myFreqs.clear();
    // iterate each word in the file and store them to the above two arraylist
    for (String s : this.fr.words()) {
      s = s.toLowerCase();
      if (!myWords.contains(s)) {
        myWords.add(s);
        int index = myWords.indexOf(s);
        myFreqs.add(index, 1);
      } else {
        int index = myWords.indexOf(s);
        int value = myFreqs.get(index);
        myFreqs.set(index, value + 1);
      }
    }
  }

  // find the most frequent word
  public void findMostFreqWord() {
    int max = 0;
    int indexOfMax = 0;
    for (int k = 0; k < myFreqs.size(); k++) {
      if (myFreqs.get(k) > max) {
        max = myFreqs.get(k);
        indexOfMax = k;
      }
    }
    System.out.println(
        "The word that occurs most often and its count are: "
            + myWords.get(indexOfMax)
            + " "
            + max);
  }
}
