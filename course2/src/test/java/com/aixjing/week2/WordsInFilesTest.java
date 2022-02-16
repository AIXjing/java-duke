package com.aixjing.week2;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;

public class WordsInFilesTest {

    WordsInFiles wordsInFiles = new WordsInFiles();

    @Test
    public void buildWordMapTest () {
        wordsInFiles.buildWordFileMap();
//        for (String word: wordsInFiles.wordsMap.keySet()) {
//            System.out.println(word + " in files: " + wordsInFiles.wordsMap.get(word));
//        }
        System.out.println("total words " + wordsInFiles.wordsMap.size() );
//        int totWords = wordsInFiles.countTotWords();
//        System.out.println("total words are " + totWords);

        int maxOccurences = wordsInFiles.maxNum();
        System.out.println("The most occurence words appears in " + maxOccurences + " files.");

        ArrayList<String> numWordsList = wordsInFiles.wordsInNumFiles(4);
//        System.out.println("The words appearred " + 4 + " times are: " + numWordsList);
        System.out.println("There are " + numWordsList.size() + " words appears in 4 out of 7 files ");

        wordsInFiles.printFilesIn("tree");
    }
}