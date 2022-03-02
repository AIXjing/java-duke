package com.aixjing.week2;

import edu.duke.FileResource;
import edu.duke.URLResource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class GladLibHash {
    private HashMap<String, ArrayList<String>> wordsMap;
    private FileResource fr;
    private Random myRandom;
    private ArrayList<String> usedWords = new ArrayList<String>();
    private ArrayList<String> usedCategory = new ArrayList<String>();

    private static String dataSourceURL = "http://dukelearntoprogram.com/course3/data";
    private static String dataSourceDirectory = "data";

    public GladLibHash() {
        initializeFromSource(dataSourceDirectory);
        myRandom = new Random();
    }

    public GladLibHash(String source) {
        initializeFromSource(source);
        myRandom = new Random();
    }

    private void initializeFromSource(String source) {
        this.wordsMap = new HashMap<String, ArrayList<String>>();
        String[] labels = {"adjective", "noun", "color", "country", "name", "animal", "timeframe", "verb", "fruit"};
        for (String label : labels) {
            ArrayList<String> wordList = readIt(source + "/" + label + ".txt");
            wordsMap.put(label, wordList);
        }
    }

    public void makeStory() {
        usedWords.clear();
        System.out.println("\n");
        String story = fromTemplate("week2/data/madtemplate2.txt");
        System.out.println("Total number of words replaced: " + usedWords.size());
        printOut(story, 60);
    }

    public int totalWordsInMap () {
        int tot = 0;
        for (String label:wordsMap.keySet()) {
            tot = tot + wordsMap.get(label).size();
        }
        return tot;
    }

    public int totalWordsConsidered () {
        int tot = 0;
        for (String usedLabel : usedCategory) {
            ArrayList<String> wordLists = wordsMap.get(usedLabel);
            tot = tot + wordLists.size();
        }
        return tot;
    }

    private String getSubstitute(String label) {
        if (wordsMap.containsKey(label)) {
            if (!usedCategory.contains(label)) {
                usedCategory.add(label);
            }
            String pickedWord = randomFrom(wordsMap.get(label));
            if (!usedWords.contains(pickedWord)) {
                usedWords.add(pickedWord);
            }
            else {
                while (usedWords.contains(pickedWord)) {
                    pickedWord = randomFrom(wordsMap.get(label));
                }
                usedWords.add(pickedWord);
            }
            return pickedWord;
        }
        if (label.equals("number")) {
            return "" + myRandom.nextInt(50) + 5;
        }
        return "**UNKNOWN**";
    }

    private String processWord(String w) {
        int first = w.indexOf("<");
        int last = w.indexOf(">", first);
        if (first == -1 || last == -1) {
            return w;
        }
        String prefix = w.substring(0, first);
        String suffix = w.substring(last + 1);
        String sub = getSubstitute(w.substring(first + 1, last));

        System.out.println(w + " replaced by " + sub);
        return prefix + sub + suffix;
    }

    private String randomFrom(ArrayList<String> list) {
        int index = myRandom.nextInt(list.size());
        return list.get(index);
    }

    private void printOut(String s, int lineWidth) {
        int charsWritten = 0;
        for (String w : s.split("\\s+")) {
            if (charsWritten + w.length() > lineWidth) {
                System.out.println();
                charsWritten = 0;
            }
            System.out.print(w + " ");
            charsWritten += w.length() + 1;
        }
    }

    private String fromTemplate(String source) {
        String story = "";
        if (source.startsWith("http")) {
            URLResource resource = new URLResource(source);
            for (String word : resource.words()) {
                story = story + processWord(word) + " ";
            }
        } else {
            FileResource resource = new FileResource(source);
            for (String word : resource.words()) {
                story = story + processWord(word) + " ";
            }
        }
        return story;
    }

    private ArrayList<String> readIt(String source) {
        ArrayList<String> list = new ArrayList<String>();
        if (source.startsWith("http")) {
            URLResource resource = new URLResource(source);
            for (String line : resource.lines()) {
                list.add(line);
            }
        } else {
            FileResource resource = new FileResource(source);
            for (String line : resource.lines()) {
                list.add(line);
            }
        }
        return list;
    }
}

