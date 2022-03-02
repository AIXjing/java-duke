package com.aixjing.week1;

import edu.duke.FileResource;

public class WordLength {
    FileResource fr;
    public WordLength(FileResource fr){
        this.fr = fr;
    }

    // to count word length
    public int wordLength (String word){
        int length = 0;
        for (int i = 0; i < word.length(); i++){
            if (Character.isLetter(word.charAt(i))) {
                length += 1;
            }
        }
        return length;
    }

    public int[] countWordsLength(){
        int[] counts = new int[32];
        for (String word : this.fr.words()){
            int index = wordLength(word);
            if(index >= 31) {
                counts[31] += 1;
            }
            else {
                counts[index] += 1;
            }
        }
        return counts;
    }

    public static int getMaxIndex (int[] values){
        int maxValue = 0;
        int maxValueIndex = 0;
        for (int k = 0; k < values.length; k++) {
            int currValue = values[k];
            if (maxValue < currValue) {
                maxValue = currValue;
                maxValueIndex = k;
            }
        }
        return maxValueIndex;
    }
}
