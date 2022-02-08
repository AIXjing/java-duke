package com.aixjing.week1;

import edu.duke.FileResource;

/**
 * Count common words in Shakespeare's works
 *
 * @author Duke Software Team
 * @version 1.0
 */


public class CommonWords {
    // get common words from the file and make them into an array "common"
    public static String[] getCommon() {
        FileResource resource = new FileResource("week1/CommonWordsData/common.txt");
        String[] common = new String[20];
        int index = 0;
        for (String s : resource.words()) {
            common[index] = s;
            index += 1;
        }
        return common;
    }

    // find where the word in the list array, return its index
    public static int indexOf(String[] list, String word) {
        for (int k = 0; k < list.length; k++) {
            if (list[k].equals(word)) {
                return k;
            }
        }
        return -1;
    }

    public static void countWords(FileResource resource, String[] common, int[] counts) {
        for (String word : resource.words()) {
            word = word.toLowerCase();
            int index = indexOf(common, word);
            if (index != -1) {
                counts[index] += 1;
            }
        }
    }
}

