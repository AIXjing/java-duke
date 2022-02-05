package com.aixjing.week1;

import edu.duke.FileResource;
import junit.framework.TestCase;
import org.junit.Test;

public class WordPlayTest {
    String phrase = "dna ctgaAactgAweCXUOO";
    WordPlay wordPlay = new WordPlay(phrase);

    @Test
    public void wordPlayTests(){
        // FileResource fr = new FileResource();
        String newString = wordPlay.replaceVowels('*');
        System.out.println("vowels are replaced: " + newString);

        String replacedString = wordPlay.replaceVowelsConditions('a');
        System.out.println("Replaced by a under conditions: " + replacedString);
    }

}