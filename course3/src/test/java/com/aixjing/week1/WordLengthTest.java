package com.aixjing.week1;

import edu.duke.FileResource;
import junit.framework.TestCase;
import org.junit.Test;

public class WordLengthTest {
    FileResource fr = new FileResource("week1/CommonWordsData/manywords.txt");
    WordLength wordLength = new WordLength(fr);

    @Test
    public void countWordsLengthTest() {
        int[] counts = wordLength.countWordsLength();
        for (int k = 1; k < counts.length; k++) {
            System.out.println(k + " length words count: " + counts[k]);
        }
        int maxIndex = WordLength.getMaxIndex(counts);
        System.out.println("The most frequent word length index is: " + maxIndex);
    }

}