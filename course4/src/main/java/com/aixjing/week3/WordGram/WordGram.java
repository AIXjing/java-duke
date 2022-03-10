package com.aixjing.week3.WordGram;

/**
 * This class can be analog to String class, but WordGram handles string array.
 * Used in the MarkovWord Class
 * @author Jing Ai
 * @version 2022-03-10
 */

public class WordGram {
    // to store the words in order
    private String[] myWords;
    // use to be able to use WordGrams as a key with a HashMap
    private int myHash;

    public WordGram(String[] source, int start, int size) {
        myWords = new String[size];
        System.arraycopy(source, start, myWords, 0, size);
    }

    public String wordAt(int index) {
        if (index < 0 || index >= myWords.length) {
            throw new IndexOutOfBoundsException("bad index in wordAt "+index);
        }
        return myWords[index];
    }

    public int length(){
        // TODO: Complete this method
        return myWords.length;
    }

    public String toString(){
        String ret = "";
        // TODO: Complete this method
        for(int i = 0; i < myWords.length; i++) {
            ret = ret + " " + wordAt(i);
        }
        return ret.trim();
    }

    public boolean equals(Object o) {
        WordGram other = (WordGram) o;
        // TODO: Complete this method
        if (myWords.length != other.length()) return false;
        for (int i = 0; i < myWords.length; i++) {
            if(!wordAt(i).equals(other.wordAt(i))) return false;
        }
        return true;
    }

    public WordGram shiftAdd(String word) {	
        WordGram out = new WordGram(this.myWords, 0, this.myWords.length);
        // shift all words one towards 0 and add word at the end. 
        // you lose the first word
        // TODO: Complete this method
        for (int i = 0; i < this.myWords.length -1; i++) {
            out.myWords[i] = this.wordAt(i + 1);
        }
        out.myWords[this.myWords.length - 1] = word;
        return out;
    }

    public int hashCode() {
        return this.toString().hashCode();
    }

}