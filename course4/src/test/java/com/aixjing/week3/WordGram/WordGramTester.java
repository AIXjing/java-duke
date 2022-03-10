package com.aixjing.week3.WordGram;

import edu.duke.FileResource;
import org.junit.Test;

import java.util.*;

public class WordGramTester {

    @Test
    public void testWordGram(){
        String source = "this is a test this is a test this is a test of words";
        String[] words = source.split("\\s+");
        int size = 4;
        for(int index = 0; index <= words.length - size; index += 1) {
            WordGram wg = new WordGram(words,index,size);
            System.out.println(index+"\t"+wg.length()+"\t"+wg);
        }
    }

    @Test
    public void testWordGramEquals(){
        String source = "this is a test this is a test this is a test of words";
        String[] words = source.split("\\s+");
        ArrayList<WordGram> list = new ArrayList<WordGram>();
        int size = 4;
        for(int index = 0; index <= words.length - size; index += 1) {
            WordGram wg = new WordGram(words, index, size);
            list.add(wg);
        }
        WordGram first = list.get(0);
        System.out.println("checking ");
        for(int k=0; k < list.size(); k++){
            //if (first == list.get(k)) {
            if (first.equals(list.get(k))) {
                System.out.println("matched at "+k+" "+list.get(k));
            }
        }
    }

    @Test
    public void indexOfTest() {
        String text = "this is a test this is a test this is a test of words";
        MarkovWord markovWord = new MarkovWord(text, 2, 5);

        String[] source = new String[]{"a", "test"};
        WordGram target = new WordGram(source, 0, 2);
        System.out.println(markovWord.indexOf(target, 5));
        System.out.println(markovWord.getFollows(target));
        System.out.println(markovWord.getRandomText(10));
    }

    @Test
    public void getRandomTextTest() {
        FileResource fr = new FileResource("src/main/resources/week3/confucius.txt");
        MarkovRunnerGram markovRunnerGram = new MarkovRunnerGram(fr, 5, 531, 50);
        markovRunnerGram.runMarkov();
    }

    @Test
    public void hashCodeTest() {
        String[] source = new String[]{"a", "test"};
        WordGram target = new WordGram(source, 0, 2);
        System.out.println("HashCode is " + target.hashCode());
    }

    @Test
    public void buildMapTest() {
//        String text = "this is a test yes this is really a test yes a test this is wow";
        FileResource fr = new FileResource("src/main/resources/week3/confucius.txt");
//        markovWord.buildMap();
        MarkovRunnerGram markovRunnerGram = new MarkovRunnerGram(fr, 0, 1024, 100);
        markovRunnerGram.runMarkov();

    }

}
