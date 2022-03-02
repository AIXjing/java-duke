package com.aixjing.week1;

import edu.duke.FileResource;
import org.checkerframework.checker.units.qual.C;
import org.junit.Test;

public class CommonWordsTest {

    @Test
    public void countShakespeare() {
        //String[] plays = {"caesar.txt", "errors.txt", "hamlet.txt",
        //          "likeit.txt", "macbeth.txt", "romeo.txt"};
        String[] plays = {"week1/CommonWordsData/small.txt"};
        String[] common = CommonWords.getCommon();
        int[] counts = new int[common.length];
        for (int k = 0; k < plays.length; k++) {
            FileResource resource = new FileResource( plays[k]);
            CommonWords.countWords(resource, common, counts);
            System.out.println("done with " + plays[k]);
        }

        for (int k = 0; k < common.length; k++) {
            System.out.println(common[k] + "\t" + counts[k]);
        }
    }
}
