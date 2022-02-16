package com.aixjing.week2;

import edu.duke.DirectoryResource;
import edu.duke.FileResource;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class WordsInFiles {
    public HashMap<String, ArrayList<String>> wordsMap;
    private DirectoryResource dr;

    public WordsInFiles() {
        this.wordsMap = new HashMap<String, ArrayList<String>>();
        this.dr = new DirectoryResource();
    }

    public void buildWordFileMap () {
        this.wordsMap.clear();
        for (File file: this.dr.selectedFiles()) {
            addWordsFromFile(file);
        }
    }

    public int countTotWords () {
        int tot = 0;
        for (File file: this.dr.selectedFiles()) {
            FileResource fr = new FileResource(file);
            for (String w : fr.words()) {
                tot ++;
            }
        }
        return tot;
    }

    public ArrayList<String> wordsInNumFiles (int num) {
        ArrayList<String> wordsList = new ArrayList<>();
        for (String word : this.wordsMap.keySet()) {
            int size = this.wordsMap.get(word).size();
            if (num == size) {
                wordsList.add(word);
            }
        }
        return wordsList;
    }

    public int maxNum () {
        int max = 0;
        for (String word: this.wordsMap.keySet()) {
            int currNums = this.wordsMap.get(word).size();
            if ( currNums > max) {
                max = currNums;
            }
        }
        return max;
    }

    public void printFilesIn(String w) {
        System.out.println("The word " + w + " appears in ");
        if (this.wordsMap.containsKey(w)) {
            int len = this.wordsMap.get(w).size();
            for (int k = 0; k < len ; k++) {
                System.out.println(this.wordsMap.get(w).get(k));
            }
        }
        else { System.out.println("not found"); }
    }

    private void addWordsFromFile(File file) {
        String fileName = file.getName();
        FileResource fr = new FileResource(file);
        for (String word: fr.words()) {
            if(!wordsMap.containsKey(word)) {
                ArrayList<String> fileNames = new ArrayList<String>();
                fileNames.add(fileName);
                wordsMap.put(word,fileNames);
            }
            if(wordsMap.containsKey(word)) {
                ArrayList<String> currList = wordsMap.get(word);
                if(!currList.contains(fileName)) {
                    currList.add(fileName);
                }
            }
        }
    }

}
