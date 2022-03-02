package com.aixjing.week2;

import edu.duke.FileResource;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;

public class WordFrequenciesTest {
    FileResource fr = new FileResource("week2/QuizGladLibsData/errors.txt");
    WordFrequencies wordList = new WordFrequencies(fr);

    @Test
    public void findUniqueTest () {
        wordList.findUnique();
        ArrayList<String> myWords = wordList.getMyWords();
        ArrayList<Integer> myFreqs = wordList.getMyFreqs();
//        for (int i = 0; i < wordList.getSize(); i++) {
//            System.out.println(myFreqs.get(i) + " " + myWords.get(i));
//        }

        System.out.println("number of unique words: " + wordList.getSize());

        wordList.findMostFreqWord();

    }


}