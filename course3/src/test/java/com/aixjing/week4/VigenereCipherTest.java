package com.aixjing.week4;

import edu.duke.FileResource;
import junit.framework.TestCase;
import org.junit.Test;

public class VigenereCipherTest {
    int[] key = {17, 14, 12, 4};
    VigenereCipher vc = new VigenereCipher(key);
    FileResource fr = new FileResource("week4/VigenereTestData/titus-small.txt");
    String testText = fr.asString();

    @Test
    public void vcTest() {
        System.out.println(vc.encrypt(testText));
        System.out.println(vc.toString());
    }


}